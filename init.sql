CREATE DATABASE IF NOT EXISTS tutordb;
use tutordb;

DROP TABLE IF EXISTS MAKE_INTERNSHIP;
DROP TABLE IF EXISTS INTERN;
DROP TABLE IF EXISTS INTERNSHIP;
DROP TABLE IF EXISTS TUTOR;
DROP TABLE IF EXISTS COMPANY;


CREATE TABLE INTERN(
	ID INT NOT NULL AUTO_INCREMENT,
	LASTNAME VARCHAR(25),
	FIRSTNAME VARCHAR(25),
    PHONE VARCHAR(10),
	ADDRESS VARCHAR(150),
	POSTALCODE VARCHAR(15),
	CITY VARCHAR(25),
	EMAIL VARCHAR(25),
    PRIMARY KEY (ID)
);

INSERT INTO INTERN(LASTNAME,FIRSTNAME,PHONE,ADDRESS,POSTALCODE,CITY,EMAIL) VALUES
('Bond','James','0123456789','2 avenue 007','92700','Colombes','jbond@gmail.com');
INSERT INTO INTERN(LASTNAME,FIRSTNAME,PHONE,ADDRESS,POSTALCODE,CITY,EMAIL) VALUES
('Jones','Indiana','0145362787','10 rue des Aventuriers','92270','Bois-colombes','ijones@gmail.com');
INSERT INTO INTERN(LASTNAME,FIRSTNAME,PHONE,ADDRESS,POSTALCODE,CITY,EMAIL) VALUES
('Bourne','Jason','0187665987','65 rue Agent Secret Perdu','92700','Colombes','jbourne@yahoo.fr');
INSERT INTO INTERN(LASTNAME,FIRSTNAME,PHONE,ADDRESS,POSTALCODE,CITY,EMAIL) VALUES
('Stark','Arya','0187611987','6 rue Sans-Nom','75016','Paris','astark@nord.com');
INSERT INTO INTERN(LASTNAME,FIRSTNAME,PHONE,ADDRESS,POSTALCODE,CITY,EMAIL) VALUES
('Lanister','Cersei','0187384987','5 bvd des Reines','21000','Dijon','clanister@mail.co.uk');


CREATE TABLE TUTOR(
        ID INT NOT NULL AUTO_INCREMENT,
        EMAIL VARCHAR(25),
        PASSWORD VARCHAR(25),
        PRIMARY KEY (ID)
);

INSERT INTO TUTOR(EMAIL, PASSWORD) VALUES
('swan@email.com', 'password123');


CREATE TABLE COMPANY(
                        ID INT NOT NULL AUTO_INCREMENT,
                        NAME VARCHAR(25),
                        ADDRESS VARCHAR(25),
                        POSTALCODE VARCHAR(25),
                        CITY VARCHAR(25),
                        PRIMARY KEY (ID)
);

INSERT INTO COMPANY(NAME, ADDRESS, POSTALCODE, CITY) VALUES
('SOCIETE GENERAL', '45 BOULEVARD JOURDAN', '75014', 'Paris');


CREATE TABLE INTERNSHIP(
        ID INT NOT NULL AUTO_INCREMENT,
        ID_COMPANY INT NOT NULL,
        MISSION VARCHAR(300),
        CDC BOOLEAN,
        VISIT_SHEET BOOLEAN,
        EVAL_SHEET BOOLEAN,
        WEB_SURVEY BOOLEAN,
        REPORT BOOLEAN,
        DEFENSE BOOLEAN,
        STARTED_DATE DATE,
        ENDED_DATE DATE,
        PRIMARY KEY (ID),
        CONSTRAINT FK_COMPANY
        FOREIGN KEY (ID_COMPANY) REFERENCES COMPANY(ID)
);

CREATE TABLE MAKE_INTERNSHIP(
        ID INT NOT NULL AUTO_INCREMENT,
        ID_INTERN INT NOT NULL,
        ID_INTERNSHIP INT NOT NULL,
        NOTE_TECH VARCHAR(10),
        NOTE_COM VARCHAR(10),
        CONSTRAINT FK_INTERN
        FOREIGN KEY (ID_INTERN) REFERENCES INTERN(ID),
        CONSTRAINT FK_INTERNSHIP
        FOREIGN KEY (ID_INTERNSHIP) REFERENCES INTERNSHIP(ID),
        PRIMARY KEY (ID)
);