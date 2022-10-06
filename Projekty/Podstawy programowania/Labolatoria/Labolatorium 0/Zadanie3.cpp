/*
Autor:  Dawid Jabłoński
Grupa:  WT/NP 11.15
Tytuł:  Zadanie 3, Laboratorium 0
Data:   6 października 2022r.
*/

#include <stdio.h>
#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    printf("Autor: Dawid Jabłoński (WT/NP 11:15)");

    // Deklaracja zmiennych
    float r;

    /*
    Wariant 1
    stdio.h
    */
    printf("\n\n\nWariant 1 stdio.h\n");

    // Pobieranie danych od użytkownika
    printf("Podaj wartosc promienia kola: ");
    scanf("%f", &r);

    // Wyświetlanie obwodu i promienia
    printf("Obwod: %f \n", 2 * M_PI * r);
    printf("Iloczyn: %f \n", M_PI * r * r);

    system("PAUSE");
    /*
    Wariant 2
    iostream
    */
    printf("\n\n\nWariant 2 iostream\n");

    // Pobieranie danych od użytkownika
    cout << "Podaj wartosc promienia kola: \n";
    cin >> r;

    // Wyświetlanie obwodu i promienia
    cout << "Obwod: " << 2 * M_PI * r << endl;
    cout << "Iloczyn: " << M_PI * r * r << endl;

    return 0;
}