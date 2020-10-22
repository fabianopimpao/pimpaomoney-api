CREATE TABLE accounting (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50) NOT NULL,
    duo_date DATE NOT NULL,
    payment_date DATE,
    value DECIMAL(10, 2) NOT NULL,
    comments VARCHAR(100),
    type VARCHAR(20) NOT NULL,
    category_id BIGINT(20) NOT NULL,
    person_id BIGINT(20) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (person_id) REFERENCES person(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'DESPESA', 2, 2);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Top Club', '2017-06-10', null, 120, null, 'RECEITA', 3, 3);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'RECEITA', 3, 4);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('DMAE', '2017-06-10', null, 200.30, null, 'DESPESA', 3, 5);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'RECEITA', 4, 6);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Bahamas', '2017-06-10', null, 500, null, 'RECEITA', 1, 7);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'DESPESA', 4, 8);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 9);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'RECEITA', 5, 10);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Café', '2017-06-10', null, 8.32, null, 'DESPESA', 1, 5);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'DESPESA', 5, 4);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Instrumentos', '2017-06-10', null, 1040.32, null, 'DESPESA', 4, 3);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'DESPESA', 4, 2);
INSERT INTO accounting(description, duo_date, payment_date, value, comments, type, category_id, person_id) VALUES ('Lanche', '2017-06-10', null, 10.20, null, 'DESPESA', 4, 1);
