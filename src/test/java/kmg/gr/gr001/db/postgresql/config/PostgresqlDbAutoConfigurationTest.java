package kmg.gr.gr001.db.postgresql.config;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import kmg.gr.gr001.domain.sample.repository.SampleGreetingRepository;

/**
 * PostgresqlDbAutoConfiguration のテスト
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method",
})
public class PostgresqlDbAutoConfigurationTest {

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public PostgresqlDbAutoConfigurationTest() {

        // 処理なし
    }

    /**
     * 自動設定のテスト - 正常系:リポジトリ実装が登録される場合
     *
     * @since 0.1.0
     */
    @Test
    public void testAutoConfiguration_normalRepositoryRegistered() {

        /* 期待値の定義 */
        final int expectedCount = 1;

        /* 準備 */
        final ApplicationContextRunner runner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(PostgresqlDbAutoConfiguration.class))
            .withBean("dataSource", DataSource.class, () -> Mockito.mock(DataSource.class));

        /* テスト対象の実行・検証 */
        runner.run(context -> {

            /* 検証の準備 */
            final int actualCount = context.getBeanNamesForType(SampleGreetingRepository.class).length;

            /* 検証の実施 */
            Assertions.assertNull(context.getStartupFailure(), "コンテキストの起動に失敗しました");
            Assertions.assertEquals(expectedCount, actualCount, "リポジトリ実装が登録されていません");

        });

    }

}
