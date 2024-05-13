.data
#stale (x^2-6) / (x-2)
n1: .int 2
n2: .int 6
integers:   .long   0, 1, 2, 3
#(b-a)/m = k
#a+(k/2)+(i*k)

.bss
.lcomm  res,8
.lcomm  i,4 
.lcomm  a,8 
.lcomm  b,8 
.lcomm  m,4 

.text
.global calcIntegralXMM
calcIntegralXMM:
# recive data
  pushl %ebx
  pushl %ebp
  movl %esp, %ebp
  sub  $24, %esp
  movl 12(%ebp), %eax
  mov %eax, (a)
  movl 16(%ebp), %eax
  mov %eax, (b)
  movl 20(%ebp), %eax
  mov %eax, (m)
#  shr $2, %eax
  add  $24, %esp
#calc

#inicjalizcja
  mov $0, %ecx #licznik
  movl $0, res
  movl m, %ebx
#krok
  movss (b), %xmm0
  movss (a), %xmm7
  subss %xmm7, %xmm0
  cvtsi2ss m, %xmm1
  divss %xmm1, %xmm0
  movaps %xmm0, %xmm6 #k
  cvtsi2ss n1, %xmm5
  cvtsi2ss n2, %xmm3
  divss %xmm5, %xmm0
  addss %xmm0, %xmm7 #a+(k/2)
  shufps $0x00, %xmm3, %xmm3
  shufps $0x00, %xmm5, %xmm5
  shufps $0x00, %xmm6, %xmm6
  shufps $0x00, %xmm7, %xmm7
nextXMM:
#(a+(k/2))+(i*k)=x
  movdqu (integers), %xmm1
  cvtdq2ps %xmm1, %xmm1
  movaps %xmm6, %xmm0
  cvtsi2ss %ecx, %xmm4
  shufps $0x00, %xmm4, %xmm4
  addps %xmm1, %xmm4 #i+0, i+1, i+2, i+3
  mulps %xmm4, %xmm0 #k*i
  addps %xmm7, %xmm0 #x
# liczenie wartosci w punkcie
  movaps %xmm0, %xmm1
  subps %xmm5, %xmm1
  mulps %xmm0, %xmm0
  subps %xmm3, %xmm0
  divps %xmm1, %xmm0
  mulps %xmm6, %xmm0
  addps %xmm0, %xmm2

  cmp %ecx, %ebx
  jle endXMM
  add $4, %ecx
  jmp nextXMM
endXMM:
#zwracaie wyniku
  haddps %xmm2, %xmm2
  haddps %xmm2, %xmm2
  movss %xmm2, (res)
  flds res

#everything set as was at the beginning
  movl %ebp, %esp
  popl %ebp
  popl %ebx
  ret
