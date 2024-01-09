#lang racket

; Aufgabe 1

; //////////////////////////////////////////////////////////////////////// Variant 1 /////////////////////////////////////////

(define (werte-aus2 term zuweisung)
  (helper-werte (flatten (append term zuweisung)) 
                (cond ((eq? '+ (car term)) +)
                      ((eq? '- (car term)) -)
                      ((eq? '* (car term)) *)
                      ((eq? '/ (car term)) /))))

(define (helper-werte lst operator)
  (apply operator (filter number? lst)))


;(werte-aus2 '(+ x 2) '((x 7)))
;(werte-aus2 '(* x y) '((x 3) (y 5))) 
;(werte-aus2 '(/ a b) '((a 6) (b 3))) 

; //////////////////////////////////////////////////////////////////////// Variant 2 /////////////////////////////////////////

(define (werte-aus term zuweisung)
  (apply (cond
         ((eq? '+ (car term)) +)
         ((eq? '- (car term)) -)
         ((eq? '* (car term)) *)
         ((eq? '/ (car term)) /))
  (filter number? (flatten (append term zuweisung)))))
  
   
; Example usage:
;(werte-aus '(+ x 2) '((x 7))) ; Output: 9
(werte-aus '(* x y) '((x 3) (y 5))) ; Output: 15
;(werte-aus '(/ a b) '((a 6) (b 3))) ; Output: 2



; Aufgabe 2
; //////////////////////////////////////////////////////////////////////// Variant 1 /////////////////////////////////////////
(define (deep-memq element liste)
  (checker element (append-List liste '())))

(define (append-List lst newList)
  (if (null? lst)
      newList
      (append-List (cdr lst) (if (pair? (car lst))
                         (append-List (car lst) newList)
                         (append newList (list (car lst)))))))

(define (checker element lst)
  (cond ((null? lst) #f)
        ((equal? element (car lst)) #t)
        (else (checker element (cdr lst)))))

;//////////////////////////////////////////////////////////////////////// Variant 2 - besser /////////////////////////////////////////

(define (deep-memq2 element liste)
  (checker2 element (flatten liste)))

(define (checker2 element lst)
  (cond ((null? lst) #f)
        ((equal? element (car lst)) #t)
        (else (checker element (cdr lst)))))
      


;(deep-memq2 2 '(1 2 3))
;(deep-memq2 3 '(1 (2 (4 5) 3)))
;(deep-memq2 3 '((1 5) (2 (7 2 6 4 (4 5) (2 4)))))

; Aufgabe 3

;//////////////////////////////////////////////////////////////////////// Variant 2 - besser /////////////////////////////////////////

(define (alle-kleineren grenze liste)
  (helper-grenze grenze (result-Append (append '() (car liste) (cdr liste)) '()) '()))


(define (result-Append appendLst result)
  (if (null? appendLst)
      result
      (result-Append (cdr appendLst)
                     (if (pair? (car appendLst))
                         (result-Append (car appendLst) result)
                         (append result (list (car appendLst)))))))

(define (helper-grenze grenze lst result)
  (if (null? lst)
      result
      (helper-grenze grenze (cdr lst) (if (< (car lst) grenze)
                                          (append result (list (car lst)))
                                          result))))

;//////////////////////////////////////////////////////////////////////// Variant 2 - besser /////////////////////////////////////////

(define (alle-kleineren2 grenze liste)
  (helper-grenze2 grenze (flatten liste) '()))

(define (helper-grenze2 grenze lst result)
  (if (null? lst)
      result
      (helper-grenze2 grenze (cdr lst) (if (< (car lst) grenze)
                                          (append result (list (car lst)))
                                          result))))


 

;(define (helper-alle-kleineren grenze lst result)
  
;(alle-kleineren2 4 '((7 2 (3 40)) (3 4 (2 3 (9)))))
;(alle-kleineren2 3 '((3 4 (6 3 (9)) 8)))
;(alle-kleineren2 22 '((19 20) (21 22) (23 24)))

;Aufgabe 4

(define (suche-schrittzahl n)
  (define (is-eins-schrittzahl zahl vorherigeZahl)
    (let*(
         (a (modulo zahl 10))
         (r (quotient zahl 10))
         (b (modulo r 10))
         (d (abs (- a b)))
         )
    (cond
      ((= r 0) #t)
      ((= d 1) (is-eins-schrittzahl r '()))
      (else #f))))
  
  (define (zahl-rek n zahl)
    (if(is-eins-schrittzahl zahl '())
       (if (= n 1)
           zahl
           (zahl-rek (- n 1) (+ zahl 1))
       )
       (zahl-rek n (+ zahl 1))
    )
  )
  (zahl-rek n 10)
)

