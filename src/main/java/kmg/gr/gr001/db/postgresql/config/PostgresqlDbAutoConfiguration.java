package kmg.gr.gr001.db.postgresql.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import kmg.gr.gr001.db.postgresql.dbflute.allcommon.DBFluteBeansJavaConfig;

/**
 * PostgreSQL 実装の自動設定<br>
 * <p>
 * 本モジュールをクラスパスに追加するだけで、DBFlute のコンポーネントとリポジトリ実装が登録されます。<br>
 * 起動モジュールは本モジュールのパッケージを意識する必要がありません。<br>
 * DataSource（Bean 名 {@code dataSource}）は起動モジュール側の設定で用意します。
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@AutoConfiguration
@Import(DBFluteBeansJavaConfig.class)
@ComponentScan("kmg.gr.gr001.db.postgresql.sample")
public class PostgresqlDbAutoConfiguration {

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public PostgresqlDbAutoConfiguration() {

        // 処理なし
    }

}
