;The AND instruction is used for supporting logical expressions by performing bitwise AND operation. 
;The bitwise AND operation returns 1, if the matching bits from both the operands are 1, 
;otherwise it returns 0. For example:

;             Operand1: 	0101
;             Operand2: 	0011
;         ----------------------------
; After AND -> Operand1:	0001

;The AND operation can be used for clearing one or more bits. 
;For example, say the BL register contains 0011 1010. 
;If you need to clear the high-order bits to zero, you AND it with 0FH.

;AND BL, 0FH   ; This sets BL to 0000 1010

section .text
   global _start            ;must be declared for using gcc
	
_start:
   mov ax, 8h              ;getting 8 in the ax 

   and ax, 1              ;and ax with 1 Performs a bitwise AND operation between the value 
                          ;in ax (which is 8) and 1.
                          ;Since 1 in binary is 00000001 and 8 in binary is 00001000, 
                          ;the result of and operation is 00000000.
                          ;This operation checks if the number is even or odd based on the 
                          ;least significant bit (LSB). If LSB is 1, number is odd; 
                          ;if 0, number is even.

   jz evnn                ; Jump to label evnn if the result of the AND operation is zero, 
                          ; that means ax = 00000000, otherwise if ax = 00000001 ->
   mov eax, 4             ;system call number (sys_write)
   mov ebx, 1             ;file descriptor (stdout)
   mov ecx, odd_msg       ;message to write
   mov edx, len2          ;length of message
   int 0x80               ;call kernel
   jmp outprog

; if jz = true ->
evnn:
   mov ah, 09h            ;ah = 09h sets up int 0x80 with a different function (sys_write).
   mov eax, 4             ;system call number (sys_write)
   mov ebx, 1             ;file descriptor (stdout)
   mov ecx, even_msg      ;message to write
   mov edx, len1          ;length of message
   int 0x80               ;call kernel

outprog:
   mov eax,1              ;system call number (sys_exit)
   int 0x80               ;call kernel

section .data
even_msg db 'Even Number!' ;message showing even number
len1 equ $ - even_msg 
   
odd_msg db 'Odd Number!'    ;message showing odd number
len2 equ $ - odd_msg