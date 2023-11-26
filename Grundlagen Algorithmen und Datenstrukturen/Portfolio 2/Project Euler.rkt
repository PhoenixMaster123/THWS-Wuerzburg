#lang racket



;Problem 16

(define (sum n)
  (helper-sum (expt 2 1000) 0))

(define (helper-sum n ergebnis)
  (if (= n 0)
      ergebnis
      (helper-sum (quotient n 10) (+ (remainder n 10) ergebnis))))
  

; Problem 20

(define (fakt n)
  (helper-fakt (fakt2 n) 0))

  (define (fakt2 n)
    (if (= n 0)
        1
        (* n (fakt2 (- n 1)))))

  (define (helper-fakt n ergebnis)
    (if (= n 0)
        ergebnis
        (helper-fakt (quotient n 10) (+ ergebnis (remainder n 10)))))
