global main
extern printf

section .text

main:

mov ecx, 1

loop:
push ecx
push ecx 
push format

call printf
add esp, 8
pop ecx

inc ecx
cmp ecx, 11
jl loop

    mov eax, 1       
    xor edi, edi     
    syscall

section .data
format db 'Counter: %d', 10, 0