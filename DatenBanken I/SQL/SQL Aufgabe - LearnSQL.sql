-- SQL Aufgabe - LearnSQL.de

-- Übung 1: Auswählen aller Spalten einer Tabelle
-- Übung: Wählen Sie alle Daten aus der Tabelle distribution_companies.

SELECT * 
FROM distribution_companies;

-- Übung 2: Auswählen einiger Spalten aus einer Tabelle
-- Übung: Wählen Sie für jeden Film den Filmtitel, die IMDb-Bewertung und das Jahr aus, in dem der Film veröffentlicht wurde.

SELECT movie_title , imdb_rating , year_released
FROM movies;

-- Übung 3: Auswahl einiger weniger Spalten und Filtern numerischer Daten in WHERE
-- Übung: Wählen Sie die Spalten movie_title und box_office aus der Tabelle movies. Zeigen Sie nur Filme mit Einnahmen über 300 Millionen Dollar an.

SELECT movie_title , box_office
FROM movies
WHERE box_office > 300;

-> correct

-- Übung 4: Auswählen einiger Spalten und Filtern von Textdaten in WHERE
-- Übung: Wählen Sie die Spalten movie_title, imdb_rating, und year_released aus der Tabelle movies. Zeigen Sie die Filme an, die das Wort "Godfather" im Titel haben.

SELECT movie_title , imdb_rating , year_released
FROM movies
WHERE movie_title like "%Godfather%";

-- Übung 5: Auswählen einiger Spalten und Filtern von Daten mithilfe von zwei Bedingungen in WHERE
-- Übung: Wählen Sie die Spalten movie_title, imdb_rating, und year_released aus der Tabelle movies. Zeigen Sie Filme an, die vor 2001 veröffentlicht wurden und eine Bewertung über 9 hatten.

SELECT movie_title , imdb_rating , year_released
FROM movies
WHERE year_released < 2001 and imdb_rating > 9;

-- -> correct

-- Übung 6: Filtern von Daten mit WHERE und Sortieren der Ausgabe
-- Übung: Wählen Sie die Spalten movie_title, imdb_rating, und year_released aus der Tabelle movies. Zeigen Sie Filme an, die nach 1991 veröffentlicht wurden. Sortieren Sie die Ausgabe nach dem Erscheinungsjahr in aufsteigender Reihenfolge.

SELECT movie_title , imdb_rating , year_released
FROM movies
WHERE year_released > 1991
ORDER BY year_released ASC;

-- Übung 7: Daten nach einer Spalte gruppieren
-- Übung: Zeigen Sie die Anzahl der Filme für jede Sprachkategorie an.

SELECT language , COUNT(*) as number_of_movies
FROM movies
GROUP BY language;

-- Übung 8: Daten nach mehreren Spalten gruppieren
-- Übung: Zeigen Sie die Anzahl der Filme nach Erscheinungsjahr und Sprache an. Sortieren Sie die Ergebnisse nach dem Erscheinungsdatum in aufsteigender Reihenfolge.

SELECT year_released , language, COUNT(*) AS number_of_movies
FROM movies
GROUP BY year_released , language
ORDER BY year_released ASC;

-- Übung 9: Filtern von Daten nach der Gruppierung
-- Übung: Zeigen Sie die gesprochenen Sprachen und das durchschnittliche Filmbudget nach Sprachkategorie an. Zeigen Sie nur die Sprachen mit einem durchschnittlichen Budget von über 50 Millionen Dollar.

SELECT language , AVG(budget) AS movie_budget
FROM movies
GROUP BY language
HAVING AVG(budget) > 50;

-- Übung 10: Auswählen von Spalten aus zwei Tabellen
-- Übung: Zeigen Sie Filmtitel aus der Tabelle moviesjeweils mit dem Namen der Verleihfirma.

SELECT m.movie_title, dc.company_name
FROM movies m
JOIN distribution_company dc ON m.distribution_company_id = dc.id;

SELECT movie_title, company_name
FROM distribution_companies dc
JOIN movies m ON dc.id = m.distribution_company_id;

 