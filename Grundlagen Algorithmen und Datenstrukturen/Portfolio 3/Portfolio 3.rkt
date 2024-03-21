#lang racket

; Aufgabe 1

(define (anpassen liste)
  (helper-anpassen (filter even? liste) '()))

(define (helper-anpassen lst result)
  (if (null? lst)
      result
      (helper-anpassen (cdr lst) (if (integer? (/ (car lst) 10))(append result (list (expt (car lst) 2))) (append result (list (car lst)))))))

; Aufgabe 2

(define (gleich? liste)
  (helper-gleich liste 0 0))

(define (helper-gleich lst positive negative)
  (if (null? lst)
      (if (= positive negative) #t #f)
      (helper-gleich (cdr lst) (if (>= (car lst) 0) (+ positive 1) positive) (if (<= (car lst) 0) (+ negative 1) negative))))

; Aufgabe 3

(define (sortieren liste preadikat)
  (append (filter preadikat liste) (filter (lambda (x) (not (odd? x))) liste)))

(sortieren '(1 2 3 4 5 6 7 8 9) odd?)
