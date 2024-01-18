#lang racket

;Stack
(define my-stack '())

; Push
(set! my-stack (cons 'apple my-stack))
(set! my-stack (cons 'banana my-stack))
(set! my-stack (cons 'cherry my-stack))

; Pop
(define popped-element (if (null? my-stack) 'empty (car my-stack)))
(set! my-stack (cdr my-stack))

; Peek
(define top-element (if (null? my-stack) 'empty (car my-stack)))

; Ausgabe
(display "Stack: ") (display my-stack)
(display "Popped Element: ") (display popped-element)
(display "Top Element: ") (display top-element)

(newline)
; Queue
(define my-queue '())
; Enqueue
(set! my-queue (append my-queue (list 'apple)))
(set! my-queue (append my-queue (list 'banana)))
(set! my-queue (append my-queue (list 'cherry)))

; Dequeue
(define dequeued-element (if (null? my-queue) 'empty (car my-queue)))
(set! my-queue (cdr my-queue))

; Peek
(define front-element (if (null? my-queue) 'empty (car my-queue)))

; Ausgabe
(display "Queue: ") (display my-queue)
(display "Dequeued Element: ") (display dequeued-element)
(display "Front Element: ") (display front-element)