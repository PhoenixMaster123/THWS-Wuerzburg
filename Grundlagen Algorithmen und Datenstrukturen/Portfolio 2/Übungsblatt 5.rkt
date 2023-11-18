#lang racket

; Aufgabe 1

(define (euler-n n)
  (if (= n 0)
      1
      (+ (/ 1.0 (fakt n)) (euler-n (- n 1)))))

(define (fakt n)
  (if (= n 0)
      1
      (* n (fakt (- n 1)))))

; Aufgabe 2

(define (ackermann m n)
  (cond ((= m 0) (+ n 1))
        ((= n 0) (ackermann (- m 1) 1))
        (else (ackermann (- m 1) (ackermann m (- n 1))))))



  
; Aufgabe 3

(define (osterformel j)
  (let ( (a (modulo j 19))
         (b (modulo j 4))
         (c (modulo j 7)))
        (let ( (k (round (/ j 100))))
          (let (
                (p (round (/ (+ (* 8 k) 13) 25)))
                (q (round (/ k 4))))
            (let (
                  (M (remainder (- (+ 15 k) p q) 30))
                  (N (remainder (- (+ 4 k) q) 7)))
              (let (
                    (d (remainder (+ (* 19 a) M) 30)))
                (let (
                    (e (remainder (+ (* 2 b) (* 4 c) (* 6 d) N) 7)))
                  (let (
                        (o (+ 22 d e)))
            (+ o 0)))))))))

; Aufgabe 4
(define (maxziffer n)
  (max-helper n 0))

  (define (max-helper n trim)
    (if (= n 0)  ; 123
        trim
        (max-helper (quotient n 10) ; 12
                                     (if
                                     (> trim (remainder n 10)) ; 0 > 3
                                      trim ; Ja
                                     (remainder n 10))))) ; Nein

; Aufgabe 5

(define (sum x y)
  (if (= y 0)
      x
      (n (sum x (- y 1)))))

(define (n x) (+ x 1))

; Aufgabe 6

(define (mul x y)
  (if (= y 0)
      0
      (sum x (mul x (- y 1)))))


; Aufgabe 7

(define (q n)
  (if (<= n 2)
      1
      (+ (q (- n (q (- n 1)))) (q (- n (q (- n 2)))))))

   ; Weil es mehr Spreicherplatz brauche
      
      