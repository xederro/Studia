.global getClock
getClock:
  push %ESI
  mov 4(%ESP), %ESI /* do esi wpisujemy int z c*/
  push %EBX
  cmp $1, %ESI
  je one
  jne zero
 
zero:
  mov $0, %EAX
  CPUID
  RDTSC
  jmp end


one:
  RDTSCP
  push %EAX
  push %EDX
  mov $0, %EAX
  CPUID
  pop %EDX
  pop %EAX


end:
  pop %EBX
  pop %ESI
  ret
  