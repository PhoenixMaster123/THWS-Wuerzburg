global main
extern printf

section .text
main:
    mov EAX, array              ; Load the address of the array into EAX
    mov EBX, 2                  ; Load the value 2 into EBX (EBX = 2)

    lea edx, [EAX + 4 * EBX + 4]; Calculate address EAX + 4 * EBX + 4 (no dereference)
                                ; EDX now holds the address of the third element (index 2 + 1)

    add dword [EDX], 10         ; Add 10 to the value at the address in EDX (keine Deferenzierung, only the operation (4 * 2 + 4 = 12))
                                ; array[3] = 40 + 10 = 50

    mov EAX, [EDX]              ; Load the updated value (50) into EAX
    mov [result], EAX           ; Store this value in the result

    push dword [result] ;(dword = 32 bit) Push the result value onto the stack (We need always type specifier schreiben stack = 16bit or 32bit)
    push formatString           ; Push the format string onto the stack
    call printf                 ; Call printf function

    add esp, 8                  ; Clean up the stack (remove pushed arguments)
                                ; We can do it also with pop (pop eax, pop ebx -> Aufwand)

    ret                         ; Return from the main function

section .data
formatString db 'The result is %d.', 10, 0

array dd 10, 20, 30, 40, 50 ; Arrays of 5 integers, jeweils dword (4 Byte) insgesamt 5 * 4 = 20 Byte allokiert

result dd 0

;array[0] is at BASE
;array[1] is at BASE + 4
;array[2] is at BASE + 8
;array[3] is at BASE + 12
;array[4] is at BASE + 16