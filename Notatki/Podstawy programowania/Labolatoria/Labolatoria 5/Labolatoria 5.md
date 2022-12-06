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



zadanie 1:
tablica wskaźników kończona nullem, a tablica cstingów \0
po malloc wsk\[0\] = null //pusta tablica
wsk\[poz+1\] = strdup(buf)
do sortowania można strcmp()


