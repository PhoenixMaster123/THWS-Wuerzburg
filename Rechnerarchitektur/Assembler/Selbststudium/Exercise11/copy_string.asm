section .text
global main
extern printf

main:
    ; Copy the string from source to destination
    mov ecx, len1          ; length of source string
    mov esi, source        ; source string
    mov edi, destination   ; destination buffer

    ;inc edi // like that I start from second position
    ;inc edi
    rep movsb              ; repeat move string byte (copies ECX bytes from ESI to EDI)

    ; Reset ESI and EDI to compare the strings
    mov ecx, len1          ; length of the strings to compare
    mov esi, source        ; source string
    mov edi, destination   ; destination buffer

    repe cmpsb             ; repeat compare string byte (compares ECX bytes of ESI and EDI)

    ; Check the result of the comparison
    jne copy_failed        ; jump if strings are not equal

copy_success:
    ; Print "Copy and comparison successful"
    push message_success
    call printf
    add esp, 4
    jmp end

copy_failed:
    ; Print "Copy and comparison failed"
    push message_failed
    call printf
    add esp, 4

end:
    ; Exit program
    mov eax, 1             ; syscall number for sys_exit
    xor ebx, ebx           ; exit code 0
    int 0x80               ; call kernel

section .data
source db 'Hello World', 0 ; source string
len1 equ $ - source        ; length of source string
destination db '0000000000000', 0 ; destination buffer, initialized with zeroes and null-terminated

message_success db 'Copy and comparison successful', 10, 0 ; success message
message_failed db 'Copy and comparison failed', 10, 0 ; failure message
