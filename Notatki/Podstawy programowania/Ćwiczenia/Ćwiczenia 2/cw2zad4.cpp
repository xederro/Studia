#include <iostream>
#include <math.h>

using namespace std;

unsigned int silnia(unsigned int n)
{
    unsigned int silnia = 1;
    for (unsigned int i = 1; i < n; i++)
    {
        silnia *= i;
    }
    return silnia;
}

int main()
{
    double eps = 1, suma1 = 0, suma2 = 0;

    while (eps > 0.1)
    {
        cout << "Podaj dokladnosc obliczen mniejsza od 0.1: ";
        cin >> eps;
    }

    // obliczanie sumy szeregu pierwszego
    for (unsigned int k = 1; (1.0 / (2 * k - 1)) >= eps; k++)
    {
        suma1 += pow((-1), (k + 1)) / (2 * k - 1);
    }
    suma1 *= 4;

    // obliczanie sumy szeregu drugiego
    for (unsigned int k = 1; (1.0 / silnia(k)) >= eps; k++)
    {
        suma2 += 1.0 / silnia(k);
    }

    cout << "Suma pierwszego szeregu wynosi: " << suma1 << endl;
    cout << "Suma drugiego szeregu wynosi: " << suma2 << endl;
    return 0;
}