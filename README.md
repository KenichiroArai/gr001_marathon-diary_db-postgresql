# marathon-diary db-postgresql

マラソン日記のDBのPostgreSQLを扱う。

## 概要

本リポジトリは、マラソン日記（marathon-diary）の DB（PostgreSQL）をまとめる。
ドメインから受け取ったデータを PostgreSQL に適用する。

- Java 25 / Spring Boot 4.1.1（ライブラリ jar）
- Maven（`packaging` jar）
- O/R マッパー: DBFlute 1.3.1（`dbflute-maven-plugin` 1.1.0）
- DB: PostgreSQL 18.6（Docker）
- DB 管理ツール: pgAdmin 4 9.18.0（Docker）
- 基盤ライブラリ: kmg-core / kmg-fund

## モジュール間の依存関係

```text
api-boot ──> api ──> domain
   └──────> db-postgresql（本リポジトリ） ──> domain
```

- 本リポジトリは domain にだけ依存し、domain の Repository インタフェースを実装する。api の存在は知らない
- 自動設定（`PostgresqlDbAutoConfiguration`）で Bean を登録するため、起動モジュールは dependency に追加するだけで利用できる
- DBFlute の Entity / Behavior は Repository 実装の外に出さず、ドメインモデルに変換して返す
- DataSource（接続先）は起動モジュールの `application.yml` / 環境変数で指定する
- 別の DB（例: db-mysql）へ切り替える場合は、同じ構成のモジュールを作り、起動モジュールの dependency を差し替える（api-boot の README を参照）

## 必要環境

- JDK 25
- Maven 3.6.3 以降
- Docker（Docker Compose v2）
- kmg-core / kmg-fund（ローカル `mvn install` または GitHub Packages）
- `gr001_marathon-diary_domain`（ローカル `mvn install`）

## セットアップ

```bash
# 1. PostgreSQL 起動（接続設定を変える場合は .env を編集し、pom.xml の dbflute.database* も合わせる）
cp .env.example .env
docker compose up -d

# 2. DBFlute エンジン取得（mydbflute/ に展開。初回のみ）
mvn dbflute:download

# 3. スキーマ適用（dbflute_marathondiary/playsql/replace-schema.sql。確認プロンプトに y で応答）
mvn dbflute:replace-schema

# 4. DBFlute のコード生成（JDBC でスキーマ情報を取得してから生成。src/main/dbflute/kmg/gr/gr001/db/postgresql/dbflute/ に出力）
mvn dbflute:regenerate

# 5. テストとローカルリポジトリへのインストール（事前に domain を mvn install しておく）
mvn install
```

非対話で実行する場合は `echo y | mvn dbflute:replace-schema` のように確認プロンプトへ `y` を渡す（PowerShell では `"y" | mvn dbflute:replace-schema`）。

### DBFlute 生成コードのソースフォルダ

DBFlute の生成コードは、手書きのコード（`src/main/java`）と分けて `src/main/dbflute` に出力する（`dbflute_marathondiary/dfprop/basicInfoMap.dfprop` の `generateOutputDirectory`）。
`src/main/dbflute` は `pom.xml` の `build-helper-maven-plugin` でソースフォルダとして登録している。パッケージ名は `kmg.gr.gr001.db.postgresql.dbflute` のまま。

- 拡張クラス（`exbhv` / `exentity` / `cbean` 直下など）を含め、`src/main/dbflute` 配下には独自ロジックを書かない
- DB アクセスの独自処理は Repository 実装（`src/main/java` 側）に書く

### Eclipse の設定

生成コードは Eclipse のコンパイラ警告・エラーのルールに合わないため、`src/main/dbflute` だけ「任意のコンパイル問題を無視」にする。
この設定は `.classpath` に保存し、Git で管理している。

「Maven」→「プロジェクトの更新」を実行すると設定が外れることがあるため、実行後は次の手順で確認する。

1. 「プロパティ」→「Java のビルド・パス」→「ソース」で `src/main/dbflute` を展開し、「任意のコンパイル問題を無視」が「はい」になっていることを確認する（外れていれば「はい」に戻す）
2. 問題ビューから DBFlute 関連の警告・エラーが消えたこと、`config/` と `sample/` には従来どおりルールが効いていることを確認する
3. `.classpath` に差分が出ていないことを確認する（差分が出た場合は意図した変更か確認してからコミットする）

### サンプルテーブル（配線確認用）

`replace-schema.sql` に DB → domain → api → 画面の配線確認用のサンプルテーブルを定義している。

| テーブル | 列 | 内容 |
| --- | --- | --- |
| `sample_greeting` | `sample_greeting_id`（BIGINT、IDENTITY、PK） | サンプル挨拶 ID |
| | `message`（VARCHAR(200)、NOT NULL） | メッセージ |

初期データとして `Hello from sample database` を 1 行投入する。
取得は `SampleGreetingRepositoryImpl`（ID 昇順の先頭 1 件）が行い、画面のサンプル挨拶パネルに表示される。

メッセージを変える手順:

1. `replace-schema.sql` の `INSERT` 文を編集する（または pgAdmin で `sample_greeting` を直接更新する）
2. `mvn dbflute:replace-schema` で DB を作り直す
3. 起動中の API（api-boot）を再起動する必要はない（リクエストごとに DB を参照する）

テーブル定義（列）を変更した場合は `mvn dbflute:regenerate` でコードを再生成し、`mvn install` し直す。

接続先（開発用の既定値）: `jdbc:postgresql://localhost:5432/marathondiary`（ユーザ / パスワード: `marathondiary`）

### pgAdmin 4

`docker compose up -d` で pgAdmin 4（9.18.0）も起動する。

1. ブラウザで `http://localhost:5050` を開く
2. `admin@example.com` / `admin` でログインする（`.env` の `PGADMIN_DEFAULT_*` で変更可）
3. サーバー `marathondiary` は登録済み（`docker/pgadmin/servers.json`）。初回接続時にパスワード `marathondiary` を入力する

注意:

- pgAdmin から見た接続先ホストは `postgres`（Compose のサービス名）、ポートは `5432`
- ログイン情報と `servers.json` は `pgadmin-data` ボリュームの初回作成時のみ反映される。変更後は `docker compose down` → `docker volume rm gr001-marathon-diary_pgadmin-data` → `docker compose up -d` で再作成する
- `.env` で DB 名・ユーザを変えた場合は `docker/pgadmin/servers.json` も合わせる

注意:

- `mvn dbflute:generate` 単体はスキーマ情報（`dbflute_marathondiary/schema/`）が無いと失敗するため、通常は `regenerate` を使う
- テーブルが 1 つも無いスキーマではコード生成できない（DBFlute の仕様）
- DBFlute タスクが失敗しても Maven は `BUILD SUCCESS` を表示するため、`[Final Message]` と `dbflute_marathondiary/log/dbflute.log` で結果を確認する

## ビルド

```bash
# テスト（JaCoCo レポート生成 + 行/分岐カバレッジ 100% チェック。DBFlute 生成コードは対象外）
mvn test

# パッケージ（通常 jar）
mvn package
```

成果物は `target/gr001_marathon-diary_db-postgresql-0.1.0.jar`（実行可能 fat jar ではない）。

## ディレクトリ構成

```text
docker-compose.yml               # PostgreSQL 18.6 / pgAdmin 4
.env.example                     # Docker の接続設定の雛形
docker/pgadmin/servers.json      # pgAdmin の接続先サーバー定義
dbflute_marathondiary/           # DBFlute クライアント
  dfprop/                        # DBFlute 設定（basicInfoMap / databaseInfoMap など）
  playsql/replace-schema.sql     # スキーマ定義（DDL）
mydbflute/                       # DBFlute エンジン（git 管理外）
src/main/java/kmg/gr/gr001/db/postgresql/
  config/                        # 自動設定（PostgresqlDbAutoConfiguration）
  sample/repository/impl/        # サンプルの Repository 実装（SampleGreetingRepositoryImpl）
src/main/dbflute/kmg/gr/gr001/db/postgresql/
  dbflute/                       # DBFlute 自動生成コード（拡張クラスを含む）
src/main/resources/META-INF/spring/
  org.springframework.boot.autoconfigure.AutoConfiguration.imports   # 自動設定の登録
src/test/java/                   # テスト
```

## Docker 操作

```bash
docker compose up -d        # 起動
docker compose ps           # 状態確認（healthy になれば接続可能）
docker compose down         # 停止
docker compose down -v      # 停止 + データ削除
```

## ライセンス

[MIT License](./LICENSE)
