CREATE DATABASE shopdb2;

USE shopdb2;

CREATE TABLE Customers                
(                                      
	CustumerNo int NOT NULL, 
	CustumerName varchar(25) NOT NULL,
	Address1 varchar(25) NOT NULL,
	Address2 varchar(25) NOT NULL,
	City      varchar(15) NOT NULL,
	State char(2) NOT NULL,
	Zip varchar(10) NOT NULL,
	Contact varchar(25) NOT NULL,
	Phone char(12),
	FedIDNo  varchar(10) NOT NULL,
	DateInSystem date NOT NULL 
);

INSERT INTO customers (CustumerNo, CustumerName, Address1, Address2, City, State, Zip, Contact, Phone, FedIDno, DateInSystem)
VALUES
(1, "abcd", "GREG", "GOG", "Kyiv", "K", "00001", "contact1", NULL, "AIFE123", NOW()),
(3, "bava", "GREP", "ABRAV", "Odessa", "O", "02031", "comul", "+38 089 675", "AFE265", NOW());

SELECT * FROM customers;

CREATE INDEX State ON Customers(State);

INSERT INTO customers (CustumerNo, CustumerName, Address1, Address2, City, State, Zip, Contact, Phone, FedIDno, DateInSystem)
VALUES
(8, "biba", "REVO", "GREEE", "Lviv", "L", "111AB", "itemh", NULL, "IDE768", NOW()),
(5, "dino", "DIO", "DIVA", "Don", "D", "23001", "duo", "+23 1213", "9862", NOW());

SELECT * FROM Customers;

DROP INDEX State ON Customers;

ALTER TABLE Customers
ADD PRIMARY KEY(CustumerNo);

ALTER TABLE Customers
DROP PRIMARY KEY;

CREATE INDEX FedIDno ON Customers(FedIDno);

SELECT * FROM CUSTOMERS;

DROP DATABASE shopdb2;