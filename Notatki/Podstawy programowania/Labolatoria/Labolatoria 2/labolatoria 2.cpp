/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadania Laboratorium 2
Data:   31 października 2022r.
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
        printf("Podaj liczbe wierszy: ");
        scanf("%hhu", &wiersz);
        printf("Podaj liczbe kolumn: ");
        scanf("%hhu", &kolumna);
    } while (wiersz == 0 || kolumna == 0);

    for (unsigned char j = 0; j < 2; j++)
    {
        for (unsigned char i = 0; i <= kolumna; i++)
        {
            if (j)
                printf("----");
            else if (i == 0)
                printf("    |");
            else
                printf("%3d ", i);
        }
        printf("\n");
    }

    for (unsigned char i = 1; i <= wiersz; i++)
    {
        printf("%3d |", i);
        for (unsigned char j = 1; j <= kolumna; j++)
        {
            printf("%3d ", i * j);
        }
        printf("\n");
    }
}

void zadanie2()
{
    unsigned long int liczba;
    unsigned char system;
    unsigned int suma = 0;

    do
    {
        printf("Podaj liczbe: ");
        scanf("%lu", &liczba);
    } while (!liczba);

    do
    {
        printf("Podaj system liczbowy: ");
        scanf("%hhu", &system);
    } while (system < 2 || system > 65);

    do
    {
        suma += liczba % system;
        liczba /= system;
    } while (liczba);

    printf("Suma cyfr z ktorych sklada sie ta liczba w systemie (%hhu) jest rowna: %u", system, suma);
    // 525 = 1000010101
    // 525 = 1015
    // 525 = 379
    // 525 = 0x20D
}

void zadanie3()
{
    int a, b;
    do
    {
        printf("Podaj a: ");
        scanf("%d", &a);
        printf("Podaj b: ");
        scanf("%d", &b);
    } while (a == 0 || b == 0);

    printf("Dla liczb a = %d i b = %d:\n", a, b);
    // nwd
    int i;

    for ((a > b) ? i = a : i = b; i > 0; i--)
    {
        if (a % i == 0 && b % i == 0)
        {
            printf("najwiekszy wspolny dzielnik nwd wynosi %d\n", i);
            break;
        }
    }

    // nww
    for (i = 1; i <= fabs(a * b); i++)
    {
        if (i % a == 0 && i % b == 0)
        {
            printf("najmniejsza wspolna wielokrotnosc nww wynosi %d\n", i);
            break;
        }
    }
}

// zadanie 4 rozpisać i nie liczyć niepotrzebnych rzeczy jak k!
void zadanie4()
{
    double eps = 1, suma1 = 0, suma2 = 0, wartosc = 1;

    while (eps > 0.1)
    {
        printf("Podaj dokladnosc obliczen mniejsza od 0.1: ");
        scanf("%lf", &eps);
    }

    // obliczanie sumy szeregu pierwszego
    for (unsigned int k = 1; fabs(1.0 / (2 * k - 1)) >= eps; k++)
    {
        if (k % 2 == 0)
            suma1 -= 1.0 / (2 * k - 1);
        else
            suma1 += 1.0 / (2 * k - 1);
    }
    suma1 *= 4;

    // obliczanie sumy szeregu drugiego
    for (unsigned int k = 1; (wartosc / k) >= eps; k++)
    {
        suma2 += wartosc;
        wartosc /= k;
    }

    printf("Suma pierwszego szeregu wynosi: %.16lf\n", suma1);
    printf("Suma drugiego szeregu wynosi: %.16lf\n", suma2);
}

void zadanie5()
{
    short int min, max;
    unsigned long long int sumd = 0, sumu = 0;
    unsigned short int n, countd = 0, countu = 0;
    srand(time(NULL));
    printf("Wpisz minimalna liczbe z przedzialu ");
    scanf("%hd", &min);
    printf("Wpisz maksymalna liczbe z przedzialu ");
    scanf("%hd", &max);
    printf("Wpisz ilosc liczb do wylosowania ");
    scanf("%hu", &n);

    while (n--)
    {
        int random = min + rand() % (max - min + 1);

        if (random < 0)
        {
            sumu -= random;
            countu++;
        }
        else
        {
            sumd += random;
            countd++;
        }
    }

    if (countd != 0)
    {
        printf("Suma liczb dodatnich wynosi: %lu\n", sumd);
        printf("Srednia liczb dodatnich wynosi %f\n", (float)sumd / countd);
    }
    else
        printf("Nie bylo liczb dodatnich\n");

    if (countu != 0)
    {
        printf("Suma liczb ujemnych wynosi: -%lu\n", sumu);
        printf("Srednia liczb ujemnych wynosi -%f\n", (float)sumu / countu);
    }
    else
        printf("Nie bylo liczb ujemnych\n");
}

// średnia z 0 liczb dodatnich nie jest równa 0
int main()
{
    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)");
    char wybor = 0;
    do
    {
        printf("\n0- Wyjscie z programu\n1- Zadanie 1\n2- Zadanie 2\n3- Zadanie 3\n4- Zadanie 4\n5- Zadanie 5\n\n");
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
            /*
                Zadanie 2
            */
            zadanie2();
            break;
        case 3:
            /*
                Zadanie 3
            */
            zadanie3();
            break;
        case 4:
            /*
                Zadanie 4
            */
            zadanie4();
            break;
        case 5:
            /*
                Zadanie 5
            */
            zadanie5();
            break;

        default:
            printf("Zly Wybor");
            break;
        }
    } while (wybor != 0);

    return 0;
}