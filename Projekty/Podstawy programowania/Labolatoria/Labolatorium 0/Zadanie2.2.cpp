/*
Autor:  Dawid Jabłoński
Grupa:  WT/NP 11.15
Temat:  Zadanie 2 wariant 2 stdio.h z Laboratorium 0
Data:   4 października 2022r.
*/

#include <stdio.h>

using namespace std;

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    printf("Autor: Dawid Jabłoński (WT/NP 11:15) \n\n\n");

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
    printf("Srednia arytmetyczna: %f \n", (float)(a + b + c) / 3);
}