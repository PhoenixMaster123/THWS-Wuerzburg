global main
extern printf

section .text

main:
    ; Write the greeting message
    mov eax, 4          ; system call number (sys_write)
    mov ebx, 1          ; file descriptor (stdout)
    mov ecx, msg        ; message to write
    mov edx, msg_len    ; message length
    int 0x80            ; call kernel

    ; Read user input
    mov eax, 3          ; system call number (sys_read)
    mov ebx, 0          ; file descriptor (stdin)
    mov ecx, buffer     ; buffer to store the input
    mov edx, buffer_size; max number of bytes to read
    int 0x80            ; call kernel

    ; Move the user input from the buffer to a register (e.g., ebx)
   ; mov ebx, buffer     ; Move the address of the buffer to ebx

    ; Output the user input 5 times
    mov esi, 5          ; repeat count

loop:
    ; Write the user input to stdout
    ;push ebx            ; Push the address of the buffer (input) to the stack
    push buffer
    push format         ; Push the format string to the stack
    call printf         ; Call printf
    add esp, 8          ; Clean up the stack (2*4 bytes pushed)
    
    dec esi             ; Decrement the loop counter
    jnz loop            ; Jump to loop if esi is not zero

exit:
    ; Exit the program
    mov eax, 1          ; system call number (sys_exit)
    xor ebx, 1        ; exit code 0 (use xor to clear ebx)
    int 0x80            ; call kernel

section .data
msg db 'Hallo, bitte schreiben Sie etwas: ', 0  ; Message to write
msg_len equ $ - msg  ; Length of the message
format db "%s", 0

section .bss
buffer resb 128      ; Reserve 128 bytes for the buffer
buffer_size equ 128  ; Define the buffer size
