section .data ; -> store variables

section .text ; -> actual code
global _start

_start:

    mov eax, 1 ; -> exit code
    mov ebx, 1 ; -> status code that we want to print
    int 80h    ; -> interrupt 