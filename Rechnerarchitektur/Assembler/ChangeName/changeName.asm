section .text
   global _start     ;must be declared for linker (ld)
_start:             ;tell linker entry point
	
   ;writing the name 'Zara Ali'
   mov	edx, len    ;message length or I can put 9
   mov	ecx, name   ;message to write
   mov	ebx, 1      ;file descriptor (stdout)
   mov	eax, 4      ;system call number (sys_write)
   int	80h         ;call kernel
   
   mov dword[name],  dword "Nuha"    ; Changed the name to Nuha Ali dword = 4 bytes | If we make mov dword[name + 7], dword Nuha, the result will be Zara AlNuh
	
   ;writing the name 'Nuha Ali'
   mov	edx, len     ;message length
   mov	ecx, name    ;message to write
   mov	ebx, 1       ;file descriptor (stdout)
   mov	eax, 4       ;system call number (sys_write)
   int	80h          ;call kernel
	
   mov	eax,1       ;system call number (sys_exit)
   mov  ebx,0
   int	80h         ;call kernel

section .data
name db "Zara Ali ", 0xa ; define name + newLine (length = 10)
len equ $ - name ; length of name
