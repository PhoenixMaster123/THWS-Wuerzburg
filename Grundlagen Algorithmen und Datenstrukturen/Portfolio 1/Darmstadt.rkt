#lang racket

; Währungsumrechnung

(define (convert-x-to-euro geld value)
  (cond ((eq? value "dollar") (/ geld 1.422))
        ((eq? value "pound") (/ geld 0.881))
        ((eq? value "yen") (/ geld 119.557))
        ((eq? value "franken") (/ geld 1.313))))

(define (convert-euro-to-x geld value)
   (cond ((eq? value "dollar") (* geld 1.422))
        ((eq? value "pound") (* geld 0.881))
        ((eq? value "yen") (* geld 119.557))
        ((eq? value "franken") (* geld 1.313))))

(define (convert-x-to-y geld value1 value2)
  (* (convert-euro-to-x (* (convert-x-to-euro geld value1) 0.99) value2) 0.99))

; Steuern

(define (get-taxrate einkommen)
  (floor (* 0.5 (/ einkommen 1000))))

(get-taxrate 40000)
(get-taxrate 23700)

; Lists
(define (binär-zähler binary)
  (binary-helper binary 0 0 '()))

(define (binary-helper binary counter0 counter1 result)
  (if (null? binary)
      (append result (list counter0) (list counter1))
      (binary-helper (cdr binary) (if (eq? (car binary) '0)(+ counter0 1) counter0) (if (eq? (car binary) '1) (+ counter1 1) counter1) '())))

(binär-zähler '(1 0 1))
(binär-zähler (list 1 0 1 0 0 1))