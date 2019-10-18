USE MyDB;

CREATE TABLE SocialInfo
(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50),
	family_status VARCHAR(20),
    birthday DATE,
    address VARCHAR(100)
);

INSERT INTO SocialInfo (name, family_status, birthday, address)
VALUES ((SELECT name FROM MyDB.Phones WHERE id = 1), "widower", "1964-03-02", "address1");

INSERT INTO SocialInfo (name, family_status, birthday, address)
VALUES ((SELECT name FROM MyDB.Phones WHERE id = 2), "not married","1986-12-26", "address2");

INSERT INTO SocialInfo (name, family_status, birthday, address)
VALUES ((SELECT name FROM MyDB.Phones WHERE id = 3), "married", "1994-12-16", "address3");

SELECT * FROM MyDB.SocialInfo;