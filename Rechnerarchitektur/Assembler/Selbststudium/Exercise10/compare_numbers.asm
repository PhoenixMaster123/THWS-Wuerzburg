section .text
global main

main:

mov eax, [num1]
mov ebx, [num2]

cmp eax, ebx
jg greater
jl smaller
je equal

greater:
mov eax, 4
mov ebx, 1
mov ecx, msg1
mov edx, msg1Len
int 0x80

jmp exit

smaller:
mov eax, 4
mov ebx, 1
mov ecx, msg2
mov edx, msg2Len
int 0x80

jmp exit

equal:
mov eax, 4
mov ebx, 1
mov ecx, msg3
mov edx, msg3Len
int 0x80

jmp exit

exit:
mov eax, 1
int 0x80

section .data
msg1 db "The first number is greater then the second"
msg1Len equ $ - msg1
msg2 db "The first number is smaller then the second"
msg2Len equ $ - msg2
msg3 db "The both numbers are equal!"
msg3Len equ $ - msg3


num1 dd 7
num2 dd 7