CREATE DATABASE GLBank;
USE GLBank;
CREATE TABLE Employees( 
	idemp INTEGER AUTO_INCREMENT,
	firstname VARCHAR(20) NOT NULL,
	lastname VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL UNIQUE,
	position CHAR(1) NOT NULL DEFAULT 'C',
	PRIMARY KEY (idemp) 
);
CREATE TABLE LoginEmployee( 
	id INTEGER AUTO_INCREMENT,
	idemp INTEGER,
	login VARCHAR(15),
	password VARCHAR(60),
	PRIMARY KEY (id),
	FOREIGN KEY (idemp) 
		REFERENCES Employees(idemp)
		ON DELETE CASCADE ON UPDATE RESTRICT 
);
CREATE TABLE HistoryLoginEmployee ( 
	id INTEGER AUTO_INCREMENT,
	idemp INTEGER,
	LoginDate DATETIME,
	PRIMARY KEY (id),
	FOREIGN KEY (idemp) 
		REFERENCES Employees(idemp)
		ON DELETE CASCADE ON UPDATE RESTRICT 
);

CREATE TABLE Clients (
	idc INTEGER AUTO_INCREMENT,
	firstname VARCHAR(20) NOT NULL,
	lastname VARCHAR(20) NOT NULL,
	disable CHAR(1) DEFAULT 'F',
	PRIMARY KEY (idc)
);

CREATE TABLE ClientDetails (
	idcd INTEGER AUTO_INCREMENT,
	idc INTEGER NOT NULL,
	street VARCHAR(20) NOT NULL,
	houseNumber INTEGER NOT NULL,
	postcode CHAR(5) NOT NULL,
	city VARCHAR(20) NOT NULL,
	dob DATE NOT NULL,
	email VARCHAR(30),
	PRIMARY KEY (idcd),
	FOREIGN KEY (idc)
		REFERENCES Clients (idc)
		ON DELETE CASCADE ON UPDATE RESTRICT
);

CREATE TABLE LoginClient (
	idlc INTEGER AUTO_INCREMENT,
	idc INTEGER NOT NULL,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	blocked CHAR(1) DEFAULT 'F',
	PRIMARY KEY (idlc),
	FOREIGN KEY (idc)
		REFERENCES Clients (idc)
		ON DELETE CASCADE ON UPDATE RESTRICT
);

insert into Employees VALUES(1,'Jan','Kollar','kollar@pobox.sk','C');
insert into Employees VALUES(2,'Daniel','Molnar','molnar@pobox.sk','C');
insert into loginemployee values(1,1,'kollar','kollar');
insert into loginemployee values(2,2,'molnar','molnar');

INSERT INTO Clients VALUES(1,'Jozef','Balint','F');
INSERT INTO Clients VALUES(2,'Martin','Molnar','F');
INSERT INTO Clients VALUES(3,'Tana','Pauhoffova','F');
INSERT INTO ClientDetails VALUES(1,1,'Lomnicka',20,'08005','Presov','1994-03-21','jozef@gmail.com');
INSERT INTO ClientDetails VALUES(2,2,'Kosicka',2,'04011','Bardejov','1998-05-15','martin@centrum.sk');
INSERT INTO ClientDetails VALUES(3,3,'Presovska',33,'08001','Kosice','1990-11-01','tana.pau@hotmail.com');
INSERT INTO LoginClient VALUES(1,1,'balint','balint','F');
INSERT INTO LoginClient VALUES(2,2,'molnar','molnar','F');
INSERT INTO LoginClient VALUES(3,3,'pauhoff','pauhoff','F');

CREATE TABLE Accounts (
	idacc BIGINT,
	idc INT NOT NULL,
	balance FLOAT(10,2) NOT NULL,
	PRIMARY KEY (idacc),
	FOREIGN KEY (idc)
		REFERENCES Clients (idc)
		ON DELETE CASCADE ON UPDATE RESTRICT
);

INSERT INTO Accounts VALUES (4561232588,1,80.20);
INSERT INTO Accounts VALUES (5645716857,1,180.20);
INSERT INTO Accounts VALUES (170158527,1,980.20);
INSERT INTO Accounts VALUES (758495375,2,59980.20);
INSERT INTO Accounts VALUES (71737028,2,980.20);

	