#include <iostream>
#define N 100

using namespace std;

float tab[N] = {0};

void wypisz_wyniki()
{
    for (float i : tab)
    {
        cout << i << " ";
    }
    cout << endl;
}

void wyczysc_tablice()
{
    for (char i = 0; i < N; i++)
    {
        tab[i] = 0;
    }
    cout << "Tablica wyczyszczona" << endl;
}

void dodaj_wynik()
{
    float wynik = 0;
    cout << "Podaj wynik: ";
    do
    {
        cin >> wynik;
    } while (wynik <= 0);

    for (char i = 0; i < N; i++)
    {
        if (tab[i] <= wynik)
        {
            for (char j = i; j < N - 1; j++)
            {
                tab[j + 2] = tab[j + 1];
            }
            tab[i] = wynik;
            break;
        }
    }
}

int main()
{
    uint8_t wybor = 0;
    do
    {
        cout << "0. Zakoncz" << endl;
        cout << "1. Wypisz wyniki" << endl;
        cout << "2. Dodaj wynik" << endl;
        cout << "3. Wyczysc tablice" << endl;
        cin >> wybor;
        cout << wybor << endl;
    } while (wybor != 0);

    return 0;
}