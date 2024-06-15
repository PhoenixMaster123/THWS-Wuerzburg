section .text
global _start

_start:
mov eax,4
mov ebx,1
mov ecx, UserMSG
mov edx, prompt_len
int 0x80

; Read Input from User

mov eax, 3
mov ebx, 0
mov ecx, buffer
mov edx, 128
int 0x80

; Print User Input
mov eax, 4
mov ebx, 1
mov ecx, buffer
mov edx, 128
int 0x80



mov eax, 1
int 0x80


section .data
UserMSG DW "Please write your message: ", 0, 0xA ; 0xA -> newLine
prompt_len equ $ - UserMSG

section .bss
buffer resb 128