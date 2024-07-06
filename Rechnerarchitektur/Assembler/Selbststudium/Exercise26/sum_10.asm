section .text
global main
extern printf

main:

mov eax, 1

mov ecx, 0
loop:

add ecx, eax   
inc eax
cmp eax, 10
jl loop

push ecx
push format
call printf
add esp, 8

mov eax, 1
int 0x80

section .data
format db 'The result is: %d', 10, 0

; Note for stack I need to use 32 bit registers