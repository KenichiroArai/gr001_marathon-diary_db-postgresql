package kmg.gr.gr001.db.postgresql.sample.repository.impl;

import java.util.Optional;

import org.dbflute.bhv.readable.CBCall;
import org.dbflute.optional.OptionalEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import kmg.gr.gr001.db.postgresql.dbflute.cbean.SampleGreetingCB;
import kmg.gr.gr001.db.postgresql.dbflute.exbhv.SampleGreetingBhv;
import kmg.gr.gr001.domain.sample.model.SampleGreeting;

/**
 * SampleGreetingRepositoryImpl のテスト
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
public class SampleGreetingRepositoryImplTest {

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public SampleGreetingRepositoryImplTest() {

        // 処理なし
    }

    /**
     * コンストラクタのテスト - 正常系:インスタンスを生成できる場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normal() {

        /* 期待値の定義 */

        /* 準備 */
        final SampleGreetingBhv mockBhv = Mockito.mock(SampleGreetingBhv.class);

        /* テスト対象の実行 */
        final SampleGreetingRepositoryImpl testTarget = new SampleGreetingRepositoryImpl(mockBhv);

        /* 検証の準備 */

        /* 検証の実施 */
        Assertions.assertNotNull(testTarget, "インスタンスが生成されていません");

    }

    /**
     * findFirst メソッドのテスト - 正常系:先頭のサンプル挨拶が返る場合
     *
     * @since 0.1.0
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testFindFirst_normalFound() {

        /* 期待値の定義 */
        final String expectedMessage = "Hello from sample database";
        final int    expectedFetch   = 1;

        /* 準備 */
        //TODO KenichiroArai 2026/09/30 モデルクラスはサフィックスに"Model"を付与し、フルパスを無くすこと
        final kmg.gr.gr001.db.postgresql.dbflute.exentity.SampleGreeting entity
            = new kmg.gr.gr001.db.postgresql.dbflute.exentity.SampleGreeting();
        entity.setMessage(expectedMessage);
        final SampleGreetingBhv mockBhv = Mockito.mock(SampleGreetingBhv.class);
        Mockito.when(mockBhv.selectEntity(ArgumentMatchers.any())).thenReturn(OptionalEntity.of(entity));
        final SampleGreetingRepositoryImpl testTarget = new SampleGreetingRepositoryImpl(mockBhv);

        /* テスト対象の実行 */
        final Optional<SampleGreeting> testResult = testTarget.findFirst();

        /* 検証の準備 */
        final ArgumentCaptor<CBCall<SampleGreetingCB>> captor = ArgumentCaptor.forClass(CBCall.class);
        Mockito.verify(mockBhv).selectEntity(captor.capture());
        final SampleGreetingCB cb = new SampleGreetingCB();
        captor.getValue().callback(cb);
        final String actualMessage = testResult.map(SampleGreeting::message).orElse(null);

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertTrue(cb.hasOrderByClause(), "並び順が指定されていません");
        Assertions.assertEquals(expectedFetch, cb.getFetchSize(), "取得件数が一致しません");

    }

    /**
     * findFirst メソッドのテスト - 準正常系:データが無い場合
     *
     * @since 0.1.0
     */
    @Test
    public void testFindFirst_semiEmpty() {

        /* 期待値の定義 */

        /* 準備 */
        final SampleGreetingBhv mockBhv = Mockito.mock(SampleGreetingBhv.class);
        Mockito.when(mockBhv.selectEntity(ArgumentMatchers.any())).thenReturn(OptionalEntity.empty());
        final SampleGreetingRepositoryImpl testTarget = new SampleGreetingRepositoryImpl(mockBhv);

        /* テスト対象の実行 */
        final Optional<SampleGreeting> testResult = testTarget.findFirst();

        /* 検証の準備 */

        /* 検証の実施 */
        Assertions.assertTrue(testResult.isEmpty(), "空が返されていません");

    }

}
