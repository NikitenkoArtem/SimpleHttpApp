CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    CONSTRAINT USER_ID_PK PRIMARY KEY (user_id)
);

CREATE TABLE cards (
    card_id INT NOT NULL,
    user_id INT NOT NULL,
    expiration_date DATE NOT NULL,
    CONSTRAINT CARD_ID_PK PRIMARY KEY (card_id),
    CONSTRAINT USER_ID_FK FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE commissions (
    commission_id INT NOT NULL,
    brand VARCHAR(30) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    value FLOAT NOT NULL,
    CONSTRAINT COMMISSION_ID_PK PRIMARY KEY (commission_id)
);

CREATE TABLE transfers (
    transfer_id INT NOT NULL AUTO_INCREMENT,
    transfer_date DATE NOT NULL,
    sum DOUBLE NOT NULL,
    commission_id INT NOT NULL,
    CONSTRAINT TRANSFER_ID_PK PRIMARY KEY (transfer_id),
    CONSTRAINT COMMISSION_ID_FK FOREIGN KEY (commission_id) REFERENCES commissions(commission_id) ON DELETE CASCADE ON UPDATE CASCADE
);