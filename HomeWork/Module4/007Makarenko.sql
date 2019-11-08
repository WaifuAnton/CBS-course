USE joinsdb;

SELECT * FROM employees;

SELECT * FROM info;

SELECT * FROM positions;

DELIMITER |
CREATE PROCEDURE task1()
BEGIN
	SELECT e.*, i.city FROM employees AS e
    JOIN info AS i
    ON e.id = i.id_employee;
END|

DELIMITER |
CALL task1(); |

DELIMITER |
CREATE PROCEDURE task2()
BEGIN
	SELECT e.*, i.birthday FROM employees AS e
    JOIN info AS i
    ON e.id = i.id_employee AND i.status = "not married";
END|

DELIMITER |
CALL task2(); |

DELIMITER |
CREATE PROCEDURE task3()
BEGIN
	SELECT e.*, i.birthday FROM employees AS e
    JOIN info AS i
    ON i.id_employee = e.id
    JOIN positions AS p
    ON p.id_employee = e.id AND p.pos = "Manager";
END|

DELIMITER |
CALL task3(); |