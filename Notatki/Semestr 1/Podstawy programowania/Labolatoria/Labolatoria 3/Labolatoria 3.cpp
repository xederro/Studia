/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadania Laboratorium 3
Data:   8 listopada 2022r.
*/

#include <iostream>
#include <stdlib.h>

#define ROZMIAR 5 // rozmiar tablicy

using namespace std;

void zadanie1a(float* tab) // wpisywanie elementów do tablicy
{
    for (unsigned char i = 0; i < ROZMIAR; i++)
    {
        cout << "tab[" << (int)i << "]: ";
        cin >> tab[i];
    }
}

void zadanie1b(float* tab) // wypisanie elementów tablicy
{
    cout << "[ ";
    for (unsigned char i = 0; i < ROZMIAR; i++)
    {
        cout << tab[i] << " ";
    }
    cout << "]" << endl;
}

void zadanie1c(float* tab) // sprawdzi i wypisze na ekranie komunikaty
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

    // wypisze na ekranie komunikaty o ilości i sumie dodatnich i ujemnych elementów tablicy
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

void zadanie1d(float* tab) // informację o uporządkowaniu elementów tablicy
{
    unsigned char rosnace = 0,
        jednakowa = 0,
        malejace = 0;

    for (unsigned char i = 0; i < ROZMIAR - 1; i++) // sprawdza czy elementy tablicy są rosnące, malejące lub jednakowe
    {
        if (tab[i] < tab[i + 1])
            rosnace++;
        if (tab[i] == tab[i + 1])
            jednakowa++;
        if (tab[i] > tab[i + 1])
            malejace++;
    }


    // wypisze na ekranie komunikaty o uporządkowaniu elementów tablicy
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

void zadanie1(float* tab)
{
    unsigned short int sortowanie = 0;
    do
    {
        cout << "\n0- Wyjscie z zadania\n1- Wpisanie elementow\n2- Wypisanie elementow\n3- Informacja o liczbach dodatnich i ujemnych \n4- Informacja o uporzadkowaniu\n\n";
        cin >> sortowanie;

        switch (sortowanie)
        {
        case 0:
            break;
        case 1:
            // wpisywanie elementów do tablicy
            zadanie1a(tab);
            break;
        case 2:
            // wypisanie elementów tablicy
            zadanie1b(tab);
            break;
        case 3:
            // sprawdzi i wypisze na ekranie komunikaty
            zadanie1c(tab);
            break;
        case 4:
            // informację o uporządkowaniu elementów tablicy
            zadanie1d(tab);
            break;

        default:
            cout << "Zly Wybor";
            break;
        }
    } while (sortowanie != 0);
}

void zadanie2(float* tab)
{
    // wpisywanie losowych elementów z przedziału do tablicy
    float min, max;

    cout << "Wpisz minimalna liczbe z przedzialu: ";
    cin >> min;
    cout << "Wpisz maksymalna liczbe z przedzialu: ";
    cin >> max;

    for (int i = 0; i < ROZMIAR; i++)
    {
        tab[i] = min + (max - min) * rand() / ((double)RAND_MAX);
    }

    zadanie1b(tab);
}

void sortowaniePrzezWstawianie(float* tab)
{
    // sortowanie przez wstawianie
    cout << "Sortowanie przez wstawianie: " << endl;
    for (short int i = 1; i < ROZMIAR; i++)
    {
        float temp = tab[i];
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
    zadanie1b(tab);
}

void sortowaniePrzezWybor(float* tab)
{
    // sortowanie przez wybór
    cout << "Sortowanie przez wybor: " << endl;
    for (short int i = 0; i < ROZMIAR; i++)
    {
        short int index = i;
        float value = tab[i];
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
    zadanie1b(tab);
}

void sortowanieBabelkowe(float* tab)
{
    // sortowanie bąbelkowe
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
                float temp = tab[i + 1];
                tab[i + 1] = tab[i];
                tab[i] = temp;
            }
        }
    } while (sorted < ROZMIAR);
    zadanie1b(tab);
}

void zadanie3(float* tab)
{
    // wybór sposobu sortowania
    unsigned short int sortowanie = 0;
    do
    {
        cout << "\n0- Wyjscie z zadania\n1- Sortowanie Babelkowe\n2- Sortowanie przez Wybor\n3- Sortowanie przez Wstawianie\n\n";
        cin >> sortowanie;

        switch (sortowanie)
        {
        case 0:
            break;
        case 1:
            /*
                Sortowanie bąbelkowe
            */
            sortowanieBabelkowe(tab);
            break;
        case 2:
            /*
                Sortowanie przez wybór
            */
            sortowaniePrzezWybor(tab);
            break;
        case 3:
            /*
                sortowanie przez wstawianie
            */
            sortowaniePrzezWstawianie(tab);
            break;

        default:
            cout << "Zly Wybor";
            break;
        }
    } while (sortowanie != 0);
}

int main()
{
    srand(time(NULL));
    float tab[ROZMIAR]; // inicjalizacja tablicy

    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)");


    // wybór zadania
    unsigned short int wybor = 0;
    do
    {
        cout << "\n0- Wyjscie z programu\n1- Zadanie 1\n2- Zadanie 2\n3- Zadanie 3\n\n";
        cin >> wybor;

        switch (wybor)
        {
        case 0:
            cout << "Do widzenia";
            break;
        case 1:
            /*
                Zadanie 1
            */
            zadanie1(tab);
            break;
        case 2:
            /*
                Zadanie 2
            */
            zadanie2(tab);
            break;
        case 3:
            /*
                Zadanie 3
            */
            zadanie3(tab);
            break;

        default:
            cout << "Zly Wybor";
            break;
        }
    } while (wybor != 0);

    return 0;
}