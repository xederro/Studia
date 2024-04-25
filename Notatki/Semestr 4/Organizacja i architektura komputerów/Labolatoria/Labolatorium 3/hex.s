STDOUT = 0x1
WRITE = 0x4
EXIT = 0x1
BREAK = 0x80

.global _start

.data
  pre:  .ascii "0x"
  values: .ascii "0123456789abcdef"
  post: .ascii "\n"

.text
  _start:
  /*wypisanie 0x*/
    mov $WRITE, %EAX
    mov $STDOUT, %EBX
    mov $pre, %ECX
    mov $2, %EDX
    int $BREAK

  /*Przygotowanie wartości*/
    mov $0x8, %EDX

    mov $-1 ,%ESI
    loop:
    mov %ESI, %EDI
    shl $4, %ESI
    shr $28, %EDI

    push %EDX

  /*wypisanie*/
    mov $WRITE, %EAX
    mov $STDOUT, %EBX
    lea values(%EDI, 1), %ECX
    mov $1, %EDX
    int $BREAK

  /*sprawdzenie czy wypisano wszystko*/
    pop %EDX
    dec %EDX

    cmp $0x0, %EDX
    jne loop

  /*wypisanie \n*/
    mov $WRITE, %EAX
    mov $STDOUT, %EBX
    mov $post, %ECX
    mov $1, %EDX
    int $BREAK
    
  /*zakonczenie*/
    mov $EXIT, %EAX
    int $BREAK
