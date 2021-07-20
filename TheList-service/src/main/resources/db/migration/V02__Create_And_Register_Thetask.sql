CREATE TABLE task (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_list BIGINT NOT NULL,
	task VARCHAR(255) NOT NULL,
	startdate VARCHAR(50),
    deadline VARCHAR(50),
    FOREIGN KEY (id_list) REFERENCES list(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO task (id_list,task,startdate,deadline) values (1,'Comprar jabuticaba','20-04-2019','20-04-2019');
INSERT INTO task (id_list,task,startdate,deadline) values (1,'Comprar acerola','25-04-2020','25-04-2020');
INSERT INTO task (id_list,task,startdate,deadline) values (2,'Limpar o banheiro','13-09-2020','13-09-2020');
INSERT INTO task (id_list,task,startdate) values (2,'Estudar programação','15-04-2020');
INSERT INTO task (id_list,task) values (3,'Colar');
INSERT INTO task (id_list,task) values (3,'Estrada');

