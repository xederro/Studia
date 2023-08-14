![Wykład 4_5 2022na23](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Wyk%C5%82ad%204_5%202022na23.pdf) h: EF_W45_2022
![Niepewność złożona2022](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Niepewno%C5%9B%C4%87%20z%C5%82o%C5%BCona2022.pdf) h: EF_zadania_2021
![Niepewność złożona2021](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Niepewno%C5%9B%C4%87%20z%C5%82o%C5%BCona2021.pdf) h: EF_zadania_2021
![ea-4-02m](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/ea-4-02m.pdf)

# Pomiary
## Wynik pomiaru

Mezurant są to wielkości które mają być zmierzone

#kolokwium {
dopasowanie do podanych wielkości fizycznych odpowiednie jednostki
- masa
- natężenie prądu
- napięcie
- odległość
- okres
- światłość
- temperatura

pytanie typu co mierzy herc

przedstaw w zapisie inżynierskim podane wielkości
$3,5 * 10^{-2} A$ - natężenie (czego) prądu - $35 mA$
$12 * 10^2 V$ - Napięcie prądu - $1,2 kV$
Co za wielkość były zmierzone?
}

Wielkości rzeczywistej nigdy nie mierzymy, mierzymy zakres miedzy którym znajduje się wielkość rzeczywista

## Błąd
Błąd przypadkowy decyduje o precyzji
Błąd systematyczny decyduje o dokładności
Błąd gruby

# Niepewności i analiza statystyczna

$\delta x = 21\pm3 mm$  - niepewność w modelu interwałowym (przedziałowym)

![Pasted image 20221025100324](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Pasted%20image%2020221025100324.png) 
m - średnia arytmetyczna
$\sigma$ - odchylenie standardowe
$m\pm \sigma$ - przedział wokół wartości mierzonej, np. z prawdopodobieństwem 95% znajduje się pomiędzy nimi wartość prawdziwa mieszona



$\not S_x = \sqrt{{1\over {n-1}}\sum^n_{i=1}(x_i-\not x)^2}$    

## Likwidacja błędów grubych
$x_{sr} - 3\sigma \leq x_{sr} \not\leq x_{sr} + 3\sigma$ 
jeżeli się nie mieści w tym zakresie to można wyrzucić

Wynik obliczeń musimy zaokrąglić, niepewności zaokrąglamy zawsze w górę, zaokrąglamy do 2 cyfr znaczących na labolatoriach

#kolokwium {
ile jest cyfr znaczyących
- 250,12
- 0,152
- 0,013

zaokrąglij do trzech cyfr znaczących
- 250,12 - 250
- 8945,71 - 8950 - $8,95*10^3$
- 7,3986 - 7,40
}



## niepewność typu b (graniczna)
I - 47,32 mA    $\sigma i$ = 1,23 mA
po zaokrągleniu 47,3 $\pm$ 1,2 mA

// nie tykać
// zgrzyty między modelami  w przykładach jest zagadka na konsulatacjach można się zgłosić i wytłumaczyć by podwyższyć ocene

$u(x) = {\Delta x \over \sqrt 3}$ 

niepewność szacowana
$u_B(x) = \sqrt{\frac{{\Delta_p X}^2}{3} + \frac{{\Delta_e X}^2}{3} + \frac{{\Delta_t X}^2}{3} + \cdots}$ 

niepewność standardowa całkowita
![Pasted image 20221108092558](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Pasted%20image%2020221108092558.png)

## prawo przenoszenia błędów skorelowanych
//nie ma kwadratu i pierwiastka w a
![Pasted image 20221108093925](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Pasted%20image%2020221108093925.png)
przydatne by zobaczyć co trzeba poprawić by błąd był niższy

![Pasted image 20221108094343](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Pasted%20image%2020221108094343.png)



## niepewność typu a
I - 47,32 mA    u(I) = 1,23 mA
po zaokrągleniu 47,3(13) mA (47,3, 13 bo 3 po przecinku 1 na jednościach więc patrząc od prawej)




## Błędy

1. Błąd systematyczny 
   ![Pasted image 20221108095755](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Pasted%20image%2020221108095755.png)
   
2. Błąd graniczny
3. Błąd addytywny
4. Błąd multiplikatywne
   ![Pasted image 20221108095832](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Pasted%20image%2020221108095832.png)
5. Błąd statystyczny
6. Błąd dynamiczny
   ![Pasted image 20221108095822](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%204/Pasted%20image%2020221108095822.png)
7. Błąd kwantowy - Błąd kwantowania, występujący we wszystkich miernikach cyfrowych, ma charakter błędu addytywnego

//wprowadzić do excela na sprawozdania , współczynnik korelacji
[strona](https://www.statsoft.pl/textbook)
//nieparzystą ilość słupków na histogramie
//wykres min a5

A. Zięba "analiza danych w naukach ścisłych i technice" PWN





