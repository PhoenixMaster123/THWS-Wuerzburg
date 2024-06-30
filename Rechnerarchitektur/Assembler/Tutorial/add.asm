section .text
global  _start

_start:
mov eax, 1
mov ebx, 2
add eax, ebx
int 80h

mov al, 0b11111111 ; 0b -> the thing that follows is binary value
mov bl, 0b0001
add al, bl ; The value is 0x0 (0)
adc ah, 0  ; adc -> add carry bit from the privios instruction. That means ah + 0 + carry ah = 0x1 (1)
int 80h

; al | 1111 1111
; bl | 0000 0001
;----------------
; al | 0000 0000 ; -> the last carry bit go to eflag register

section .data

; eflag -> each bit represents specific flag and that flag gives us an information about the operation
;          that was just executed (add in this situation)
; PF -> parity flag for instance. Parity flag is a set, when the value that resulted from the operation 
; is an odd number (the pf is set to 1) and its sets to zero is even number
; IF -> interrupted flag -> typically set to one when we allow interrupts to be done on our system