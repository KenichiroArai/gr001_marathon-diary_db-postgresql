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

## 必要環境

- JDK 25
- Maven 3.6.3 以降
- Docker（Docker Compose v2）
- kmg-core / kmg-fund（ローカル `mvn install` または GitHub Packages）

## セットアップ

```bash
# 1. PostgreSQL 起動（接続設定を変える場合は .env を編集し、pom.xml の dbflute.database* も合わせる）
cp .env.example .env
docker compose up -d

# 2. DBFlute エンジン取得（mydbflute/ に展開。初回のみ）
mvn dbflute:download

# 3. スキーマ適用（dbflute_marathondiary/playsql/replace-schema.sql。確認プロンプトに y で応答）
mvn dbflute:replace-schema

# 4. DBFlute のコード生成（JDBC でスキーマ情報を取得してから生成。src/main/java/kmg/gr/gr001/db/postgresql/dbflute/ に出力）
mvn dbflute:regenerate
```

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
  dbflute/                       # DBFlute 自動生成コード
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
