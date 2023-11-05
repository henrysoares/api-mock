CREATE TABLE MOCK (
    MOCK_ID SERIAL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    METHOD VARCHAR(100) NOT NULL,
    IS_ACTIVE BOOLEAN NOT NULL,
    REQUEST_PATH TEXT,
    PAYLOAD TEXT,
    STATUS INTEGER,
    WORKFLOW_SCRIPT VARCHAR(45),
    METADATA TEXT,
    DAT_CREATION TIMESTAMP NOT NULL,
    DAT_UPDATE TIMESTAMP NOT NULL
);
