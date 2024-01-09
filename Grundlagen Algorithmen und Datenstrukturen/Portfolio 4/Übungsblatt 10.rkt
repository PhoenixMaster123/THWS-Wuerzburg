#lang racket

;Aufgabe 1

;///////////////////////////////////////////////////////////// Variant 1 - My //////////////////////////////////////////////
(define (removeFirstLast string)
 (helper-remove (string->list string) '() (length (string->list string))))

(define (helper-remove lst result lengthLst)
  (if (null? lst)
      (list->string result)
      (helper-remove (cdr lst) (cond ((= (length lst) lengthLst) result)
                                     ((= (length lst) 1) result)
                                     (else (append result (list (car lst))))) lengthLst)))

;///////////////////////////////////////////////////////////// Variant 2 - AI //////////////////////////////////////////////
(define (removeFirstLast2 string)
  (let ((chars (string->list string)))
    (list->string (drop-right (cdr chars) 1))))
;///////////////////////////////////////////////////////////// Variant 3 - My //////////////////////////////////////////////
(define (removeFirstLast3 string)
  (helper-remove2 (cdr (string->list string)) '()))

(define (helper-remove2 chars result)
  (if (null? chars)
      (list->string result)
      (if (null? (cdr chars))
          (list->string result)
          (helper-remove2 (cdr chars) (append result (list (car chars)))))))

;///////////////////////////////////////////////////////////// Variant 4 - My //////////////////////////////////////////////
(define (removeFirstLast4 string)
  (helper-remove3 (cdr (string->list string)) '()))

(define (helper-remove3 lst result)
  (if (null? lst)
      (list->string result)
      (helper-remove3 (cdr lst) (if (> (length lst) 1) (append result (list (car lst)))  result))))

; Aufgabe 2

(define (sicheresPasswort passwort)
  (checker (string->list passwort) 0 0 0 (string-length passwort)))

(define (checker lst symbols kleinBuchstaben grossBuchstaben length)
  (if (null? lst)
      (cond ((< length 8) #f)
            ((< symbols 2) #f)
            ((or (< kleinBuchstaben 2) (< grossBuchstaben 2)) #f)
            (else #t))
      (checker (cdr lst)
               (if (and (char-lower-case? (car lst)) (char-alphabetic? (car lst))) (+ kleinBuchstaben 1) kleinBuchstaben)
               (if (and (char-upper-case? (car lst)) (char-alphabetic? (car lst))) (+ grossBuchstaben 1) grossBuchstaben)
                (if (char-symbolic? (car lst)) (+ 1 symbols) symbols)
               length)))

; Aufgabe 3

;///////////////////////////////////////////////////////////// Variant 1 //////////////////////////////////////////////
(define (isAnagramm anagramm string2)
  (define (ohneLeerzeichnen liste) (filter (lambda (x) (not (equal? #\space x))) liste))
  (define (compare a b) (char-ci<? a b))
  (equal? (sort (ohneLeerzeichnen (string->list (string-downcase anagramm))) compare)
        (sort (ohneLeerzeichnen (string->list (string-downcase string2))) compare)))


;///////////////////////////////////////////////////////////// Variant 2 //////////////////////////////////////////////
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

;In Scheme, the use of the dot . in a parameter list is known as the "rest" or "rest argument" feature.
;It allows a function to accept a variable number of arguments beyond a certain point. When you define a function with a dotted-tail parameter
;like (sum . something),it means that the variable something will capture any remaining arguments passed to the function as a list.


