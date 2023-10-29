#lang racket

; Aufgabe 1

;10 ; 10
;(+ 5 3 4) ; 12
;(- 9 1) ; 8
;(/ 6 2) ; 3
;(+ (* 2 4) (- 4 6)) ; 6
;(define a 3)
;(define b (+ a 1)) ; 4
;(+ a b (* a b)) ;19
;(= a b) #f
;(if (and (> b a) (< b (* a b))) ; #t
;b  ; 4
;a)
;(cond ((= a 4) 6)
;((= b 4) (+ 6 7 a)) ; 16
;(else 25))
;(+ 2 (if (> b a) b a)) ; 6
;(* (cond ((> a b) a)
;((< a b) b) ; 4
;(else -1))
;(+ a 1)) ; 4
; 16

; Aufgabe 2

(define x (/ (+ 5 4 (- 2 (- 3 (+ 6 4/5)))) (* 3 (* (- 6 2) (- 2 7)))))

; Aufgabe 3

(define (f x y z)
  (cond ((and (>= x y) (>= y z)) (+ (* x x) (* y y)))
        ((and (>= y x) (>= x z)) (+ (* y y) (* x x)))
        (else (+ (* y y) (* z z)))))

(define (a-plus-abs-b a b)
((if (> b 0) + -) a b))



(define (squar x) (* x x))
(define (square x) (exp (double (log x))))
(define (double x) (+ x x))
