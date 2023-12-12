#lang racket

; Aufgabe 1 
(define (tuerme-von-hanoi n)
   (move n 'a 'c 'b))

  (define (move n start end temp)
    (if (= n 0)
        '()
        (append (move (- n 1) start temp end) (list (cons start end)) (move (- n 1) temp end start))))
;(hanoi 3)
; Ausgabe: ((a . c) (a . b) (c . b) (a . c) (b . a) (b . c) (a . c))


;Aufgabe 2

;///////////////////////////////////////////////////////////// Variant 1 ////////////////////////////////////////////////////////////////
(define (liste-teilen eingabe)
  (teilen eingabe '() '()))

(define (teilen originalLst lst1 lst2)
  (if (null? originalLst)
      (list (reverse lst2) (reverse lst1))
      (teilen (cdr originalLst) (if (even? (car originalLst))
                                           (cons (car originalLst) lst1)
                                           lst1) (if (odd? (car originalLst))
                                                      (cons (car originalLst) lst2)
                                                      lst2))))
;///////////////////////////////////////////////////////////// Variant 2 ////////////////////////////////////////////////////////////////
(define (liste-teilen2 eingabe)
  (teilen2 eingabe '() '()))

(define (teilen2 value lst1 lst2)
  (if (null? value)
      (list lst1 lst2)
  (list (cons (filter odd? value) lst1) (cons (filter even? value) lst2))))

; Ohne if null? -> (liste-teilen2 '()) -> Fehler ((()) (()))

; Aufgabe 3

; ///////////////////////////////////////////////////////////// Variant 1 ////////////////////////////////////////////////////////////////
(define (listen-verschmelzen eingabe)
  (if (null? eingabe)
      '()
  (verschmelzen (car eingabe) (car (cdr eingabe)))))

(define (verschmelzen lst1 lst2)
       (sort (append lst1 lst2) <))

; ///////////////////////////////////////////////////////////// Variant 2 ////////////////////////////////////////////////////////////////

(define (listen-verschmelzen2 eingabe)
  (if (null? eingabe)
      '()
      (verschmelzen2 (car eingabe) (car (cdr eingabe)) '())))

(define (verschmelzen2 lst1 lst2 result)
  (cond ((and (null? lst1) (null? lst2)) result)
        ((null? lst1) (append result (list (car lst2))))
        ((null? lst2) (append result (list (car lst1))))
        (else (verschmelzen2 (cdr lst1) (cdr lst2) (append result (list (car lst1)) (list (car lst2)))))))

; Aufgabe 4

(define (hamming lst1 lst2)
  (hamming-helper lst1 lst2 0))

(define (hamming-helper lst1 lst2 counter)
  (if (or (null? lst1) (null? lst2))
      counter
      (hamming-helper (cdr lst1) (cdr lst2) (if (eq? (car lst1) (car lst2))
                                                counter
                                                (+ counter 1)))))


; Tafelübung 9

(define (was-ist-los liste1 liste2)
(cond ((null? liste1) liste2)
((null? liste2) liste1)
((equal? (car liste1) (car liste2))
(cons (car liste1)
(was-ist-los (cdr liste1) (cdr liste2))))
(else (was-ist-los (cdr liste1) (cdr liste2)))))

; (was-ist-los '(1 3 4 5) '(2 3 4 6 7 8)) -> (3 4 7 8)
; (was-ist-los '(3 4 6 8) '(2 3 4 6 8 8)) -> (8 8)
;(was-ist-los '((1 2) (11 12) (21 22)) '((1 2 3) (11 12))) ;-> ((11 12) (21 22))
;(was-ist-los '((1 2) (11 12) (21 22)) '(((1 2)))) ;-> (11 12) (21 22))))