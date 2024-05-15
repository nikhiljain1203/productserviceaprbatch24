ALTER TABLE product
    ADD is_deleted BIT(1) NULL;

ALTER TABLE product
    MODIFY is_deleted BIT (1) NOT NULL;