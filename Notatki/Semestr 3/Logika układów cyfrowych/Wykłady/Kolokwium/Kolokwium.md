# Algebra Boolea

- alternatywa logiczna "lub": $a+b$ 
- iloczyn logiczny "i": $a\cdot b$ 
- przemienność: $a+b=b+a$
- rozdzielność:
	- $a\cdot(b+c) = a\cdot b+a\cdot c$
	- $a+(b\cdot c)=(a+b)\cdot(a+c)$
- elementy neutralne:
	- $a+0=a$
	- $a\cdot0=0$
	- $a\cdot1=a$
	- $a+1=1$
- pochłanianie
	- $a+\not a = 1$
	- $a\cdot\not a = 0$
- łączność
	- $a+(b+c)=(a+b)+c$
	- $(a\cdot b)\cdot d=a\cdot(b\cdot c)$
- zasada pochłaniania
	- $a+a\cdot b=a$
	- $a(a+b)=a$
	- $a+\not a=1$
	- $a\cdot a=a$
- Prawa de Morgana
	- $\not(a\cdot b)=\not a+\not b$
	- $\not(a+b)=\not a\cdot\not b$
	- $\not(\not a)=a$

# Opis funkcji boolowskiej
Postać kanoniczna wzgl. sumy:
	$f(x_0, x_1,\cdots,x_{n-1})$
	$f(x_0, x_1,\cdots,x_{n-1})=x_0f_1(x_1,x_2,\cdots,x_{n-1})+\not x_0f_2(x_1,x_2,\cdots,x_{n-1})$
	Możemy tak rozwijać dalej, i uzyskać $2^n$ składników
	$f(x_0, x_1,\cdots,x_{n-1})=x_0x_1\cdots x_{n-1}f(1,1,\cdots,1)+x_0x_1\cdots\not x_{n-1}f(1,1,\cdots,0)+\cdots$
Postać kanoniczna wzgl. iloczynu:
	$f(x_0, x_1,\cdots,x_{n-1})$
	$f(x_0, x_1,\cdots,x_{n-1})=(x_0+f_1(x_1,x_2,\cdots,x_{n-1}))\cdot(\not x_0+f_2(x_1,x_2,\cdots,x_{n-1}))$
	Możemy tak rozwijać dalej, i uzyskać $2^n$ składników
	$f(x_0, x_1,\cdots,x_{n-1})=(x_0+x_1+\cdots+x_{n-1}+f(1,1,\cdots,1))\cdot(x_0+x_1+\cdots+\not x_{n-1}+f(1,1,\cdots,0))\cdots$

Możemy to zapisać jako:
$f(x_1,x_2,x_3)=\sum(011,101,110,111)= \not x_1x_2x_3+x_1\not x_2x_3+x_1x_2\not x_3+x_1x_2x_3$
lub
$f(x_1,x_2,x_3)=\prod(011,101,110,111)= (\not x_1+x_2+x_3)(x_1+\not x_2+x_3)(x_1+x_2+\not x_3)(x_1+x_2+x_3)$

# System funkcjonalnie pełny
Jeżeli możemy udowodnić, że można elementami systemu wykonać NOT, AND, OR to wtedy wiemy, że jest on pełny

# Minimalizacja
Sklejanie jedynek:
$a\not x+ ax=a \rightarrow a(\not x+x)=a$
Sklejanie zer:
$(a+\not x)(a+x)=a \rightarrow a+(\not xx)=a$

- n zmiennych
- $2^n$ elementów
- grupy mogą mieć $2^k$ gdzie $0$




![](/Notatki/Semestr%203/Logika%20układów%20cyfrowych/Wykłady/Kolokwium/Drawing%202024-02-01%2009.18.03.excalidraw.svg)![](/Notatki/Semestr%203/Logika%20układów%20cyfrowych/Wykłady/Kolokwium/e.circ)

