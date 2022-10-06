/*
Autor:  Dawid Jabłoński
Grupa:  WT/NP 11.15
Tytuł:  Zadanie 2, Laboratorium 0
Data:   6 października 2022r.
*/

#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    cout << "Autor: Dawid Jabłoński (WT/NP 11:15)";

    /*
    Wariant 1
    iostream
    */
    printf("\n\n\nWariant 1 iostream\n");

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
    cout << "Srednia arytmetyczna: " << (a + b + c) / 3.0 << endl;

    system("PAUSE");
    /*
    Wariant 2
    stdio.h
    */
    printf("\n\n\nWariant 2 stdio.h\n");

    // Pobieranie danych od użytkownika
    printf("Podaj wartosc a: ");
    scanf("%d", &a);
    printf("Podaj wartosc b: ");
    scanf("%d", &b);
    printf("Podaj wartosc c: ");
    scanf("%d", &c);

    // Wyświetlanie odpowiednich obliczeń
    printf("Suma: %d \n", a + b + c);
    printf("Iloczyn: %d \n", a * b * c);
    printf("Srednia arytmetyczna: %f \n", (a + b + c) / 3.0);

    return 0;
}