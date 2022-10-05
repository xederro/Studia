/*
Autor:  Dawid Jabłoński
Grupa:  WT/NP 11.15
Temat:  Zadanie 3 wariant 2 iostream z Laboratorium 0
Data:   4 października 2022r.
*/

#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    cout << "Autor: Dawid Jabłoński (WT/NP 11:15) \n\n\n";

    // Deklaracja zmiennych
    float r;

    // Pobieranie danych od użytkownika
    cout << "Podaj wartosc a: \n";
    cin >> r;

    // Wyświetlanie obwodu i promienia
    cout << "Obwod: " << 2 * M_PI * r << endl;
    cout << "Iloczyn: " << M_PI * r * r << endl;
}