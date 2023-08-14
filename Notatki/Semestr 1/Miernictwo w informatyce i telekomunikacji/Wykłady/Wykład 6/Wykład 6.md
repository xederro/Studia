[oze](https://oze.pwr.edu.pl//kursy/fizykacw/content/start/K-08.html)
![Wykład 7_8-2021](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%206/Wyk%C5%82ad%207_8-2021.pdf)H: EF_W78_2021
![oczka](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%206/oczka.pdf)
![polaczeniaR](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%206/polaczeniaR.pdf)
![zrodla](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%206/zrodla.pdf)
![Kartkówka](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%206/Pasted%20image%2020221122091152.png) #kolokwium 
#kolokwium {
# Prawo Ohma
U = IR
R = 1/G
G - konduktancja 1/$\ohm$ \[S-simens\]
1S = 1A/1V
I = GU

# Prawo Kirchhoffa
## I prawo
I1 + I2 + I3 = I4 + I5
## II prawo
$\sum_i U_i = \sum_k \epsilon_k$ 

# Rezystancja
$P=IU=I^2R=\frac{U^2}{R}=U^2G=\frac{I^2}{G}$


# Źródło napięciowe
 - Idealne źródło napięciowe - jest dwójnikiem, na którego zaciskach występuje stała różnica potencjałów niezależnie od natężenia i kierunku prądu. W szczególności napięcie takiego źródła nie zależy od wartości rezystancji obciążenia
 - Rzeczywiste źródło napięciowe - zachowuje się jak idealne źródło napięciowe z szeregowo połączonym rezystorem o małej wartości rezystancji. Ogniwo elektryczne, baterię, akumulator można uważać za przybliżone źródła napięciowe.
odróżnianie ich

# Źródło prądowe 
- Idealne źródło prądowe jest dwójnikiem, który wymusza prąd o stałym natężeniu w dołączonym obwodzie, niezależnie od wartości napięcia na jego zaciskach.
- Rzeczywiste źródło prądowe charakteryzuje się pewną graniczną wartością napięcia wyjściowego, a wydajność prądowa jest tylko w przybliżeniu stała. 
- Źródła napięciowe i prądowe zaliczamy do elementów aktywnych w obwodach elektrycznych – mogą one dostarczać energię do obwodu. 


Rozróżniamy dwa typy źródeł: 
-  Źródła niezależne 
-  Źródła zależne (sterowane).
}

#Lab{
# Obciążanie źródeł energii elektrycznej 
Zamknięcie obwodu elektrycznego (połączenie biegunów źródła z odbiornikiem energii elektrycznej) skutkuje pojawieniem się prądu w stworzonym dla niego obwodzie i przekazywaniem energii. 

Odbierana moc wyniesie {prezentacja}

Biorąc pochodną tego wyrażenia po R i przyrównując do zera znajdziemy, że maksymalna moc wydzieli się w odbiorniku o rezystancji Rw = R. Nazywamy to zasadą maksymalnego przekazu mocy. 

Warto zauważyć, że dla Rw = R wydzieli się identyczna moc na rezystancji wewnętrznej. Oznacza to, że przy maksymalnym przekazie mocy mamy spore straty energii (równe energii przekazanej do odbiornika). Oszczędniej z energią będzie w sytuacji Rw >>R.
}

#kolokwium { rysunki rozróżniać
# Twierdzenie Thevenina
Dowolną sieć elektryczną (a w szczególności zasilacz) z dwoma wybranymi zaciskami można zastąpić szeregowym połączeniem jednego źródła napięciowego o sile elektromotorycznej UT i pojedynczego rezystora RT. UT jest napięciem na rozwartych zaciskach układu UT = Urozwarcia RT jest wewnętrzną rezystancją theveninowskiego układu zastępczego: Definicja UT = Urozwarcia podpowiada jak można zmierzyć lub obliczyć UT. Natomiast definicja RT = UT/Izwarcia mówi jak można wyznaczyć RT mając wyznaczoną wartość UT: należy obliczyć lub zmierzyć Izwarcia i obliczyć ułamek UT /Izwarcia.

# Twierdzenie Nortona
Każdą sieć elektryczną (a w szczególności zasilacz) można zastąpić równoległym połączeniem źródła prądowego generującego prąd IN i rezystora RN. IN jest prądem zwarcia. IN = Izwarcia. Gdy spotkamy układy z napięciami i prądami zmiennymi będziemy posługiwać się uogólnieniem rezystancji jakim jest impedancja Z (czyli „oporność zależna od częstotliwości”). Z powyższego widać, że dla każdego układu


![Pasted image 20221122095829](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%206/Pasted%20image%2020221122095829.png)//bardzo często na #kolokwium 
}

# Wybrane metody analizy obwodów elektrycznych


1. Metoda uproszczeń. 
2. Metoda superpozycji. 
3. Metoda stosowania twierdzeń Thevenina i Nortona. 
4. Metoda oczkowa, zwana też metodą prądów oczkowych (preferowane są układy zawierające źródła napięciowe). #kolokwium 
5. Metoda węzłowa, zwana też metodą napięć węzłowych jest najczęściej stosowana (preferowane są źródła prądowe).  //lubiana
6. Metoda graficzna. Stosowana jest szczególnie w przypadku układów zawierających elementy nieliniowe.

# Pomiar napięcia

## Wpływ voltomierza na napięcie źródła badanego
Rezystancje wewnętrzne urządzeń wpisać do excela
jeżeli miernik ma rozrzut 1% a poprawka ma 0.001% to nie ma po co jej pisać (rezystancja mierzona do urządzenia \* 100%)

## Wpływ amperomierza
jeżeli miernik ma rozrzut 1% a poprawka ma 0.001% to nie ma po co jej pisać (-rezystancja urządzenia do mierzonej \* 100%)

#kolokwium {
	wiedzieć o amperomierzach i voltomierzach, jak podłącza, rezystancja, co mierzy
	obrazek/układ i wskazać który jest dobry a który nie
	meta: 
	przeliczanie decybeli
}

## Ohmomierz
!bez zasialania!

#kolokwium {
$R_{gr} = \sqrt{R_A*R_V}$

$Rx>R_{Gr}$ to pmp
$Rx<R_{Gr}$ to pmp
}

#kolokwium zadania z eportalu bywają, ale częściej źródła

# Metody zerowe
## Metoda mostkowa
jedno napięcie, mierzymy małe rezystancje, 

## Metoda Kompensacyjna
dwa napięcia, mierzymy siły elektromotorowyczne

## Mostkowy układ pomiarowy
Galwanometr pokazuje zero gdy jest równowaga napięć
$U_{ac} = U_{bd}$ i $U_{ad} = U_{bc}$
rezystancje przeciwstawnych rezystorów są równe gdy galwanometr 0
