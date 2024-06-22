section .text
global _start

_start:
mov ax, '8'
sub ax, '0'

mov bl, '2'
sub bl, '0'

div bl
add ax, '0'

mov [result], ax

mov eax, 4
mov ebx, 1
mov ecx, msgResult
mov edx, lenResult
int 0x80

mov eax, 4
mov ebx, 1
mov ecx, result
mov edx, 1
int 0x80


section .data
msgResult db "The result is: ", 0xA, 0xD
lenResult equ  $ - msgResult

section .bss
result resb 1