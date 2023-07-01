![[Notatki/Semestr 1/Podstawy programowania/Labolatoria/Labolatoria 5/Laboratorium 5_2021.pdf]]
![[Notatki/Semestr 1/Podstawy programowania/Labolatoria/Labolatoria 5/TabliceLiczb.pdf]]
![[Notatki/Semestr 1/Podstawy programowania/Labolatoria/Labolatoria 5/DynamicznaTablicaLiczb.cpp]]
![[Notatki/Semestr 1/Podstawy programowania/Labolatoria/Labolatoria 5/DynamicznaTablicaWskaznikow.cpp]]
![[Notatki/Semestr 1/Podstawy programowania/Labolatoria/Labolatoria 5/StatycznaTablicaLiczb.cpp]]
![[Notatki/Semestr 1/Podstawy programowania/Labolatoria/Labolatoria 5/StatycznaTablicaWskaznikow.cpp]]


zmienne są w stosie zapisywane w kolejności inicjalizacji
wchodzimy do funkcji, na stosie pojawia się adres powrotu
parametr umieszczamy na stosie
wychodząc z funkcji/bloku zmienne lokalne są zdejmowane ze stosu

stos = stack <- tutaj są zapisywane zmienne

# Zmienne dynamiczne
nie ma swojej nazwy
nie ma zakresu widoczności
używa się adresem

sterta = heap <- tutaj są zapisywane zmienne dynamiczne

wskaźnik na typ void <- wskaźnik bez typu

```c
float* wf;

wf = (float*)malloc(sizeof(float)); //malloc(ILOŚĆ_BAJTOW); - alokuje pamięć

wf* = 3.1415;

free(wf); //(ADRES) - zwalnia pamięć

wf = (float*)realloc(wf, 2*sizeof(float)); //(ADRES_DOTYCHCZASOWY, WIELKOŚĆ_PO_ALOKACJI) - zmienia adres, na nowy adres wysyła dane dotychczasowe, zwalnia pamięć
```

```cpp
float* wf;

wf = new (float);//(float[2])

wf* = 3.1415;

delete wf;//[]wf

// nie ma odpowiednika realloc w c++
```



![[Notatki/Semestr 1/Podstawy programowania/Labolatoria/Labolatoria 5/Labolatoria 5.1.cpp]]
![[Notatki/Semestr 1/Podstawy programowania/Labolatoria/Labolatoria 5/Labolatoria 5.2.cpp]]


[[Notatki/Semestr 1/Podstawy programowania/Wykłady/Wykład 8/Wykład 8]]
[[Notatki/Semestr 1/Podstawy programowania/Wykłady/Wykład 11/Wykład 11]]