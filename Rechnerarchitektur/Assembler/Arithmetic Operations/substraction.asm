section .text
global _start

_start:

    ; Print the first message
    mov eax, 4
    mov ebx, 1
    mov ecx, msg1
    mov edx, len1
    int 0x80

    ; Read first number
    mov eax, 3
    mov ebx, 0
    mov ecx, num1
    mov edx, 2
    int 0x80

    ; Print the second message
    mov eax, 4
    mov ebx, 1
    mov ecx, msg2
    mov edx, len2
    int 0x80

    ; Read second number
    mov eax, 3
    mov ebx, 0
    mov ecx, num2
    mov edx, 2
    int 0x80

    ; Print the result message
    mov eax, 4
    mov ebx, 1
    mov ecx, msg3
    mov edx, len3
    int 0x80

    ; Convert the first number from ASCII to integer
    mov eax, [num1]
    sub eax, '0'

    ; Convert the second number from ASCII to integer
    mov ebx, [num2]
    sub ebx, '0'

    ; Subtract the two numbers
    sub eax, ebx

    ; Convert the result back to ASCII
    add eax, '0'

    ; Store the result
    mov [res], eax

    ; Print the result
    mov eax, 4
    mov ebx, 1
    mov ecx, res
    mov edx, 1
    int 0x80

    ; Exit command
    mov eax, 1
    xor ebx, ebx
    int 0x80

section .data
msg1 db "Enter a number: ", 0
len1 equ $ - msg1

msg2 db "Enter a second number: ", 0
len2 equ $ - msg2

msg3 db "The result is: " , 0xA, 0xD
len3 equ $ - msg3

section .bss
num1 resb 2
num2 resb 2
res resb 1
