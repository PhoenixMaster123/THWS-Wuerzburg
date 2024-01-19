#lang racket

; Vektoraddition:

(define (vector-add vec1 vec2)
  (helper-add vec1 vec2 0 #()))

(define (helper-add vec1 vec2 pos result)
  (cond ((and (>= pos (vector-length vec1)) (>= pos (vector-length vec2))) result)
        ((>= pos (vector-length vec1)) (helper-add vec1 vec2 (+ pos 1) (vector-append result (vector (vector-ref vec2 pos)))))
        ((>= pos (vector-length vec2)) (helper-add vec1 vec2 (+ pos 1) (vector-append result (vector (vector-ref vec1 pos)))))
        (else (helper-add vec1 vec2 (+ pos 1) (vector-append result (vector (+ (vector-ref vec1 pos) (vector-ref vec2 pos))))))))

; Skalarprodukt:

(define (dot-product vec1 vec2)
  (helper-skalar vec1 vec2 0 0))

(define (helper-skalar vec1 vec2 pos result)
  (cond ((and (>= pos (vector-length vec1)) (>= pos (vector-length vec2))) result)
        ((>= pos (vector-length vec1)) (helper-skalar vec1 vec2 (+ pos 1) (+ result (vector-ref vec2 pos))))
        ((>= pos (vector-length vec2)) (helper-skalar vec1 vec2 (+ pos 1) (+ result (vector-ref vec1 pos))))
        (else (helper-skalar vec1 vec2 (+ pos 1) (+ result (* (vector-ref vec1 pos) (vector-ref vec2 pos)))))))

; Vektorsubtraktion:

(define (vector-subtract vec1 vec2)
  (helper-subtract vec1 vec2 0 #()))

(define (helper-subtract vec1 vec2 pos result)
  (cond ((and (>= pos (vector-length vec1)) (>= pos (vector-length vec2))) result)
        ((>= pos (vector-length vec1)) (helper-subtract vec1 vec2 (+ pos 1) (vector-append result (vector (vector-ref vec2 pos)))))
        ((>= pos (vector-length vec2)) (helper-subtract vec1 vec2 (+ pos 1) (vector-append result (vector (vector-ref vec1 pos)))))
        (else (helper-subtract vec1 vec2 (+ pos 1) (vector-append result (vector (- (vector-ref vec1 pos) (vector-ref vec2 pos))))))))


; Kreuzproduct

(define (kreuzproduct vec1 vec2)
 (if (not (= (vector-length vec1) (vector-length vec2)))
      0
  (kreuzproduct-helper vec1 vec2 1 2 2 1 #() 0)))

(define (kreuzproduct-helper vec1 vec2 pos1 pos2 pos3 pos4 result counter)
  (if (= counter (vector-length vec1))
      result
      (kreuzproduct-helper vec1 vec2 (if (>= pos1 (- (vector-length vec1) 1)) 0 (+ pos1 1))
                                     (if (>= pos2 (- (vector-length vec2) 1)) 0 (+ pos2 1))
                                     (if (>= pos3 (- (vector-length vec1) 1)) 0 (+ pos3 1))
                                     (if (>= pos4 (- (vector-length vec2) 1)) 0 (+ pos4 1))

                                     (vector-append result (vector (- (* (vector-ref vec1 pos1) (vector-ref vec2 pos2)) (* (vector-ref vec1 pos3) (vector-ref vec2 pos4)))))
                                     (+ counter 1))))

; Vektornorm:

(define (vector-norm vec)
  (helper-norm vec 0 0))

(define (helper-norm vec pos result)
  (if (= pos (vector-length vec))
      (sqrt result)
      (helper-norm vec (+ pos 1) (+ result (expt (vector-ref vec pos) 2)))))

  
; Lineare Kombination:

(define (linear-combination v1 v2 c1 c2)
  (helper-combination v1 v2 c1 c2 0 #()))

(define (helper-combination v1 v2 c1 c2 pos result)
  (if (= pos (vector-length v1))
      result
  (helper-combination v1 v2 c1 c2 (+ pos 1)
                      (if (= pos 0)
                          (vector-append result (vector (+ (* (vector-ref v1 pos) c1) (* (vector-ref v2 pos) c1))))
                          (vector-append result (vector (+ (* (vector-ref v1 pos) c2) (* (vector-ref v2 pos) c2))))))))

; Determinante 

(define (determinante vec1 vec2 vec3)
  (helper-determinante vec1 vec2 vec3 0))

(define (helper-determinante vec1 vec2 vec3 result)
  (+ result (- (+
             (* (vector-ref vec1 0) (vector-ref vec2 1) (vector-ref vec3 2))
             (* (vector-ref vec1 2) (vector-ref vec2 0) (vector-ref vec3 1))
             (* (vector-ref vec1 1) (vector-ref vec2 2) (vector-ref vec3 0)))
               
               (* (vector-ref vec1 2) (vector-ref vec2 1) (vector-ref vec3 0))
               (* (vector-ref vec1 1) (vector-ref vec2 0) (vector-ref vec3 2))
               (* (vector-ref vec1 0) (vector-ref vec2 2) (vector-ref vec3 1)))))

; String-remove

(define (entfernen str wort index)
  (entfernen-helper (string-split str) wort index 1 '()))

(define (entfernen-helper string wort index counter result)
  (if (null? string)
      (string-join result " ")
      (cond ((and (equal? (car string) wort) (= index counter)) (entfernen-helper (cdr string) wort index counter result))
            ((equal? (car string) wort) (entfernen-helper (cdr string) wort index (+ counter 1) (append result (list (car string)))))
            (else (entfernen-helper (cdr string) wort index counter (append result (list (car string))))))))
          

; String - Polindrom?

;///////////////////////////////////////////// Variant 1 ////////////////////////////////////////
(define (polindrom? str)
  (helper-palindrom? (string->list (string-downcase str))))

(define (helper-palindrom? lst)
  (if (equal? (car lst) (last lst)) #t #f))

;///////////////////////////////////////////// Variant 2 ////////////////////////////////////////
(define (polindrom2? str)
  (helper-palindrom2? (string->list str)))

(define (helper-palindrom2? lst)
  (if (char-ci=? (car lst) (last lst)) #t #f))

(define (funktion vec)
  (lambda (x) (vector-map (lambda (y) (+ x y)) vec)))

; Schreiben Sie eine Procedure, welche eine lambda funktion übergeben bekommen und diese auf alle element

(define plus (funktion #(1 2 3 4)))
(define result (plus 5))

;Koordinaten des Mittelpunkts des Dreiecks


(define (mittelpunkt vec1 vec2 vec3)
  (helper-mittelpunkt vec1 vec2 vec3 #() 0))

(define (helper-mittelpunkt vec1 vec2 vec3 result pos)
  (if (= pos (vector-length vec1))
      result
  (helper-mittelpunkt vec1 vec2 vec3 (vector-append result
                                      (vector (/ (+ (vector-ref vec1 pos) (vector-ref vec2 pos) (vector-ref vec3 pos)) 3)))
                      (+ pos 1))))


; Filter Durchschnittlich

(define (durchschnittlich vec)
  (helper-filter (/ (vector-sum vec 0 0) (vector-length vec)) vec 0 #()))

(define (vector-sum vec pos sum)
  (if (= pos (vector-length vec))
      sum
      (vector-sum vec (+ pos 1) (+ sum (vector-ref vec pos)))))

(define (helper-filter durchschnitt vec pos result)
  (if (= pos (vector-length vec))
      result
      (helper-filter durchschnitt vec (+ pos 1) (if (> (vector-ref vec pos) durchschnitt)
                                                    (vector-append result (vector (vector-ref vec pos)))
                                                    result))))

; Schreiben Sie eine Prozedure, welche einen string durch einen anderen ersetzt

; Replace
(define (ersetze-str str newString newWort)
  (helper-ersetze (string-split str newString) newString newWort '() ))

  (define (helper-ersetze string wort new result)
    (append result (list (string-append (car string) new))))


