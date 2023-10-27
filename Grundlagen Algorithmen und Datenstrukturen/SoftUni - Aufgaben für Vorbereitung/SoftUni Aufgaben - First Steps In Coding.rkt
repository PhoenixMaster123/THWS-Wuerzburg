#lang racket

; Aufgabe 1 - USD to BGN

(define (bgn x) (* x 1.79549 ))

; Aufgabe 2 - Radians to Degrees

(define (degree x) (* x (/ 180 pi)))

; Aufgabe 3 - Deposit Calculator

(define (deposit x y z) (+  x (* y (/ (* x (/  z 100)) 12))))

; Aufgabe 4 - Vacation Books List

(define (books x y z) (/ (/ x y) z))

; Aufgabe 5 - Supplies for School
(define (calculate-total-cost chemicals markers cleaner discount)
 (let* ((chemical-price 5.80)
         (marker-price 7.20)
         (cleaner-price 1.20)
         (chemicals-cost (* chemicals chemical-price))
         (markers-cost (* markers marker-price))
         (cleaner-cost (* cleaner cleaner-price))
         (total-cost (+ chemicals-cost markers-cost cleaner-cost))
         (discount-amount (/ (* total-cost discount) 100)))
    (- total-cost discount-amount)))
