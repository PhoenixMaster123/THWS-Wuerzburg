section .text

global main
extern printf

main:


;mov eax, [num1]
;mov ebx, [num2]
; or
mov eax, 7
mov ebx, 15

call add_numbers

push eax
push formatSum
call printf
add esp, 8

mov eax, 7
mov ebx, 15

call sub_numbers

push eax
push formatSub
call printf
add esp, 8

mov eax, 1
int 0x80

add_numbers:
add eax, ebx
ret

sub_numbers:
sub eax, ebx
ret


section .data
num1 dd 10
num2 dd 5
formatSum db 'The sum is: %d', 10, 0
formatSub db 'The sub is: %d', 10, 0