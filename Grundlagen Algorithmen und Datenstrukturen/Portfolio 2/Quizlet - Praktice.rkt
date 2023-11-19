#lang racket

; Aufgabe 1 - Rekursiv - Quadrat -> Sum

(define (summe-der-quadrat n)
  (if (< n 1)
        0
      (+ (sqr n) (summe-der-quadrat (- n 1)))))

; Aufgabe 1 - Iterativ

(define (sdq-iter n ergebnis)
  (if (= n 1)
      (+ 1 ergebnis)
      (sdq-iter (- n 1) (+ ergebnis (* n n)))))

(define (summe-der-quadrat2 n)
  (if (= n 0)
      0
      (sdq-iter n 0)))

       
; Aufgabe 2 - Rekursiv - Sum -> Quadrat

(define (quadrat n)
  (if (< n 0)
      0
      (+ n (quadrat (- n 1)))))

(define (quadrat-der-summe n)
  (expt (quadrat n) 2))

; Aufgabe 2 - Iterativ

(define (quadrat-iter n ergebnis)
  (if (< n 0)
      (expt ergebnis 2)
      (quadrat-iter (- n 1) (+ ergebnis n))))

(define (quadrat-der-summe2 n)
  (quadrat-iter n 0))

; Aufgabe 3 - Polindromzahl

(define (drehe-iter zahl ergebnis)
  (if (< zahl 10)
      (+ (* 10 ergebnis) zahl)
      (drehe-iter (quotient zahl 10) (+ (* 10 ergebnis) (remainder zahl 10)))))

(define (drehe zahl)
(drehe-iter zahl 0))

(define (polindrom n)
  (= n (drehe n)))

; Schritt für Schritt

; Beispiel - (drehe 12321):

;Ruft drehe-iter auf mit zahl = 12321 und ergebnis = 0.
;(< zahl 10) ist falsch (weil 12321 nicht kleiner als 10 ist), daher gehen wir zum zweiten Zweig.
;(quotient 12321 10) ist 1232 (Ganzzahldivision von 12321 durch 10).
;(* 10 0) ist 0.
;(remainder 12321 10) ist 1 (Rest der Division von 12321 durch 10).
;(drehe-iter 1232 (+ (* 10 0) 1)): Hier erfolgt ein rekursiver Aufruf mit aktualisierten Werten.

; Aufgabe 4 - Einstellige-Quersumme

(define (einstellige-quersumme n)
  (if (< n 10)
      n
      (einstellige-quersumme (sum-of-digits n))))

(define (sum-of-digits zahl)
  (if (< zahl 10)
      zahl
      (+ (remainder zahl 10) (sum-of-digits (quotient zahl 10)))))

; Aufgabe 5 - Apply-two

(define (apply-two n f g)
  (g (f n)))

(define (prozeduren n)
  (lambda (x) ; The returned lambda function takes an argument x
    (apply-two x
               (lambda (y) (* y 3)) ; First lambda function: x * 3
               (lambda (z) (* z 10))))) ; Second lambda function: x * 10

; Example usage:
(define result (prozeduren 2))

(display "Result: ")
(display (result 3)) ; Applying the composed function to 1
(newline)

; Aufgabe 6 - quersumme - kleiner 5

(define (einstellige-quersumme2 n) ; 153
      (sum-of-digits2 n 0))

(define (sum-of-digits2 zahl ergebnis) ; 153 -> 15
  (if (< zahl 10)
      (if (>= (remainder zahl 10) 5)
          ergebnis
          (+ ergebnis (remainder zahl 10)))
      (sum-of-digits2 (quotient zahl 10) ; 15
                      (if (< (remainder zahl 10) 5)  ; 3            
            (+ (remainder zahl 10) ergebnis) 
             (+ 0 ergebnis)))))




















   