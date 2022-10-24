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
    status  ENUM ('AVAILABLE','UNAVAILABLE'),
    FOREIGN KEY (author_id) REFERENCES author (id)
);
CREATE TABLE IF NOT EXISTS copies_of_books
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    status  ENUM ('AVAILABLE','UNAVAILABLE'),
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS user
(
    id                   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name           VARCHAR(50) NOT NULL,
    last_name            VARCHAR(50) NOT NULL,
    username             VARCHAR(50) NOT NULL,
    password             VARCHAR(30) NOT NULL,
    email                VARCHAR(50) NOT NULL,
    birthday             DATE,
    date_of_registration DATE,
    role                 VARCHAR(50)
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

    book_instance_id INT  NOT NULL,
    date_of_request  DATE NOT NULL,
    get_book_date    DATE,
    should_be_return DATE,
    return_date      DATE,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (book_instance_id) REFERENCES copies_of_books (id)
);