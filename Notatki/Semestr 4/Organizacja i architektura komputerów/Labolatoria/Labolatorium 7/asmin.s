.data
#stale (x^2-6) / (x-2)
n1: .int 2
n2: .int 6
#do zmiany
#(b-a)/m = k
#a+(k/2)+(i*k)

.bss
.lcomm  k,8
.lcomm  x,8
.lcomm  res,8
.lcomm  i,4 
.lcomm  a,8 
.lcomm  b,8 
.lcomm  m,4 

.text
.global calcIntegral
calcIntegral:
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
  add  $24, %esp
#calc

#inicjalizcja
  finit
  #fldcw 0x037F
  mov $0, %ecx #licznik
  movl $0, res
  movl m, %ebx
#krok
  flds b
  fsubs a
  fidivl m
  fstpl (k)
next:
#a+(k/2)+(i*k)=x
  fldl k
  fidivs n1
  fadds a
  fldl k
  movl %ecx, i
  fimull i
  faddp
  fstpl (x)
# liczenie wartosci w punkcie
  fldl x
  fisubs n1
  fldl x
  fmull x
  fisubs n2
  fdivp
  fmull k
  faddl res
  fstpl (res)

  cmp %ecx, %ebx
  je end
  inc %ecx
  jmp next
end:
#kopiowanie wyniku
  fldl res

#everything set as was at the beginning
  movl %ebp, %esp
  popl %ebp
  popl %ebx
  ret
