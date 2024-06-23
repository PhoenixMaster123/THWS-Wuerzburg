#lang racket
;////////////////////////////////////////////////////////   Vektoren   /////////////////////////////////////////////////////

(define (ersetzen v pos . data)
  (helper-ersetzen v pos data))

(define (helper-ersetzen v pos data)
  (cond ((null? data) v)
        ((equal? (richtige-position? pos v) #t) (vector-set! v pos (car data)) (helper-ersetzen v (+ pos 1) (cdr data)))
        (else (helper-ersetzen v pos data ))))

(define (richtige-position? position vector)
  (and (integer? position) (>= position 0) (< position (vector-length vector))))

(ersetzen (vector 0 1 2 3 4 5) 2 42 #t sin) ; -> #(0 1 42 #t #<procedure:sin> 5)

(define my-vector (vector 1 2 3 4 5))
(vector-set! my-vector 2 sin) my-vector

;In Scheme or Racket, the vector-set! procedure is used to modify a vector in place.
;However, it's important to note that this procedure doesn't return the modified vector as its result.
;Instead, it returns an unspecified value. The actual modification happens to the vector itself.

; Sort vector with help from lists

(define (vector-sort vector)
  (list->vector (helper-sort (vector->list vector))))

(define (helper-sort vector)
  (if (null? vector)
      '()
      (helper-sort2 (car vector) (helper-sort (cdr vector)))))

(define (helper-sort2 x lst)
  (cond ((null? lst) (list x))
        ((< x (car lst)) (cons x lst))
        (else (cons (car lst) (helper-sort2 x (cdr lst))))))

(vector-sort (vector 3 6 8 10 1 2 1))

; Vector add

(define (vector-add vec1 vec2)
  (vector-map (lambda (x y) (+ x y)) vec1 vec2))

(vector-add #(1 2 3) #(4 5 6))

; Swap positions

(define (vektor-swap! v idx1 idx2)
  (swap-values v idx1 idx2 (vector-ref v idx1)))

(define (swap-values v idx1 idx2 temp)
  (vector-set! v idx1 (vector-ref v idx2))
  (vector-set! v idx2 temp) v)


(define v (vector 1 2 3 4 5 6)) ; -> #(1 5 3 4 2 6)
(vektor-swap! v 1 4)

(define (combine-vectors vec1 vec2)
  (vector-map (lambda (x y) (string-append x y)) vec1 vec2))

(combine-vectors (vector "a" "b" "c") (vector "x" "y" "z"))

; Aufgabe 14: Vektoroperationen mit Bedingungen

;Schreiben Sie eine Funktion, die einen gegebenen Vektor von Ganzzahlen modifiziert,
;indem sie jedes Element durch 2 teilt, wenn das Element gerade ist,
;und das Element verdoppelt, wenn es ungerade ist.

(define (modify-vector vector)
  (helper-operations vector #() 0))

(define (helper-operations v result counter)
  (if (= counter (vector-length v))
      result
      (helper-operations v (cond ((even? (vector-ref v counter)) (vector-append result (vector (/ (vector-ref v counter) 2))))
                                      ((odd? (vector-ref v counter)) (vector-append result (vector (vector-ref v counter))
                                                                                    (vector (vector-ref v counter))))) (+ counter 1))))


(modify-vector #(1 2 3 4 5)) ; -> #(1 1 1 3 3 5 5)







