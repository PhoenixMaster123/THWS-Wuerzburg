-- Aufgabe 1

-- INNER JOIN

SELECT lieferant.lnum , lieferung.lnum
FROM lieferant
JOIN lieferung on lieferant.lnum = lieferung.lnum;

 -- Ergebniss: 10 <-> 40 

-- LEFT JOIN

SELECT * -- lieferant.lnum , lieferung.lnum
FROM lieferant
LEFT JOIN lieferung on lieferant.lnum = lieferung.lnum;

 -- Ergebniss: 10 <-> 50 (es gibt null value)
 
 -- alle Lieferanzen, die keine Lieferung haben
 SELECT *
 FROM lieferant
 LEFT join lieferung ON lieferant.lnum = lieferung.lnum
 WHERE lieferung.lnum IS NULL;
 
-- RIGHT JOIN

SELECT * -- lieferant.lnum , lieferung.lnum
FROM lieferant
RIGHT JOIN lieferung on lieferant.lnum = lieferung.lnum;

-- Ergebniss: 10 - 40 <-> 10 - 90 (es gibt null value)

-- OUTER JOIN(UNION ALL GIBT AUCH DIE DUPLIKATE)
SELECT *
FROM lieferant
LEFT JOIN lieferung on lieferant.lnum = lieferung.lnum
UNION
SELECT * 
FROM lieferant
RIGHT JOIN lieferung on lieferant.lnum = lieferung.lnum;

-- Aufgabe 2

SELECT lieferung.anum AS Artikelnummer, SUM(lieferung.anzahl) AS Summe_der_Artikel
FROM lieferung
GROUP BY lieferung.anum;

-- Aufgabe 3

SELECT lieferung.anum , SUM(lieferung.anzahl)
FROM lieferung
JOIN lieferant ON lieferung.lnum = lieferant.lnum
WHERE lieferant.lsitz = 'Mue' AND lieferung.datum BETWEEN '01.01.2003' AND '31.05.2003'
GROUP By lieferung.anum;

-- Aufgabe 4

SELECT SUM(artikel.gewicht * lieferung.anzahl) AS Gesamtgewicht
FROM ARTIKEL
JOIN lieferung ON artikel.anum = lieferung.anum
WHERE artikel.farbe = 'rot';

-- Aufgabe 5

SELECT artikel.farbe AS Farbe, SUM(artikel.gewicht * lieferung.anzahl) AS Gewicht , count(distinct lieferung.anum) AS ANZAHL
FROM lieferung 
JOIN artikel ON lieferung.anum = artikel.anum
WHERE lieferung.datum between '01.01.2002' and ' 31.12.2002'
GROUP BY artikel.farbe;

-- Aufgabe 6
SELECT lieferung.datum AS Datum, lieferant.lsitz AS Stadt, COUNT(*) AS ANZAHL
FROM lieferung
JOIN lieferant ON lieferung.lnum = lieferant.lnum
GROUP BY lieferung.datum, lieferant.lsitz;

-- Aufgabe 7

SELECT lsitz as Stadt, AVG(lieferung.anzahl) AS DURCHSCHINLICH
FROM lieferant
JOIN lieferung ON lieferung.lnum = lieferant.lnum
GROUP BY Stadt;

-- Aufgabe 8

SELECT artikel.farbe , lieferant.lsitz , COUNT(lieferung.anum) AS Anzahl
FROM lieferant
JOIN lieferung ON lieferant.lnum = lieferung.lnum
JOIN artikel ON lieferung.anum = artikel.anum
GROUP BY artikel.farbe , lieferant.lsitz

