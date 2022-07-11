CREATE TABLE people_dao
(
    id        INTEGER      NOT NULL AUTO_INCREMENT,
    name      VARCHAR(128) NOT NULL,
    lastname  VARCHAR(128) NOT NULL,
    birthdate DATE         NOT NULL,
    PRIMARY KEY (id)
);