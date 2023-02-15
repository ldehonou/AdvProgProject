CREATE DATABASE IF NOT EXISTS interns;
use interns;

DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
  ID int(11) NOT NULL AUTO_INCREMENT,
  USERNAME varchar(255),
  PRIMARY KEY (ID)
);

INSERT INTO user(username) VALUES ('toto');