/*
Autor:  Dawid Jabłoński
Grupa:  PN/NP 11.15
Temat:
Data:   4 października 2022r.
*/

#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    printf("Autor: Dawid Jabłoński (WT/NP 11:15) \n\n");

    // Deklaracja zmiennych lokalnych typu int i float
    int a;
    float b;

    // Przypisanie zmiennycm warto��i pocz�tkowych
    a = 2;
    b = 3.5;

    // PRZYK�AD PIERWSZY
    // Drukowanie komunikat�w z wykorzystaniem biblioteki iostream   (Tylko C++)
    cout << "To jest przyklad uzycia biblioteki iostream. " << endl;
    cout << "Zmienna a ma wartosc " << a << endl;
    cout << "Zmienna b ma wartosc " << b << endl;
    cout << "suma a+b wynosi " << a + b << endl
         << endl;

    // Wczytywanie danych z wykorzystaniem biblioteki iostream    (Tylko C++)
    cout << "Podaj nowa wartosc a: ";
    cin >> a;
    cout << "Podaj nowa wartosc b: ";
    cin >> b;
    cout << "Suma a+b wynosi " << a + b << endl;

    system("PAUSE");

    // PRZYK�AD DRUGI
    // Drukowanie komunikat�w z wykorzystaniem biblioteki stdio.h    (C , C++)
    printf("\n");
    printf("To jest przyklad uzycia biblioteki stdio.h. \n");
    printf("Zmienna a ma wartosc %d \n", a);
    printf("Zmienna b ma wartosc %f \n", b);
    printf("Suma a+b wynosi %f \n\n", a + b);

    printf("Podaj nowa wartosc a: ");
    scanf("%d", &a);
    printf("Podaj nowa wartosc b: ");
    scanf("%f", &b);
    printf("Suma a+b wynosi %f \n\n", a + b);

    system("PAUSE");

    return 0;
}