SYS_EXIT equ 1
SYS_READ equ 3
SYS_WRITE equ 4
STDIN equ 0
STDOUT equ 1

section .text
global _start

_start:

; Msg1 -> Enter a digit:

mov eax, 4        ; sys_write
mov ebx, 1        ; stdout
mov ecx, msg1     ; pointer
mov edx, len1     ; length msg1
int 0x80          ; interrupt

; Read first number

mov eax, 3        ; sys_read
mov ebx, 0        ; stdin (STDIN = Console)
mov ecx, num1     ; pointer
mov edx, 2        ; size
int 0x80          ; interrupt

; Msg2 -> Enter a second digit:

mov eax, 4        ; sys_write
mov ebx, 1        ; stdout
mov ecx, msg2     ; pointer (msg2 Enter a second digit)
mov edx, len2     ; length msg1
int 0x80          ; interrupt

; Read second number

mov eax, 3        ; sys_read
mov ebx, 0        ; stdin
mov ecx, num2     ; pointer
mov edx, 2        ; size  2 -> digit + enter (2 Zeichnen)
int 0x80          ; interrupt

; Msg3 -> The sum is:

mov eax, 4         ; sys_write
mov ebx, 1         ; stdout
mov ecx, msg3      ; pointer
mov edx, len3      ; length msg1
int 0x80           ; interrupt

; moving the first number to eax register and second number to ebx
; and subtracting ascii '0' to convert it into a decimal number

mov eax, [num1]
sub eax, '0'

mov ebx, [num2] ; one charachter in ebx
sub ebx, '0' ; convert ASCII to binary

;add eax and ebx
add eax, ebx
;add '0' to to convert the sum from decimal to ASCII 
add eax, '0'

; storing the sum in memory location res
mov [res], eax

; Print the result
mov eax, 4
mov ebx, 1
mov ecx, res
mov edx, 1
int 0x80

; Exit:

mov eax, 1
mov ebx, 0
int 0x80

section .data
msg1 db "Enter a digit: " , 0xA, 0xD
len1 equ $ - msg1

msg2 db "Enter a second digit: " , 0xA, 0xD
len2 equ $ - msg2

msg3 db "The sum is: "
len3 equ $ - msg3

segment .bss
num1 resb 2 ; (Resb = reserve a Byte)
num2 resb 2
res  resb 1 ; (one byte allociert)

; Example -> 2 + 5 = 7
; Example -> g + 2 = k