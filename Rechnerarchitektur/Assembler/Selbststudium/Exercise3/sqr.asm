extern printf
section .data
number dd 5
result dd 0 
format db 'The result is %d',10, 0
section .text
global main

main:

mov eax, [number]
mul eax
mov [result], eax

push dword [result]
push dword format
call printf
add esp, 8

mov eax, 1
int 0x80