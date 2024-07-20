section .text
extern printf
extern scanf
global main

main:

push integer
push formatNumber
call scanf
add esp, 8

mov eax, [integer]
mov ebx, 1

fakt:

cmp eax, 1
jle exit
imul ebx, eax
dec eax

jmp fakt


exit:

push ebx
push formatPrint
call printf
add esp, 8

mov eax, 1
int 0x80

section .data
formatNumber db '%d'
integer times 4 db 0
formatPrint db 'The result is: %d', 10, 0
