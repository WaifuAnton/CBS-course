CREATE DATABASE JoinsDB;

USE JoinsDB;

CREATE TABLE Employees
(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    second_phone VARCHAR(20)
);

CREATE TABLE Positions
(
	id_employee INT NOT NULL,
    pos VARCHAR(30),
    salary INT,
    FOREIGN KEY (id_employee) REFERENCES Employees (id),
    PRIMARY KEY (id_employee, pos)
);

CREATE TABLE Info
(
	id_employee INT NOT NULL PRIMARY KEY,
    birthday DATE,
    status VARCHAR(30),
    city VARCHAR(30),
    FOREIGN KEY (id_employee) REFERENCES Employees (id)
);

INSERT INTO Employees (name, phone, second_phone)
VALUES
("Alexandr", "099 999 9999", NULL),
("Anton", "098 888 8800", "050 555 5455"),
("Tony", "070 787 7772", NULL),
("Sofia", "050 555 3423", NULL);

INSERT INTO Positions (id_employee, pos, salary)
VALUES
(1, "CEO", 200000),
(2, "Manager", 100000),
(3, "Office worker", 50000),
(4, "Manager", 120000);

INSERT INTO Info (id_employee, birthday, status, city)
VALUES
(1, "1989-12-3", "not married", "Lviv"),
(2, "1992-1-23", "not married", "Kyiv"),
(3, "1992-5-12", "married", "Berlin"),
(4, "1991-3-2", "married", "Berlin");

SELECT *, (SELECT city FROM Info AS i WHERE i.id_employee = e.id) AS city
FROM Employees AS e;

SELECT *, (SELECT birthday FROM Info AS i WHERE i.id_employee = e.id) AS birthday 
FROM Employees AS e
WHERE e.id IN (SELECT id_employee FROM Info AS i WHERE i.status = "not married");

SELECT *, (SELECT birthday FROM Info AS i WHERE i.id_employee = e.id) AS birthday
FROM Employees AS e
WHERE e.id IN (SELECT p.id_employee FROM Positions AS p WHERE p.pos = "Manager");

-- DROP DATABASE JoinsDB;