section .text
global _start

_start:
; div (unsigned numbers)
; idiv(signed numbers)

mov eax, 11 ; eax = 11/2 = 5 | edx = 1 (remainder)
mov ecx, 2
div ecx
int 80h

mov eax, 0xff ; eax = -1/2 =
mov ecx, 2
idiv ecx
int 80h


section .data