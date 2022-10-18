CREATE DATABASE IF NOT EXISTS library;

USE library;

CREATE TABLE IF NOT EXISTS author
(
    id         INT         NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS book
(
    id               INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title            VARCHAR(50) NOT NULL,
    author_id        INT         NOT NULL,
    number_of_copies INT         NOT NULL,
    FOREIGN KEY (author_id) REFERENCES author (id)
);

CREATE TABLE IF NOT EXISTS user_account
(
    id                   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name           VARCHAR(50) NOT NULL,
    last_name            VARCHAR(50) NOT NULL,
    password             VARCHAR(30) NOT NULL,
    email                VARCHAR(50) NOT NULL,
    birthday             DATE,
    date_of_registration DATE,
    role                 ENUM ('READER','MANAGER')
);

CREATE TABLE IF NOT EXISTS book_author
(
    book_id      INT NOT NULL,
    co_author_id INT NOT NULL,
    CONSTRAINT id PRIMARY KEY (book_id, co_author_id),
    FOREIGN KEY (book_id) REFERENCES book (id),
    FOREIGN KEY (co_author_id) REFERENCES author (id)
);

CREATE TABLE IF NOT EXISTS history_of_request
(
    id               INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id          INT  NOT NULL,
    book_id          INT  NOT NULL,
    date_of_issue    DATE NOT NULL,
    should_be_return DATE NOT NULL,
    return_date      DATE,
    FOREIGN KEY (user_id) REFERENCES user_account (id),
    FOREIGN KEY (book_id) REFERENCES book (id)
);

CREATE TABLE IF NOT EXISTS copies_of_books
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    status  ENUM ('AVAILABLE','UNAVAILABLE'),
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
);
