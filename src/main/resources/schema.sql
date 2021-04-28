CREATE TABLE buzzfeed_news (
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(500) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    uri VARCHAR(500) NOT NULL,
    published_date TIMESTAMP WITH TIME ZONE,
    inserted_date TIMESTAMP WITH TIME ZONE NOT NULL,
    UNIQUE (uri)
);

CREATE INDEX idx_published_date ON buzzfeed_news(published_date);