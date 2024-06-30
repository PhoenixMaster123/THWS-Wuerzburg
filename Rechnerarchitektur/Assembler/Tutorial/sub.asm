section .text
global _start

_start:
mov eax, 5
mov ebx, 3
sub eax, ebx ; eax = 5 - 3 = 2 | 0x2
int 80h

mov eax, 3
mov ebx, 5
sub eax, ebx ; eax = 3 - 5 = -2 | 0xfffffffe (compliment)
int 80h

mov eax, 3
mov ebx, 5
sub eax, ebx ; eax = 3 - 5 = -2 | 0xfffffffe (2 compliment)
mov ebx, 2
add eax, ebx ; eax = -2 + 2 = 0  |0x0
int 80h

section .data

; Note:
; We check eflags
; SF (sign flag)