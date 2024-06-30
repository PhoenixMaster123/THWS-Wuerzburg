section .data

; DB (define byte -> 1 byte) 8 bits 
; DW (define word -> 2 bytes) 16 bits
; DD (define doble word -> 4 bytes) 32 bits
; DQ (define quadrad word -> 8 bytes) 64 bits
; DT (10 Bytes)

; The store is binary data -> 0000 0000 (8 bits)

num dd 5 ; (name|type|initial value)

section .text
global _start

_start:

mov eax, 1
mov ebx, [num] ; -> ebx = 0,if we don't use [],  because we store the location of the address of the data for this variable
int 80h

; Note: Use debugger gdb 
; If we use x/x $ebx -> what is located on the stack on the location ebx 
; to take the actual value we use [], that means go to this adress and take the value 
