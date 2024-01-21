#lang racket


; Übungsblatt 10

; Aufgabe 1

(define (removeFirstLast string)
  (helper-remove (cdr (string->list string)) '()))

(define (helper-remove lst result)
  (if (null? lst)
      (list->string result)
      (helper-remove (cdr lst) (if (= (length lst) 1)
                                   result
                                   (append result (list (car lst)))))))

; Aufgabe 2

(define (sicheresPasswort passwort)
  (helper-sicher (string->list passwort) 0 0 0 (length (string->list passwort))))

(define (helper-sicher lst gross klein symbols length)
  (if (null? lst)
      (cond
        ((< length 8) #f)
        ((< symbols 2) #f)
        ((or (< gross 1) (< klein 1)) #f)
        (else #t))
      (helper-sicher (cdr lst)               
                     (if (and (char-ci>=? (car lst) '#\A) (char-ci<=? (car lst) '#\Z)) (+ gross 1) gross)
                     (if  (and (char-ci>=? (car lst) '#\a) (char-ci<=? (car lst) '#\z)) (+ klein 1) klein)
                     (if (not (char-alphabetic? (car lst))) (+ symbols 1) symbols)
                     length)))
                     
                         
; Aufgabe 3

(define (isAnagramm2 anagramm string2)
  (define (ohneLeerzeichnen liste)
    (filter (lambda (x) (not (equal? #\space x))) liste))

  (define (helper-anagramm lst1 lst2)
    (cond ((null? lst1) (null? lst2))
          ((member (car lst1) lst2) (helper-anagramm (cdr lst1) (remove (car lst1) lst2)))
          (else #f)))

  (helper-anagramm (ohneLeerzeichnen (string->list (string-downcase anagramm)))
                   (ohneLeerzeichnen (string->list (string-downcase string2)))))

; Aufgabe 4

(define (vektor-add . vektoren)
 (apply map + vektoren))

; Übungblatt 11

; Aufgabe 1

(define (werte-aus term zuweisung)
  (helper-wert (flatten (append term zuweisung)) (eval (car term)) 0))

(define (helper-wert lst operator result)
  (if (null? lst)
      result
      (helper-wert (cdr lst) operator (cond ((and (number? (car lst)) (= result 0)) (+ result (car lst)))
                                            ((and (number? (car lst)) (> result 0)) (operator result (car lst)))
                                            (else result)))))

; Aufgabe 2

(define (deep-memq element liste)
  (if (member element (flatten liste)) #t #f))

; Aufgabe 3

(define (alle-kleineren grenze liste)
  (helper-grenze (flatten liste) grenze '()))

(define (helper-grenze lst grenze result)
  (if (null? lst)
      result
      (helper-grenze (cdr lst) grenze (if (< (car lst) grenze)
                                   (append result (list (car lst)))
                                   result))))


(define (suche-schrittzahl n)
  (define a 0) ; lokale Variable
  (define r 0) ; lokale Variable
  (define b 0) ; lokale Variable
  (define d 0) ; lokale Variable
  (define (is-eins-schrittzahl zahl vorherigeZahl)
    (set! a (modulo zahl 10)) ; Variable zuweisen
    (set! r (quotient zahl 10)) ; Variable zuweisen
    (set! b (modulo r 10)) ; Variable zuweisen
    (set! d (abs (- a b))) ; Variable zuweisen
    (cond
      ((= r 0) #t)
      ((= d 1) (is-eins-schrittzahl r '()))
      (else #f)))
  
  (define (zahl-rek n zahl)
    (if(is-eins-schrittzahl zahl '())
       (if (= n 1)
           zahl
           (zahl-rek (- n 1) (+ zahl 1))
       )
       (zahl-rek n (+ zahl 1))))
  (zahl-rek n 10))

; Übungblatt 12

; Aufgabe 1

(define (wort-sortieren wort)
  (list->string (sort (string->list wort) char-ci<?)))

; Aufgabe 2

(define (string-enthalten satz wort)
  (string-contains? satz wort))

; Aufgabe 3

(define (tokenizer satz token)
  (string-split satz token))

; Aufgabe 4

(define (vector-add vec1 vec2)
  (helper-vec vec1 vec2 0 #()))

(define (helper-vec vec1 vec2 pos result)
  (cond ((and (>= pos (vector-length vec1)) (>= pos (vector-length vec2))) result)
        ((>= pos (vector-length vec1)) (helper-vec vec1 vec2 (+ pos 1) (vector-append result (vector (vector-ref vec2 pos)))))
        ((>= pos (vector-length vec2)) (helper-vec vec1 vec2 (+ pos 1) (vector-append result (vector (vector-ref vec1 pos)))))
        (else (helper-vec vec1 vec2 (+ pos 1) (vector-append result (vector (+ (vector-ref vec1 pos) (vector-ref vec2 pos))))))))

; Aufgabe 5

(define (bubble-sort vec comparator)
  (vector-sort vec comparator))

; Aufgabe 6

(define (vector-apply start operator vecVal vecIndices)
  (helper-apply start operator vecVal vecIndices start 0))

(define (helper-apply start operator vecVal vecIndices result position)
  (if (= (vector-length vecIndices) position)
      result
      (helper-apply start operator vecVal vecIndices (operator (vector-ref vecVal (vector-ref vecIndices position)) result) (+ position 1))))
        