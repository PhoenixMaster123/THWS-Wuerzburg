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
   



      