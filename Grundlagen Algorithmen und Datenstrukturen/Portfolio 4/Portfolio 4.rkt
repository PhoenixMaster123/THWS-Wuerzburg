#lang racket

;Aufgabe 1

(define (make-suche praedikat)
  (define (suchen vektor element)
    (define (bin-suche links rechts)
      (let* ((mitte (quotient (+ links rechts) 2))
             (mitte-el (vector-ref vektor mitte)))
        (cond ((= element mitte-el) mitte)
              ((< rechts links) #f)
              ((praedikat element mitte-el) (bin-suche links (- mitte 1)))
              (else (bin-suche (+ mitte 1) rechts)))))
    (bin-suche 0 (- (vector-length vektor) 1)))
  suchen)

(define bs (make-suche <))
(bs #(1 4 9 17 28 35 49) 28)

; Aufgabe 2

(define (teilen str durch)
  (helper str (string (car (string->list durch))) (string (cadr (string->list durch)))))

(define (helper str ele1 ele2)
  (string-split (string-replace (string-replace str ele1 "") ele2 "") " "))



(teilen "nach den Abschluss-Prüfungen, kommen die Ferien" ",-")

; Aufgabe 3

;////////////////////////////////////////////////////////////// Variant 1 //////////////////////////////////////////

(define (ersetzen v pos . data)
  (helper-ersetzen v pos data))

(define (helper-ersetzen vector position daten)
  (cond ((null? daten) vector)
        ((not (richtige-position? position vector)) (helper-ersetzen vector (+ position 1) (cdr daten)))
        (else (vector-set! vector position (car daten)) (helper-ersetzen vector (+ position 1)(cdr daten)))))

(define (richtige-position? position vector)
  (and (integer? position) (>= position 0) (< position (vector-length vector))))


;(ersetzen (vector 0 1 2 3 4 5) 2 42 #t sin)


;////////////////////////////////////////////////////////////// Variant 2 //////////////////////////////////////////
(define (ersetzen2 v pos . data)
  (define new-vector (vector-copy v))
  (vector-set! new-vector pos (car data))
  (helper-ersetzen new-vector (+ pos 1) (cdr data)))

(define (helper-ersetzen2 vector position daten)
  (cond ((null? daten) vector)
        ((not (richtige-position? position vector)) (helper-ersetzen vector (+ position 1) (cdr daten)))
        (else (vector-set! vector position (car daten)) (helper-ersetzen vector (+ position 1) (cdr daten)))))

(define (richtige-position2? position vector)
  (and (integer? position) (>= position 0) (< position (vector-length vector))))

(ersetzen2 (vector 0 1 2 3 4 5) 2 42 #t sin)
