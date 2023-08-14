![Laboratorium 5_2021](/Notatki/Semestr%201/Podstawy%20programowania/Labolatoria/Labolatoria%205/Laboratorium%205_2021.pdf)
![TabliceLiczb](/Notatki/Semestr%201/Podstawy%20programowania/Labolatoria/Labolatoria%205/TabliceLiczb.pdf)
![DynamicznaTablicaLiczb](/Notatki/Semestr%201/Podstawy%20programowania/Labolatoria/Labolatoria%205/DynamicznaTablicaLiczb.cpp)
![DynamicznaTablicaWskaznikow](/Notatki/Semestr%201/Podstawy%20programowania/Labolatoria/Labolatoria%205/DynamicznaTablicaWskaznikow.cpp)
![StatycznaTablicaLiczb](/Notatki/Semestr%201/Podstawy%20programowania/Labolatoria/Labolatoria%205/StatycznaTablicaLiczb.cpp)
![StatycznaTablicaWskaznikow](/Notatki/Semestr%201/Podstawy%20programowania/Labolatoria/Labolatoria%205/StatycznaTablicaWskaznikow.cpp)


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



![Labolatoria 5.1](/Notatki/Semestr%201/Podstawy%20programowania/Labolatoria/Labolatoria%205/Labolatoria%205.1.cpp)
![Labolatoria 5.2](/Notatki/Semestr%201/Podstawy%20programowania/Labolatoria/Labolatoria%205/Labolatoria%205.2.cpp)


[Wykład 8](/Notatki/Semestr%201/Podstawy%20programowania/Wyk%C5%82ady/Wyk%C5%82ad%208/Wyk%C5%82ad%208.md)
[Wykład 11](/Notatki/Semestr%201/Podstawy%20programowania/Wyk%C5%82ady/Wyk%C5%82ad%2011/Wyk%C5%82ad%2011.md)