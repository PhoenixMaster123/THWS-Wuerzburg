section .bss ; -> block storing symbol
num resb 3   ; -> reserve byte

section .data
num2 db 3 dup(2) ; -> write 2 in the memory 3 times its like default value (itialise)

section .text
global _start

_start:

;mov [num], 1 ; -> only like that is not working
mov bl, 1
mov [num], bl ; [num] -> move to first memory location [num + 1] -> second and etc. | result: 0x00000001
mov [num + 1], bl ; result: 0x00000101
mov [num + 2], bl ; 0x00010101

mov eax, 1
int 80h