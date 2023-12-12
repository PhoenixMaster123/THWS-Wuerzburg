#lang racket
; Dublikate each elemnt of the list

(define duplicate-list (lambda (lst)
  (if (null? lst)
      '() ; Base case -> if the list is empty - '(), if not 
      (cons (car lst) (cons (car lst) (duplicate-list (cdr lst)))))))

(define rember (lambda (element lst) ; remove
      (cond ( (null? lst) '())
            ( (equal? (car lst) element) (cdr lst))
            (else (cons (car lst) (rember element (cdr lst)))))))

; Member funktion

(define member? (lambda (ele lst)
                  (cond ( (null? lst) #f)
                        ( (equal? (car lst) ele) #t)
                        ( (member? ele (cdr lst)) #t)
                        (else #f))))
;(member? 1 (list 3 1 3))


; Sum List

(define sum (lambda (lst)
              (if (null? lst)
                  0 ; We want to return one value 
                  (+ (car lst) (sum (cdr lst))))))

; (sum (list 1 2 3 4 5)) -> 15 

; Multiply each element

(define multiply (lambda (x) (* x 2)))
(define doubleList (lambda (lst)
                     (if (null? lst)
                         '()
                         (cons (multiply (car lst)) (doubleList (cdr lst))))))


; Multiply + Sum

(define sumdoubleList (lambda (lst)
                 (if (null? lst)
                     0
                     (+ (multiply (car lst)) (sumdoubleList (cdr lst))))))

; Summing the doubles of a list using we've already written.

(define betterSumDoubleList (lambda (lst)
                              (if (null? lst)
                                  0
                                  (sum (doubleList lst)))))

; Add two list together

(define addLists (lambda (lst1 lst2)
  (cond ( (null? lst1) lst2)
        ( (null? lst2) lst1)
        (else (cons (+ (car lst1) (car lst2)) (addLists (cdr lst1) (cdr lst2)))))))


; (addLists (list 1 2 3) (list 4 5 6)) -> (5 7 9)


; Generate list of numbers up to n

(define numList (lambda (n)
                  (if (< n 1)
                      '()
                      (append (numList (- n 1)) (list n)))))

; numList 5 -> (1 2 3 4 5)

; Generate number lists
(define gen-num-lists (lambda (start end)
                        (if (>= start end)
                            (list start)
                            (cons start (gen-num-lists (+ start 1) end)))))

;(gen-num-lists 5 10) -> (5 6 7 8 9 10)

(define triple (lambda (x) (* 3 x)))
(define triple-list (lambda (lst)
                      (if (null? lst)
                          '()
                          (cons (triple (car lst)) (triple-list (cdr lst))))))


; Option 2

(define triple-list2 (lambda (lst)
                       (if (null? lst)
                           '()
                           (cons (* (car lst) 3) (triple-list (cdr lst))))))


; (triple-list2 (list 2 3 4 5)) -> (6 9 12 15)


(define letter-grade (lambda (grade)
                        (cond ((>= grade 900) 'A)
                              ((>= grade 800) 'B)
                              ((>= grade 700) 'C)
                              ((>= grade 600) 'D)
                              (else 'F))))

(define grade->letter (lambda (gradelst)
                        (if (null? gradelst)
                            '()
                            (cons (letter-grade (car gradelst)) (grade->letter (cdr gradelst))))))



; (grade->letter (list 848 950 300 601 710)) -> (B A F D C)

;Find position
(define where-is (lambda (lst n)
(where-is-helper lst n 1)))

(define where-is-helper (lambda (lst n loc)
                          (cond ((null? lst) -1)
                                ((equal? (car lst) n) loc)
                                (else (where-is-helper (cdr lst) n (+ loc 1))))))

;(where-is (list 3 5 1 2 6) 2) -> position 4

; Same strukture

(define same-strukture? (lambda (lst1 lst2)
                          (if (and (pair? lst1) (pair? lst2))
                              (and (same-strukture? (car lst1) (car lst2))
                                   (same-strukture? (cdr lst1) (cdr lst2)))
                              (if (or (pair? lst1) (pair? lst2))
                                      #f
                                      #t))))

;(same-strukture? '(a b c d) '(1 2 3 4)) -> #t
;(same-strukture? '(a (b . c) (d e f)) '(1 (2 . 3) (4 5 6))) -> #t
;(same-strukture? '(a b (c . d)) '(1 2 (3 4))) -> #f
;(same-strukture? '(a b c d) '(1 2 3 4 5)) -> #f

; Tower of Hanoi
(define hanoi (lambda (n source temp destination)
                (if (= n 1)
                    (list 'Move source destination)
                    (list (hanoi (- n 1) source destination temp)
                          (hanoi 1 source temp destination)
                          (hanoi (- n 1) temp source destination)))))
