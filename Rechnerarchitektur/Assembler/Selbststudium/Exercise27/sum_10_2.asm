extern printf

section .text
global main

main:
    ; Initialize EAX to 1 and EBX to 0
    mov eax, 1
    mov ebx, 0  ; Clear EBX to 0
;or xor ebx, ebx

loop:
    ; Print the current number
    push eax              ; Save EAX
    push eax              ; Push the current number as argument
    push format1          ; Push the format string as argument
    call printf           ; Call printf
    add esp, 8            ; Clean up the stack (2 arguments * 4 bytes)
    pop eax               ; Restore EAX

    ; Add the current number to the running total
    add ebx, eax

    ; Print the current result (running total)
    push eax              ; Save EAX again
    push ebx              ; Push the current result as argument
    push format2          ; Push the format string as argument
    call printf           ; Call printf
    add esp, 8            ; Clean up the stack (2 arguments * 4 bytes)
    pop eax               ; Restore EAX again

    ; Increment the current number
    inc eax
    ; Check if the current number is less than 10
    cmp eax, 10
    jl loop               ; Jump to the start of the loop if less than 10

    ; Print the final result
    push ebx              ; Push the final result as argument
    push format3          ; Push the format string as argument
    call printf           ; Call printf
    add esp, 8            ; Clean up the stack (2 arguments * 4 bytes)

    ; Exit the program
    mov eax, 1            ; System call number (sys_exit)
    xor ebx, ebx          ; Exit code 0
    int 80h               ; Call kernel

section .data
    format1 db 'The current number: %d', 10, 0
    format2 db 'The current result is: %d', 10, 0
    format3 db 'The result is: %d', 10, 0

; Note: To keep with the counter you need to add this counter in every printf and pop it