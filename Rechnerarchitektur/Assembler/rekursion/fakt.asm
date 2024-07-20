section .text
extern printf
extern scanf
global main

main:
    ; Read integer from user
    push integer
    push formatNumber
    call scanf
    add esp, 8

    ; Load the integer into eax
    mov eax, [integer]

    ; Call the factorial function
    call factorial

    ; Print the result
    push eax
    push formatPrint
    call printf
    add esp, 8

    ; Exit the program
    mov eax, 1            ; System call number (sys_exit)
    xor ebx, ebx          ; Exit code 0
    int 0x80              ; Call kernel to exit

; Factorial function using recursion
factorial:
    ; Base case: if eax <= 1, return 1
    cmp eax, 1
    jle factorial_base_case

    ; Save the current value of eax (n)
    push eax

    ; Decrement eax (n-1)
    dec eax

    ; Recursive call to factorial(n-1)
    call factorial

    ; Restore the original value of eax (n)
    pop ebx

    ; Multiply the result by eax (n * factorial(n-1))
    imul eax, ebx
    ret

factorial_base_case:
    mov eax, 1
    ret

section .data
formatNumber db '%d', 0
integer times 4 db 0
formatPrint db 'The result is: %d', 10, 0
