global main
extern printf

section .text
    print_eax:               ; Set up for calling _printf to print myVar's value
        push EAX             ; Pushes the value of EAX onto the stack
        push formatString    ; Pushes the string address onto the stack
        call printf          ; Calls the _printf function from the C library
        add ESP, 8           ; Cleans up the stack after the call to _printf
    ret                      ; return

    main:      	            ; The main entry point of the program
 
        MOV EAX, 4          ; EAX = 4
        IMUL EAX, 2         ; Multiplying EAX by 2 => EAX = EAX *2 => EAX = 4 * 2 = 8
        CALL print_eax      ; Prints the value of EAX
    ret                     ; Return from _main

section .data
    formatString db 'The product of 4 and 2 is %d.', 10, 0     ; Format string for _printf


; Comments

; MUL:

; MUL (Multiply) is used for unsigned multiplication. 
; It takes one operand (either an explicit operand or implicitly the accumulator register AX, EAX, RAX 
; depending on the operand size) and multiplies it by the other operand.

; IMUL

; IMUL (Integer Multiply) is used for signed multiplication. 
;It also takes one operand and multiplies it by the other operand, 
;but it considers the operands as signed integers.

; When to Use Which:

;Use MUL when: You want to perform unsigned multiplication 
;(e.g., multiplying two positive integers or handling operations where the sign doesn't matter).

;Use IMUL when: You need to perform signed multiplication, where the sign of the operands matters 
;(e.g., handling negative numbers, or ensuring correct results when dealing with signed integers).

; Signed and Unsigned:

;Signed Integers:
;Signed integers can represent both positive and negative numbers. They use a specific bit 
;(usually the most significant bit, known as the sign bit) to indicate the sign of the number:

;Positive numbers: Represented directly in binary form.
;Negative numbers: Typically represented using two's complement notation, where the sign bit is 1 and the remaining bits represent the magnitude of the number.
;For example, in an 8-bit signed integer:

;0110 0101 represents the number 101 (positive).
;1110 0101 represents the number -21 (negative).

;Unsigned Integers:
;Unsigned integers only represent non-negative numbers (zero and positive numbers). 
;They do not use a sign bit:

;All bits represent the magnitude of the number directly.
;The range of an unsigned integer is typically larger than that of a signed integer because the sign bit in signed integers reduces the number of bits available for magnitude representation.
;For example, in an 8-bit unsigned integer:

;0110 0101 represents the number 101 (same as in signed).
;1110 0101 represents the number 229 (interpreted as a positive number, not -21 as in signed).

;Choosing Between Signed and Unsigned:
;Signed integers are used when you need to represent both positive and negative numbers or when 
;arithmetic operations require consideration of signs.

;Unsigned integers are used when you only need to represent 
;non-negative values or when you want to utilize the full range of bits for magnitude representation.