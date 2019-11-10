USE joinsdb;

DELIMITER |
DROP PROCEDURE IF EXISTS task4; |

DELIMITER |
CREATE PROCEDURE task4(IN new_n VARCHAR(30), IN new_ph VARCHAR(20), IN new_s_ph VARCHAR(20))
BEGIN
	START TRANSACTION;
    INSERT INTO employees(name, phone, second_phone)
    VALUES (new_n, new_ph, new_s_ph);
    IF EXISTS (SELECT phone FROM employees WHERE phone = new_ph) THEN
		ROLLBACK;
	END IF;
    IF EXISTS (SELECT second_phone FROM employees WHERE second_phone = new_s_ph) THEN
		ROLLBACK;
	END IF;
    COMMIT;
END|

DELIMITER |
CALL task4("aaa bbovich", "098 888 8860", NULL); |

SELECT * FROM employees; |