#include <stdio.h>
#include <iostream>
#include <math.h>
#include <iomanip>

using namespace std;

int main()
{
    // Deklaracja zmiennych
    float rmin, rmax;
    unsigned char n;

    // Pobieranie danych od uzytkownika
    printf("Podaj minimalna wartosc promienia kola: \n");
    scanf("%f", &rmin);
    printf("Podaj maksymalna wartosc promienia kola: \n");
    scanf("%f", &rmax);
    printf("Podaj liczbe wierszy tabeli : \n");
    scanf("%hhu", &n);

    // Sprawdzane czy promienie sa poprawne
    if (rmin < 0 || rmax < 0)
    {
        printf("\n\nPODANY PROMIEN JEST NIEPOPRAWNY! \n");
        return -1;
    }

    // Poprawienie kolejnosci promieniow gdyby byla zla
    if (rmax < rmin)
    {
        float temp_r = rmax;
        rmax = rmin;
        rmin = temp_r;
    }

    // Zmienna pomocnicza okreslajaca zmiane promienia na kazdym wierszu tabeli
    float delta = 0;

    //
    if (rmax == rmin)
    {
        n = 1;
    }
    else
    {
        /*
        Upewnienie sie, ze wydrukowanie tabeli ma sens,
        czyli nie ma 0 rzedow albo 1 rzedu przy 2 promieniach
        */

        if (n < 2)
            n = 2;

        delta = (rmax - rmin) / (n - 1);
    }

    // Drukowanie tabeli
    printf("==========================================\n");
    printf("| Lp | Promien | Obwod kola | Pole kola  |\n");
    printf("==========================================\n");

    for (unsigned char i = 1; i <= n; i++)
    {
        float temp_r = rmin + delta * (i - 1);
        printf("|%3hhu | %7.2f | %10.2f | %10.2f |\n", i, temp_r, 2 * M_PI * temp_r, M_PI * temp_r * temp_r);
    }
    printf("==========================================\n");

    // Drukowanie tabeli iostream
    cout << "==========================================\n";
    cout << "| Lp | Promien | Obwod kola | Pole kola  |\n";
    cout << "==========================================\n";

    for (unsigned char i = 1; i <= n; i++)
    {
        float temp_r = rmin + delta * (i - 1);

        cout << "|" << setw(3) << (int)i << " | " << setw(7) << setprecision(2) << fixed << temp_r << " | " << setw(10) << setprecision(2) << fixed << 2 * M_PI * temp_r << " | " << setw(10) << setprecision(2) << fixed << M_PI * temp_r * temp_r << " |\n";
    }

    cout << "==========================================\n";

    return 0;
}