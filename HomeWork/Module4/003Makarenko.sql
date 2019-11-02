CREATE DATABASE army;

USE army;

CREATE TABLE officers
(
	officerID INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(30),
    title VARCHAR(20),
    PRIMARY KEY(officerID)
);

CREATE TABLE weapons
(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    responsible_officer INT,
    FOREIGN KEY(responsible_officer) REFERENCES officers(officerID)
);

CREATE TABLE soldiers
(
    soldierID INT NOT NULL,
    name VARCHAR(30),
    platoon INT,
    weaponID INT NOT NULL,
    PRIMARY KEY(soldierID, weaponID),
    FOREIGN KEY(weaponID) REFERENCES weapons(ID)
);

INSERT INTO officers (name, title) 
VALUES 
("Буров О.С.", "майор"),
("Рибаков Н.Г.", "майор"),
("Деребанов В.А.", "підполковник");

INSERT INTO weapons (name, responsible_officer)
VALUES
("АК-47", 1),
("Глок20", 2),
("АК-74", 3);

INSERT INTO soldiers (soldierID, name, platoon, weaponID)
VALUES
(205, "Петров В.А.", 222, 1),
(205, "Петров В.А.", 222, 2),
(221, "Лодарев П.С.", 232, 3),
(221, "Лодарев П.С.", 232, 2),
(201, "Леонтьєв К.В.", 212, 1),
(201, "Леонтьєв К.В.", 212, 2),
(0, "Духов Р.М.", 200, 1);

SELECT * FROM officers;
SELECT * FROM weapons;
SELECT * FROM soldiers;