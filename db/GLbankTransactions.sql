CREATE TABLE BankTransactions (idbt INT AUTO_INCREMENT,
							   amount FLOAT(10,2) NOT NULL,
							   transdatetime datetime NOT NULL,
							   description VARCHAR (144) DEFAULT NULL,
							   idemp INT NOT NULL,
							   sourceAcc BIGINT NOT NULL,
							   destinationAcc BIGINT NOT NULL,
							   srcBank INT NOT NULL,
							   destBank INT NOT NULL,
							   PRIMARY KEY(idbt),
							   FOREIGN KEY(idemp) REFERENCES Employees(idemp)
							   );
						
CREATE TABLE CashTransactions (idct INT AUTO_INCREMENT,
							   idemp INT NOT NULL,
							   amount FLOAT(10,2) DEFAULT 0 NOT NULL,
							   idacc BIGINT NOT NULL,
							   cashdatetime DATETIME NOT NULL,
							   PRIMARY KEY(idct),
							   FOREIGN KEY(idemp) REFERENCES Employees(idemp),
							   FOREIGN KEY(idacc) REFERENCES Accounts(idacc)
							   );
							   
CREATE TABLE AtmWithdrawals (idAtmw INT AUTO_INCREMENT,
							 amount INT NOT NULL,
							 atmdatetime DATETIME DEFAULT CURRENT_TIMESTAMP,
							 idatm INT NOT NULL DEFAULT 0,
							 idCard INT NOT NULL,
							 PRIMARY KEY(idAtmw),
							 FOREIGN KEY(idCard) REFERENCES Cards(idCard)
							 ON DELETE CASCADE
							 ON UPDATE RESTRICT
							 );
							   
CREATE TABLE Cards (idCard INT AUTO_INCREMENT,
				    cardNumber BIGINT UNIQUE NOT NULL,
				    idacc BIGINT NOT NULL,
					pin INT(4) NOT NULL DEFAULT 0,
				    blocked CHAR (1) DEFAULT 'F',
				    PRIMARY KEY(idCard),
				    FOREIGN KEY(idacc) REFERENCES Accounts(idacc)
					ON DELETE CASCADE
					ON UPDATE RESTRICT
				    );
							  
CREATE TABLE WrongPins (idWrongPins INT AUTO_INCREMENT,
						cardNumber BIGINT UNIQUE NOT NULL,
						wrongPinCount INT NOT NULL,
						PRIMARY KEY(idWrongPins),
						FOREIGN KEY(cardNumber) REFERENCES Cards(cardNumber)
						ON DELETE CASCADE
						ON UPDATE RESTRICT
						);	

INSERT INTO Cards (cardNumber, idacc, pin) VALUES(7000600050004000,502330928,1111);							  