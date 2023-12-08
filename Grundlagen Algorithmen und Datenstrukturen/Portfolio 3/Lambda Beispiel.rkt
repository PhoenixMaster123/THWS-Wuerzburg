#lang racket
(define (prozedur-quadrat1)
  (lambda (x) (* x x)))

;( (prozedur-quadrat1) 4) - > 16

(define (prozedur-quadrat2)
  (define (quadrat x) (* x x))
  quadrat)

; ( (prozedur-quadrat2) 4) -> 16