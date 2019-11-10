USE joinsdb;

SELECT * FROM employees;
SELECT * FROM info;
SELECT * FROM positions;

DELETE FROM employees WHERE id = 6;

INSERT INTO info (id_employee, birthday, status, city)
VALUES
(6, "1989-12-3", "married", "Poznan");

INSERT INTO info (id_employee, birthday, status, city)
VALUES
(9, "1970-11-2", "married", "Poznan");

INSERT INTO positions (id_employee, pos, salary)
VALUES
(6, "Office worker", 50000),
(9, "Manager", 100000);

DELETE FROM info WHERE info.id_employee = 6;

DROP TRIGGER IF EXISTS delete_employee;

DELIMITER |
CREATE TRIGGER delete_employee
BEFORE DELETE ON employees FOR EACH ROW
BEGIN
	DELETE FROM positions WHERE positions.id_employee = OLD.id;
    DELETE FROM info WHERE info.id_employee = OLD.id;
END|

DELETE FROM employees WHERE id = 12;