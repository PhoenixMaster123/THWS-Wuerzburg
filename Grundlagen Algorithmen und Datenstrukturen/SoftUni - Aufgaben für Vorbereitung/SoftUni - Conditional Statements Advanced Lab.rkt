#lang racket

; Aufgabe 1 - Day of Week

(define (day x)
  (cond ( (= x 1) "Monday")
        ( (= x 2) "Tuesday")
        ( (= x 3) "Wednesday")
        ( (= x 4) "Thursday")
        ( (= x 5) "Friday")
        ( (= x 6) "Saturday")
        ( (= x 7) "Sunday")
        ("Error")))


; Aufgabe 2 - Weekend or Working Day

(define (days x)
  (cond ( (equal? x "Monday") "Working day")
        ( (equal? x "Tuesday") "Working day")
        ( (equal? x "Wednesday") "Working day")
        ( (equal? x "Thursday") "Working day")
        ( (equal? x "Friday") "Working day")
        ( (equal? x "Saturday") "Weekend")
        ( (equal? x "Sunday") "Weekend")
        ("Error")))

; Aufgabe 3 - Animal Type

(define (animal x)
  (cond ( (equal? x "dog") "mammal")
  ( (or (equal? x "snake") (equal? x "crocodile") (equal? x "tortoise")) "reptile")
  ("unknown")))

; Aufgabe 4 - Personal Titles


(define (values age gender)
  (cond ( (and (>= age 16) (equal? gender "m")) "Mr.")
        ( (and (< age 16) (equal? gender "m")) "Master")
        ( (and (>= age 16) (equal? gender "f")) "Ms.")
        ("Miss")))

; Aufgabe 7 - Working Hours

(define (working_day uhr tag)
  (cond ( (and (equal? tag "Monday") (and (>= uhr 10) (<= uhr 18))) "open")
        ((and (equal? tag "Tuesday") (and (>= uhr 10) (<= uhr 18))) "open")
        ((and (equal? tag "Wednesday") (and (>= uhr 10) (<= uhr 18))) "open")
        ((and (equal? tag "Thursday") (and (>= uhr 10) (<= uhr 18))) "open")
        ((and (equal? tag "Friday") (and (>= uhr 10) (<= uhr 18))) "open")
        ((and (equal? tag "Saturday") (and (>= uhr 10) (<= uhr 18))) "open")
        ((and (equal? tag "Sunday") (and (>= uhr 10) (<= uhr 18))) "closed")
        ("closed")))

; Aufgabe 8 - Cinema Ticket

(define (tag x)
  (cond ( (or (equal? x "Monday") (equal? x "Tuesday") (equal? x "Friday")) 12)
        ( (or (equal? x "Wednesday") (equal? x "Thursday")) 14)
        (16)))

; Aufgabe 9 - Fruit or Vegetable

(define (betrag x)
  (cond ( (or (equal? x "banana") (equal? x "apple") (equal? x "kiwi") (equal? x "cherry") (equal? x "lemon") (equal? x "grapes")) "frucht")
        ( (or (equal? x "tomato") (equal? x "cucumber") (equal? x "pepper") (equal? x "carrot")) "vegetable")
          ("unknown")))
              
; Aufgabe 9 Frucht or Vegetable - second variant

;In Scheme, (member) is a built-in function that checks if an element is a member of a list.
;It takes two arguments: an element and a list. It returns the sublist starting with the first occurrence of the element if it is found in the list.
;If the element is not found, it returns #f

(define (value x)
  (cond ((member x '("banana" "apple" "kiwi" "cherry" "lemon" "grapes")) "frucht")
        ((member x '("tomato" "cucumber" "pepper" "carrot")) "vegetable")
        (else "unknown")))


; Aufgabe 10 - Invalid Number

(define (number x)
  (cond ( (or (and (>= x 100) (<= x 200)) (= x 0)) #t)
        (else "invalid")))

;Aufgabe Points

;set! is a special form used to rebind a variable to a new value.
;It's a way to update the value associated with a variable after it has been defined.

(define points 0)

(define (startPoints x)
  (if (= (modulo x 2) 0)
      (set! points (+ points 1))
      (set! points (+ points 2)))
  (cond ((<= x 100) (set! points (+ points 5)))
        ((> x 100) (set! points (* points 0.2)))
        ((> x 1000) (set! points (* points 0.1))))
  points ) ;It returns the value of points after all calculations are complete.

        