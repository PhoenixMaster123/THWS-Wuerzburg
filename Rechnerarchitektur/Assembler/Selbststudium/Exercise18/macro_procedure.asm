section .text
    extern printf
    global main

    ; Define the iteration macro
    %macro iteration 3
        mov esi, 0              ; Initialize esi to 0
        mov edx, 0              ; Initialize edx to 0

        loop_start:
            cmp esi, %3           ; Compare esi with lenArr
            jge loop_end          ; If esi >= lenArr, exit loop
            add %1, dword[%2 + esi] ; Add element to %1
            add esi, 4            ; Move to the next element (dword, so increment by 4)
            jmp loop_start        ; Repeat loop

        loop_end:
    %endmacro

    ; Define the sumNumbers procedure
    sumNumbers:
        iteration eax, array, lenArr
        ret

main:
    mov eax, 0              ; Initialize sum (eax) to 0

    ; Call the sumNumbers procedure
    call sumNumbers

    ; Print the result
    push eax
    push formatResult
    call printf
    add esp, 8

    ; Exit the program
    mov eax, 1
    xor ebx, ebx
    int 0x80

    section .data
    array dd 5, 10, 5, 20, 10
    lenArr equ ($ - array)
    formatResult db 'The sum is %d', 10, 0

