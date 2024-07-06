section .text
global main

main:
mov eax, '3'
sub eax, '0'

mov ebx, '6'
sub ebx, '0'

add eax, ebx
add eax, '0'

mov [sum], eax

mov eax, 4
mov ebx, 1
mov ecx, msg
mov edx, lenMsg
int 0x80

mov ebx,1   
mov eax,4  
mov ecx,sum
mov edx, 1
int 0x80    

mov eax, 1
mov ebx, 0
int 0x80

section .data
msg db "The result is ", 10, 0
lenMsg equ $-msg

sum db 1 ; Option 1

;section .bss ; Option 2
;sum resb 1