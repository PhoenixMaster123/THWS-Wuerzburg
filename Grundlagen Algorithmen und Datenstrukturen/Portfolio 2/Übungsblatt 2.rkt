#lang racket


; Aufgabe 1
(define (nat-wurzel n)
  (define (sum result zahl)
    (if (> result n)
        (sqrt zahl)
        (sum (+ result 2) (+ zahl result))))
  (sum 1 0))

;////////////////////////////////////////// Variant 2 - einfacher ////////////////////////////////

;(define (nat-wurzel x)
;(helper-wurzel x 1 0))

;(define (helper-wurzel x counter result)
 ; (if (> counter x)
    ;  (sqrt result)
     ; (helper-wurzel x (+ counter 2) (+ result counter))))


; Aufgabe 2

(define (zahl-umdrehen x) 
  (define (umkehren-helfer zahl result)
    (if (= zahl 0)
        result
        (umkehren-helfer (quotient zahl 10) (+ (* result 10) (remainder zahl 10)))))
  
  (umkehren-helfer x 0))

;////////////////////////////////////////// Variant 2 - einfacher ////////////////////////////////
;(define (zahl-umdrehen x)
  ;(string->number (list->string (reverse (string->list (number->string x))))))


; Aufgabe 3

(define (aufsteigendes-produkt? a b c d) (if (and (< a b c d) (= (* a b c) d)) #t #f))



; Aufgabe 4

;f1
(define (f1 a b) (and (not (or a b)) (or a b) (and a (not b))))
;f2
(define (f2 a b c) (or a (and a b (not c)) (and (not a) c) (and (not(and a b)) c)))
;f3
(define (f3 a b c d) (and (xor (not a) b) (not (or a (not b) c)) (or (not d c b a))))



