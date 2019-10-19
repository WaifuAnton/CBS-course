CREATE DATABASE Business;

USE Business;

CREATE TABLE Dillers
(
	id INT NOT NULL AUTO_INCREMENT,
    name varchar(20),
    item varchar(20),
    PRIMARY KEY(id)
);

CREATE TABLE Staff
(
	id INT NOT NULL AUTO_INCREMENT,
    name varchar(20),
    position varchar(20),
    diller_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY(diller_id) REFERENCES Dillers(id)
);

CREATE TABLE Customers
(
	id INT NOT NULL AUTO_INCREMENT,
    name varchar(20),
    staff_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY(staff_id) REFERENCES Staff(id)
);

INSERT INTO Dillers (name, item)
VALUES
('Anton Anton', 'Anton Item'),
('Pasha Pasha', 'Pasha Item'),
('Serg Serg', 'Serg Item');

INSERT INTO Staff (name, position, diller_id)
VALUES
('Serg Staff', 'Selling manager', 3),
('Pasha Staff', 'Administrator', 2),
('Anton Staff', 'Assistant', 1);

INSERT INTO Customers (name, staff_id)
VALUES
('Pasha', 2),
('Pasha', 2),
('Serg', 1),
('Anton', 3),
('Serg', 3),
('Pasha', 1);

SELECT * FROM Dillers;
SELECT * FROM Staff;
SELECT * FROM Customers;