#lang racket
; Sortieren

; bubble sort

(define (bubbleH L) 
    (bubble-sort-aux (length L) L))

(define (bubble-sort2 L)
    (if (null? (cdr L))   
        L    
        (if (< (car L) (cadr L))   
            (cons (car L) (bubble-sort2 (cdr L)))   
            (cons (cadr L) (bubble-sort2 (cons (car L) (cddr L)))))))

(define (bubble-sort-aux N L)    
    (cond ((= N 1) (bubble-sort2 L))   
          (else (bubble-sort-aux (- N 1) (bubble-sort2 L)))))

(bubbleH '(5 10 9 8 7))

; Quick sort

(define (partition compare l1)
      (cond
         ((null? l1) '())
         ((compare (car l1)) (cons (car l1) (partition compare (cdr l1))))
         (else (partition compare (cdr l1)))))

   (define (quicksort l1)
      (cond
         ((null? l1) '())
         (else (let ((pivot (car l1)))
            (append (append (quicksort (partition (lambda (x) (< x pivot)) l1))
                       (partition (lambda (x) (= x pivot)) l1))
                    (quicksort (partition (lambda (x) (> x pivot)) l1)))))))

(quicksort '(1 2 5 52 15 -1))



(define (partition2 compare-fn l1)
  (cond
    ((null? l1) '())
    ((compare-fn (car l1)) (cons (car l1) (partition compare-fn (cdr l1))))
    (else (partition compare-fn (cdr l1)))))

(define (less-than? x y)
  (< x y))

(define (equals? x y)
  (= x y))

(define (greater-than? x y)
  (> x y))

(define (quicksort2 l1)
  (cond ((null? l1) '())
    (else (let ((pivot (car l1)))
            (append (append (quicksort (partition less-than? l1))
                           (partition equals? l1))
                    (quicksort (partition greater-than? l1)))))))

(quicksort '(3 1 4 1 5 9 2 6 5))