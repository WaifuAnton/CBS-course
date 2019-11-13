CREATE DATABASE test_db;

USE test_db;

CREATE TABLE test_table (
	id INT PRIMARY KEY AUTO_INCREMENT,
    str VARCHAR(20)
);

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';