/**
CREATE TABLE person (
    id integer not null,
    name varchar(255),
    location varchar(255),
    birth_date timestamp,
    primary key (id)
);
*/

INSERT INTO person
    (id, name, location, birth_date)
    VALUES (10001, 'Marius', 'Bucharest', sysdate());

INSERT INTO person
    (id, name, location, birth_date)
    VALUES (10002, 'Robert', 'Bucharest', sysdate());

INSERT INTO person
    (id, name, location, birth_date)
    VALUES (10003, 'Gabi', 'Bucharest', sysdate());