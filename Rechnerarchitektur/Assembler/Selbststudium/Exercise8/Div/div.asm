extern printf
extern scanf
section .text
global main

main:
push integer1
push format1
call scanf
add esp, 8

push integer2
push format1
call scanf
add esp, 8

mov eax, [integer1]
mov ebx, [integer2]

div ebx

push eax
push formatRes
call printf
add esp, 8

mov eax, 1
int 0x80

section .data
format1 db '%d', 0
integer1 times 4 db 0 ;32 bytes integer = 4 bytes
integer2 times 4 db 0 ; -> equivalent to integer2 dd 0
formatRes db 'The result is: %d', 10, 0

; Note: First need to be every scanf and the to add them to the registers
