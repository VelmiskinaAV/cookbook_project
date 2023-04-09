CREATE TABLE COOKBOOK.RECEIPT_TAB
(
    id                          SERIAL NOT NULL,
    name                        VARCHAR(250) NOT NULL,
    short_description           VARCHAR(1000),
    photo                       VARCHAR(250) NOT NULL,
    ingredients                 VARCHAR(5000) NOT NULL,
    receipt                     VARCHAR(10000) NOT NULL,
    rating                      FLOAT DEFAULT 0.0,
    editable                    BOOLEAN,
    author_id                   VARCHAR(50) NOT NULL,
    category_id                 INT NOT NULL,
    energy_value_id             INT NOT NULL,
    cook_time                   INT NOT NULL,
    portions                    INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_author_tab
        FOREIGN KEY(author_id)
            REFERENCES COOKBOOK.AUTHOR_TAB(id),
    CONSTRAINT fk_category_tab
        FOREIGN KEY(category_id)
            REFERENCES COOKBOOK.CATEGORY_TAB(id),
    CONSTRAINT fk_energy_value_tab
        FOREIGN KEY(energy_value_id)
            REFERENCES COOKBOOK.ENERGY_VALUE_TAB(id)
);