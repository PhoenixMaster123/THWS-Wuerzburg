section .text
global main

main:

mov esi, 10

loop:

mov eax, 4
mov ebx, 1
mov ecx, msg
mov edx, msglen
int 0x80

dec esi
jnz loop

mov eax, 1
int 0x80


section .data
msg db "Hello World!", 10, 0
msglen equ $ - msg