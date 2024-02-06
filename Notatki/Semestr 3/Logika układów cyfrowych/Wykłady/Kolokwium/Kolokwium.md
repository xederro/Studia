# TTL - Transistor-Transistor logic
0 -> 0-0.8V
1 -> 2.4-5V
czas propagacji: 1.5-3ms
obciążalność 10
# Algebra Boole'a
- **alternatywa logiczna "lub":** $a+b$ 
- **iloczyn logiczny "i":** $a\cdot b$ 
- **przemienność:** $a+b=b+a$
- **rozdzielność:**
	- $a\cdot(b+c) = a\cdot b+a\cdot c$
	- $a+(b\cdot c)=(a+b)\cdot(a+c)$
- **elementy neutralne:**
	- $a+0=a$
	- $a\cdot0=0$
	- $a\cdot1=a$
	- $a+1=1$
- **pochłanianie:**
	- $a+\not a = 1$
	- $a\cdot\not a = 0$
- **łączność:**
	- $a+(b+c)=(a+b)+c$
	- $(a\cdot b)\cdot d=a\cdot(b\cdot c)$
- **zasada pochłaniania:**
	- $a+a\cdot b=a$
	- $a(a+b)=a$
	- $a+\not a=1$
	- $a\cdot a=a$
- **Prawa de Morgana:**
	- $\not(a\cdot b)=\not a+\not b$
	- $\not(a+b)=\not a\cdot\not b$
	- $\not(\not a)=a$

# Opis funkcji boolowskiej
**Postać kanoniczna** wzgl. sumy:**!ZAPISUJEMY JEDYNKI!**
	$f(x_0, x_1,\cdots,x_{n-1})$
	$f(x_0, x_1,\cdots,x_{n-1})=x_0f_1(x_1,x_2,\cdots,x_{n-1})+\not x_0f_2(x_1,x_2,\cdots,x_{n-1})$
	Możemy tak rozwijać dalej, i uzyskać $2^n$ składników
	$f(x_0, x_1,\cdots,x_{n-1})=x_0x_1\cdots x_{n-1}f(1,1,\cdots,1)+x_0x_1\cdots\not x_{n-1}f(1,1,\cdots,0)+\cdots$

**Postać kanoniczna** wzgl. iloczynu:**!ZAPISUJEMY ZERA!**
	$f(x_0, x_1,\cdots,x_{n-1})$
	$f(x_0, x_1,\cdots,x_{n-1})=(x_0+f_1(x_1,x_2,\cdots,x_{n-1}))\cdot(\not x_0+f_2(x_1,x_2,\cdots,x_{n-1}))$
	Możemy tak rozwijać dalej, i uzyskać $2^n$ składników
	$f(x_0, x_1,\cdots,x_{n-1})=(x_0+x_1+\cdots+x_{n-1}+f(0,0,\cdots,0))\cdot(x_0+x_1+\cdots+\not x_{n-1}+f(0,0,\cdots,1))\cdots$

Możemy to zapisać jako:
$f(x_1,x_2,x_3)=\sum(011,101,110,111)= \not x_1x_2x_3+x_1\not x_2x_3+x_1x_2\not x_3+x_1x_2x_3$ - **!ZAPISUJEMY JEDYNKI!**
lub
$f(x_1,x_2,x_3)=\prod(011,101,110,111)= (x_1+\not x_2+\not x_3)(\not x_1+x_2+\not x_3)(\not x_1+\not x_2+x_3)(\not x_1+\not x_2+\not x_3)$ - **!ZAPISUJEMY ZERA!**

# System funkcjonalnie pełny
Jeżeli możemy udowodnić, że można elementami systemu wykonać **NOT, AND, OR** to wtedy wiemy, że jest on pełny

# Minimalizacja
jest to problem np trudny z górnym ograniczeniem $3^n\over n$

Sklejanie jedynek:
$a\not x+ ax=a \rightarrow a(\not x+x)=a$
Sklejanie zer:
$(a+\not x)(a+x)=a \rightarrow a+(\not xx)=a$

- n zmiennych
- $2^n$ elementów
- grupy mogą mieć $2^k$ gdzie $0\eqslantless k \eqslantless n$
- grupa jest opisana przez n-k zmiennych
- każdy element ma potencjalnie n-k grup sąsiednich


# Multiplekser i demultiplekser
**multiplekser** zamienia kod równoległy na szeregowy
realizuje funkcje $y=\not a_1a_0d+a_1a_0d$ gdzie d to wejście

**demultiplekser** kod szeregowy na równoległy

oba działają dzięki sterowaniu adresem


# Kody
**BCD** - kod dwójkowo - dziesiętny:
- **8421**
- **+3** (D=B+3)
- **2421** - samouzupełniający

Kod **refleksyjny** (odporność na zakłócenia, 1 bit):
- kod **Graya** - kolejna wartość różni się max 1 bitem

Kod **detekcyjny**:
- kontrola **parzystości**
- **1z10** czy **2z5**

Kod **korekcyjny**:
- kod **Hamminga**


# Enkoder
1 z n na bin

# Dekoder
bin na 1 z n

# Transkoder
inny niż 1 z n na inny niż 1 z 10

# Sprzężenie zwrotne
- **Stan Stabilny** - jednoznacznie określony
- **Stan Bistabilny** - zależy od stanu poprzedniego zapamiętanego
- **Stan Astabilny** - sprzeczność $Q=\not Q$

# Przerzutniki
- **RS** - Reset Set
- **RS** synchroniczny - Reset Set Clock(enable)
- **D** - Data i Clock

| D | Q | Q' |
| ---- | ---- | ---- |
| 0 | 0 | 0 |
| 0 | 1 | 0 |
| 1 | 0 | 1 |
| 1 | 1 | 1 |
- **JK** - Jedynkujące Kasujące i Clock

| J | K | Q' |
| ---- | ---- | ---- |
| 0 | 0 | Q |
| 0 | 1 | 0 |
| 1 | 0 | 1 |
| 1 | 1 | $\not Q$ |
- **T** - Trigger i Clock

| T | Q | Q' |
| ---- | ---- | ---- |
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |

# Opis automatu
$\Sigma$- alfabet wejściowy
Q- stany
$\delta$- funkcja przejść
$q_0$- stan początkowy
Y lub F- stany końcowe
$\lambda$- funkcja wyjść
$\Delta$- alfabet wyjściowy

**Automat Moore'a** - (Q, $\Sigma$, $\delta$, $\Delta$, $q_0$, $\lambda$)
**Automat Mealy'ego** - (Q, $\Sigma$, $\delta$, $\Delta$, $q_0$, $\lambda$)

# Synteza
**Synteza abstrakcyjna**:
- opis działania automatu – algorytm słowny,
- przedstawienie algorytmu słownego w postaci wyrażeń regularnych bądź grafu automatu,
- określenie tablicy przejść i wyjść,
- określenie grafu przejść, jeśli znane jest wyrażenie regularne, a nie graf przejść.

**Synteza strukturalna** – od opisu do fizycznej realizacji układu cyfrowego, czyli:
- kodowanie sygnałów, wejść i wyjść,
- budowa tablicy wzbudzeń przerzutników,
- określenie funkcji wzbudzeń przerzutników,
- określenie funkcji wyjścia,
- stworzenie schematu logicznego układu.

# Automat Skończony
(Q, $\Sigma$, $\delta$, F, $q_0$)

**Automat skończony** jest modelem matematycznym systemu dyskretnego, działającego w dyskretnych chwilach czasu. Jego działanie jest określone na skończonych zbiorach sygnałów wejściowych, stanów wewnętrznych i sygnałów wyjściowych.

- **DFA** - Deterministyczny
- **NFA** - Niedeterministyczny

# Minimalizacja wyrażeń regularnych

Miejsce „**podstawowe**” — miejsce, na lewo od którego stoi litera oraz miejsce początkowe. 
Miejsce „**przedpodstawowe**” — miejsce, od którego na prawo stoi litera.

- **Reguła 1**
  Symbole miejsca "**podstawowego**" przed nawiasem iteracyjnym rozmieszcza się w miejscach “**przedpodstawowych**" we wszystkich miejscach początkowych wszystkich członów dysjunktywnych stojących w danym nawiasie.
- **Reguła 2**
  Symbol miejsca końcowego dowolnego członu dysjunktywnego zamkniętego w nawiasy iteracyjne rozmieszczamy w miejscach początkowych ("**przedpodstawowych**") wszystkich członów dysjunktywnych zamkniętych w danym nawiasie.
- **Reguła 3**
  Symbole miejsc "**podstawowych**", na lewo i prawo od których stoją litery nie rozmieszcza się nigdzie więcej.
- **Reguła 4**
  Symbol miejsca końcowego wyrażenia rozmieszcza się we wszystkich tych miejscach "**przedpodstawowych**"”, gdzie znajduje się symbol miejsca początkowego.
- **Reguła 5**
  Symbol miejsca końcowego dowolnego członu dysjunktywnego zamkniętego w nawiasy iteracyjne rozmieszcza się w miejscu "**przedpodstawowym**" bezpośrednio za danym nawiasem.
- **Reguła 6**
  Symbol miejsca przed nawiasem iteracyjnym zapisuje się w miejscu "**przedpodstawowym**" znajdującym się za tym nawiasem.

# Hazard
**Hazard** — zjawisko powstawania błędnych stanów na wyjściu układu podczas procesów przejściowych. 
Przyczyną powstawania błędnych sygnałów są rzeczywiste właściwości przełączające I transmisyjne: 
- różne czasy propagacji sygnału z wejścia na wyjście, 
- jednoczesna zmiana co najmniej dwóch sygnałów wejściowych, propagująca się do wyjścia różnymi drogami oraz 
- niejednoczesna zmiana sygnałów wejściowych, propagująca się do wyjścia drogami o jednakowych opóźnieniach. 

**Hazard statyczny** powstaje, kiedy źródłem niepożądanego stanu są nieidealne właściwości przełączające; na wyjściu układu występuje krótkie zakłócenie prawidłowego stanu logicznego; zazwyczaj przy propagacji sygnału dwiema drogami o różnych opóźnieniach. 

**Hazard dynamiczny** wywołany jest nieidealnymi właściwościami transmisyjnymi; gdy po prawidłowej zmianie stanu wyjściowego wystąpi krótkotrwały powrót do stanu poprzedniego; może wystąpić przy przesyłaniu sygnału trzema drogami o różnych opóźnieniach.

# Wyścigi
**Wyścig** w układach asynchronicznych to zjawisko istnienia różnych dróg przejść ze stanu niestabilnego do stanu stabilnego. 

Wyścigi mogą wystąpić tylko wtedy, gdy następuje zmiana sygnału wyjść co najmniej dwóch elementów pamięciowych. 

Jeżeli możliwe jest (następuje) przejście ze stanu niestabilnego do różnych stanów stabilnych, wtedy mówimy o tzw. **wyścigu krytycznym**. 

Jeżeli przejście odbywa się ze stanu niestabilnego do odpowiadającego mu stanu stabilnego, mówimy o **wyścigu niekrytycznym**.

# Automat parametryczny

# Gramatyka bezkontekstowa - CFG
Mogą opisywać szczególne własności:
$0^n1^n$ Gdzie $n>0$

**Języki bezkontekstowe** (context-free languages — CFL) 
Języki powiązane z CFG. Obejmują wszystkie języki regularne oraz wiele dodatkowych języków.

**Automat ze stosem**, to klasa maszyn rozpoznających języki bezkontekstowe.

---

![](/Notatki/Semestr%203/Logika%20układów%20cyfrowych/Wykłady/Kolokwium/Drawing%202024-02-01%2009.18.03.excalidraw.svg)![](/Notatki/Semestr%203/Logika%20układów%20cyfrowych/Wykłady/Kolokwium/e.circ)

![](/Notatki/Semestr%203/Logika%20układów%20cyfrowych/Wykłady/Kolokwium/Drawing%202024-02-05%2014.08.37.excalidraw.svg)![](/Notatki/Semestr%203/Logika%20układów%20cyfrowych/Wykłady/Kolokwium/Drawing%202024-02-05%2020.19.39.excalidraw.svg)