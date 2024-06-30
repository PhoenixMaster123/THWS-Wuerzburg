section .data
num  db 1
num2 db 2

section .text
global _start

; General Purpose registers
;eax
;ebx -> get all 32 bits 
;ecx
;edx

_start:
;mov ebx, [num] ; we receive 0x201 | we don't need the whole 32 bits, we need only 8 thats why we type not ebx but ah/al
mov bl, [num]
mov cl, [num2]
mov eax, 1
int 80h

; Note:
; ah, bh, ch, dh -> 0000(left -> high) 0000 
; al, bl, cl, dl -> 0000 0000(right -> low) 

; If we use ah/al -> doesn't matter which one we use

; high -> bigger  numbers
; low  -> smaller numbers