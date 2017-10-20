DROP SCHEMA public CASCADE;

CREATE SEQUENCE seq1 START WITH 1;

CREATE TABLE customers (
       id BIGINT NOT NULL PRIMARY KEY,
       firstName VARCHAR(255),
       lastName VARCHAR(255),
       code VARCHAR(255)
);

INSERT INTO customers (id, firstName, lastName, code) VALUES (NEXT VALUE FOR seq1, 'Mari', 'Kask', 'A123');
INSERT INTO customers (id, firstName, lastName, code) VALUES (NEXT VALUE FOR seq1, 'Mari2', 'Kask2', 'B123');


