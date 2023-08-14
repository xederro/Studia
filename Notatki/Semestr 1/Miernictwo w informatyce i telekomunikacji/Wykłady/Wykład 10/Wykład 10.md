![scope_146](/Notatki/Semestr%201/Miernictwo%20w%20informatyce%20i%20telekomunikacji/Wyk%C5%82ady/Wyk%C5%82ad%2010/scope_146.exe)
[symulator](https://www.zeitnitz.eu/scope_en)

# Oscyloskop

2 płytki które sterują natężeniem pola elektromagnetycznego i przez nie oddziałują na elektrony które jak w kineskopie strzelają i ekscytują luminofor na ekranie, który dzięki temu wyświetla przebieg.

Najlepiej nieskończona impedancja.

- DC - przemienny i składowa stała
- AC - przemienny bez składowej stałej
- GND - 0

## Poziom wyzwalania i zbocze

- Zbocze wyzwalania determinuje czy wyzwolenie nastąpi przy wzroście lub spadku sygnału
- Poziom wyzwolenia określa, gdzie na zboczu znajduje się punkt wyzwolenia

## Podstawowe parametry oscyloskopu

### Pasmo
Pasmo zajmowane przez sygnał
Nie ma nieskończonych pasm
Największa częstotliwość sygnałów które możne przenieść bez zniekształceń, gdyby był nieskończony to istniała by idealnie kwadratowa funkcja

### Czas narostu sygnału
   $T_R$ - czas narostu sygnału
   $t_R[\micro s] = 0,35/B[MHz]$ - oscyloskopu
   $T'_R zmierzone - \sqrt{t_R^2 + T_R^2}$

## Jak mierzyć oscyloskopem

1. Odczytujemy liczbę dziaek na ekranie
2. Przeliczamy liczbę działek na wartości bezwzględne na podstawie nastaw oscyloskopu
   - Amplituda - V/dc
   - Czas - ($\micro$s/ms/s)/dz
   - Niepewność głównie z rozdziałki

# Oscyloskop Cyfrowy

## Sample rate

Częstotliwość próbkowania, 

dla $\sin{x}/x >2.5*f_{max}$
dla interpolacji liniowej $>10*f_{max}$

kompromis - min nadpróbkowanie $>5*f_{max}$
