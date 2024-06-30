extern printf
extern scanf

section .text
global main

main:
    ; Read input number
    push num
    push format
    call scanf
    add esp, 8

    ; Initialize ESI and EAX for factorial calculation
    mov esi, [num]
    mov eax, 1

factorial_loop:
    ; Multiply EAX by ESI
    mul esi
    ; Decrement ESI
    dec esi
    ; Compare ESI with 1, loop if greater or equal
    cmp esi, 1
    jge factorial_loop

    ; Print result
    push eax
    push format2
    call printf
    add esp, 8

    ; Exit program
    mov eax, 1
    xor ebx, ebx
    int 0x80

section .data
num dd 0          ; Define num as a double word to hold the input number
format db '%d', 0 ; Format string for scanf
format2 db 'Your result is: %d', 10, 0 ; Format string for printf
