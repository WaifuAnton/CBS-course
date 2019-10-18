DROP DATABASE CarShop;
CREATE DATABASE CarShop;
USE CarShop;

CREATE TABLE CurrentProducts
(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	mark VARCHAR(10),
    model VARCHAR(20),
    engine_volume DOUBLE,
    price INT,
    speed INT
);

INSERT INTO CurrentProducts (mark, model, engine_volume, price, speed)
VALUES ('Audi', 'A5', 1.5, 10000, 180);

INSERT INTO CurrentProducts (mark, model, engine_volume, price, speed)
VALUES ('Audi', 'A5', 2, 15000, 210);

SELECT * FROM CarShop.CurrentProducts