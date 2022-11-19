-- USER
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`, `role`) VALUES ('1', 'Андрій', 'Мельник', '1234', 'a@gmail.com', '2000-05-06', '2022-10-19', 'MANAGER');
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`, `role`) VALUES ('2', 'Петро', 'Швець', '1234', 'b@gmail.com', '2000-05-06', '2022-10-19', 'MANAGER');
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`, `role`) VALUES ('3', 'Андрій', 'Кравець', '1234', 'c@gmail.com', '2000-05-06', '2022-10-19', 'READER');
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`, `role`) VALUES ('4', 'Олександр', 'Боднар', '1234', 'd@gmail.com', '2000-05-06', '2022-10-19', 'READER');
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`, `role`) VALUES ('5', 'Сергій', 'Ведмідь', '1234', 'e@gmail.com', '2000-05-06', '2022-10-19', 'READER');
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`, `role`) VALUES ('6', 'Олександра', 'Зима', '1234', 'f@gmail.com', '2000-05-06', '2022-10-19', 'READER');
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`, `role`) VALUES ('7', 'Марина', 'Візник', '1234', 'g@gmail.com', '2000-05-06', '2022-10-19', 'READER');
INSERT INTO `library`.`user` (`id`, `first_name`, `last_name`, `password`, `email`, `birthday`, `date_of_registration`, `role`) VALUES ('8', 'Максим', 'Ковач', '1234', 'h@gmail.com', '2000-05-06', '2022-10-19', 'READER');

-- AUTHOR
INSERT INTO `library`.`author` (`id`, `first_name`, `last_name`) VALUES ('1', 'William', 'Shakespeare ');
INSERT INTO `library`.`author` (`id`, `first_name`, `last_name`) VALUES ('2', 'James', 'Joyce');
INSERT INTO `library`.`author` (`id`, `first_name`, `last_name`) VALUES ('3', 'William', 'Faulkner');
INSERT INTO `library`.`author` (`id`, `first_name`, `last_name`) VALUES ('4', 'Charles', 'Dickens');
INSERT INTO `library`.`author` (`id`, `first_name`, `last_name`) VALUES ('5', 'Henry', 'James');

-- BOOK
INSERT INTO `library`.`book` (`id`, `title`, `author_id`,  `status`) VALUES ('1', 'book1', '1', 'AVAILABLE');
INSERT INTO `library`.`book` (`id`, `title`, `author_id`,  `status`) VALUES ('2', 'book2', '2', 'AVAILABLE');
INSERT INTO `library`.`book` (`id`, `title`, `author_id`,  `status`) VALUES ('3', 'book3', '3', 'AVAILABLE');
INSERT INTO `library`.`book` (`id`, `title`, `author_id`,  `status`) VALUES ('4', 'book4', '4', 'AVAILABLE');
INSERT INTO `library`.`book` (`id`, `title`, `author_id`,  `status`) VALUES ('5', 'book5', '5', 'AVAILABLE');
INSERT INTO `library`.`book` (`id`, `title`, `author_id`,  `status`) VALUES ('6', 'book6', '1', 'AVAILABLE');
INSERT INTO `library`.`book` (`id`, `title`, `author_id`,  `status`) VALUES ('7', 'book7', '2', 'AVAILABLE');
INSERT INTO `library`.`book` (`id`, `title`, `author_id`,  `status`) VALUES ('8', 'book8', '3', 'AVAILABLE');

-- BOOK_AUTHOR
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('1', '2');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('1', '3');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('2', '1');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('2', '3');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('3', '1');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('4', '1');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('4', '2');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('4', '3');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('5', '2');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('5', '4');
INSERT INTO `library`.`book_author` (`book_id`, `co_author_id`) VALUES ('7', '5');

-- COPIES_OF_BOOK
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('1', '1', 'UNAVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('2', '2', 'AVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('3', '3', 'UNAVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('4', '4', 'UNAVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('5', '5', 'AVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('6', '5', 'AVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('7', '6', 'AVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('8', '6', 'AVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('9', '7', 'AVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('10', '7', 'UNAVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('11', '8', 'UNAVAILABLE');
INSERT INTO `library`.`copies_of_books` (`id`, `book_id`, `status`) VALUES ('12', '8', 'UNAVAILABLE');

-- HISTORY_OF_REQUEST
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`) VALUES ('1', '1', '1', '2022-10-19', NULL);
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`) VALUES ('2', '1', '3', '2022-10-19', NULL);
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`) VALUES ('3', '2', '4', '2022-10-19', NULL);
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`) VALUES ('4', '3', '10', '2022-10-19', NULL);
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`) VALUES ('5', '4', '11', '2022-10-19', NULL);
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`) VALUES ('6', '5', '12', '2022-10-19', NULL);
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`, `should_be_return`, `return_date`) VALUES ('7', '5', '5', '2022-10-19', '2022-10-17', '2022-10-30', '2022-10-19');
INSERT INTO `library`.`history_of_request` (`id`, `user_id`, `book_instance_id`, `date_of_request`, `get_book_date`, `should_be_return`, `return_date`) VALUES ('8', '6', '6', '2022-10-19', '2022-10-17', '2022-10-30', '2022-10-19');


