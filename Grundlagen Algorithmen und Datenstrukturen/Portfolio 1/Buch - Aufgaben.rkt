#lang racket

; Aufgabe 1

;(define x (/ (+ 42 (- 25 (* 3 4))) 11)) ; 1b

;(define y (+ (/ (+ 24 32) 7) (* 3 (- 17 15)))) ; 1b

;(define z (- (/ 34428 38) (- 1103 197))) ; 1c

; Aufgabe 2

;(define x (* 4/9 (- 1 (/ 7/2 8)))) ; 2a
;(define y (- 1/3 1/5)) ; 2b
;(define z (/ (- 7 3/4) (+ 2 6.3)))

#;(define x (/ (+ 1/3 4/3) (* 1/3 4/3)))



#; (remainder 490458039881102987 17)

#; (define x (/ (+ 5 4 (- 2 (- 3 (+ 6 4/5)))) (* 3 (* (- 6 2) (- 2 7)))))

; (define (sum-square x y z) (cond (> (sqr x) (and (+ (sqr y) (sqr z))) (sqr x))))


(define (result x) 
  (cond ((> x 3) x)))


(define (betrag x y) (/ (+ (/ x (sqr y)) (* 2 y))3))