CREATE TABLE users (
    user_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

CREATE TABLE currencies (
    currency_id INT NOT NULL,
    currency VARCHAR(3) NOT NULL,
    CONSTRAINT CURRENCY_ID_PK PRIMARY KEY (currency_id),
);

CREATE TABLE card (
    card_id INT NOT NULL,
    user_id INT NOT NULL,
    expiration_date DATE NOT NULL,
    CONSTRAINT CARD_ID_PK PRIMARY KEY (card_id),
    CONSTRAINT USER_ID_FK FOREIGN KEY users(user_id)
);