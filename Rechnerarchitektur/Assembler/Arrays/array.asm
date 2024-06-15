section .text
global _start

_start:

    mov edx, 9
    mov ecx, arr
    mov ebx, 1
    mov eax, 4
    int 0x80

    mov eax, 1
    int 0x80 

section .data
arr times 9 DB '*'

;eax: Accumulator register, used for arithmetic operations and to store the return value of system calls.
;ebx: Base register, often used to hold the base address of data or the file descriptor for system calls.
;ecx: Counter register, used for loops and string operations, or as a pointer in system calls.
;edx: Data register, used for I/O operations or as a secondary accumulator in arithmetic.

;eax: System call number.
;ebx: First argument (e.g., file descriptor, pointer to data).
;ecx: Second argument (e.g., pointer to buffer).
;edx: Third argument (e.g., size of buffer).

;Common System Calls

   ; sys_write (System Call Number: 4)
       ; eax: 4 (system call number for sys_write)
       ; ebx: File descriptor (e.g., 1 for stdout, 2 for stderr)
       ; ecx: Pointer to the buffer to be written
       ; edx: Number of bytes to write

   ; sys_read (System Call Number: 3)
       ; eax: 3 (system call number for sys_read)
       ; ebx: File descriptor
       ; ecx: Pointer to the buffer to store the read data
       ; edx: Number of bytes to read

  ;  sys_exit (System Call Number: 1)
     ;   eax: 1 (system call number for sys_exit)
     ;   ebx: Exit status code

    ; For the sys_write system call:

    ;eax: Should be 4 (the system call number for sys_write).
    ;ebx: Should be the file descriptor (e.g., 1 for stdout).
    ;ecx: Should be the pointer to the buffer (the data to write).
    ;edx: Should be the length of the data to write.