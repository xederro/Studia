![[Laboratorium 5_2021.pdf]]
![[TabliceLiczb.pdf]]
![[DynamicznaTablicaLiczb.cpp]]
![[DynamicznaTablicaWskaznikow.cpp]]
![[StatycznaTablicaLiczb.cpp]]
![[StatycznaTablicaWskaznikow.cpp]]


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

```cpp
float* wf;

wf = (float*)malloc(sizeof(float)); //malloc(ILOŚĆ_BAJTOW); - alokuje pamięć

wf* = 3.1415;

free(wf); //(ADRES) - zwalnia pamięć

realloc(); //
```

