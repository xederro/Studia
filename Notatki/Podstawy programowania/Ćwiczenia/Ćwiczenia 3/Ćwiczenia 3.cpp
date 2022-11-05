#include <iostream>

#define N 10

using namespace std;

int main()
{
    int tab[N];
    // a
    for (int i = 0; i < N; i++)
    {
        srand(time(NULL));
        tab[i] = rand() % (50 + 30 + 1) - 30;
    }

    // b
    int suma = 0;
    for (int i : tab)
    {
        suma += i;
    }
    cout << "Srednia: " << (float)suma / N << endl;

    // c
    int suma = 0;
    char ilosc = 0;
    for (int i : tab)
    {
        if (i % 2 == 1)
        {
            ilosc++;
            suma += i;
        }
    }
    cout << "Srednia liczb nieparzystych: " << (float)suma / ilosc << endl;

    // d

    return 0;
}