CREATE DATABASE IF NOT EXISTS library;

USE library;

CREATE TABLE IF NOT EXISTS author
(
    id         BIGINT         NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS book
(
    id               BIGINT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title            VARCHAR(50) NOT NULL,
    author_id        BIGINT         NOT NULL,
    status  ENUM ('AVAILABLE','UNAVAILABLE', 'DELETED'),
    FOREIGN KEY (author_id) REFERENCES author (id)
);
CREATE TABLE IF NOT EXISTS copies_of_books
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT NOT NULL,
    status  ENUM ('AVAILABLE','UNAVAILABLE', 'DELETED'),
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS user
(
    id                   BIGINT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name           VARCHAR(50) NOT NULL,
    last_name            VARCHAR(50) NOT NULL,
    password             VARCHAR(30) NOT NULL,
    email                VARCHAR(50) NOT NULL UNIQUE,
    birthday             DATE,
    date_of_registration DATE,
    role                 enum('READER','MANAGER')
);

CREATE TABLE IF NOT EXISTS book_author
(
    book_id      BIGINT NOT NULL,
    co_author_id BIGINT NOT NULL,
    CONSTRAINT id PRIMARY KEY (book_id, co_author_id),
    FOREIGN KEY (book_id) REFERENCES book (id),
    FOREIGN KEY (co_author_id) REFERENCES author (id)
);

CREATE TABLE IF NOT EXISTS history_of_request
(
    id               BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT  NOT NULL,

    book_instance_id BIGINT  NOT NULL,
    date_of_request  DATE NOT NULL,
    get_book_date    DATE,
    should_be_return DATE,
    return_date      DATE,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (book_instance_id) REFERENCES copies_of_books (id)
);