/*
Autor:  Dawid Jabłoński
Grupa:  WT/NP 11.15
Temat:  Zadanie 3 wariant 1 stdio.h z Laboratorium 0
Data:   4 października 2022r.
*/

#include <stdio.h>
#include <math.h>

using namespace std;

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    printf("Autor: Dawid Jabłoński (WT/NP 11:15) \n\n\n");

    // Deklaracja zmiennych
    float r;

    // Pobieranie danych od użytkownika
    printf("Podaj wartosc a: ");
    scanf("%f", &r);

    // Wyświetlanie obwodu i promienia
    printf("Obwod: %f \n", 2 * M_PI * r);
    printf("Iloczyn: %f \n", M_PI * r * r);
}