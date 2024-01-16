-- Aufgabe 1

SELECT distinct audiocd.id , audiocd.title
FROM audiocd
JOIN track on audiocd.id = track.audiocd_id
JOIN artist on track.artist_id = artist.id
WHERE artist.name = 'Jackson';

-- Aufgabe 2

SELECT artist.name, COUNT(DISTINCT track.audiocd_id) AS Anzahl_CDS
FROM track
JOIN artist ON track.artist_id = artist.id
GROUP BY artist.name;

-- Aufgabe 3

SELECT audiocd.id, audiocd.title
FROM audiocd
JOIN track on track.audiocd_id = audiocd.id
JOIN song on song.id = track.song_id
WHERE audiocd.title = song.name
GROUP BY audiocd.id, audiocd.title;

-- Aufgabe 4

SELECT *
FROM

(SELECT audiocd.id , audiocd.trackcount, count(*)
FROM audiocd
JOIN track ON audiocd.id = track.audiocd_id
GROUP BY audiocd.id , audiocd.trackcount) AS COMPARE(audioid, audiocd , realtracks)

WHERE audiocd <> realtracks;

-- Aufgabe 5

SELECT audiocd.title
FROM audiocd
JOIN track on audiocd.id = track.audiocd_id
JOIN song on track.song_id = song.id
WHERE song.name like '%Music%' or song.name like '%ll%'
group by audiocd.title
having count(audiocd.title) >= 2

