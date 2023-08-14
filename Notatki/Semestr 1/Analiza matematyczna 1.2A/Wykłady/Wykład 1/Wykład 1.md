![W1_Analiza_21_Wstep](/Notatki/Semestr%201/Analiza%20matematyczna%201.2A/Wyk%C5%82ady/Wyk%C5%82ad%201/W1_Analiza_21_Wstep.pdf)

# Elementy Logiki Matematycznej


## Logika
$\wedge$ - i - iloczyn log - premienna
$\vee$ - lub - suma logiczna - przemienna
$\Rightarrow$ - jeżeli ..., to... - wynikowanie
$\Leftrightarrow$ - wtedy i tylko wtedy, gdy - iff
$\neg$ - nieprawda, że - zaprzeczenie


| $P$ | $Q$ | $P\wedge Q$ | $P\vee Q$ | $P\rightarrow Q$ | $P\leftrightarrow Q$ | $\neg P$ |
| --- | --- | ----------- | --------- | ---------------- | -------------------- | -------- |
| 1   |1|1|1|1|1|0|
| 1   |0|0|1|0|0|0|
| 0   |1|0|1|1|0|1|
| 0   |0|0|0|1|1|1|

## Kwantyfikatory

$\forall_{x\in A}$ - kwantyfikator ogólny
$\exists_{x\in A}$ - kwantyfikator szczegółowy
$\exists !_{x\in A}$ - kwantyfikator szczegółowy (dokłądnie jeden)

Przykład:
$\forall_{x\in A} x=2x$
$\exists_{x\in A} x= 2x$


## Elementy teorii zbiorów

$a\in A$, $a\not\in A$    
$\emptyset$ -zbiór pusty

A={$a_1$,$a_2$,$\cdots$,$a_n$,} - zbiór skończony
A={$x\in R : f(x)$} - A zawiera elementy spełniające warunek f(x)

$A\subset B$ - A zawiera się w B

- suma
- iloczyn
- róznica
- dopelnienie


## Suma i iloczyn

$A_1$,$A_2$,$A_3$,$\cdots$,$A_n$, będzie ciągiem zbiorów
- suma $K=\sum_{i = 1}^{n} A_i$, przyczym $x\in K \Leftrightarrow\exists i(1\leq x \leq n), x\in A_i$
- iloczyn $T=\prod_{i=1}^{n} A_i$, przyczym $x\in T \Leftrightarrow\forall i(1\leq x \leq n), x\in A_i$


## Iloczyn kartezjański

Iloczyn kartezjański zbiorów A,B jest zbiorem par uporządkowanych
$A\times B = {(x,y): x\in A \wedge y\in B}$

nie jest przemienny

Każdy podzbiór iloczyu kartezjańskiego nazywamy relacją.

A = {a,b,c}     $f: A -^{1-1}->B$  jak mają tyle samo to da się przypisać każdemu z a jeden, różny z b
B = {x,y,z}

N - naturalne
P - parzyste      $f: n -^{1-1}->2n$
$P\subset N$

liczba elementów $N=Z=Q \not= NW$

$\aleph_0$ - aleph 0 

[Ćwiczenia 1](/Notatki/Semestr%201/Analiza%20matematyczna%201.2A/%C4%86wiczenia/%C4%86wiczenia%201/%C4%86wiczenia%201.md)[Wykład 3](/Notatki/Semestr%202/Matematyka%20dyskretna/Wyk%C5%82ady/Wyk%C5%82ad%203/Wyk%C5%82ad%203.md)