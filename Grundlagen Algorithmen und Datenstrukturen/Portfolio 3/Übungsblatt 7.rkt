#lang racket

; Aufgabe 1

(define (loesche liste praedikat)
  (helper liste praedikat))

  (define (helper list praedikat)
    (if(or (null? list) (not (praedikat (car list))))
        list
        (helper (if (praedikat (car list))
                    (cdr list)
                    list) praedikat)))

;(loesche (list) even?)
;(loesche (list 4 6 8 3 2 4 5) (lambda(x) (and (integer? x) (even? x))))

; Aufgabe 2

(define (drehe liste)
(reverse liste))

;/////////////////////////////////////////////////////////////////////////// Option 2 ////////////////////////////////////

; Iterativ
(define (drehe2 liste)
  (define (iter lst ergebnis)
    (if (null? lst)
        ergebnis
        (iter (cdr lst) (cons (car lst) ergebnis))))
  (iter liste '() ))

; Rekursiv
(define (drehe3 liste)
  (if (null? liste)
      liste
      (append (drehe3 (cdr liste)) (list (car liste)))))

; Aufgabe 3

(define (typ-or typ1 typ2)
(lambda (x)
  (if (or (typ1 x) (typ2 x))
      #t
      #f)))

; Aufgabe 4

(define (operation operatoren n)
  (cond ( (null? operatoren) (lambda (x) display "Do dudel"))
        ( (= n 1) (lambda (x) ((car operatoren) (car x)  (car (cdr x)))))
        (else (operation (cdr operatoren) (- n 1)))))

;(define plus (operation (list + - * / + - *) 15))
;(plus (list 1 2))

; Aufgabe 5

(define (caesar_encrypt_list data key)
  (helper-caesar data key key '()))

(define (helper-caesar lst values copy newList)
  (cond ((null? values) '())
        ((null? lst) newList)
      (else (helper-caesar (cdr lst) (if (= (length values) 1) copy (cdr values)) copy (append newList (list (remainder (+ (car lst) (car values)) 10)))))))

; //////////////////////////////////////////////////////////// Bessere Option ////////////////////////////////////////////////
(define (caesar_encrypt_list2 data key)
  (define (caeser_encrypt_list-iter restlicheDataListe restlicheKeyListe)
    (if (null? restlicheDataListe)
        '()
        (if (null? restlicheKeyListe)
            (caeser_encrypt_list-iter restlicheDataListe key)
            (cons (modulo (+ (car restlicheDataListe) (car restlicheKeyListe)) 10) (caeser_encrypt_list-iter (cdr restlicheDataListe) (cdr restlicheKeyListe)))
        )
    )
  )
  (if (null? key)
      (display "Key darf nicht null sein") ; oder evtl data zurückgeben => in Portfolio fragen
      (caeser_encrypt_list-iter data key)
  )
)


    
        
        