USE library;

-- DELETE FROM author, book, book_author, copies_of_books, history_of_request, user;

-- USER
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`,
                              `role`)
VALUES ('1', 'Андрій', 'Мельник', '$2a$10$eT4IHiLzmaZTKxB/2TFj6.eFjcyIkccFh.xeis7HvhGQeKDkHhUaG', 'a@gmail.com', '2000-05-06', '2022-10-19', 'MANAGER'),
       ('2', 'Петро', 'Швець', '$2a$10$eT4IHiLzmaZTKxB/2TFj6.eFjcyIkccFh.xeis7HvhGQeKDkHhUaG', 'b@gmail.com', '2000-05-06', '2022-10-19', 'MANAGER'),
       ('3', 'Андрій', 'Кравець', '$2a$10$eT4IHiLzmaZTKxB/2TFj6.eFjcyIkccFh.xeis7HvhGQeKDkHhUaG', 'c@gmail.com', '2000-05-06', '2022-10-19', 'READER'),
       ('4', 'Олександр', 'Боднар', '$2a$10$eT4IHiLzmaZTKxB/2TFj6.eFjcyIkccFh.xeis7HvhGQeKDkHhUaG', 'd@gmail.com', '2000-05-06', '2022-10-19', 'READER'),
       ('5', 'Сергій', 'Ведмідь', '$2a$10$eT4IHiLzmaZTKxB/2TFj6.eFjcyIkccFh.xeis7HvhGQeKDkHhUaG', 'e@gmail.com', '2000-05-06', '2022-10-19', 'READER'),
       ('6', 'Олександра', 'Зима', '$2a$10$eT4IHiLzmaZTKxB/2TFj6.eFjcyIkccFh.xeis7HvhGQeKDkHhUaG', 'f@gmail.com', '2000-05-06', '2022-10-19', 'READER'),
       ('7', 'Марина', 'Візник', '$2a$10$eT4IHiLzmaZTKxB/2TFj6.eFjcyIkccFh.xeis7HvhGQeKDkHhUaG', 'g@gmail.com', '2000-05-06', '2022-10-19', 'READER'),
       ('8', 'Максим', 'Ковач', '$2a$10$eT4IHiLzmaZTKxB/2TFj6.eFjcyIkccFh.xeis7HvhGQeKDkHhUaG', 'h@gmail.com', '2000-05-06', '2022-10-19', 'READER');

-- AUTHOR
INSERT INTO `library`.`author` (`id`, `first_name`, `last_name`)
VALUES ('1', 'William', 'Shakespeare '),
       ('2', 'James', 'Joyce'),
       ('3', 'William', 'Faulkner'),
       ('4', 'Charles', 'Dickens'),
       ('5', 'Henry', 'James');

-- BOOK
INSERT INTO `library`.`book` (`id`, `title`, `author_id`, `status`)
VALUES ('1', 'book1', '1', 'AVAILABLE'),
       ('2', 'book2', '2', 'AVAILABLE'),
       ('3', 'book3', '3', 'AVAILABLE'),
       ('4', 'book4', '4', 'AVAILABLE'),
       ('5', 'book5', '5', 'AVAILABLE'),
       ('6', 'book6', '1', 'AVAILABLE'),
       ('7', 'book7', '2', 'AVAILABLE'),
       ('8', 'book8', '3', 'AVAILABLE');

-- BOOK_AUTHOR
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`)
VALUES ('1', '2'),
       ('1', '3'),
       ('2', '1'),
       ('2', '3'),
       ('3', '1'),
       ('4', '1'),
       ('4', '2'),
       ('4', '3'),
       ('5', '2'),
       ('5', '4'),
       ('7', '5');

-- COPIES_OF_BOOK
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`)
VALUES ('1', '1', 'UNAVAILABLE'),
       ('2', '2', 'AVAILABLE'),
       ('3', '3', 'UNAVAILABLE'),
       ('4', '4', 'UNAVAILABLE'),
       ('5', '5', 'AVAILABLE'),
       ('6', '5', 'AVAILABLE'),
       ('7', '6', 'AVAILABLE'),
       ('8', '6', 'AVAILABLE'),
       ('9', '7', 'AVAILABLE'),
       ('10', '7', 'UNAVAILABLE'),
       ('11', '8', 'UNAVAILABLE'),
       ('12', '8', 'UNAVAILABLE');

-- HISTORY_OF_REQUEST
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`)
VALUES ('1', '1', '1', '2022-10-19', NULL),
       ('2', '1', '3', '2022-10-19', NULL),
       ('3', '2', '4', '2022-10-19', NULL),
       ('4', '3', '10', '2022-10-19', NULL),
       ('5', '4', '11', '2022-10-19', NULL),
       ('6', '5', '12', '2022-10-19', NULL);
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`,
                                            `should_be_return`, `return_date`)
VALUES ('7', '5', '5', '2022-10-19', '2022-10-19', '2022-10-30', '2022-10-22'),
       ('8', '5', '7', '2022-01-19', '2022-01-19', '2022-10-30', null),
       ('9', '6', '6', '2022-10-19', '2022-10-19', '2022-10-30', '2022-10-19');


