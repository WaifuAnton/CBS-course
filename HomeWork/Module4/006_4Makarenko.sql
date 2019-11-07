USE joinsdb;

CREATE VIEW CITY
AS SELECT e.*, i.city FROM Employees AS e
JOIN Info AS i
ON e.id = i.id_employee;

CREATE VIEW NMARRIED_BIRTHDAY
AS SELECT e.*, i.birthday FROM Employees AS e
JOIN Info AS i
ON i.status = "not married" AND e.id = i.id_employee;

CREATE VIEW MANAGER_BIRTHDAY
AS SELECT e.*, i.birthday FROM Employees AS e 
JOIN Positions AS p
ON p.pos = "Manager" AND e.id = p.id_employee
JOIN Info AS i
ON i.id_employee = e.id;

SELECT * FROM CITY;

SELECT * FROM NMARRIED_BIRTHDAY;

SELECT * FROM MANAGER_BIRTHDAY;