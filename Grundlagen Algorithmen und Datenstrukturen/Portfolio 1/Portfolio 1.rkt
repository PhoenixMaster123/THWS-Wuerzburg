#lang racket

; Aufgabe 1

(define (f a b c d e)
  (or (and a b d e) (not (or (and c a d) (not (and a c))))))

(f #f #f #f #t #t)


; Aufgabe 2

(define (tetraederzahl n)
  (/ (* n (+ n 1) (+ n 2)) 6))

(tetraederzahl 1)
(tetraederzahl 6)

; Aufgabe 3

(define (preis kwh)
  (cond ((< kwh 2000) (* (* kwh 0.20) 1.1))
        ((>= kwh 3500) (* (* kwh 0.20) 0.95))
        (else (* kwh 0.20))))

(preis 2500)

; Aufgabe Beschreibung:
; Der Stromanbieter cheatEnergy berechnet die Tarife für seine Kunden nach folgendem Schema:
; Der Grundpreis pro kWh beträgt 0.20$. Gibt der Kunde seinen Jahresverbrauch mit weniger als 2000kWh an, so erhöht sich der Preis pro kWh um 10%.
; Gibt der Kunde seinen Jahresverbrauch mit mindestens 3500kWh an, so verringert sich der Preis pro kWh um 5%. Schreiben Sie eine prozedur preis, die
; den geschätzten Jahresverbrauch des Kunden entgegennimmt und damit die Kosten des Stroms für ein Jahr unter Berücksichtigung der obigen Preisausgestaltung berechnet.

