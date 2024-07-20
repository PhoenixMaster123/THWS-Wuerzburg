section .text
global main
extern printf

; Exercise -> find if the charachter is in this string and print the position

main:
    ; Initialize the search
    mov ecx, stringLen       ; Length of the string
    mov edi, string          ; Pointer to the string
    mov al, byte [char]      ; Character to search for

    ; Save the starting position of the string
    mov esi, edi

    ; Search for the character in the string
    repne scasb              ; Repeat until the character is found or ECX becomes zero

    ; Check if the character was found
    jecxz not_found          ; If ECX is zero, the character was not found

    ; Calculate the position (index) of the found character
    sub edi, esi             ; Get the number of bytes scanned
    dec edi                  ; Convert to zero-based index

    ; Print the success message with the position
    push edi                 ; Push the position onto the stack
    push msgFoundFormat
    call printf
    add esp, 8               ; Clean up the stack (2 pushes = 8 bytes)
    jmp exit                 ; Jump to exit

not_found:
    ; Print not found message
    push msgNotFoundFormat
    call printf
    add esp, 4               ; Clean up the stack (1 push = 4 bytes)
    jmp exit

exit:
    ; Exit the program
    mov eax, 1               ; System call number (sys_exit)
    xor ebx, ebx             ; Exit code 0
    int 0x80                 ; Call kernel

section .data
string db 'Hello, World!', 0
stringLen equ $ - string
char db 'y'
msgFoundFormat db 'The character was found at position %d', 10, 0
msgNotFoundFormat db 'The character was not found', 10, 0
