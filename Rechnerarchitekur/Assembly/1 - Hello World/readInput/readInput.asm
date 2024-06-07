section .data                               ;Data segment
    userMsg db 'Please enter a number: '    ;Ask the user to enter a number
    lenUserMsg equ $-userMsg                ;The length of the message
    dispMsg db 'You have entered: '         ;next message
    lenDispMsg equ $-dispMsg                ;The length of next message

section .bss                                ;Uninitialized data
    num resb 5
    
section .text                               ;Code Segment
    global main
    
    main:        

    ;User prompt:
    mov eax, 4
    mov ebx, 1
    mov ecx, userMsg
    mov edx, lenUserMsg
    int 80h                                  
    
    ;Read and store the user input:
    mov eax, 3
    mov ebx, 2
    mov ecx, num
    mov edx, 6 ;5 bytes (numeric, 1 for sign) of that information ; if i change the number I can read and print more numbers
    int 80h     
    
    ;Output the message 'The entered number is: 
     mov eax, 4
     mov ebx, 1
     mov ecx, dispMsg
     mov edx, lenDispMsg
     int 80h
     
     ;Output the number entered:
     mov eax, 4
     mov ebx, 1
     mov ecx, num
     mov edx, 6
     int 80h
     
     ;Exit code
     mov eax, 1
     mov ebx, 0
     int 80h