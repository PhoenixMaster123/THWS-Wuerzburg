section .text
global main

main:

mov eax, '2'
sub eax, '0'

mov ebx, '4'
sub ebx, '0'

mul ebx
add eax, '0'

mov [res], eax

mov eax, 4
mov ebx, 1
mov ecx, msg
mov edx, msgLen
int 0x80

mov eax, 4
mov ebx, 1
mov ecx, res
mov edx, 1
int 0x80

mov eax, 1
int 0x80

section .data
msg db "The result is ", 0
msgLen equ $ - msg
res db 1