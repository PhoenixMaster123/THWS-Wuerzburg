#lang racket
; Durchschnitt

; Iterativ 
(define (durchschnitt . werte)
  (define (iter rest ergebnis)
    (if (null? rest)
        (/ ergebnis (length werte))
        (iter (cdr rest) (+ ergebnis (car rest)))))
  (iter werte 0.0))

; Rekursiv
(define (durchschnitt-rek . werte)
  (define (rek liste)
    (if (null? liste)
        0.0
        (+ (car liste) (rek (cdr liste)))))
  (/ (rek werte) (length werte)))

; My variant
(define (durchschnitt-rek-my list)
  (/ (helper-durchschnitt list) (length list)))

(define (helper-durchschnitt lst)
  (if (null? lst)
      0.0
      (+ (car lst) (helper-durchschnitt (cdr lst)))))


(define (make-1337 word)
  (helper-word (string->list word) '()))


  (define (helper-word lst newList)
    (if (null? lst)
        (list->string newList)
        (helper-word (cdr lst) (append newList (list (changer (car lst)))))))

(define (changer element)
  (cond ((eq? element #\a) #\4)
        ((eq? element #\e) #\3)
        ((eq? element #\l) #\1)
        ((eq? element #\s) #\5)
        ((eq? element #\t) #\7)
        ((eq? element #\o) #\0)
        (else element)))

(make-1337 "scheme") ;-> "5ch3m3"


(define (FILTER word)
  (filter-helper (string->list word) '()))

(define (filter-helper lst newList)
  (if (null? lst)
      (list->string (reverse (filter identity newList)))
      (filter-helper (cdr lst) (cons (checker-letter (car lst)) newList))))

(define (checker-letter element)
  (if (or (and (>= (char->integer element) 65) (<= (char->integer element) 90)) (equal? element #\space))
      element  ; Exclude uppercase letters
      #f)) ; Include other characters

;(FILTER "Read Evaluate Print Loop!")-> "R E P L!"


(define (entfernen word zeichen)
  (entfernen-helper (string->list word) (string->list zeichen) '()))

(define (entfernen-helper lst zeichen newList)
  (if (null? lst)
      (list->string (reverse (filter identity newList)))
      (entfernen-helper (cdr lst) zeichen (cons (zeichnen-checker (car lst) zeichen) newList))))

(define (zeichnen-checker currentElement zeichen)
  (if (or (eq? currentElement (car zeichen)) (eq? currentElement (car (cdr zeichen)))) #f currentElement))

;(entfernen "scheme" "cm") -> "shee"


(define (binär-zähler lst)
  (helper-binaer lst 0 0))

(define (helper-binaer lst count0 count1)
  (if (null? lst)
      (list count0 count1)
      (helper-binaer (cdr lst)
                     (if (= (car lst) 0)
                                   (+ count0 1)
                                   count0)
                     (if (= (car lst) 1)
                         (+ count1 1)
                         count1))))

; Vowel

(define (vowel? c)
  (member c '(#\a #\e #\i #\o #\u)))

(define (ending lst)
  (car (reverse lst)))

(define (butlast lst)
  (reverse (cdr (reverse lst))))

(define (plural word)
  (let ((chars (string->list word)))
    (list->string
     (cond ((or (and (vowel? (ending chars))
                     (vowel? (ending (butlast chars))))
                (not (vowel? (ending chars))))
            (append chars '(#\s)))
           ((eq? (ending chars) #\y)
            (append (butlast chars) '(#\i #\e #\s)))
           (else (append (butlast chars) '(#\i #\e #\s)))))))

