DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE products
(
    id                     bigint       NOT NULL AUTO_INCREMENT, --id
    title                  varchar(100) NOT NULL,                --상품명
    total_invest_amount bigint       NOT NULL,                --총 투자 모집금액
    invested_count          bigint       DEFAULT 0,               --투자자 수
    invested_amount         bigint       DEFAULT 0,               --현재까지 투자 금액
    started_at             datetime     NOT NULL,                --투자시작일시
    finished_at            datetime     NOT NULL,                --투자종료일시
    PRIMARY KEY (id)
);