CREATE DATABASE ElectricityItems;

DROP database ElectricityItems;

USE ElectricityItems;

CREATE TABLE items
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    power INT,
    turnedOn BOOLEAN
);

CREATE TABLE conditioners
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    power INT,
    minTemperature INT,
    maxTemperature INT,
    turnedOn BOOLEAN
);

CREATE TABLE washingMachines
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    power INT,
    maxClothesWeight INT,
    turnedOn BOOLEAN
);

CREATE TABLE kettles
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    power INT,
    liters INT,
    turnedOn BOOLEAN
);

INSERT INTO conditioners (name, power, minTemperature, maxTemperature, turnedOn) VALUES ("Mitsubishi", 12, 15, 25, 1);