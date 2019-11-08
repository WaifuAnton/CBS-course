drop database carsshop; 

create database carsshop; 

use carsshop; 


create table marks(
   id int not null auto_increment primary key,
   mark varchar(20) unique
); 

create table cars(
  id INT NOT NULL auto_increment primary key,
  mark_id INT NOT NULL,
  model varchar(20) NOT NULL,
  price INT NOT NULL,
  foreign key(mark_id) references marks(id)
); 

CREATE TABLE clients
(
	
	 id INT AUTO_INCREMENT NOT NULL,
     name VARCHAR(30),
     age TINYINT,
     phone VARCHAR(15),
     PRIMARY KEY (id)
); 

create table orders(
     id int not null primary key auto_increment,
     car_id int not null,
     client_id int not null,
     foreign key(car_id) references cars(id),
     foreign key(client_id) references clients(id)
); 

INSERT into marks(mark) values('Audi');
INSERT into marks(mark) values('Porsche'); 

insert into cars(mark_id, model, price) values (1, 'A5', 50000); 
insert into cars(mark_id, model, price) values (2, 'panamera', 100000); 
insert into cars(mark_id, model, price) values (2, 'caymen S', 88000); 

insert into clients(name, age) values ('petro', 20), ('vasya', 25), ('vitaly', 75); 

insert into orders(car_id, client_id) values(1, 1), (2, 2), (1, 3);


DELIMITER |
CREATE FUNCTION minAge()
RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE min INT;
    SET min = (SELECT min(age) FROM clients);
    RETURN min;
END
|

DELIMITER |
DROP FUNCTION minAge; |

DELIMITER |
SELECT minAge()|

DELIMITER |
CREATE PROCEDURE allCars(IN clientAge INT)
BEGIN
	DECLARE clientID VARCHAR(30);
    SET clientID = (SELECT id FROM clients WHERE age = clientAge);
    SELECT cl.name, c.model FROM clients AS cl 
    JOIN orders AS o ON cl.id = client_id
    JOIN cars AS c ON o.car_id = c.mark_id
    WHERE c.id = clientID
    GROUP BY model;
END|

DELIMITER |
CALL allCars((SELECT minAge())); |

DELIMITER |
DROP PROCEDURE allCars; |