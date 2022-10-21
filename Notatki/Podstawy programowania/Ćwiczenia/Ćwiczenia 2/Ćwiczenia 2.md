[[Cwiczenia_2.pdf]]


1. 
   a.
    ![[cw2zad1a.svg]]
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
   [[cw2zad2a.cpp]]
   [[cw2zad2a.exe]]
	b.
	[[cw2zad2b.cpp]]
	[[cw2zad2b.exe]]

3. [[cw2zad3.cpp]]
   [[cw2zad3.exe]]


4. 

