![w14_2023](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%2011/w14_2023.pdf)
H: EF_W14_2023

# Obwody prądu sinusoidalnego


j - liczba zespolona co by się nie myliło, wektory

## Rezystor

## Cewka
#kolokwium {
Idealna cewka powoduje przesunięcie napięcia o $\frac{\pi}{2}$
-> reaktancja indukcyjna - $X_L=j \omega L = j 2 \pi fL$ - opór ale zespolony \[$\ohm$\]
indukcyjna lub pojemnościowa
-> susceptancja indukcyjna - $B_L=\frac{1}{X_L}$ - przewodność ale zespolona




\+ cewka
\- transformator
}

## Idealna indukcyjność
prawo ohma jest zachowane w liczbach zespolonych

$I = Re(I_me^{j(\omega t+\phi)})$
$U = L\frac{d}{dt}I_me^{j(\omega t+\phi)}$
$X_L = \omega L e^{j\frac{\pi}{2}}$ - zapis symboliczny
podkreślenie pod U lub I oznacza że będzie to liczb zespolona

#kolokwium {
Idealny kondensator powoduje przesunięcie napięcia o $-\frac{\pi}{2}$
-> reaktancja pojemnościowa - $X_L=j \omega C = j 2 \pi fC$ - opór ale zespolony \[$\ohm$\]
-> susceptancja pojemnościowa - $B_L=\frac{1}{X_L}$ - przewodność ale zespolona \{siemens\]
}


Um - maksymalna
U- skuteczna
$u(t)$

## Dwójnik szeregowy R, L
napięcie w górę
impedancja - opór zespolony

## Dwójnik szeregowy R, C
napięcie w dół

## Impedancja (Admitancja)
Impedancja - $Z = U/I = R+jX=R+j(\omega L - 1/\omega C)$ - (opór zespolony)
Admitancja - odwrotność Impedancji - $Y = I/U = G+jB=G+j(\omega C - 1/\omega L)$

Idealny rezystor ma tylko część R(rezystancyjną a nie ma części admitancyjnej) $Z=R+j0$
#Lab - przeliczanie do róznych modelów w zależności od częstotliwości

analizator widma - to transformata fouriera
analizator wektorowy - drogie i mierzy

## pomiar impedancji - metoda techniczna
#kolokwium {
narysowanie ukłądu
amperomierz po voltomierzu i potem opornik - dobrze mierzone prądu - duże oporności
amperomierz przed voltomierzem i potem opornik - dobrze mierzone natęrzenie - małe oporności
jak zamiast rezystora będzie kondensator to prąd stały nie przepłynie 
}

## Mostek Wienna


# Moc w obwodach prądu sinusoidalnego

## Moc chwilowa dla prądów i napięć przemiennych
$P = U_sI_scos(\phi)$ \[W\]

Moc bierna \[War\]
$Q=U_sI_s sint(\phi)$

Moc pozorna \[VA\]
$Q=U_sI_s$

## Moc zespolona S=UI*

\*-sprzęrzone
\[VA\]

moc zespolona daje moc czynną + moc bierną
|S| = moc pozorna


## Współczynnik mocy

## Pomiar mocy

Watomierz - 4 gniazda - 2 obwodu, prądowy, napięciowy 

Waromierz - 

## Przesunięcie fazowe

przesunięcie dwóch funkcji zależnych od czasu między sobą
$2\pi\frac{t}{T}$
T - okres
t - różnica

#kolokwium {
jak mierzyć jak odczytywać z oscyloskopu
mierzymy okres a  nie czestotliwosc
}

## Figura Lissajous

figury powstające przez wyświetlenie 2 funkcji jako x i y od czasu w zależności od przesunięcia fazowego i częstotliwości funkcji
#lab{
wyznaczanie stosunku częstotliwości
rysujemy 2 proste w miejscach z największą ilością przecięć
liczymy przecięcia - x=2, y-8
$\frac{f_y}{f_x} = \frac{x}{y} = \frac{8}{2} = 4$
}
