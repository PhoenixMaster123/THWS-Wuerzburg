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
  (define (helper n position)
    (if (= n 0)
        #f  ; Return -1 if the digit is not found
        (if (= digit (remainder n 10))
            position
            (helper (quotient n 10) (+ position 1)))))

  (helper number 0))

(display (left-index 3 531863))  ; Should print 3
(newline)




