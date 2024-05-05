.data
#stale (x^2-6) / (x-2)
float_: .asciz "%f\n"
n1: .short 2
n2: .short 6
#do zmiany
#(b-a)/m = k
#a+(k/2)+(i*k)
a: .float 5
b: .float 10
m: .long  1000

.bss
.lcomm  k,8 #define place for double k
.lcomm  x,8 #define place for double x
.lcomm  res,8 #define place for double res
.lcomm  i,4 

.text
.global main
main:
#inicjalizcja
  finit
  sub $12, %esp
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
  fstpl (%esp)
  movl (%esp), %eax
  movl 4(%esp), %edx

#drukowanie
  push %edx
  push %eax
  push $float_
  call printf
  add $12, %esp




  addl $12, %esp
  mov $1, %eax
  mov $0, %ebx
  int $0x80
