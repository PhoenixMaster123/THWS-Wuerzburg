 global main
 extern printf

section .text

main:
    mov ecx, 0   ; Index counter
   ; mov eax, 0x00000000               
    movzx eax, byte[numbers]    ; Load the first element of the array into eax
    mov [max], eax              ; Initialize max with the first element of the array
    mov edi, lenArr             ; Load the length of the array into edi

search_max:
    cmp ecx, edi                ; Compare index counter with length of the array
    jge exit                    ; If index >= length, exit the loop

    movzx eax, byte [numbers + ecx] ; Load current element into eax
    mov ebx, [max]                ; Load the current max value into ebx
    cmp eax, ebx                  ; Compare current element with current max value
    jle next                      ; If current element <= max, go to next iteration

    mov [max], eax              ; Update max if current element is greater

next:
    inc ecx                     ; Increment index counter
    jmp search_max              ; Repeat the loop

exit:
    mov eax, [max]              ; Load the max value into eax
    push eax                    ; Push the max value onto the stack
    push msg                    ; Push the format string onto the stack
    call printf                 ; Call printf to print the max value
    add esp, 8                  ; Clean up the stack (2 * 4 bytes)

    mov eax, 1                  ; Exit system call
    xor ebx, ebx                ; Status 0
    int 0x80                    ; Call kernel

section .data
    msg db 'The max value in this array is: %d', 10, 0
    len equ $ - msg
    numbers db 10, 16, 9, 50, 70, 30, 99
    lenArr equ ($ - numbers)

section .bss
    max resb 4

