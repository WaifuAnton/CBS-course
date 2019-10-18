CREATE DATABASE MyDB;
USE MyDB;

CREATE TABLE Phones
(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    phone VARCHAR(12)
);

INSERT INTO Phones (name, phone)
VALUES ("Jon Snow", 555-54-45);

INSERT INTO Phones (name, phone)
VALUES ("John Wick", 555-55-55);

INSERT INTO Phones (name, phone)
VALUES ("John Just", 444-55-55)