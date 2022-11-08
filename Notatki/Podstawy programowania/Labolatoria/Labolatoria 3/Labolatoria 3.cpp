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

float tab[ROZMIAR] = {0}; // wstawić do main i funkcje zrobić z parametrem wskaźnikiem

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
        cout << "Ilosc liczb dodatnich: " << (int)iloscd << endl;
        cout << "Suma liczb dodatnich: " << sumad << endl;
        cout << "Srednia liczb dodatnich: " << sumad / iloscd << endl;
    }
    else
    {
        cout << "Nie ma liczb dodatnich." << endl;
    }

    if (iloscu)
    {
        cout << "Ilosc liczb ujemnych: " << (int)iloscu << endl;
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
    unsigned char rosnace = 0,
                  jednakowa = 0,
                  malejace = 0;

    for (unsigned char i = 0; i < ROZMIAR - 1; i++)
    {
        if (tab[i] < tab[i + 1])
            rosnace++;
        if (tab[i] == tab[i + 1])
            jednakowa++;
        if (tab[i] > tab[i + 1])
            malejace++;
    }

    if (rosnace == ROZMIAR - 1)
        cout << "Tablica jest posortowana rosnaco" << endl;
    else if (jednakowa == ROZMIAR - 1)
        cout << "Tablica ma jednakowa wartosc" << endl;
    else if (malejace == ROZMIAR - 1)
        cout << "Tablica jest posortowana malejaco" << endl;
    else if (rosnace + jednakowa == ROZMIAR - 1)
        cout << "Tablica jest posortowana niemalejaco" << endl;
    else if (malejace + jednakowa == ROZMIAR - 1)
        cout << "Tablica jest posortowana nierosnaca" << endl;
    else
        cout << "Tablica jest nie posortowana" << endl;
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

void sortowaniePrzezWstawianie()
{
    cout << "Sortowanie przez wstawianie: " << endl;
    for (short int i = 1; i < ROZMIAR; i++)
    {
        short int temp = tab[i];
        for (short int j = i; j >= 0; j--)
        {
            if ((j - 1 == -1) || tab[j - 1] <= temp)
            {
                tab[j] = temp;
                break;
            }
            else
            {
                tab[j] = tab[j - 1];
            }
        }
    }
    zadanie1b();
}

void sortowaniePrzezWybor()
{
    cout << "Sortowanie przez wybor: " << endl;
    for (short int i = 0; i < ROZMIAR; i++)
    {
        short int index = i, value = tab[i];
        for (short int j = i; j < ROZMIAR; j++)
        {
            if (value > tab[j])
            {
                value = tab[j];
                index = j;
            }
        }
        tab[index] = tab[i];
        tab[i] = value;
    }
    zadanie1b();
}

void sortowanieBabelkowe()
{
    cout << "Sortowanie babelkowe: " << endl;

    short int sorted;
    do
    {
        sorted = 1;
        for (short int i = 0; i < ROZMIAR - 1; i++)
        {
            if (tab[i] <= tab[i + 1])
            {
                sorted++;
            }
            else
            {
                short int temp = tab[i + 1];
                tab[i + 1] = tab[i];
                tab[i] = temp;
            }
        }
    } while (sorted < ROZMIAR);
    zadanie1b();
}

void zadanie3()
{
    // char wybor = 0;
    // do
    // {
    //     printf("\n0- Wyjscie z programu\n1- Zadanie 1\n2- Zadanie 2\n3- Zadanie 3\n4- Zadanie 4\n\n");
    //     scanf("%hhu", &wybor);

    //     switch (wybor)
    //     {
    //     case 0:
    //         break;
    //     case 1:
    //         /*
    //             Zadanie 1
    //         */
    //         zadanie1();
    //         break;
    //     case 2:
    //         /*
    //             Zadanie 2
    //         */
    //         zadanie2();
    //         break;
    //     case 3:
    //         /*
    //             Zadanie 3
    //         */
    //         zadanie3();
    //         break;

    //     default:
    //         printf("Zly Wybor");
    //         break;
    //     }
    // } while (1 < wybor < 4);
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