#lang racket

; SoftUni if Bedingung

; Aufgabe 1 - Excellent Result

(define (grade x)
  (if (>= x 5) "Excellent" ""))

; Aufgabe 2 - Greater Number

(define (numbers x y)
  (if (> x y) x y))

; Aufgabe 3 - Even or Odd

(define (num x)
  (if (= (modulo x 2) 0) "even" "odd"))

; Aufgabe 4 - Password Guess

(define password "s3cr3t!P@ssw0rd")
(define (user x)
  (if (equal? x password) "Welcome" "Wrong password!"))


; Aufgabe 5 - Number 100...200

(define (greater x)
  (cond ((< x 100) "Less than 100")
        ((and (>= x 100) (<= x 200)) "Between 100 and 200")
        ((> x 200) "Greater than 200")))


; Aufgabe 6 - Speed Info

(define (speed x)
  (cond ((<= x 10) "slow")
        ((and (> x 10) (<= x 50)) "average")
        ((and (> x 50) (<= x 150)) "fast")
        ((and (> x 150) (<= x 1000)) "ultra fast")
        ((> x 1000) "extremely fast")))


; Aufgabe 7 - Area of Figures

(define (area figur x y)
  (cond ((equal? figur "square") (* x x))
        ((equal? figur "rectangle") (* x y))
        ((equal? figur "circle") (* pi (sqr x)))
        ((equal? figur "triangle") (/ (* x y) 2))))

