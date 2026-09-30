-- マラソン日記のスキーマ定義（DBFlute ReplaceSchema）
-- mvn dbflute:replace-schema で既存オブジェクトを削除後、本ファイルの DDL を適用する
-- 論理設計は kb001_marathon-diary_doc を正とする

-- =============================================================================
-- サンプル（配線確認用。DB → ドメイン → API → 画面）
-- =============================================================================
CREATE TABLE sample_greeting (
    sample_greeting_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    message            VARCHAR(200) NOT NULL
);

COMMENT ON TABLE sample_greeting IS 'サンプル挨拶';
COMMENT ON COLUMN sample_greeting.sample_greeting_id IS 'サンプル挨拶ID';
COMMENT ON COLUMN sample_greeting.message IS 'メッセージ';

INSERT INTO sample_greeting (message) VALUES ('Hello from sample database');
