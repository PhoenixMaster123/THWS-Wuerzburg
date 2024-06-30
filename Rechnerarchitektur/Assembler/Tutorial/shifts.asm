section .text
global _start

_start:

mov eax, 2
shr eax, 1 ; shift to the right | 2 (0010) -> 1(0001) the last value go to the carry flag
int 80h

; Note shift to the right <=>  digit / 2

mov eax, 2
shr eax, 1 ; shift to the left | 2 (0010) -> 4(0100) the last value go to the carry flag
int 80h

; Note shift to the left <=>  digit * 2

section .data