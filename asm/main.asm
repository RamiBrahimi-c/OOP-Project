section .data
    newline db 10  ; ASCII code for newline
    temp db 0
section .bss
    ; No uninitialized data needed here

section .text
    global _start

_start:
    ; rcx holds argc (argument count)
    pop rcx         ; Pop the argument count from the stack into rcx

    ; rsi points to argv (argument vector)
    mov rsi, rsp    ; Move the stack pointer (which points to argv) into rsi

print_args:
    ; Check if there are no more arguments
    cmp rcx , 0
    jz exit         ; If argc == 0, exit
    dec rcx         ; Decrement argc
    mov [temp] , rcx
    ; Print the current argument
    pop rdi         ; Pop the next argument (pointer to string) into rdi
    call print_string

    ; Print a newline
    mov rdi, newline
    call print_string

    mov rcx , [temp]
    ; Repeat for the next argument
    jmp print_args

print_string:
    ; Calculate the length of the string
    mov rdx, 0      ; Initialize length counter
    mov rax, rdi    ; Copy string pointer to rax
count_length:
    cmp byte [rax], 0
    je print        ; If null terminator, stop counting
    inc rax         ; Move to the next character
    inc rdx         ; Increment length counter
    jmp count_length

print:
    ; Write the string to stdout
    mov rax, 1      ; syscall: write
    mov rsi , rdi
    mov rdi, 1      ; file descriptor: stdout
    syscall
    ret

exit:
    ; Exit the program
    mov rax, 60     ; syscall: exit
    xor rdi, rdi    ; exit code: 0
    syscall