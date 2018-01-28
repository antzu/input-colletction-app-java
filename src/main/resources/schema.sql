DROP SCHEMA public CASCADE;

CREATE SEQUENCE seq1 START WITH 1;
CREATE SEQUENCE formgroupseq START WITH 1;

CREATE TABLE Customer (
       id BIGINT NOT NULL PRIMARY KEY,
       firstName VARCHAR(255),
       lastName VARCHAR(255),
       code VARCHAR(255),
       type VARCHAR(255)
);
CREATE TABLE Phone (
       id BIGINT NOT NULL PRIMARY KEY,
       customerId BIGINT NOT NUll,
       type VARCHAR(255),
       value VARCHAR(255)
);

CREATE TABLE Formgroup(
       id BIGINT NOT NULL PRIMARY KEY,
       name VARCHAR(255) NOT NULL
);

INSERT INTO Formgroup (id, name) VALUES (NEXT VALUE FOR formgroupseq, 'Planning');
INSERT INTO Formgroup (id, name) VALUES (NEXT VALUE FOR formgroupseq, 'Production');
