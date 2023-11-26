#lang racket

; Aufgabe 1 - Summe von Zahlen

(define (summe n)
  (if (= n 0)
      n
      (+ n (summe (- n 1)))))

; Aufgabe 2 - Exponentiation

(define (exponent a n)
  (exp a n 1))

(define (exp zahl n ergebnis)
  (if (= n 0)
      ergebnis
      (exp zahl (- n 1) (* zahl ergebnis))))

; Aufgabe 3 - Binomialkoeffizient

(define (C n k)
  (/ (fakt-n n) (* (fakt-k k) (fakt-ergebnis (- n k)))))


(define (fakt-n n)
  (if (= n 0)
      1
      (* n (fakt-n (- n 1)))))

(define (fakt-k k)
  (if (= k 0)
      1
      (* k (fakt-k (- k 1)))))

 (define (fakt-ergebnis result)
   (if (= result 0)
       1
       (* result (fakt-ergebnis (- result 1)))))


; Aufgabe 4 - Höchster gemeinsamer Teiler (HGT):


(define (hgt a b)
  (if (= b 0)
      a
      (hgt b (remainder a b))))

; Aufgabe 5 - Collatz-Folge:

(define (collatz n)
  (if (= n 1)
      '(1)
      (cons n (if (even? n)
                  (collatz (quotient n 2))
                  (collatz (+ (* n 3) 1))))))

; Aufgabe 6 - Anzahl der Ziffern:

(define (ziffern n)
  (counter n 0))


  (define (counter n count)
    (if (= n 0)
        count
        (counter (quotient n 10) (+ count 1))))

; Aufgabe 7 - Gaußsche Summenformel:

(define (summenformel n)
  (if (= n 0)
      n
      (+ n (summenformel (- n 1)))))


; Aufgabe 8 - Potenz von 2:

; Checker if n is potenz of 2
 (define (potenz n)
   (= n (checker n 1)))


  (define (checker n ergebnis)
    (if (<= n 1)
        ergebnis
        (checker (quotient n 2) (* 2 ergebnis))))


; Aufgabe 9 - Zinsen Berechnung

(define (zinsen-rekursiv kapital zinssatz jahre)
  (if (= jahre 0)
      kapital
      (zinsen-rekursiv (+ kapital (* kapital (/ zinssatz 100.0))) zinssatz (- jahre 1))))



; Aufgabe 10 -  Berechnung des Fibonaccisums

(define (fibonacci-sum n)
  (if (= n 0)
      0
      (+ (fibonacci n) (fibonacci-sum (- n 1)))))

(define (fibonacci n)
  (if (< n 2)
      n
      (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

; Aufgabe 11 - Tribonacci-Zahlen

(define (tribonacci n)
  (cond ((= n 0) 0)
        ((or (= n 1) (= n 2)) 1)
        (else (+ (tribonacci (- n 1))
                 (tribonacci (- n 2))
                 (tribonacci (- n 3))))))


; Aufgabe 12 - Hyperfaktorials

(define (hyperfakt n)
  (hyper-iter n n 1))

  (define (hyper-iter n counter ergebnis)
    (if (= n 0)
        ergebnis
        (hyper-iter (- n 1) (- counter 1) (* (expt n counter) ergebnis))))

; Aufgabe 13 - Berechnung der Katalanzahlen


(define (catalan n)
  (if (= n 0)
      1
      (/ (* 2 (- (* 2 n) 1) (catalan (- n 1)))
         (+ n 1))))



     

  