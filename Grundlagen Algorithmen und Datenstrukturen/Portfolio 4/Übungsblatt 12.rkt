#lang racket

;Aufgabe 1

;/////////////////////////////////////////////////////////////////// Varinat 1 /////////////////////////////////////////////
(define (wort-sortieren wort)
  (define sorted-string
    (list->string
     (sort (string->list wort) char<? #:key char-foldcase)))
  sorted-string)
;/////////////////////////////////////////////////////////////////// Varinat 2 /////////////////////////////////////////////
(define (wort-sortieren2 wort)
  (list->string
   (sort (string->list wort)
         (lambda (char1 char2)
           (char<? (char-foldcase char1) (char-foldcase char2))))))
;/////////////////////////////////////////////////////////////////// Varinat 3 - nicht schwer zu verstehen /////////////////////////////////////////////
(define (char-less-than-folded? char1 char2)
  (< (char->integer (char-foldcase char1))
     (char->integer (char-foldcase char2))))

(define (wort-sortieren3 wort)
  (list->string (sort (string->list wort) char-less-than-folded?)))
;/////////////////////////////////////////////////////////////////// Varinat 4 - einfach zu verstehen /////////////////////////////////////////////
(define (char-less-than-ignore-case? char1 char2)
  (char<? (if (char-upper-case? char1) (char-downcase char1) char1)
          (if (char-upper-case? char2) (char-downcase char2) char2)))

(define (wort-sortieren4 wort)
  (list->string (sort (string->list wort) char-less-than-ignore-case?)))


;char-foldcase -> unsensitive sortierung

;Dies ist eine Racket-Funktion, die einen Buchstaben in seinen kleingeschriebenen, faltbaren Äquivalent umwandelt.
;Das bedeutet, dass der Buchstabe in Kleinbuchstaben umgewandelt wird,
;aber auch bestimmte Zeichen mit diakritischen Markierungen oder Akzenten behandelt werden.
;!!!! Es ist nützlich, wenn du eine Fall-unsensitive Sortierung möchtest.

;#:key

;#:key-Argument wird hauptsächlich bei der Sortierung verwendet
;, um eine benutzerdefinierte Schlüsseltransformation auf die Elemente anzuwenden, bevor sie verglichen werden.
;Dies ermöglicht eine flexiblere Sortierung nach bestimmten Kriterien.

; Aufgabe 2

;/////////////////////////////////////////////////////////////////// Varinat 1 /////////////////////////////////////////////
(define (string-enthalten satz wort)
  (string-helper (string->list satz) (string->list wort) #f))

(define (string-helper lst1 lst2 temp)
  (cond
    ((or (null? lst1) (null? lst2)) temp)
    ((char=? (car lst1) (car lst2)) (string-helper (cdr lst1) (cdr lst2) #t))
    ((and (eq? temp #t) (eq? (char=? (car lst1) (car lst2)) #f)) #f)
    (else (string-helper (cdr lst1) lst2 temp))))

;(string-enthalten "Heute ist Dienstag" "tag") - tag nicht vollständig

;/////////////////////////////////////////////////////////////////// Varinat 2 /////////////////////////////////////////////
(define (string-enthalten2 satz wort)
  (string-contains? satz wort))

;(string-enthalten "Heute ist Dienstag" "ist") - vollständig

; Aufgabe 3

;/////////////////////////////////////////////////////////////////// Varinat 1 /////////////////////////////////////////////
(define (tokenizer satz token)
  (string-split satz token))


; Aufgabe 4

;(define (vector-add vec1 vec2)
;  (vector-map + vec1 vec2)) -> muss mit gleich Laenge sein

;/////////////////////////////////////////////////////////////////// Variant 1 - My ////////////////////////////////////////
(define (vector-add vec1 vec2)
  (helper-vector vec1 vec2 0 #()))

(define (helper-vector vec1 vec2 position result)
 (cond ((and (<= (vector-length vec1) position) (<= (vector-length vec2) position)) result)
       ((>= position (vector-length vec1)) (helper-vector vec1 vec2 (+ position 1) (vector-append result (vector (vector-ref vec2 position)))))
       ((>= position (vector-length vec2)) (helper-vector vec1 vec1 (+ position 1) (vector-append result (vector (vector-ref vec1 position)))))
      (else (helper-vector vec1 vec2 (+ position 1) (vector-append result (vector (+ (vector-ref vec1 position) (vector-ref vec2 position))))))))

;(define (helper-vector vec1 vec2 position result)
;  (cond ((and (>= position (vector-length vec1)) (>= position (vector-length vec2))) result)
       ; (else helper-vector vec1 vec2 (+ position 1) (vector-append result (vector (+ (vector-ref vec1 position) (vector-ref vec2 position)))))))

; Beispielaufruf:
;(vector-add #(1 1 1) #(4 5 6)) ; Ausgabe: #(5 6 6 7)

;/////////////////////////////////////////////////////////////////// Varinat 2 - My Variant mit vector->list /////////////////////////////////////////////
(define (vector-add4 vec1 vec2)
  (helper-vector2 (vector->list vec1) (vector->list vec2) '()))

(define (helper-vector2 lst1 lst2 result)
  (cond ((and (null? lst1) (null? lst2)) (list->vector result))
        ((null? lst1) (helper-vector2 lst1 (cdr lst2) (append result (list (car lst2)))))
        ((null? lst2) (helper-vector2 (cdr lst1) lst2 (append result (list (car lst1)))))
        (else (helper-vector2 (cdr lst1) (cdr lst2) (append result (list (+ (car lst1) (car lst2))))))))

; Beispielaufruf:
;(vector-add4 #(1 1 1) #(4 5 6)) ; Ausgabe: #(5 6 7)


;/////////////////////////////////////////////////////////////////// Varinat 3 /////////////////////////////////////////////
(define (vector-add2 vec1 vec2)
  (define (pad-vector vec len)
    (if (< (vector-length vec) len)
        (vector-append vec (make-vector (- len (vector-length vec)) 0))
        vec))

  (let* ((len (max (vector-length vec1) (vector-length vec2)))
         (padded-vec1 (pad-vector vec1 len))
         (padded-vec2 (pad-vector vec2 len)))
    (vector-map + padded-vec1 padded-vec2)))

; Beispielaufruf:
;(vector-add2 #(1 1) #(4 5 6 7)) ; Ausgabe: #(5 6 6 7)

;/////////////////////////////////////////////////////////////////// Varinat 4 /////////////////////////////////////////////
(define (vector-add3 vec1 vec2)
  (define (pad-vector vec len)
    (if (< (vector-length vec) len)
        (vector-append vec (make-vector (- len (vector-length vec)) 0))
        vec))

  (vector-map + (pad-vector vec1 (max (vector-length vec1) (vector-length vec2)))
                (pad-vector vec2 (max (vector-length vec1) (vector-length vec2)))))

; Beispielaufruf:
;(vector-add3 #(1 1) #(4 5 6 7)) ; Ausgabe: #(5 6 6 7)

; Aufgabe 5

(define (bubble-sort vec comparator)
(vector-sort vec comparator))

; Aufgabe 6
;/////////////////////////////////////////////////////////////////// Varinat 1 vector->list/////////////////////////////////////////////
(define (vector-apply start operator vecVal vecIndices)
  (helper-apply start operator (vector->list vecVal) (vector->list vecIndices) start))

(define (helper-apply start operator vecVal vecIndices result)
  (if (null? vecIndices)
       result
      (helper-apply start operator vecVal (cdr vecIndices) (operator (list-ref vecVal (car vecIndices)) result))))

;/////////////////////////////////////////////////////////////////// Varinat 2 vectors /////////////////////////////////////////////
(define (vector-apply2 start operator vecVal vecIndices)
  (helper-apply2 start operator vecVal vecIndices start 0))

(define (helper-apply2 start operator vecVal vecIndices result position)
  (if (= (vector-length vecIndices) position)
      result
      (helper-apply2 start operator vecVal vecIndices (operator (vector-ref vecVal (vector-ref vecIndices position)) result) (+ position 1))))





