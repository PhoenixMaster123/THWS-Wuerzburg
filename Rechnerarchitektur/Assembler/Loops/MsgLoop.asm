extern printf
global main
section .text

main:
mov eax, 4
mov ebx, 1
mov ecx, msg
mov edx, msgLen
int 0x80

mov eax, 3
mov ebx, 0
mov ecx, buffer
mov edx, bufferLeng
int 0x80

mov esi, 0

loop_start:

push buffer
push format
call printf
add esp, 8

inc esi
cmp esi, 5
jl loop_start

mov eax, 1
mov ebx, 1
int 0x80

section .data
msg db "Type your message: ", 0
msgLen equ $ - msg
format db "%s", 0

section .bss
buffer resb 64
bufferLeng equ $ - buffer
