/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytuł:  Zadania Laboratorium 0
Data:   8 października 2022r.
*/

#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

void zadanie1a()
{
    /*
    Zadanie 1 Podpunkt A
    iostream
    */
    cout << "\n\n\nZadanie 1 Poepunkt B iostream\n\n";

    cout << "Dawid Jabłoński" << endl;
    cout << "Edwarda Wittiga 6, \n51-628 Wrocław" << endl;
    cout << "+48 643 938 263" << endl;
    cout << "student@example.com" << endl;
}

void zadanie1b()
{
    /*
    Zadanie 1 Podpunkt B
    stdio.h
    */
    printf("\n\n\nZadanie 1 Podpunkt B stdio.h\n\n");

    printf("Adam Kowalski\n");
    printf("Janiszewskiego 11/17, \n50-372 Wrocław\n");
    printf("+48 123 456 789\n");
    printf("admin@example.com\n");
}

void zadanie2a()
{
    /*
    Zadanie 2 Wariant 1
    iostream
    */
    cout << "\n\n\nZadanie 2 Wariant 1 iostream\n";

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
}

void zadanie2b()
{
    /*
    Wariant 2
    stdio.h
    */
    printf("\n\n\nZadanie 2 Wariant 2 stdio.h\n");

    // Deklaracja zmiennych
    int a, b, c;

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
}

void zadanie3a()
{
    /*
    Wariant 1
    stdio.h
    */
    printf("\n\n\nWariant 1 stdio.h\n");

    // Deklaracja zmiennych
    float r;

    // Pobieranie danych od użytkownika
    printf("Podaj wartosc promienia kola: ");
    scanf("%f", &r);

    // Wyświetlanie obwodu i promienia
    printf("Obwod: %f \n", 2 * M_PI * r);
    printf("Iloczyn: %f \n", M_PI * r * r);
}

void zadanie3b()
{
    /*
    Wariant 2
    iostream
    */
    printf("\n\n\nWariant 2 iostream\n");

    // Deklaracja zmiennych
    float r;

    // Pobieranie danych od użytkownika
    cout << "Podaj wartosc promienia kola: \n";
    cin >> r;

    // Wyświetlanie obwodu i promienia
    cout << "Obwod: " << 2 * M_PI * r << endl;
    cout << "Iloczyn: " << M_PI * r * r << endl;
}

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    printf("Autor: Dawid Jabłoński (WT/N 11:15)");

    /*
    Zadanie 1 Podpunkt A
    iostream
    */
    zadanie1a();
    system("PAUSE");

    /*
    Zadanie 1 Podpunkt B
    stdio.h
    */
    zadanie1b();
    system("PAUSE");

    /*
    Zadanie 2 Wariant 1
    iostream
    */
    zadanie2a();
    system("PAUSE");

    /*
    Zadanie 2 Wariant 2
    stdio.h
    */
    zadanie2b();
    system("PAUSE");

    /*
    Zadanie 3 Wariant 1
    stdio.h
    */
    zadanie3a();
    system("PAUSE");

    /*
    Zadanie 3 Wariant 2
    iostream
    */
    zadanie3b();
    system("PAUSE");

    return 0;
}