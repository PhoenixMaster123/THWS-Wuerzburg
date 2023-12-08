#lang racket

; Aufgabe 1

(define (zaehlen start ende n)
  (define (iter x count pm)
    (cond ((and (= (remainder x 3) 0) (= (remainder x 7) 0)) (iter (+ x pm) (+ count 1) pm))
          ((= count n) (- x pm))
          ((= x ende) 0)
          (else (iter (+ x pm) count pm))))
    (iter start 0 (if (< ende start)
                     -1
                     1)))

; Aufgabe 2

(define (gleiche-ziffern zahl)
  (if (= (firstZiffer (abs zahl)) (remainder (abs zahl) 10))
      zahl
      (gleiche-ziffern (+ zahl 1))))

(define (firstZiffer n)
 ; (if (and (>= n 1) (<= n 9))
  (if (<= n 9)
     n
      (firstZiffer (quotient n 10))))


; Aufgabe 2 - Variant 2 - schwieriger

(define (gleiche-ziffern2 zahl)
  (define (ziffern-länge n)
    (if (< n 10)
        1
        (+ 1 (ziffern-länge (quotient n 10)))))
  
  (define (erste-letzte-gleich? n)
    (if (< n 10)
        #t
        (if (= (quotient n (expt 10 (- (ziffern-länge n) 1))) (remainder n 10)) #t #f)))
  
  (define (erhöhe-zahl n)
    (if (erste-letzte-gleich? n)
        n
        (erhöhe-zahl (+ n 1))))
  (erhöhe-zahl zahl))


; Aufgabe 3

(define (konst-addierer n)
(lambda (x) (+ n x)))

; Aufgabe 4

(define (konst-ggt b)
  (lambda (x)
  (ggt b x)))


(define (ggt a b)
  (if (= b 0)
      a
      (ggt b (remainder a b))))

; Aufgabe 5
(define (paar-operation op)
  (lambda (x) ; 2 . 3
(op (car x) (cdr x))))  ; op(operation) linke Seite 2 rechte Seite 3

; Aufgabe 6

(define nil (list))
(define strukture1 (cons (cons 24 (cons 1 2)) (cons 20 (cons 1 1))))
(define strukture2 (cons (cons 7 (cons 2 (cons 3 (cons 1 nil)))) nil))
(define strukture3 (cons (cons 3 (cons 3 nil)) (cons 3 (cons 3 (cons 3 3)))))
(define strukture4 (cons (cons (cons nil (cons 6 (cons 1 (cons 0 (cons 2 4))))) (cons 3 3)) (cons 10 (cons 7(cons 8(cons 9 (cons 3 nil)))))))

(require sdraw)
(sdraw strukture3 #:null-style '/)






