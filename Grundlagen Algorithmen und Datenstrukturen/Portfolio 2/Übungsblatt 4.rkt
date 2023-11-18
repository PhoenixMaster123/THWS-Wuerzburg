#lang racket

; Aufgabe 1

(define (ganzzahlige-wurzel? n)
  (if (integer? (sqrt n)) #t #f))



; Aufgabe 2

(define (fakt n)
  (if (even? n)
      2
      (helper n (ceiling (sqrt n)))))

(define (helper n a)
  (define b-sqrt (- (sqr a) n))

    (if (integer? (sqrt b-sqrt))
        (- a (sqrt b-sqrt))
        (helper n (+ a 1))))

;////////////////////////////////////////////// Aufgabe 2 - Variant 2 /////////////////////////////////////////////////////////

(define (fakt2 n)
  (if (even? n)
      2
  (prozedur (ceiling (sqrt n)) (- (quadrat (ceiling (sqrt n))) n) n)))

(define (prozedur a b n)
  (if (integer? (sqrt b))
      (- a (sqrt b))
      (prozedur (+ a 1) (- (quadrat (+ a 1)) n) n)))

(define (quadrat x) (* x x))


; Aufgabe 3

(define (primzahl? n)
  (cond (( not (integer? n)) #f)
        ((<= n 1) #f)
        ( (or  (= (fakt2 n) 1.0) (= n 2)) #t)
        (else (#f))))


; Aufgabe 4

(define (kubiksumme n)
  (expt (kubik-helper n) 3))

(define (kubik-helper n)
  (if(= n 0)
     n
     (+ (remainder n 10) (kubik-helper (quotient n 10)))))


; Aufgabe 5

(define (caesar_encrypt n k)
  (helper3 n k 0 0))

(define (helper3 n k result position)
  (if (= n 0)
      result
      (helper3 (quotient n 10) k (+ result (* (remainder (+ k (remainder n 10)) 10) (expt 10 position))) (+ position 1))))


;////////////////////////////////////////////// Aufgabe 5 - Variant 2 /////////////////////////////////////////////////////////

(define (ziffer_hochzahlen x k)
  (remainder (+ x k) 10)) ; 8 4 -> 12 / 10 -> 2
(define (caesar_encrypt2 n k)
  (cond ((= n 0) 0)
        (else (+ ( * 10 (caesar_encrypt(quotient n 10) k)) (ziffer_hochzahlen (remainder n 10) k)))))

