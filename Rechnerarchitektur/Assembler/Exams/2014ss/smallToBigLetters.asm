section .data
msg db "Type your word: ", 0
mylen equ $ - msg

section .bss
buffer resb 10
length_size resd 1  ; store the length of the input

section .text
global main

main:
    ; Write message
    mov eax, 4         ; system call number (sys_write)
    mov ebx, 1         ; file descriptor (stdout)
    mov ecx, msg       ; message to write
    mov edx, mylen     ; message length
    int 0x80           ; call kernel

    ; Read input
    mov eax, 3         ; system call number (sys_read)
    mov ebx, 0         ; read from standard input
    mov ecx, buffer    ; address to pass to
    mov edx, 10        ; max. input length
    int 0x80           ; call kernel

    ; Store the length of the input
    mov [length_size], eax

    ; Convert characters to lowercase
    mov esi, 0

loop:
    cmp esi, [length_size] ; check if we have processed the entire input length
    jge end_loop           ; if esi >= input_length, end loop

    mov al, byte [buffer + esi] ; read character from buffer
    cmp al, 0           ; check for null terminator (end of input)
    je end_loop         ; if end of input, end loop

    cmp al, 'A'         ; check if character is uppercase
    jb next_char        ; if less than 'A', skip conversion
    cmp al, 'Z'         ; check if character is greater than 'Z'
    ja next_char        ; if greater than 'Z', skip conversion

    add al, 32          ; convert to lowercase

next_char:
    mov byte [buffer + esi], al ; write character back to buffer
    inc esi
    jmp loop

end_loop:
    ; Write the modified buffer
    mov eax, 4         ; system call number (sys_write)
    mov ebx, 1         ; file descriptor (stdout)
    mov ecx, buffer    ; address of buffer
    mov edx, [length_size] ; number of bytes to write
    int 0x80           ; call kernel

    ; Exit the program
    mov eax, 1         ; system call number (sys_exit)
    xor ebx, ebx       ; exit code 0
    int 0x80           ; call kernel
