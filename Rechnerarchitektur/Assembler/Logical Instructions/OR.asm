;The OR instruction is used for supporting logical expression by performing bitwise OR operation. 
;The bitwise OR operator returns 1, if the matching bits from either or both operands are one. 
;It returns 0, if both the bits are zero.

;For example:

;             Operand1:     0101
;             Operand2:     0011
;       ----------------------------
;  After OR -> Operand1:    0111

;The OR operation can be used for setting one or more bits. 
;For example, let us assume the AL register contains 0011 1010, 
;you need to set the four low-order bits, you can OR it with a value 0000 1111, i.e., FH.

;OR BL, 0FH                   ; This sets BL to  0011 1111


section .text
   global _start            ;must be declared for using gcc
	
_start:
   mov    al, 5             ;getting 5 in the al
   mov    bl, 3             ;getting 3 in the bl

   or     al, bl            ;or al and bl registers, result should be 7
   ; Explanation:

  ;mov al, 5  ; al = 00000101 (binary)
  ;mov bl, 3  ; bl = 00000011 (binary)

  ;or al, bl  ; al = al | bl

  ; When you perform or al, bl, it combines the bits of al and bl:


   add    al, byte '0'      ;converting decimal to ascii
	
   mov    [result],  al
   mov    eax, 4
   mov    ebx, 1
   mov    ecx, result
   mov    edx, 1 
   int    0x80
    
outprog:
   mov    eax,1             ;system call number (sys_exit)
   int    0x80              ;call kernel
	
section .bss
result resb 1