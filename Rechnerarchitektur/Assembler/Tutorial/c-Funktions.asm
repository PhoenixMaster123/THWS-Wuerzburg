extern printf
extern exit

; printf(format + value) -> first format then msg
; exit(1 Argument)

section .text
global main ; I need main funktion to work with gcc

main:

; Stack -> LIFO (Last in first out)
push msg2
push msg  ; second this
push fmt  ; first this
call printf
push 1
call exit


section .data
msg  db "Hello World", 0
msg2 db "This is a test", 0
fmt  db "Output is: %s %s", 10, 0 ; %s string | 10 -> new line charachter

; Note printf(%s %s, msg, msg2)