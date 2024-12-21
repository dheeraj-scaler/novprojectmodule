ALTER TABLE product
    ADD height INT NULL;

ALTER TABLE product
    MODIFY height INT NOT NULL;

DROP TABLE category_seq;

DROP TABLE product_seq;