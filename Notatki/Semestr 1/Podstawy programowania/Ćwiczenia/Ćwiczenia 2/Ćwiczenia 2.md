![Cwiczenia_2](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%202/Cwiczenia_2.pdf)


1. 
   a.
    ![cw2zad1a](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%202/cw2zad1a.svg)
b. 
```cpp
int wiersz, kolumna;

    wiersz = 1;

    kolumna = 1;

    while (wiersz < 10)

    {

        printf("%3d", kolumna);

        if (wiersz == kolumna)

        {

            wiersz++;

            kolumna = 0;

            printf("\n");

        }

        kolumna++;

    }
```
c. 
```cpp
int wiersz;

    wiersz = 1;

    for (int kolumna = 1; wiersz < 10; kolumna++)

    {

        printf("%3d", kolumna);

        if (wiersz == kolumna)

        {

            wiersz++;

            kolumna = 0;

            printf("\n");

        }

    }
```
d. 
```cpp
for (int kolumna = 1; kolumna < 10; kolumna++)

    {

        for (int wiersz = 1; wiersz <= kolumna; wiersz++)

        {

            printf("%3d", wiersz);

        }

        printf("\n");

    }
```
e. 
```cpp
int wiersz, kolumna;

    wiersz = 1;

    kolumna = 1;

    do

    {

        printf("%3d", kolumna);

        if (wiersz == kolumna)

        {

            wiersz++;

            kolumna = 0;

            printf("\n");

        }

        kolumna++;

    } while (wiersz < 10);
```


2. a. 
   ![cw2zad2a](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%202/cw2zad2a.cpp)

	b.
	![cw2zad2b](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%202/cw2zad2b.cpp)

3. 
   ![cw2zad3](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%202/cw2zad3.cpp)


4. 
   ![cw2zad4](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%202/cw2zad4.cpp)


1. 
	1. A2 = 10 
	   A1 = 15 
	   A3 = 7 
	   A4 = 10
	2. R1 = 100
	   R2 = 30
	3. K2 = 20
	   K1 = 3
	4. K = 23
	5. R1 = 105
	   R2 = 35


[Wykład 3](/Notatki/Semestr%201/Podstawy%20programowania/Wyk%C5%82ady/Wyk%C5%82ad%203/Wyk%C5%82ad%203.md)