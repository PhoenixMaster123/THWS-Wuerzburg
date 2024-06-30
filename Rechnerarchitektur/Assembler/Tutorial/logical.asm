section .text
global _start

_start:
mov eax, 0b1010
mov ebx, 0b1100
and eax, ebx 

; eax | 1010
; ebx | 1100
;-------------
; eax | 1000 -> 8

mov eax, 0b1010
mov ebx, 0b1100
or  eax, ebx

; eax | 1010
; ebx | 1100
;-------------
; eax | 1110 -> 14

not eax ; -> -15 (we flip all the bits and we don't want that)
int 80h

mov eax, 0b1010
not eax
and eax, 0x0000000F ; 0x0(4bits)0(8bits)0(12bits)0(16bits)0(20bits)0(24bits)0(28bits) -> the result is 5
int 80h             ;The value is set remains, the value that is not set go to 0-> a mask

; Short version: 0x0000000F <=> 0xF (the last 4 bits)

mov eax, 0b1010
mov ebx, 0b1100
xor  eax, ebx
int 80h

; eax | 1010
; ebx | 1100
;-------------
; eax | 0110 -> 6





section .data