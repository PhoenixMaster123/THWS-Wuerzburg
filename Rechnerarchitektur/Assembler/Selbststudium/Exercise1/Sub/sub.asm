section .text
global main

main:
mov eax, 9
;sub eax, '0'

mov ebx, 3
;sub ebx, '0'

sub eax, ebx
add eax, '0'

mov [res], eax

mov eax, 4
mov ebx, 1
mov ecx, res
mov edx, 1
int 0x80

mov eax, 1
int 0x80

section .data
res db 1