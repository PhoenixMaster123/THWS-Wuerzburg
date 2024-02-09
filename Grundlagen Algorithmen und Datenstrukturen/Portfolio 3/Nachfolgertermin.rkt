#lang racket

; Aufgabe 1

; Entfernen Zweiter Element

(define (entfernen list)
  (helper-entfernen list 0 '()))

(define (helper-entfernen lst counter result)
  (if (null? lst)
      result
      (helper-entfernen (cdr lst) (+ counter 1) (if (and (even? counter) (> counter 0)) result (append result (list (car lst)))))))

; Aufgabe 2

(define (berechnen lst)
  (lambda (x)
    (apply x lst)))

(define numbers '(1 2 3 4 5))

(define add1 (berechnen numbers))
(display (add1 +))

; Aufgabe 3

(define (primfaktorzerlegung zahl)
   (hilfsfunktion zahl 2))

  (define (hilfsfunktion zahl faktor)
    (cond
      ((= zahl 1) '())
      ((= (remainder zahl faktor) 0) (cons faktor (hilfsfunktion (/ zahl faktor) faktor)))
      (else (hilfsfunktion zahl (+ faktor 1)))))


(display (primfaktorzerlegung 36)) ; Ausgabe: (2 2 3)

