/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadania Laboratorium 2
Data:   25 października 2022r.
*/

#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

void zadanie1()
{
    unsigned char wiersz, kolumna;
    do
    {
        printf("Podaj wiersz: ");
        scanf("%hhu", &wiersz);
        printf("Podaj kolumne: ");
        scanf("%hhu", &kolumna);
    } while (wiersz == 0 || kolumna == 0);

    for (unsigned char i = 0; i <= wiersz; i++)
    {
        if (i == 0)
            printf("   ");
        else
            printf("%3d ", i);
    }
    printf("\n");

    for (unsigned char i = 1; i <= wiersz; i++)
    {
        printf("%3d", i);
        for (unsigned char j = 1; j <= kolumna; j++)
        {
            printf("%3d ", i * j);
        }
        printf("\n");
    }
}
// zadanie 2 suma cyfr zapisana w systemie trójkowym, zmienny system od binarnego do 60 modulo podstawa systemu, dzielenie przez podstawe systemu
// zadanie 4 rozpisać i nie liczyć niepotrzebnych rzeczy jak k!
// średnia z 0 liczb dodatnich nie jest równa 0
int main()
{
    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)");
    char wybor = 0;
    do
    {
        printf("0- Wyjscie z programu\n1- Zadanie 1\n2- Zadanie 2\n3- Zadanie 3\n4- Zadanie 4\n5- Zadanie 5\n\n");
        scanf("%hhu", &wybor);

        switch (wybor)
        {
        case 0:
            printf("Do widzenia");
            break;
        case 1:
            /*
                Zadanie 1
            */
            zadanie1();
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:
            break;
        case 5:
            break;

        default:
            printf("Zly Wybor");
            break;
        }
    } while (wybor != '0');

    return 0;
}