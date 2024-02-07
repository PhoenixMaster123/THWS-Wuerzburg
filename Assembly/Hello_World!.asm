section .data
    helloMsg db 'Hello, World!', 0

section .text
    global _start

_start:
    ; Initialize counter
    mov ecx, 10        ; Set loop counter to 10

loop_start:
    ; Write 'Hello, World!' to stdout
    mov eax, 4          ; syscall number for sys_write
    mov ebx, 1          ; file descriptor 1 (stdout)
    mov edx, 13         ; length of the message
    mov esi, helloMsg   ; pointer to the message
    mov ecx, edx        ; counter for number of characters to print
    mov eax, 4          ; syscall number for sys_write
    int 0x80            ; invoke syscall

    ; Decrement counter
    dec ecx

    ; Check if loop should continue
    jnz loop_start

    ; Exit the program
    mov eax, 1          ; syscall number for sys_exit
    xor ebx, ebx        ; exit code 0
    int 0x80            ; invoke syscall

