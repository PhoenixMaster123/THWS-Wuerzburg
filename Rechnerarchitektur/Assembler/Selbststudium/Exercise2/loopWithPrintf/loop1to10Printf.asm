extern printf
section .text
global main

main:

mov esi, 1

loop:

push esi
push esi
push format
call printf
add esp, 8


inc esi
cmp esi, 11
jl loop

mov eax, 1
int 0x80


section .data
format db 'Number: %d',10, 0 ; If I use "" I don't receive result
