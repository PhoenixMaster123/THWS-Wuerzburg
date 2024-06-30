section .data
char db 'A' ; -> 65 ASCII Table
list db 1, 2, 3, 4
string1 db "ABA", 0 ; -> with 0 we indicate the end of the str
string2 db "CDE", 0

section .text
global _start

_start:

mov bl, [string1] ;[list] ;[char]
mov eax, 1
int 80h