global main
extern printf

section .text

main:
    mov ecx, 10      ; Set loop counter to 10

loop_start:
    ; Prepare arguments for printf
    push ecx
    push ecx         ; Push the current counter value (argument for %d)
    push format      ; Push the format string

    call printf      ; Call printf
    add esp, 8       ; Clean up the stack (2 * 4 bytes)
    pop ecx

    dec ecx          ; Decrement loop counter
    jnz loop_start   ; Jump to loop_start if ECX is not zero

    ; Exit program
    mov eax, 1       ; syscall: exit (1 for 32-bit, 60 for 64-bit)
    xor edi, edi     ; exit code 0
    syscall

section .data
format db 'Counter: %d', 10, 0

section .bss
    ; Declare space for variables if needed
