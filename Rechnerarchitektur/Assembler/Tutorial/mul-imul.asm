section .text
global _start

_start:
;mul  (unsigned value)
;imul (signed value)
mov al, 2 ; the result is stored is al
mov bl, 3
mul bl  ; al = bl(3) * al(2) = 6
int 80h

mov al, 0xFF ; 245
mov bl, 2
mul bl  ; al = -2  | ah = 1 | ax = 510 -> the actial result (expanded it automatic)
int 80h

mov al, 0xFF ; al = -1 (compliment form)
mov bl, 2    ; bl = 2
imul bl      ; al = -1 * 2 = -2
int 80h

section .data