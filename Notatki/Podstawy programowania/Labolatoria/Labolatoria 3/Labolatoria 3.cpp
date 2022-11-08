/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadania Laboratorium 3
Data:   8 listopada 2022r.
*/

#include <iostream>
#include <stdio.h>

#define ROZMIAR 5

using namespace std;

float tab[ROZMIAR] = {0};

void zadanie1a() // wpisywanie elementów do tablicy
{
    for (unsigned char i = 0; i < ROZMIAR; i++)
    {
        cout << "tab[" << (int)i << "]: ";
        cin >> tab[i];
    }
}

void zadanie1b() // wypisanie elementów tablicy
{
    cout << "[ ";
    for (unsigned char i = 0; i < ROZMIAR; i++)
    {
        cout << tab[i] << " ";
    }
    cout << "]" << endl;
}

void zadanie1c() // sprawdzi i wypisze na ekranie komunikaty
{
    unsigned char iloscd, iloscu = 0;
    float sumad, sumau = 0;

    for (unsigned char i = 0; i < ROZMIAR; i++)
    {
        if (tab[i] >= 0)
        {
            sumad += tab[i];
            iloscd++;
        }
        else
        {
            sumau -= tab[i];
            iloscu++;
        }
    }

    if (iloscd)
    {
        cout << "Ilosc liczb dodatnich: " << iloscd << endl;
        cout << "Suma liczb dodatnich: " << sumad << endl;
        cout << "Srednia liczb dodatnich: " << sumad / iloscd << endl;
    }
    else
    {
        cout << "Nie ma liczb dodatnich." << endl;
    }

    if (iloscu)
    {
        cout << "Ilosc liczb ujemnych: " << iloscu << endl;
        cout << "Suma liczb ujemnych: -" << sumau << endl;
        cout << "Srednia liczb ujemnych: -" << sumau / iloscu << endl;
    }
    else
    {
        cout << "Nie ma liczb ujemnych." << endl;
    }
}

void zadanie1d() // informację o uporządkowaniu elementów tablicy
{
    unsigned char rosnace, niemalejace, jednakowa, nierosnace, malejace = 1;

    for (unsigned char i = 0; i < ROZMIAR - 1; i++)
    {
        if (tab[i] < tab[i + 1])
            rosnace++;
        if (tab[i] <= tab[i + 1])
            niemalejace++;
        if (tab[i] == tab[i + 1])
            jednakowa++;
        if (tab[i] >= tab[i + 1])
            nierosnace++;
        if (tab[i] > tab[i + 1])
            malejace++;
    }

    if (jednakowa > ROZMIAR)
        cout << "Funkcja jest jednakowa." << endl;
    else if (niemalejace > ROZMIAR)
        cout << "Funkcja jest niemalejace." << endl;
    else if (rosnace > ROZMIAR)
        cout << "Funkcja jest rosnaca." << endl;
    else if (nierosnace > ROZMIAR)
        cout << "Funkcja jest nierosnace." << endl;
    else if (malejace > ROZMIAR)
        cout << "Funkcja jest malejace." << endl;
    else
        cout << "Funkcja jest nie uporzadkowana." << endl;
}

void zadanie1()
{
    // wpisywanie elementów do tablicy
    zadanie1a();

    // wypisanie elementów tablicy
    zadanie1b();

    // sprawdzi i wypisze na ekranie komunikaty
    zadanie1c();

    // informację o uporządkowaniu elementów tablicy
    zadanie1d();
}

void zadanie2()
{
}

void zadanie3()
{
}

void zadanie4()
{
}

int main()
{
    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)");
    char wybor = 0;
    do
    {
        printf("\n0- Wyjscie z programu\n1- Zadanie 1\n2- Zadanie 2\n3- Zadanie 3\n4- Zadanie 4\n\n");
        scanf("%hhu", &wybor);

        switch (wybor)
        {
        case 0:
            printf("Do widzenia");
            break;
        case 1:
            /*
                Zadanie 1
            */
            zadanie1();
            break;
        case 2:
            /*
                Zadanie 2
            */
            zadanie2();
            break;
        case 3:
            /*
                Zadanie 3
            */
            zadanie3();
            break;
        case 4:
            /*
                Zadanie 4
            */
            zadanie4();
            break;

        default:
            printf("Zly Wybor");
            break;
        }
    } while (wybor != 0);

    return 0;
}