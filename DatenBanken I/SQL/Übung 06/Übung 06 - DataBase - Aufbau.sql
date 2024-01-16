CREATE TABLE Lieferant (
	lnum VARCHAR (10) NOT NULL PRIMARY KEY,
	lname VARCHAR (40),
	lstatus VARCHAR (5),
	lsitz VARCHAR (5)
);

CREATE TABLE Artikel (
	anum VARCHAR (10) NOT NULL PRIMARY KEY,
	aname VARCHAR (40),
	farbe VARCHAR (10),
	gewicht DECIMAL (5),
	lager VARCHAR (10)
);

CREATE TABLE Lieferung (
	lnum VARCHAR (10) NOT NULL,
	anum VARCHAR (10) NOT NULL,
	datum DATE NOT NULL,
	anzahl INTEGER,
	PRIMARY KEY (lnum, anum, datum));
    
INSERT INTO Artikel VALUES
('100', 'Stuhl', 'rot', 15, 'Nord'),
('200', 'Lampe', 'blau', 1, 'Sued'),
('300', 'Tisch', 'rot', 60, 'West'),
('400', 'Schrank', 'gruen', 200, 'Sued'),
('500', 'Spiegel', 'rot', 3, 'Nord'),
('600', 'Ofen', 'rot', 260, 'West')
;

INSERT INTO Lieferant VALUES
('10', 'Albert', 'F', 'Mue'),
('20', 'Bender', 'F', 'Mue'),
('30', 'Helbart', 'G', 'Fra'),
('40', 'Ingbert', 'F', 'Ber'),
('50', 'Moser', 'F', 'Mue')
;

INSERT INTO Lieferung VALUES
('10', '300', '02.01.2003', 5),
('10', '500', '13.02.2003', 1),
('20', '400', '12.01.2003', 2),
('30', '600', '30.04.2003', 3),
('30', '600', '09.05.2003', 2),
('10', '200', '01.01.2002', 7),
('10', '100', '01.02.2002', 3),
('40', '600', '01.03.2002', 1),
('40', '100', '01.04.2002', 2),
('90', '300', '01.05.2002', 6)
;

    
    
