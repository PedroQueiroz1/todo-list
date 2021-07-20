CREATE TABLE book (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    justamessage VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO book (justamessage) values ('Congratulations!');
INSERT INTO book (justamessage) values ('You rock!');
INSERT INTO book (justamessage) values ('Very good!');
