section .text
global _start    ;must be declared for using gcc
	
_start:             ;tell linker entry point

   mov	al, '3'    ; Move character '3' into AL (8-bit register)
   sub	al, '0'    ; Subtract ASCII value of '0' from AL ('3' - '0' = 3)
	
   mov	bl, '2'    ; Move character '2' into BL (8-bit register)
   sub	bl, '0'    ; Subtract ASCII value of '0' from BL ('2' - '0' = 2)

   mul	bl         ; Multiply AL by BL (3 * 2 = 6)
   add	al, '0'    ; Convert result in AL to ASCII ('6' = 6 + '0')

   mov	[res], al  ; Store the result (character '6') in memory at location res
   
   mov	ecx, msg   ; Load address of msg (message) into ECX
   mov	edx, len   ; Load length of msg into EDX
   mov	ebx, 1     ; File descriptor (stdout)
   mov	eax, 4     ; System call number (sys_write)
   int	0x80      ; Call kernel to write msg to stdout
	
   mov	ecx, res   ; Load address of res (result) into ECX
   mov	edx, 1     ; Length of result (1 byte)
   mov	ebx, 1     ; File descriptor (stdout)
   mov	eax, 4     ; System call number (sys_write)
   int	0x80      ; Call kernel to write result to stdout
	
   mov	eax, 1     ; System call number (sys_exit)
   int	0x80      ; Call kernel to exit program

section .data
msg db "The result is: ", 0xA, 0xD  ; Define message with newline characters
len equ $ - msg                     ; Calculate length of msg

section .bss
res resb 1  ; Reserve 1 byte for storing the result
