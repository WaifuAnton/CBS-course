USE joinsdb;

SELECT * FROM employees;
CREATE INDEX name ON employees(name);

SELECT * FROM info;
CREATE INDEX birthday ON employees(birthday);

SELECT * FROM positions;
CREATE INDEX pos ON positions(pos);