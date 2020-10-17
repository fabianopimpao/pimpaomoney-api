CREATE TABLE PERSON (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    street VARCHAR(255),
    number VARCHAR(10),
    complement VARCHAR(50),
    neighborhood VARCHAR(100),
    zip VARCHAR(10),
    city VARCHAR(50),
    state VARCHAR(50),
    active BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Pedro Barbosa', 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Henrique Medeiros', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Carlos Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Leonardo Oliveira', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO PERSON(name, street, number, complement, neighborhood, zip, city, state, active) VALUES ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);