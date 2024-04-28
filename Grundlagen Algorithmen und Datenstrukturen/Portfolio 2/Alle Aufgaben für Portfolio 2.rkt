#lang racket
(require math/number-theory)
; Portfolio 2 -> alle Aufgabeben von den Übungsblätter

; Übungsblatt 2

; Aufgabe 1

(define (nat-wurzel x)
  (helper-nat x 1 0))

(define (helper-nat x counter result)
  (if (> counter x)
      (sqrt result)
      (helper-nat x (+ counter 2) (+ result counter))))

;(nat-wurzel 11)

; Aufgabe 2

(define (zahl-umdrehen x)
  (string->number (list->string (reverse (string->list (number->string x))))))

;(zahl-umdrehen 597050)

; Übungsblatt 3

; Aufgabe 1

(define (sinus-approx x)
  (helper-approx x))

(define (helper-approx x)
  (cond ((<= x 0.1) x)
        (( (- (* 3 (helper-approx (/ x 3))) (* 4 (helper-approx (expt (/ x 3) 3))))))))


; Aufgabe 2

(define (count-perm x)
  (helper-count x 1))

  (define (helper-count x result)
  (if (= x 1)
      result
      (helper-count (- x 1) (* result x))))

;(count-perm 2) 
;(count-perm 3) 
;(count-perm 5)


; Aufgabe 3

(define (isbn-test isbn)
  (helper-isbn isbn 9 0))

(define (helper-isbn isbn counter result)
  (if (zero? isbn)
      (checker result)
      (helper-isbn (quotient isbn 10) (- counter 1) (+ result (* counter (remainder isbn 10))))))


(define (checker result)
  (if (= (remainder result 11) 10) "X"(remainder result 11)))


;(isbn-test 344615497) 
;(isbn-test 026201153) 
;(isbn-test 392511825)

; Aufgabe 4

(define (zylinder-kegel radius-zylinder hoehe-zylinder radius-kegel hoehe-kegel)
  (quotient (volumen-zylinder radius-zylinder hoehe-zylinder) (volumen-kegel radius-kegel hoehe-kegel)))

(define (volumen-zylinder r h)
  (floor (* pi (expt r 2) h)))

(define (volumen-kegel r h)
  (floor (* 1/3 pi (expt r 2) h)))

;(zylinder-kegel 3 5 3 5)

; Übungsblatt 4

; Aufgabe 1

(define (ganzzahlige-wurzel? n)
  (if (integer? (sqrt n)) #t #f))

;(ganzzahlige-wurzel? 25)
;(ganzzahlige-wurzel? 24)

; Aufgabe 2

(define (fakt n)
  (if (even? n)
      2
      (b-sqrt n (ceiling (sqrt n)))))

(define (b-sqrt n a)
  (if (integer? (sqrt(- (expt a 2) n)))
      (- a (sqrt (- (expt a 2) n)))
      (b-sqrt n (+ a 1))))

;(fakt 2183) 
;(fakt 25) 
;(fakt 100) 
;(fakt 11)

; Aufgabe 3

(define (primzahl? n)
  (cond (( not (integer? n)) #f)
        ((<= n 1) #f)
        ( (or  (= (fakt n) 1.0) (= n 2)) #t)
        (else #f)))
  
;(primzahl? 11) 
;(primzahl? 26737) 
;(primzahl? 200) 
;(primzahl? 121)

; Aufgabe 4

(define (kubiksumme n)
  (helper-kubik n 0))

  (define (helper-kubik n result)
    (if (zero? n)
        (expt result 3)
        (helper-kubik (quotient n 10) (+ result (remainder n 10)))))


;(kubiksumme 101042)
;(kubiksumme 34567)

; Aufgabe 5

(define (caesar_encrypt n k)
  (helper-caesar n k))

(define (helper-caesar n k)
  (if (= n 0)
      0
      (+ (* 10 (helper-caesar (quotient n 10) k)) (ziffer_hochzahlen (remainder n 10) k))))

(define (ziffer_hochzahlen x k)
(remainder (+ x k) 10))

; /////////////////////////////////////////////////////////////// Variant with list /////////////////////
(define (caesar n k)
  (helper-caesar2 (string->list (number->string n)) k '()))

  (define (helper-caesar2 lst k result)
    (if (null? lst)
        (string->number (list->string result))
        (helper-caesar2 (cdr lst) k (append result  (string->list (number->string (ziffer_hochzahlen (string->number (list->string (list (car lst)))) k)))))))

;(caesar_encrypt 1234 1)
;(caesar_encrypt 7901 2) 
;(caesar_encrypt 987 1)

; Übungsblatt 5

; Aufgabe 1

(define (euler-n n)
  (if (= n 0)
      1
      (+ (/ 1.0 (fakt2 n)) (euler-n (- n 1)))))

(define (fakt2 n)
  (if (= n 0)
      1
      (* n (fakt2 (- n 1)))))


;(euler-n 0)
;(euler-n 1)
;(euler-n 2)
;(euler-n 27)

; Aufgabe 2

(define (ackermann n m)
  (cond ((= n 0) (+ m 1))
        ((= m 0) (ackermann (- n 1) 1))
        (else (ackermann (- n 1) (ackermann n (- m 1))))))

;(ackermann 0 0)
;(ackermann 0 1)
;(ackermann 4 0) 
;(ackermann 3 1) 
;(ackermann 3 9)

; Aufgabe 4

(define (maxziffer n)
(helper-max n 0))

(define (helper-max n ziffer)
  (if (zero? n)
      ziffer
      (helper-max (quotient n 10) (if (> (remainder n 10) ziffer)(remainder n 10) ziffer))))

;(maxziffer 3475376)
;(maxziffer 1012)

; Übungsblatt 6

; Aufgabe 2

(define (gleiche-ziffern zahl)
  (helper-gleich zahl (string-length (number->string zahl))))

(define (helper-gleich zahl length)
  (if (= (quotient zahl (expt 10 (- length 1))) (remainder zahl 10))
      zahl
      (helper-gleich (+ zahl 1) length)))

;(gleiche-ziffern 123)
;(gleiche-ziffern 4567)


; Portfolio 2 -> Winter Semester

; Aufgabe 1

(define (zaehleteiler n)
(helper-teiler n 2 0))

(define (helper-teiler n teiler counter)
  (if (= n teiler)
      counter
      (helper-teiler n (+ teiler 1) (if (integer? (/ n teiler)) (+ counter 1) counter))))

;(zaehleteiler 10)
;(zaehleteiler 16)

; Aufgabe 2

(define (linker-index ziffer zahl)
 (helper-pos ziffer zahl (string-length (number->string zahl)) 1))

(define (helper-pos ziffer zahl length pos)
  (cond
    ((= length 0) #f)
    ((= (quotient zahl (expt 10 (- length 1))) ziffer) pos)
    (else (helper-pos ziffer (remainder zahl (expt 10 (- length 1))) (- length 1) (+ pos 1)))))
      

(linker-index 9 531863)


; Zusätzliche Aufgaben

; binary to decimal

(define (binary-to-decimal binary)
  (if (zero? binary)
      0
      (+ (remainder binary 10) (* 2 (binary-to-decimal (quotient binary 10))))))

;(binary-to-decimal 1111)


; first even then odd

(define (sort digit)
  (helper-sort digit 0 (string-length (number->string digit))))

(define (helper-sort digit result length)
  (+ (sort-odd digit 0 length) (* (sort-even digit 0 length) (expt 10  (string-length (number->string (sort-odd digit 0 length)))))))

(define (sort-even digit result length)
  (if (zero? digit)
      result
      (sort-even (remainder digit (expt 10 (- length 1)))
                 (if (even? (quotient digit (expt 10 (- length 1))))
                 (+ (* result 10) (quotient digit (expt 10 (- length 1))))
                                         result) (- length 1))))

(define (sort-odd digit result length)
  (if (zero? digit)
      result
      (sort-odd (remainder digit (expt 10 (- length 1))) (if (odd?  (quotient digit (expt 10 (- length 1))))
                                         (+ (* result 10) (quotient digit (expt 10 (- length 1))))
                                         result) (- length 1))))

;(sort 543210)

; decimal to binary

(define (convert-to-bin n)
  (define (convert-helper c_number result)
    (let ((q_number (quotient c_number 2)) (r_number (quotient c_number 2)  ))
    (if (> c_number 0)
        (convert-helper (if (= q_number 0) r_number q_number )  (+ (* result 10) (remainder c_number 2)))  result)))
  (convert-helper n 0))

(define (convert-dec-bin n)
  (helper-convert n 0))



; decimal to binary

(define (helper-convert n result)
  (if (zero? n)
      (reverse result)
      (helper-convert (quotient n 2) (+ (* result 10) (remainder n 2)))))

(define (reverse n)
  (helper-reverse n 0))

(define (helper-reverse n result)
  (if (zero? n)
      result
      (helper-reverse (quotient n 10) (+ (* result 10) (remainder n 10)))))

;(convert-dec-bin 111)

; binary to decimal

(define (convert-bin-to-dec n)
  (helper-convert-dec n 0 0))

(define (helper-convert-dec n result counter)
  (if (= n 0)
      result
      (helper-convert-dec (quotient n 10) (+ result (* (expt 2 counter) (remainder n 10))) (+ counter 1))))

;(convert-bin-to-dec 1101111)

;insert left

(define (insert-left n ziffer)
  (helper-insert n ziffer 0 0 (string-length (number->string n))))

(define (helper-insert n ziffer counter result length)
  (cond ((= length 0) result)
        ((= counter 0) (helper-insert n ziffer (+ counter 1) (+ (* result 10) ziffer) length))
        (else (helper-insert (remainder n (expt 10 (- length 1))) ziffer (+ counter 1)
                             (+ (* result 10) (quotient n (expt 10 (- length 1)))) (- length 1)))))
        
  

;(insert-left 12345 4)

; check the if the index digits prim are

(define (prim n index)
  (helper-prim n index (string-length (number->string n))))

(define (helper-prim n index length)
  (if (prime? (quotient n (expt 10 (- length index)))) #t #f))

;(prim 199535 3)

; Polindrom

(define (polindrom? number)
  (helper-polindrom number))

(define (helper-polindrom number)
  (if (= number (reverse-polindrom number 0)) #t #f))

(define (reverse-polindrom number result)
  (if (= number 0)
      result
      (reverse-polindrom (quotient number 10) (+ (* result 10) (remainder number 10)))))

;(polindrom? 102)

; Tribonacci

(define (tribonacci n)
  (cond ((= n 0) 0)
        ((or (= n 1) (= n 2)) 1)
        (else (+ (tribonacci (- n 1)) (tribonacci (- n 2)) (tribonacci (- n 3))))))

; Berechnung des Fibonaccisums

(define (fibonacci-sum n)
  (if (= n 0)
      0
      (+ (fibonacci n) (fibonacci-sum (- n 1)))))

(define (fibonacci n)
  (if (< n 2)
      n
      (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

; Zinsen Berechnung

(define (zinsen-rekursiv kapital zinssatz jahre)
  (if (= jahre 0)
      kapital
      (zinsen-rekursiv (+ kapital (* kapital (/ zinssatz 100.0))) zinssatz (- jahre 1))))


; Is prime?

(define (is-prime zahl)
  (helper-prime zahl 2))

(define (helper-prime zahl divisior)
  (cond ((<= zahl 1) #f)
        ((= zahl 2) #t)
        ((= divisior zahl) #t)
        ((= (remainder zahl divisior) 0) #f)
        (else (helper-prime zahl (+ divisior 1)))))

;(is-prime 199)
        
;GGT

(define (ggt a b)
  (if (= b 0)
      a
      (ggt b (remainder a b))))

;(ggt 40 6)


(define (linker-index3 zahl index)
  (helper-pos3 zahl index (string-length (number->string zahl)) 1))

(define (helper-pos3 zahl index length position)
  (cond ((= length 0) -1)
        ((= position index)
         (if (prime? (quotient zahl (expt 10 (- length 1)))) #t #f))
        (else (helper-pos3 (remainder zahl (expt 10 (- length 1))) index (- length 1) (+ position 1)))))

(define (prim? digit)
  (helper-prim? digit 2))

(define (helper-prim? digit devisor)
  (cond ((<= digit 1) #f)
        ((= digit 2) #t)
        ((= digit devisor) #t)
        ((= (remainder digit devisor)) #f)
        (else (helper-prim? digit (+ devisor 1)))))


 ;(linker-index3 531863 1)
 ;(linker-index3 531863 3)
 ;(linker-index3 531863 8)


; Hoefigste element

(define (hoefigste n)
  (helper-hoefigste n n 0 0))

(define (helper-hoefigste n copy counter result)
  (if (= n 0)
      result
      (cond
        ((< counter (checker-hoef copy 0 (remainder n 10)))
      (helper-hoefigste (quotient n 10) copy (checker-hoef copy 0 (remainder n 10)) (remainder n 10)))
            (else (helper-hoefigste (quotient n 10) copy counter result)))))


(define (checker-hoef n result digit)
  (if (= n 0)
      result
      (checker-hoef (quotient n 10) (if (= (remainder n 10) digit) (+ result 1) result) digit)))

;(hoefigste 14223889)


