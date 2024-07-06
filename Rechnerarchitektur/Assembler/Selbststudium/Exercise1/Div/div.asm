section .text
global main

main:

mov ax, '8'
sub ax, '0'

mov bl, '4'
sub bl, '0'

div bl
add al, '0'

mov [result], al

mov eax, 4
mov ebx, 1
mov ecx, msg
mov edx, msgLen
int 0x80

mov eax, 4
mov ebx, 1
mov ecx, result
mov edx, 1
int 0x80

mov eax, 1
int 0x80

section .data
msg db "The result is ", 0
msgLen equ $ - msg

section .bss
result resb 1