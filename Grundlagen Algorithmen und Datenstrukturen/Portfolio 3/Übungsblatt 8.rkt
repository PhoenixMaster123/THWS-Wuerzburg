#lang racket

; Aufgabe 1

; //////////////////////////////////////////////////////////////// Variant 1 /////////////////////////////////////////////
(define (compress liste)
  (if (null? liste) ; if the list is empty
      '()
      (helper-compress (cdr liste) (car liste) 1 '()))) ; helper-funktion 

(define (helper-compress intern-lst currentElement counter newList)
  (cond ((null? intern-lst) (addToNewList currentElement counter newList)) ; if the intern-lst is empty
        ((eq? currentElement (car intern-lst)) (helper-compress (cdr intern-lst) currentElement (+ counter 1) newList)) ; if the cur ele = first element from intern-lst
        
        (else (helper-compress (cdr intern-lst) (car intern-lst) 1 (addToNewList currentElement counter newList))))) ; counter = 1 and we add the first symbol


(define (addToNewList currentElement counter newList)
  (if (> counter 1)
      (append newList (list counter currentElement))
      (append newList (list currentElement))))
  
  

; Beispielaufruf der Funktion
;(compress '(a a a a a a a a a a))
;(compress '(a b b c c c a b c))

;////////////////////////////////////////////////////////////// Variant 2 - kürzer //////////////////////////////////////////////////

(define (compress2 lst)
   (if (null? lst)
       '()
       (compress-inner (cdr lst) (car lst) 1 '())))
  
  (define (compress-inner lst cur-sym count newList)
    (cond ((null? lst) (add cur-sym count newList))
          ((eq? cur-sym (car lst)) (compress-inner (cdr lst) cur-sym (+ count 1) newList))
          (else (compress-inner (cdr lst) (car lst) 1 (add cur-sym count newList)))))

  (define (add sym count acc)
    (append acc (if (> count 1) (list count sym) (list sym))))
  
 

; Beispielaufruf der Funktion
;(compress2 '(a a a a a a a a a a)) ; Ausgabe: (10 a)
;(compress2 '(a b b c c c a b c)) ; Ausgabe: (1 a 2 b 3 c 1 a 1 b 1 c)

; Aufgabe 2

(define (expandiere sym-liste)
  (expandiere-iter sym-liste '()))

(define (expandiere-iter liste result)
  (if (null? liste)
      result
      (if (and (pair? liste) (number? (car liste)))
          (expandiere-iter (cddr liste) (append result (expandiere-helper (cadr liste) (car liste) '())))
          (expandiere-iter (cdr liste) (append result (expandiere-helper (car liste) 1 '()))))))

(define (expandiere-helper char counter result)
  (if (> counter 0)
      (expandiere-helper char (- counter 1) (append (list char) result)) result))


; Aufgabe 3

; //////////////////////////////////////////////////////////////// Variant 1 /////////////////////////////////////////////
(define (loeschen liste n)
  (delete liste n 0))

(define (delete lst range counter)
  (if (or (= counter range) (null? lst))
      lst
      (delete (cdr lst) range (+ counter 1))))

; //////////////////////////////////////////////////////////////// Variant 2 /////////////////////////////////////////////

(define (loeschen2 liste n)
  (if (or (null? liste) (= n 0))
      liste
      (loeschen2 (cdr liste) (- n 1))))
