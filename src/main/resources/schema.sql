DROP SCHEMA public CASCADE;

CREATE SEQUENCE seq1 START WITH 1;
CREATE SEQUENCE projectseq START WITH 1;
CREATE SEQUENCE formgrouptempseq START WITH 1;
CREATE SEQUENCE formfieldtempseq START WITH 1;
CREATE SEQUENCE formgroupseq START WITH 1;
CREATE SEQUENCE formfieldseq START WITH 1;
CREATE SEQUENCE formvalueseq START WITH 1;

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

CREATE TABLE Project(
      id BIGINT NOT NULL PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      createdBy VARCHAR (255) NOT NULL,
      createdOn TIMESTAMP NOT NULL
);

INSERT INTO Project (id, name, createdBy, createdOn) VALUES (NEXT VALUE FOR projectseq, 'New project', 'Andres', now());

CREATE TABLE FormgroupClassifiers(
      id BIGINT NOT NULL PRIMARY KEY,
      name VARCHAR (255) NOT NULL
);

INSERT INTO FormgroupClassifiers (id, name) VALUES (NEXT VALUE FOR formgrouptempseq, 'Planning');
INSERT INTO FormgroupClassifiers (id, name) VALUES (NEXT VALUE FOR formgrouptempseq, 'Production');

CREATE TABLE FormfieldClassifiers(
      id BIGINT NOT NULL PRIMARY KEY,
      formgroupId BIGINT NOT NULL,
      name VARCHAR(255) NOT NULL,
      type VARCHAR (255) NOT NULL
);

INSERT INTO FormfieldClassifiers (id, formgroupId, name, type) VALUES (NEXT VALUE FOR formfieldtempseq, 1, 'SKU name', 'text');
INSERT INTO FormfieldClassifiers (id, formgroupId, name, type) VALUES (NEXT VALUE FOR formfieldtempseq, 1, 'Producer', 'text');
INSERT INTO FormfieldClassifiers (id, formgroupId, name, type) VALUES (NEXT VALUE FOR formfieldtempseq, 2, 'Minumum produ qty', 'text');
INSERT INTO FormfieldClassifiers (id, formgroupId, name, type) VALUES (NEXT VALUE FOR formfieldtempseq, 2, 'Production time days', 'text');


CREATE TABLE Formgroup(
       id BIGINT NOT NULL PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       projectId BIGINT NOT NULL
);

CREATE TABLE Formfield(
       id BIGINT NOT NULL PRIMARY KEY,
       formgroupId BIGINT NOT NULL,
       name VARCHAR(255) NOT NULL,
       type VARCHAR (255) NOT NULL
);

CREATE TABLE Formvalue(
      id BIGINT NOT NULL PRIMARY KEY,
      formfieldId BIGINT NOT NULL,
      value VARCHAR (255)
);

INSERT INTO Formgroup (id, name, projectId) VALUES (NEXT VALUE FOR formgroupseq, 'Planning', 1);
INSERT INTO Formgroup (id, name, projectId) VALUES (NEXT VALUE FOR formgroupseq, 'Production', 1);

INSERT INTO Formfield (id, formgroupId, name, type) VALUES (NEXT VALUE FOR formfieldseq, 1, 'SKU name', 'text');
INSERT INTO Formfield (id, formgroupId, name, type) VALUES (NEXT VALUE FOR formfieldseq, 1, 'Producer', 'text');
INSERT INTO Formfield (id, formgroupId, name, type) VALUES (NEXT VALUE FOR formfieldseq, 2, 'Minumum produ qty', 'text');
INSERT INTO Formfield (id, formgroupId, name, type) VALUES (NEXT VALUE FOR formfieldseq, 2, 'Production time days', 'text');

INSERT INTO Formvalue (id, formfieldId, value) VALUES (NEXT VALUE FOR formvalueseq, 1, 'Saku Kuld');
INSERT INTO Formvalue (id, formfieldId, value) VALUES (NEXT VALUE FOR formvalueseq, 2, 'Saku Õlletehas');

