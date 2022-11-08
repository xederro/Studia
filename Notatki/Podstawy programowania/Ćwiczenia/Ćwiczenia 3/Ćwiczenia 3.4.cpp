#include <stdio.h>
#define N 100

using namespace std;

float tab[N] = {0};

void wypisz_wyniki()
{
    for (float i : tab)
    {
        if (i == 0.0)
            break;

        printf("%f\n", i);
    }
}

void wyczysc_tablice()
{
    for (char i = 0; i < N; i++)
    {
        tab[i] = 0;
    }
    printf("Tablica wyczyszczona\n");
}

void dodaj_wynik()
{
    float wynik = 0;
    printf("Podaj wynik: ");
    do
    {
        scanf("%f", &wynik);
    } while (wynik <= 0);

    for (char i = 0; i < N; i++)
    {
        if (tab[i] > wynik || tab[i] == 0)
        {
            for (char j = N - i; j >= i; j--)
            {
                tab[j] = tab[j - 1];
            }
            tab[i] = wynik;
            break;
        }
    }
}

int main()
{
    unsigned char wybor = 0;

    while (true)
    {
        printf("0. Zakoncz\n1. Wypisz wyniki\n2. Dodaj wynik\n3. Wyczysc tablice\n");

        scanf("%hhu", &wybor);

        switch (wybor)
        {
        case 0:
            return 0;
        case 1:
            wypisz_wyniki();
            break;
        case 2:
            dodaj_wynik();
            break;
        case 3:
            wyczysc_tablice();
            break;
        default:
            printf("Nie ma takiej opcji\n");
            break;
        }
    }

    return 0;
}