.global getClock
getClock:
  mov 4(%ESP), %ESI /* do esi wpisujemy int z c*/
  push %EBX
  cmp $1, %ESI
  je skip
  mov $0, %EAX
  CPUID
skip:
  RDTSCP
  pop %EBX
  ret
