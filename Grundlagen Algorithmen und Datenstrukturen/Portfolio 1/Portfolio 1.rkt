#lang racket

; Aufgabe 1

(define (f a b c d e)
  (or (and a b d e) (not (or (and c a d) (not (and a c))))))

(f #f #f #f #t #t)

