#lang racket

; Rekursiv -> Sum elements
(define (sum-list list)
  (if (null? list)
      0
      (+ (car list) (sum-list (cdr list)))))

; Iterativ
(define (sum-list-iter list)
  (sum-iter list 0))

(define (sum-iter lst ergebnis)
  (if (null? lst)
      ergebnis
      (sum-iter (cdr lst) (+ (car lst) ergebnis))))

; Variant 1 -> List Length
(define (list-laenge list)
  (laenge list 0))
(define (laenge lst counter)
  (if (null? lst)
      counter
      (laenge (cdr lst) (+ counter 1))))
; Variant 2
(define (list-laenge2 list)
  (length list))

;Variant 1 - Max
(define (max-ziffer list)
  (max-element list 0))

(define (max-element lst maxElement)
  (if (null? lst)
      maxElement
      (max-element (cdr lst) (if (> (car lst) maxElement)
                         (car lst)
                         maxElement))))

; Variant 2 - Max

(define (max-ziffer2 lst)
  (apply max lst))

; Min
(define (mini a)
 (if (null? (cdr a))
     (car a) 
  (min (car a) (mini(cdr a)))))

; Min - Variant 2
(define (min-element lst)
  (apply min lst))

; Produkt in listen

(define (produkt list)
  (if (null? list)
      1
      (* (car list) (produkt (cdr list)))))

;Listen verschmelzen:
(define (verschmelzen lst1 lst2)
  (append lst1 lst2))

;Duplikate entfernen:

(define (entfernen lst)
  (entfern lst '()))

(define (entfern lst newList)
  (if (null? lst)
      (reverse newList)
      (entfern (cdr lst) (if (member (car lst) newList)
                            newList
                              (cons (car lst) newList)))))

; Gerade und ungerade Zahlen filtern:

(define (filter? zahlen operation) (filter operation zahlen))
;(filter?  '(1 2 3 (4 5) (6 7) 8) pair?) -> ((4 5) (6 7))

; Listen Verschachteln

(define (verschachteln lst1 lst2)
  (cond ((null? lst1) lst2)
        ((null? lst2) lst1)
        (else (cons (car lst1) (cons (car lst2) (verschachteln (cdr lst1) (cdr lst2)))))))


;(display (verschachteln '(1 2 3) '(a b c))) -> (1 a 2 b 3 c)


; Häufigstes Element finden:

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



; Beispiel
;(display (haeufigstes-element '(2 2 3 3 3 2))) ; Gibt 2 aus

(define (zyklisch-verschieben lst n)
  (if (or (null? lst) (zero? n))
      lst
      (rotate-zyklisch lst (- (length lst) (modulo n (length lst))))))

  (define (rotate-zyklisch lst count)
    (if (zero? count)
        lst
        (rotate-zyklisch (append (cdr lst) (list (car lst))) (- count 1))))

; Beispiel
;(display (zyklisch-verschieben '(1 2 3 4 5) 2)) ; Sollte (4 5 1 2 3) ausgeben

;Paare bilden:

(define (paare-bilden lst1 lst2)
  (if (or (null? lst1) (null? lst2))
      '() ; Rückgabewert für leere Listen
      (cons (list (car lst1) (car lst2))
            (paare-bilden (cdr lst1) (cdr lst2)))))

; Beispiel
;(display (paare-bilden '(1 2 3) '(a b c))) ; Gibt '((1 a) (2 b) (3 c)) aus

;Polindrom:

(define (polindrom lst)
  (if (eq? (car lst) (car (reverse lst)))
      #t
      #f))

(define (polindrom2 lst)
  (if (eq? (first lst) (last lst))
      #t
      #f))

;Listen-Slice:

(define (list-slice-helper lst i end result)
  (if (= i end)
      (reverse result)
      (list-slice-helper lst (+ i 1) end (cons (list-ref lst i) result))))

(define (list-slice lst start end)
  (if (or (< start 0) (>= start (length lst)) (< end start) (>= end (length lst)))
      '()
      (list-slice-helper lst start end '())))


; (list-slice '(1 2 3 4 5) 1 4) -> (2 3 4)

;Listen-Entfernung von Element:

(define (entfernung lst element)
  (delete lst element '()))

(define (delete lst element newList)
  (if (null? lst)
      newList
      (delete (cdr lst) element (cond ((and (number? (car lst)) (= element (car lst))) newList)
                                      ((and (symbol? (car lst)) (eq? element (car lst))) newList)
                                      (else (append newList (list (car lst))))))))

;Listen-Teilung:

(define (list-teilen lst groups)
  (teilen-helper lst groups '() '() 0))

(define (teilen-helper lst groups lst1 lst2 counter)
      (if (null? lst)
        (list (reverse lst1) (reverse lst2))
        (teilen-helper (cdr lst) groups (if (< counter groups)
                                                  (cons (car lst) lst1)
                                                  lst1)
                             (if (>= counter groups)
                                 (cons (car lst) lst2)
                                 lst2) (+ counter 1))))

;(list-teilen '(1 2 3 4 5 6) 2)
      
      
; Listen-Replikation:

(define (replikation lst times)
  (replikation-helper lst times '()))

  (define (replikation-helper lst times newList)
    (if (= times 0)
        newList
        (replikation-helper lst (- times 1) (append newList lst))))

; Listen-Rotation:

(define (rotate lst n)
  (cond
    [(< n 0) (error "n is negative")]
    [(or (= n 0) (null? lst)) lst]
    [else (rotate (append (cdr lst) (list (car lst))) (- n 1))]))

;(rotate '(1 2 3 4 5) 2) ; returns (3 4 5 1 2)


; Listen-Prefix-Überprüfung:

(define (is-prefix? lst1 lst2)
  (helper-prefix lst1 lst2 (min (length lst1) (length lst2))))

(define (helper-prefix lst1 lst2 counter)
  (if (= counter 0)
      #t
      (and (eqv? (car lst1) (car lst2))
           (helper-prefix (cdr lst1) (cdr lst2) (- counter 1)))))

;Listen-Permutationen:


(define (remove x lst)
  (cond
    ((null? lst) '())
    ((= x (car lst)) (remove x (cdr lst)))
    (else (cons (car lst) (remove x (cdr lst))))))

(define (permutations lst)
  (cond
    ((null? lst) '(()))
    ((null? (cdr lst)) (list lst))
    (else
      (define (insert x lst)
        (if (null? lst)
            (list (list x))
            (cons (cons x lst)
                  (map (lambda (p) (cons (car lst) p))
                       (insert x (cdr lst))))))
      (foldr append '() (map (lambda (x) (insert x (remove x lst))) lst)))))

; Perfekte zahl
(define (teiler-summe n)
  (define (iter i summe)
    (cond
      ((= i n) (+ summe i))
      ((zero? (modulo n i)) (iter (+ i 1) (+ summe i)))
      (else (iter (+ i 1) summe))))
  (iter 1 0))

(define (perfekt? n)
  (= n (/ (teiler-summe n) 2)))

(define (perfekte-zahlen n)
  (define (iter i liste)
    (cond
      ((= i n) liste)
      ((perfekt? i) (iter (+ i 1) (cons i liste)))
      (else (iter (+ i 1) liste))))
  (iter 1 '()))

;(perfekte-zahlen 10000) ; gibt (8128 496 28 6)

; Primazahlen
(define (primzahl? n)
  (define (iter i)
    (cond
      ((= i n) #t)
      ((zero? (modulo n i)) #f)
      (else (iter (+ i 1)))))
  (iter 2))

(define (primzahlen lst)
  (cond
    ((null? lst) '())
    ((primzahl? (car lst)) (cons (car lst) (primzahlen (cdr lst))))
    (else (primzahlen (cdr lst)))))

(primzahlen '(12 17 23 25 29))
