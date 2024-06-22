global main

section .data
    formatString db '0x000000FF XOR 0x000000FF is %d.', 10   ; Format string for output (note: no null terminator needed)
    formatLength equ $ - formatString   ; Calculate length of formatString

section .bss
    outputBuffer resb 64  ; Reserve a buffer for the output

section .text

main:
    mov eax, 0x000000FF     ; Load 0xFF into RAX
    xor eax, 0x000000FF     ; XOR RAX with 0xFF

    ; Prepare parameters for write syscall
    mov rdi, 1              ; File descriptor 1 (stdout)
    lea esi, [formatString] ; Load address of formatString into RSI
    mov edx, formatLength   ; Length of the message to print
    mov eax, 1              ; syscall number for sys_write
    syscall                 ; Call syscall to write to stdout

    ; Exit the program
    mov eax, 60             ; syscall number for exit
    xor edi, edi            ; Exit status 0
    syscall                 ; Call syscall to exit

    ;Toggle the 2nd and 4th bits of ax
    ;mov ax, 10    ; ax = 00001010 in binary (which is 10 in decimal)
    ;xor ax, 0x14  ; xor with 00010100 in binary (which is 20 in decimal)
    ;Now ax = 00011110 in binary (which is 30 in decimal)


;///////////////////////////////////////////////////// The Professors Code //////////////
   ; global main
;extern printf

;Note -> if you use 64bit system you need to use not EAX(32bit) but RAX(64bit)

;section .text

   ; print_eax:                  ; Set up for calling _printf to print EAX's value
    ;    push EAX                ; Pushes the value of EAX onto the stack
    ;    push formatString       ; Pushes the string address onto the stack
    ;    call printf            ; Calls the _printf function from the C library  ; Cleans up the stack after the call to _printf
    ;    add ESP, 8              ; Corrects the stack pointer
   ; ret

   ; main:
      ;  MOV EAX, 0x000000FF     ; Using XOR to toggle and reset bits, EAX starts as: 00..00 11111111
      ;  XOR EAX, 0x000000FF     ; Toggling all bits off results in: 00000000
 
     ;  CALL print_eax          ; Prints the value of EAX, Calls the procedure to print EAX's value
  ;  ret                         ; Returns from _main

;section .data
  ;  formatString db '0x000000FF XOR 0x000000FF is %d.', 10, 0   ; Format string for printf

