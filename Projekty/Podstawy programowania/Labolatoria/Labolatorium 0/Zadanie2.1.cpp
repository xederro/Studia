/*
Autor:  Dawid Jabłoński
Grupa:  WT/NP 11.15
Temat:  Zadanie 2 wariant 1 iostream z Laboratorium 0
Data:   4 października 2022r.
*/

#include <iostream>

using namespace std;

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    cout << "Autor: Dawid Jabłoński (WT/NP 11:15) \n\n\n";

    // Deklaracja zmiennych
    int a, b, c;

    // Pobieranie danych od użytkownika
    cout << "Podaj wartosc a: ";
    cin >> a;
    cout << "Podaj wartosc b: ";
    cin >> b;
    cout << "Podaj wartosc c: ";
    cin >> c;

    // Wyświetlanie odpowiednich obliczeń
    cout << "Suma: " << a + b + c << endl;
    cout << "Iloczyn: " << a * b * c << endl;
    cout << "Srednia arytmetyczna: " << (float)(a + b + c) / 3 << endl;
}