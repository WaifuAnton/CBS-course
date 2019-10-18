USE MyDB;

CREATE TABLE Positions
(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name VARCHAR(50),
    position VARCHAR(50),
    salary INT
);

INSERT INTO Positions (name, position, salary)
VALUES ((SELECT name FROM MyDB.Phones WHERE id = 1), "meteorologist", 10000);

INSERT INTO Positions (name, position, salary)
VALUES ((SELECT name FROM MyDB.Phones WHERE id = 2), "killer", 10000000);

INSERT INTO Positions (name, position, salary)
VALUES ((SELECT name FROM MyDB.Phones WHERE id = 3), "administrator", 1000);

SELECT * FROM MyDB.Positions;