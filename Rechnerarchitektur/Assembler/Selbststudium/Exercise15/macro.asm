
section .text
    global main
    extern printf
    ; Define the LOG_ERROR macro
    ;%macro LOG_ERROR 2  ; 2 means that this macro expects 2 arguments
      ;  mov eax, 4         ; sys_write
     ;   mov ebx, 1         ; file descriptor 1 (stdout)
       ; mov ecx, %1        ; message to print %1 -> first argument
       ; mov edx, %2        ; message length   %2 -> first argument
       ; int 0x80           ; call kernel
    ;%endmacro
    %macro LOG_ERROR 1
    push %1
    push formatError
    call printf
    add esp, 8
    %endmacro

main:
    ; Use the LOG_ERROR macro
    LOG_ERROR errorMessage      ; string, stringLen ; argument1, argument2

    ; Exit the program
    mov eax, 1            ; sys_exit
    xor ebx, ebx          ; exit code 0
    int 0x80              ; call kernel to exit

    section .data
   ; string db 'Hello World!', 10, 0
   ; stringLen equ $ - string
    formatError db 'Error: %s', 10, 0  ; Format string for error messages
    errorMessage db 'An unexpected error occurred!', 0


; Note! -> Macro need to be defined before main

;Syntax ; %macro name arguments
           ;// Logic
        ;  %endmacro
