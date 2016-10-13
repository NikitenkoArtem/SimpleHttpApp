CREATE TABLE users (
    user_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    CONSTRAINT USER_ID_PK PRIMARY KEY (user_id)
);

CREATE TABLE currencies (
    currency_id INT NOT NULL,
    currency VARCHAR(3) NOT NULL,
    CONSTRAINT CURRENCY_PK PRIMARY KEY (currency_id, currency)
);

CREATE TABLE cards (
    card_id INT NOT NULL,
    user_id INT NOT NULL,
    expiration_date DATE NOT NULL,
    CONSTRAINT CARD_ID_PK PRIMARY KEY (card_id),
    CONSTRAINT USER_ID_FK FOREIGN KEY users(user_id)
);

CREATE TABLE commissions (
    commission_id INT NOT NULL,
    brand VARCHAR(30) NOT NULL,
    currency_id INT NOT NULL,
    value FLOAT NOT NULL,
    CONSTRAINT COMMISSION_ID_PK PRIMARY KEY (commission_id),
    CONSTRAINT CURRENCY_ID_FK FOREIGN KEY currencies(currency_id)
);

CREATE TABLE transfers (
    transfer_id INT NOT NULL,
    transfer_date DATE NOT NULL,
    currency VARCHAR(3) NOT NULL,
    sum INT NOT NULL,
    commission_id INT NOT NULL
    CONSTRAINT TRANSFER_ID_PK PRIMARY KEY (transfer_id),
    CONSTRAINT COMMISSION_ID_FK FOREIGN KEY commissions(commission_id)
);