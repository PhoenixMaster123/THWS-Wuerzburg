#lang racket

; Aufgabe 1

; Entfernen jedes zweite Element in einem List

(define (entfernen lst)
  (helper-entfernen lst 1 '()))

(define (helper-entfernen lst counter result)
  (if (null? lst)
      result
     (helper-entfernen (cdr lst) (+ counter 1) (if (= (remainder counter 2) 0) result (append result (list (car lst)))))))

(entfernen '(1 2 3 4 5 6)) ; -> (1 3 5) 

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


(display (primfaktorzerlegung 36)) ; Ausgabe: (2 2 3 3)
//////////////////////////////////////// Variant 2 /////////////////////////////////////
(define (primfaktorzerlegung2 zahl)
  (helper-zerlegung zahl 2 '()))

(define (helper-zerlegung zahl faktor result)
  (cond ((= zahl 1) result)
        ((= (remainder zahl faktor) 0) (helper-zerlegung (/ zahl faktor) faktor (append result (list faktor))))
        (else (helper-zerlegung zahl (+ faktor 1) result))))

