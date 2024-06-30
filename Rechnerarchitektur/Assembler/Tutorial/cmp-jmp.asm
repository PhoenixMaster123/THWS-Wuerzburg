section .text
global _start

_start:

mov eax, 3
mov ebx, 2
cmp eax, ebx 
jl lesser  ; je (jump if equals) jne (jump if not equals) jg (jump if greater) jge (>=) jl (<) jle (<=) jz (jump if zero) jnz (jump if not zero)
jmp end ; always execute no matter what

lesser:
mov eax, 1
int 80h

end:
mov eax, 1
mov 80h

; Note:
; 3 - 2 = 1 (we care if is positive, negative or zero) 
;That means = positive eax > ebx| negative eax < ebx | zero eax = ebx
                                                                      

section .data