#lang racket

; Aufgabe 1

(define (zaehleteiler n)
  (if (<= n 1)
      0
  (helper n 0 2)))

(define (helper n ergebnis counter )
  (if (= counter n)
      ergebnis
      (helper n (if (integer? (/ n counter))
                    (+ ergebnis 1)
                    ergebnis) (+ counter 1))))

; Aufgabe 2

(define (left-index digit number)
  (helper2 digit number (string-length (number->string number)) 0 0))

(define (helper2 n number length result next)
  (cond ((and (= (remainder number 10) n ) (= next 0)) length)
        ((> result 0) (- length result))
        ((= number 0) #f)
        (else (helper2 n (quotient number 10) length (if (= (remainder number 10) n) (+ result next) result) (+ next 1)))))

(display (left-index 1 531869))

; ///////////////////////////////////////////////// Varian 2 ///////////////////////////////////

(define (linker-index ziffer zahl)
 (helper-pos ziffer zahl (string-length (number->string zahl)) 1))

(define (helper-pos ziffer zahl length pos)
  (cond
    ((= length 0) #f)
    ((= (quotient zahl (expt 10 (- length 1))) ziffer) pos)
    (else (helper-pos ziffer (remainder zahl (expt 10 (- length 1))) (- length 1) (+ pos 1)))))


