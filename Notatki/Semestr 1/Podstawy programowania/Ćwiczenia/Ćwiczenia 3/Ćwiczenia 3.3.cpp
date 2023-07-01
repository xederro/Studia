#include <iostream>
#include <ctime>

#define N 100

using namespace std;

int main()
{
    srand(time(NULL));
    double tab[N];

    // a
    for (char i = 0; i < N; i++)
    {
        tab[i] = (double)(rand()) / ((double)(RAND_MAX / (50 + 30))) - 30;
        cout << tab[i] << " ";
    }
    cout << endl;

    // b
    double suma = 0;
    for (char i : tab)
    {
        suma += i;
    }
    cout << "Srednia: " << suma / N << endl;

    // c
    suma = 0;
    char ilosc = 0;
    for (char i : tab)
    {
        if (i % 2 == 1)
        {
            ilosc++;
            suma += i;
        }
    }

    if (ilosc == 0)
    {
        cout << "Brak liczb nieparzystych" << endl;
    }
    else
    {
        cout << "Srednia liczb nieparzystych: " << suma / ilosc << endl;
    }

    // d
    bool rosnaca = true;
    for (char i = 1; i < N; i++)
    {
        if (tab[i] >= tab[i - 1])
            continue;
        else
        {
            rosnaca = false;
            break;
        }
    }
    if (rosnaca)
        cout << "Tablica jest posortowana rosnaco" << endl;
    else
        cout << "Tablica nie jest posortowana rosnaco" << endl;

    // e
    bool powtorzenie = false;
    for (char i = 0; i < N; i++)
    {
        for (char j = 0; j < N; j++)
        {
            if (i == j)
                continue;
            if (tab[i] == tab[j])
            {
                cout << "Tablica zawiera powtorzenia" << endl;
                powtorzenie = true;
                break;
            }
        }
        if (powtorzenie)
            break;
    }

    // f
    double min = tab[0];
    char index = 0;
    for (char i = 1; i < N; i++)
    {
        if (tab[i] < min)
        {
            min = tab[i];
            index = i;
        }
    }
    cout << "Najmniejsza wartosc ma indeks " << (int)index << endl;

    // g
    for (char i = 0; i < N; i++)
    {
        if (tab[i] < 0)
        {
            cout << "Liczba ujemna znajduje sie w tablicy na indeksie: " << (int)i << endl;
        }
    }

    // h
    double max = tab[0];
    for (char i : tab)
    {
        if (i > max)
            max = i;
    }
    cout << "Najwieksza wartosc w tablicy: " << max << endl;

    return 0;
}