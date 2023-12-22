#lang racket
"All Übungen -> Lists"
(newline)
"Übungsblatt 7"
(newline)
"Aufgabe 1"

(define (loesche liste praedikat)
  (if (null? liste)
      #f
  (helper-loesche liste praedikat)))

  (define (helper-loesche liste praedikat)
    (if (or (null? liste) (eq? (praedikat (car liste)) #f))
        liste
        (helper-loesche (cdr liste) praedikat)))
;(loesche (list 4 6 8 3 2 4 5) even?)
"correct"
(newline)
"Aufgabe 2"

(define (drehe liste)
  (helper-drehe liste '()))

(define (helper-drehe lst newList)
  (if (null? lst)
      newList
      (helper-drehe (cdr lst) (cons (car lst) newList))))

;(drehe (list 1 (list 5 6) 2 (list 3 4)))
"correct"
(newline)
"Aufgabe 3"
(define (typ-or typ1 typ2)
  (lambda (x) (if (or (typ1 x) (typ2 x)) #t #f)))
"correct"
(newline)
"Aufgabe 4"
  (define (operation operatoren n)
  (cond ( (null? operatoren) (lambda (x) display "Do dudel"))
        ( (= n 1) (lambda (x) ((car operatoren) (car x)  (car (cdr x)))))
        (else (operation (cdr operatoren) (- n 1)))))
"correct"
(newline)
"Aufgabe 5"
(define (caesar_encrypt_list data key)
  (helper-caesar data key key '()))

(define (helper-caesar lst values copy newList)
  (cond ((null? values) '())
        ((null? lst) newList)
      (else (helper-caesar (cdr lst) (if (= (length values) 1) copy (cdr values)) copy (append newList (list (remainder (+ (car lst) (car values)) 10)))))))
"correct"
(newline)

"Übungsblatt 8"
(newline)
"Aufgabe 1"
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

  (newline)
"Aufgabe 2"

(define (expandiere sym-liste)
  (if (null? sym-liste)
      '()
      (helper-expand sym-liste '())))

(define (helper-expand lst newList)
  (if (null? lst)
      newList
      (helper-expand (cdr lst) (if (number? (car lst))
                                   (append newList (expand (car lst) (list (car (cdr lst))) '()))
                                   (append newList (list (car lst)))))))

(define (expand counter ele list)
  (if (= counter 1)
      list
      (expand (- counter 1) ele (append list ele))))
"correct"
(newline)
"Aufgabe 3"
(define (loeschen liste n)
  (if (or (null? liste) (= n 0))
      liste
      (loeschen (cdr liste) (- n 1))))
"correct"
(newline)

"Übungsblatt 9"
(newline)
"Aufgabe 2"

(define (liste-teilen eingabe)
  (helper-teilen eingabe '() '()))

(define (helper-teilen eingabe lst1 lst2)
  (if (null? eingabe)
      (list lst2 lst1)
      (helper-teilen (cdr eingabe) (if (even? (length eingabe))
                                              (append lst1 (list (car eingabe)))
                                              lst1)
                                       (if (odd? (length eingabe))
                                                 (append lst2 (list (car eingabe)))
                                                 lst2))))
"correct"
(newline)
"Aufgabe 3"
(define (listen-verschmelzen eingabe)
  (helper-verschmelzen (car eingabe) (car (cdr eingabe)) '()))

(define (helper-verschmelzen lst1 lst2 result)
  (cond ((and (null? lst1) (null? lst2)) result)
        ((null? lst1) (append result (list (car lst2))))
        ((null? lst2) (append result (list (car lst1))))
        (else (helper-verschmelzen (cdr lst1) (cdr lst2) (append result (list (car lst1)) (list (car lst2)))))))
"correct"
(newline)
"Aufgabe 4"

(define (hamming lst1 lst2)
  (helper-hamming lst1 lst2 0))

(define (helper-hamming lst1 lst2 counter)
  (if (or (null? lst1) (null? lst2))
      counter
      (helper-hamming (cdr lst1) (cdr lst2) (if (= (car lst1) (car lst2))
                                         counter
                                         (+ counter 1)))))
"correct"
(newline)

(define (compress-zaehler liste char zaehler)
  (if (and (> (length liste) 0) (eq? (car liste) char))
      (compress-zaehler (cdr liste) char (+ zaehler 1)) (list zaehler liste)))


(define (custom-flatte liste)
  (define (flatte-helper c_list result)
    (if (pair? c_list)
        (let ((c_zaehler (if (list? (car c_list))                             
                             (compress-zaehler (car c_list) (caar c_list) 0)
                             (compress-zaehler c_list (car c_list) 0))))
          (flatte-helper (if (list? (car c_list)) (cdr c_list) (cadr c_zaehler))
                         (if (list? (car c_list))
                             (append result (list (append (list (car c_zaehler)) (list (caar c_list)))))
                             (if (> (car c_zaehler) 1) (append result (list (car c_zaehler)) (list (car c_list)))
                                 (append result (list (car c_list))))))) result))
  (flatte-helper liste '()))
 

(custom-flatte '(a b b (b b) (a a)))

"ChatGPT - Aufgaben"
(newline)
"Dublicate entfernen"

(define (entfernen eingabe)
  (helper-entfernen eingabe '()))

(define (helper-entfernen lst result)
  (if (null? lst)
      result
      (helper-entfernen (cdr lst) (if (member (car lst) result)
                                      result
                                      (append result (list (car lst)))))))
   
;(entfernen '(1 2 3 3 3 4 5 6)) -> '(1 2 3 4 5 6)

" Häufigstes Element finden "

(define (haeufigstes-element lst)
   (if (null? lst)
      #f
      (haeufigstes-element-helfer (cdr lst) (car lst) (zaehlen (car lst) lst))))

  (define (zaehlen element lst)
    (cond
      ((null? lst) 0)
      ((equal? (car lst) element) (+ 1 (zaehlen element (cdr lst))))
      (else (zaehlen element (cdr lst)))))

  (define (haeufigstes-element-helfer lst bisher-haeufigstes aktuelles-haeufigkeit)
    (cond
      ((null? lst) bisher-haeufigstes)
      ((> (zaehlen (car lst) lst) aktuelles-haeufigkeit)
       (haeufigstes-element-helfer (cdr lst) (car lst) (zaehlen (car lst) lst)))
      (else (haeufigstes-element-helfer (cdr lst) bisher-haeufigstes aktuelles-haeufigkeit))))

(haeufigstes-element '(1 2 2 3 3 4 4 4 1 1 2 2))


; Liste von Zahlen zu kommagetrennter Zeichenkette:


(define (zeichenkette eingabe)
  (string-join (map number->string eingabe) ","))

(zeichenkette '(1 2 3 4 5))
