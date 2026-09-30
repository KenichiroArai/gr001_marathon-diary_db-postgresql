package kmg.gr.gr001.db.postgresql.sample.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import kmg.gr.gr001.db.postgresql.dbflute.exbhv.SampleGreetingBhv;
import kmg.gr.gr001.domain.sample.model.SampleGreeting;
import kmg.gr.gr001.domain.sample.repository.SampleGreetingRepository;

/**
 * サンプル挨拶リポジトリの PostgreSQL 実装<br>
 * <p>
 * DBFlute の Behavior で sample_greeting テーブルを参照し、ドメインモデルに変換して返します。<br>
 * DBFlute のエンティティはこのクラスの外に出しません。
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@Repository
public class SampleGreetingRepositoryImpl implements SampleGreetingRepository {

    /**
     * サンプル挨拶の Behavior
     *
     * @since 0.1.0
     */
    private final SampleGreetingBhv sampleGreetingBhv;

    /**
     * コンストラクタ
     *
     * @since 0.1.0
     *
     * @param sampleGreetingBhv
     *                          サンプル挨拶の Behavior
     */
    public SampleGreetingRepositoryImpl(final SampleGreetingBhv sampleGreetingBhv) {

        this.sampleGreetingBhv = sampleGreetingBhv;

    }

    /**
     * {@inheritDoc}
     *
     * @since 0.1.0
     */
    @Override
    public Optional<SampleGreeting> findFirst() {

        /* 戻り値の宣言 */
        final Optional<SampleGreeting> result;

        /* ID 昇順の先頭1件を取得し、ドメインモデルに変換 */
        result = this.sampleGreetingBhv.selectEntity(cb -> {
            cb.query().addOrderBy_SampleGreetingId_Asc();
            cb.fetchFirst(1);
        }).toOptional().map(entity -> new SampleGreeting(entity.getMessage()));

        return result;

    }

}
