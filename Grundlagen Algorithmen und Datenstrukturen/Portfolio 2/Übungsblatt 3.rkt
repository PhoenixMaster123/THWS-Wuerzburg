 #lang racket

; Aufgabe 1

(define (sinus-approx x)
  (if (<= x 0.1)
      x
      (sinus-approx (- (* 3 (sinus-approx (/ x 3)))
                       (* 4 (expt (sinus-approx (/ x 3)) 3))))))

; Aufgabe 2
(define (count-perm x)
  (if (<= x 2)
      x
      (* x (count-perm (- x 1)))))


;///////////////////////////////////////////////// Variant 3 - My(einfacher) //////////////////////////////////
;(define (isbn-test isbn)
 ; (isbn-helper isbn))

;(define (isbn-helper isbn)
 ; (if (= (remainder (sum isbn 9 0) 11) 10) "X"
      ;  (remainder (sum isbn 9 0) 11)))

;(define (sum isbn counter result)
 ; (if (= isbn 0)
    ;  result
    ;  (sum (quotient isbn 10) (- counter 1) (+ result (* (remainder isbn 10) counter)))))

; Aufgabe 3 (einfach)
(define (zerteilen position rest)
  (if (= position 1)
      rest
      (+ (* position (remainder rest 10)) (zerteilen (- position 1)(quotient rest 10)))))

(define (z-iter position rest ergebnis)
  (if (= position 0 )
      ergebnis
      (z-iter (position 1) (quotient rest 10) (+ ergebnis (* position (remainder rest 10))))))

(define (isbn-test isbn)
  (ergebnis (remainder (z-iter 9 isbn 0) 11)))
;(ergebnis (remainder(zerteilen 9 isbn) 11)))

(define (ergebnis rest)
  (if (= rest 10) "X" rest))



; Aufgabe 3 (schwierig)
#;(define (isbn-test isbn)
  (define (isbn-test-iter summe zifferVonIsbn restlicheIsbn counter)
    (if (= counter 0)
        summe
        (isbn-test-iter (+ summe (* counter zifferVonIsbn)) (modulo restlicheIsbn 10) (quotient restlicheIsbn 10) (- counter 1))))
  
  (define gesamtsumme (isbn-test-iter 0 (modulo isbn 10) (quotient isbn 10) 9))

  (if (= (modulo gesamtsumme 11) 10) "X" (modulo gesamtsumme 11)))

; Aufgabe 4
(define (zylinder-kegel radius-zylinder hoehe-zylinder radius-kegel hoehe-kegel)
  (define zylinder-volumen (* pi (sqr radius-zylinder) hoehe-zylinder))
    (define volumen-kegel (* 1/3 pi (sqr radius-kegel) hoehe-kegel))
  (round (/ zylinder-volumen volumen-kegel))) ; quontient -> /

;///////////////////////////////////////////////// Variant 2 - einfacher //////////////////////////////////

;(define (zylinder-kegel radius-zylinder hoehe-zylinder radius-kegel hoehe-kegel)
  ;(zylinder-kegel-helper radius-zylinder hoehe-zylinder radius-kegel hoehe-kegel))

;(define (zylinder-kegel-helper radius-zylinder hoehe-zylinder radius-kegel hoehe-kegel)
 ; (quotient (round (zylinder-volumen  radius-zylinder hoehe-zylinder))  (round (kegel-volumen radius-kegel hoehe-kegel))))

;(define (zylinder-volumen radius-zylinder hoehe-zylinder)
 ; (* pi (expt radius-zylinder 2) hoehe-zylinder))

;(define (kegel-volumen radius-kegel hoehe-kegel)
 ; (* 1/3 pi (expt radius-kegel 2) hoehe-kegel))

;(zylinder-kegel 3 5 3 5)
