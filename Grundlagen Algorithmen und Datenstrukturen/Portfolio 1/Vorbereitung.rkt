#lang racket

#;(define x (- (/ (+ 9 6) (* (- 3 1) 5)) (* (- (/ 7 8) 2) 4))) ; Aufgabe 1


(define (g u v w) (+ (/ (- v (* 7 u)) (- u w)) (/ (+ u v) (- (* w 6) v )))) ; Aufgabe 2

#;(define (my-max x y)
(if (> x y)
    x
    y)) ; Aufgabe 3

#;(define (groesser-zehn? x) (if (> x 10) #t #f)) ; Aufgabe 4

#;(define (groesserp? x y z) (if (> (+ x y) z) #t #f)) ; Aufgabe 5

 #;(define (squared-max x y z) (define (square k) (* k k))
  (cond ((> (square x) (and (square y) (square z))) (square x))
        ((> (square y) (and (square x) (square z))) (square y))
        (else (square z)))) ; Aufgabe 6

#;(define (squared-max x y z) ; Aufgabe 6 Variant 2
  (cond ((> (sqr x) (and (sqr y) (sqr z))) (sqr x))
        ((> (sqr y) (and (sqr x) (sqr z))) (sqr y))
        (else (sqr z))))