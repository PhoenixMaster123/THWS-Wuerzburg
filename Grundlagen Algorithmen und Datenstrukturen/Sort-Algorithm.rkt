#lang racket

; Sort elements with aufsteigender oder absteigend Reihenfolge
(define (insert x sorted)
  (cond ((null? sorted) (list x))
        ((< x (car sorted)) (cons x sorted))
        (else (cons (car sorted) (insert x (cdr sorted))))))

(define (insertion-sort lst)
  (if (null? lst)
      '()
      (insert (car lst) (insertion-sort (cdr lst)))))
  
(insertion-sort '(1 2 4 5 11 9 2))

