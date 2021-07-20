CREATE TABLE list (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO list (title) values ('Lista de compras');
INSERT INTO list (title) values ('Lista de afazeres');
INSERT INTO list (title) values ('Lista de coisas');

