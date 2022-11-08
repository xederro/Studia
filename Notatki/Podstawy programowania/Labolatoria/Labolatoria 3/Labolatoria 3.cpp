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
        cout << "tab[" << i << "]: ";
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
    unsigned char liczbad, liczbau = 0;
    float sumad, sumau = 0;

    for (unsigned char i = 0; i < ROZMIAR; i++)
    {
        }
}

void zadanie1()
{
    // wpisywanie elementów do tablicy
    zadanie1a();

    // wypisanie elementów tablicy
    zadanie1b();
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