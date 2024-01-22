#lang racket


(define (teilen str durch)
  (helper str (string (car (string->list durch))) (string (cadr (string->list durch)))))

(define (helper str ele1 ele2)
  (string-split (string-replace (string-replace str ele1 "") ele2 "") " "))



(teilen "nach den Abschluss-Prüfungen, kommen die Ferien" ",-")