extern printf
extern scanf
section .text
global main


main:

mov eax, 4
mov ebx, 1
mov ecx, startMsg
mov edx, startMsgLength
int 0x80

mov eax, 4
mov ebx, 1
mov ecx, sumMsg
mov edx, sumMsgLength
int 0x80

mov eax, 4
mov ebx, 1
mov ecx, subMsg
mov edx, subMsgLength
int 0x80

mov eax, 4
mov ebx, 1
mov ecx, mulMsg
mov edx, mulMsgLength
int 0x80

mov eax, 4
mov ebx, 1
mov ecx, divMsg
mov edx, divMsgLength
int 0x80

push numberCmp
push formatNumber
call scanf
add esp, 8

mov eax, 4
mov ebx, 1
mov ecx, num1Msg
mov edx, num1MsgLength
int 0x80

push number1
push formatNumber
call scanf
add esp, 8

mov eax, 4
mov ebx, 1
mov ecx, num2Msg
mov edx, num2MsgLength
int 0x80

push number2
push formatNumber
call scanf
add esp, 8

mov eax, [number1]
mov ebx, [number2]


mov ecx, [numberCmp]
cmp ecx, 1
je sum
cmp ecx, 2 
je sub
cmp ecx, 3
je Multiply
cmp ecx, 4
je Divide
jmp wrongOperation

sum:
add eax, ebx

push eax
push formatString1
call printf
add esp, 8
jmp exit

sub:
sub eax, ebx

push eax
push formatString2
call printf
add esp, 8
jmp exit


Multiply:
imul eax, ebx
push eax
push formatString3
call printf
add esp, 8
jmp exit

Divide:

div ebx
push eax
push formatString4
call printf
add esp, 8
jmp exit

wrongOperation:
mov eax, 4
mov ebx, 1
mov ecx, wrongOperationMsg
mov edx, wrongOperationMsgLength
int 0x80
jmp exit

exit:
mov eax, 1
mov ebx, 0
int 80h


section .data
formatString1 db 'The sum is: %d', 10, 0
formatString2 db 'The sub is: %d', 10, 0
formatString3 db 'The mul is: %d', 10, 0
formatString4 db 'The div is: %d', 10, 0

startMsg db "Welcome to this calculator the provided options are: ", 0xA
startMsgLength equ $ - startMsg

wrongOperationMsg db "The Operation that you provide was wrong!", 0
wrongOperationMsgLength equ $ - wrongOperationMsg

sumMsg db "1 -> Sum", 0xA
sumMsgLength equ $ - sumMsg

subMsg db "2 -> Sub", 0xA
subMsgLength equ $ - subMsg


mulMsg db "3 -> Mul", 0xA
mulMsgLength equ $ - mulMsg


divMsg db "4 -> Div", 0xA
divMsgLength equ $ - divMsg

num1Msg db "Type the first number:", 0xA
num1MsgLength equ $ - num1Msg

num2Msg db "Type the second number:", 0xA
num2MsgLength equ $ - num2Msg

numberCmp dd 0
number1 dd 0
number2 dd 0
formatNumber db '%d'
