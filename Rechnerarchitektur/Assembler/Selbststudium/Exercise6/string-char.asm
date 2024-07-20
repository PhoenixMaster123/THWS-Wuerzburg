section .text
    global main

main:
    ; Initialize pointers and indices
    mov esi, string          ; Point ESI to the start of the string

loop:
    ; Load the next character
    
    movzx eax, byte [esi]   ; Load the next character into EAX (zero-extended)
    test  eax, eax           ; Test if it's the null terminator
    jz    end_program        ; If zero, end the program
    
    ; Print the character
    mov eax, 4               ; sys_write system call number
    mov ebx, 1               ; file descriptor (stdout)
    mov ecx, esi             ; pointer to the character to print
    mov edx, 1               ; number of bytes to write
    int 0x80                 ; invoke system call

    ; Print a newline
    mov eax, 4               ; sys_write system call number
    mov ebx, 1               ; file descriptor (stdout)
    mov ecx, newlineMsg      ; pointer to the newline message
    mov edx, newlineLen      ; length of the newline message
    int 0x80                 ; invoke system call

    ; Move to the next character
    inc esi
    jmp loop                 ; Repeat the loop

end_program:
    ; Exit the program
    mov eax, 1               ; sys_exit system call number
    xor ebx, ebx             ; Return code 0
    int 0x80                 ; invoke system call

section .data
    string db "Hello, World!", 0  ; The string to print, null-terminated
    newlineMsg db 0xA            ; Newline message (Line Feed only)
    newlineLen equ $ - newlineMsg ; Length of the newline message
