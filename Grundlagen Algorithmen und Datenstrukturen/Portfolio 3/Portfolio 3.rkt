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

; Aufgabe 3 - falsch

(define (sortieren liste praedikat)
  (define (filter-predicate element)
    (if (praedikat element) #t #f))
  
  (define (partition lst pred)
    (if (null? lst)
        (cons '() '())
        (if (pred (car lst))
            (cons (cons (car lst) (car (partition (cdr lst) pred))) (cadr (partition (cdr lst) pred)))
            (cons (car (partition (cdr lst) pred)) (cons (car lst) (cadr (partition (cdr lst) pred)))))))
  
  (append (partition (filter filter-predicate liste) praedikat)))



(sortieren '(1 2 3 4 5 6 7 8 9) odd?)
