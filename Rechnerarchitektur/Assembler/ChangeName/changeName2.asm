section .text
global _start

_start:
mov edx, len
mov ecx, name
mov ebx, 1
mov eax, 4
int 80h

mov eax, dword[newFirstName]
mov dword[name], eax

mov edx, len
mov ecx, name
mov ebx, 1
mov eax, 4
int 80h

mov eax, 1
mov ebx, 0
int 80h

section .data

name db 'Zara Ali ', 0xa
len equ $ - name

newFirstName db 'Alex'