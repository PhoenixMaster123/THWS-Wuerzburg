section .text
global _start

_start:
mov eax, 0 ; counter
mov cl, 0  ; track of the sum or ecx but the numbers are small

loop:
mov bl, [list + eax]
add cl, bl
inc eax
cmp eax, 4
je end
jmp loop

end:
mov eax, 1
mov ebx, 1
int 80h


section .data
list db 1,2,3,4