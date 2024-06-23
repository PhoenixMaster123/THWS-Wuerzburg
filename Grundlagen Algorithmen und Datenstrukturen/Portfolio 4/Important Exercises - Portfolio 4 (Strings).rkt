#lang racket

;//////////////////////////////////////////////////////// Strings /////////////////////////////////////////
; String sort alphabetic
(define (string-sort-alphabetic str)
  (helper-sort (string-split str " ")))

(define (helper-sort str-lst)
  (if (null? str-lst)
      '()
      (helper-sort2 (car str-lst) (helper-sort (cdr str-lst)))))

(define (helper-sort2 x lst)
  (cond ((null? lst) (list x))
        ((string-ci<? x (car lst)) (cons x lst))
        (else (cons (car lst) (helper-sort2 x (cdr lst))))))

(string-sort-alphabetic "My name ist Kristian") ; -> ("ist" "Kristian" "My" "name")

; String split with 2 charachters
(define (teilen text trennzeichen)
  (string-split (helper-teilen (string-split (string-replace (string-replace text (string (car (string->list trennzeichen))) " ")
                                             (string (cadr (string->list trennzeichen))) " ") " ") "") " "))

(define (helper-teilen lst result)
  (if (null? lst)
       result
      (helper-teilen (cdr lst) (if (equal? (car lst) "") result (string-append result (car lst) " ")))))



(teilen "nach den Abschluss-Prüfungen, - kommen die Ferien" ",-") ; -> ("nach" "den" "Abschluss" "Prüfungen" "kommen" "die" "Ferien")

; Second Variant
(define (teilen2 text trennzeichen)
  (helper-teilen2 (string-split (string-replace (string-replace text (string (car (string->list trennzeichen))) " ")
                                             (string (cadr (string->list trennzeichen))) " ") " ") '()))

(define (helper-teilen2 lst result)
  (if (null? lst)
       result
      (helper-teilen2 (cdr lst) (if (equal? (car lst) "") result (append result (list (car lst)))))))

(teilen2 "nach den Abschluss-Prüfungen, - kommen die Ferien" ",-") ; -> ("nach" "den" "Abschluss" "Prüfungen" "kommen" "die" "Ferien")

; Sort with first predicat on the first position then not predicat on second position

(define (sort-pred str pred)
  (helper-sort-upper (string->list str) '() '() pred))

(define (helper-sort-upper string-lst upper lower pred)
  (if (null? string-lst)
      (list->string (append upper lower)) 
      (helper-sort-upper (cdr string-lst) (if (pred (car string-lst))(append upper (list (car string-lst))) upper)
                                          (if (not (pred (car string-lst))) (append lower (list (car string-lst))) lower) pred)))

(sort-pred "HaLLO" char-lower-case?) ; -> aHLLO

; Variant 2 -> short and easy
(define (sort-pred2 str pred)
  (list->string (append (filter pred (string->list str) (filter-not pred (string->list))))))

(sort-pred "HaLLO" char-upper-case?) ; -> HLLOa

; Count substrings
(define (count-substrings str word)
  (helper-count (string-split str " ") word 0))

(define (helper-count string-lst word counter)
  (if (null? string-lst)
      counter
      (helper-count (cdr string-lst) word (if (string-contains? (string-upcase (car string-lst)) (string-upcase word)) (+ counter 1) counter))))

(count-substrings "Heute am Dienstag habe ich spätdienst" "Dienst") ; -> 2

(define (transformation str)
  (append (list (list->string (reverse (string->list str)))) (list (string-upcase str)) (list (helper-transformation (string->list str) '()))))

(define (helper-transformation lst result)
  (if (null? lst)
      (list->string result)
      (helper-transformation (cdr lst) (if (or (char-ci=? (car lst) #\a) (char-ci=? (car lst) #\e) (char-ci=? (car lst) #\i)
                                               (char-ci=? (car lst) #\o) (char-ci=? (car lst) #\u))
                                           result
                                           (append result (list (car lst)))))))

(transformation "Racket") ; -> ("tekcaR" "RACKET" "Rckt")

(define (char-frequencies str)
  (helper-frequencies (string->list str) '() '()))

(define (helper-frequencies lst checkList result)
  (if (null? lst)
      result
      (helper-frequencies (cdr lst) (if (member (car lst) checkList) checkList (append checkList (list (car lst))))
                          (if (member (car lst) checkList)
                           result
                          (append result (list (cons (car lst) (check-count lst (car lst) 0)))))))) ; if you don't want with h . 1 then make without cons

(define (check-count lst current counter)
  (if (null? lst)
      counter
      (check-count (cdr lst) current (if (equal? (car lst) current)
                                         (+ counter 1)
                                         counter))))

(char-frequencies "hello") ; -> ((#\h . 1) (#\e . 1) (#\l . 2) (#\o . 1))
(char-frequencies "mississippi") ; -> ((#\m . 1) (#\i . 4) (#\s . 4) (#\p . 2))

; Aufgabe 6: Erste und Letzte Zeichen Vertauschen

(define (swap-first-last str)
  (string-append (string (last (string->list str))) (substring str 1 (- (string-length str) 1)) (string (car (string->list str)))))

(swap-first-last "Racket") ; -> "tackeR"


; Aufgabe 8: Einfügen eines Zeichens zwischen jedes Zeichen

(define (insert-char-between str)
  (substring (string-join (string-split str "") "-")  1 (- (string-length (string-join (string-split str "") "-")) 1)))

(insert-char-between "hello") ; -> "h-e-l-l-o"

;Aufgabe 10: Alle Permutationen eines Strings erzeugen

(define (permutation str)
  (helper-combine-permutation (permutations (string->list str)) '()))

(define (helper-combine-permutation lst-permutation result)
  (if (null? lst-permutation)
      result
      (helper-combine-permutation (cdr lst-permutation) (append result (list (list->string (car lst-permutation)))))))

(permutation "abc")

; Aufgabe 11: Anzahl der Wörter mit einer bestimmten Länge

(define (count-words-with-length str len)
  (length (helper-length (string-split str " ") len '())))

(define (helper-length lst len result)
  (if (null? lst)
      result
      (helper-length (cdr lst) len (if (= (string-length (car lst)) len)(append result (list (car lst))) result))))

(count-words-with-length "Racket is a fun programming language" 3) ; -> 1

; Aufgabe 12: Kürzestes Wort in einem String finden

(define (shortest-word str)
  (helper-short-word (cdr (string-split str " ")) (car (string-split str " "))))

(define (helper-short-word lst result)
  (if (null? lst)
      result
      (helper-short-word (cdr lst) (if (< (string-length (car lst)) (string-length result)) (car lst)  result))))
  

(shortest-word "Racket is a fun programming language")

; Aufgabe 16: Häufigkeit von Wörtern zählen
(define (string-frequencies str)
  (helper-frequencies (string-split str " ") '() '()))

(define (helper-frequencies2 lst checkList result)
  (if (null? lst)
      result
      (helper-frequencies2 (cdr lst) (if (member (car lst) checkList) checkList (append checkList (list (car lst))))
                          (if (member (car lst) checkList)
                           result
                          (append result (list (cons (car lst) (check-count2 lst (car lst) 0)))))))) ; if you don't want with h . 1 then make without cons

(define (check-count2 lst current counter)
  (if (null? lst)
      counter
      (check-count2 (cdr lst) current (if (equal? (car lst) current)
                                         (+ counter 1)
                                         counter))))

(string-frequencies "hello hello world")

; Find the sum

(define (string-summe s)
  (helper-summe (string->list s) 0))

(define (helper-summe lst result)
  (if (null? lst)
      result
      (helper-summe (cdr lst) (if (char-numeric? (car lst))(+ result (string->number (string (car lst)))) result))))

(string-summe "97070_Würzburg_2")
