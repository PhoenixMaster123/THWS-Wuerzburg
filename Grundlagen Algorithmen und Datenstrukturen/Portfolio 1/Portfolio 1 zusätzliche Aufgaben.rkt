#lang racket

; exercism

; Aufgabe 1

(define (triangle a b c)
  (cond ((or (< a 0 ) (< b 0) (< c 0)) "Das ist kein Dreieck")
        ((or (= a b) (= a c) (= b c)) "gleichschenklig")
        ((and (= a b) (= a c)) "gleichseitig")
        (else "ungleichschenklig")))


; Aufgabe 2

(define (input num)
  (cond ((and (= (remainder num 3) 0) (= (remainder num 7) 0)) "PlingPlong")
        ((and (= (remainder num 3) 0) (= (remainder num 5) 0)) "PlingPlang")
        ((and (= (remainder num 5) 0) (= (remainder num 3) 0)) "PlangPling")
        ((and (= (remainder num 5) 0) (= (remainder num 7) 0)) "PlangPlong")
        ((and (= (remainder num 7) 0) (= (remainder num 3) 0)) "PlongPling")
        ((and (= (remainder num 7) 0) (= (remainder num 5) 0)) "PlongPlang")
        ((= (remainder num 3) 0) "Pling")
        ((= (remainder num 5) 0) "Plang")
        ((= (remainder num 7) 0) "Plong")
        (else (string num))))


; Aufgabe 3

(define (budget preis)
  (cond ((>= preis 1500) (* preis 0.9))
        ((< preis 1500) (* preis 1.1))))
        


        