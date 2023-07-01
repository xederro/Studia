/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadania Laboratorium 1
Data:   14 października 2022r.
*/

#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

void zadanie1()
{
    /*
    Zadanie 1
    */

    cout << "\n\n\nZadanie 1\n";

    // Definiujemy 3 zmienne
    float a, b, c;

    // Wprowadzamy dane
    cout << "Wpisz A,B,C bedace wspolczynnikami rownania kwadratowego : Ax2 + Bx + C = 0" << endl;
    cin >> a >> b >> c;

    // Bledne dane, a==0
    if (a == 0)
    {
        cout << "Nie jest to rownanie kwadratowe" << endl;
        return;
    }

    // Liczymy delte i sprawdzamy czy jest ona wieksza, rowna lub mniejsza od 0
    float delta = (b * b) - (4 * a * c);

    if (delta > 0)
    {
        float x1, x2;
        x1 = (-b - sqrt(delta)) / (2 * a);
        x2 = (-b + sqrt(delta)) / (2 * a);

        cout << "Sa dwa rozwiazania: " << x1 << " oraz " << x2 << endl;
    }
    else if (delta == 0)
    {
        float x;
        x = (-b - sqrt(delta)) / (2 * a);

        cout << "Jest jedno rozwiazanie: " << x << endl;
    }
    else
    {
        cout << "Brak pierwiastkow rzeczywistych" << endl;
    }
}

// Funkcja zwraca true jezeli rok jest przystepny
bool jestPrzystepny(unsigned short rok)
{
    /*
    rok  nie  jest  przestepny  (rok  zwykly)  jesli:
        - nie dzieli sie przez 4
        - lub dzieli sie przez 100, ale nie dzieli sie przez 400.
    */
    return !(rok % 4 != 0 || (rok % 100 == 0 && rok % 400 != 0));
}

void zadanie2()
{
    /*
    Zadanie 2
    */
    printf("\n\n\nZadanie 2\n");

    unsigned char dz, msc;
    unsigned short rok;

    // Pobieranie danych od uzytkownika
    printf("Podaj dzien: ");
    scanf("%hhu", &dz);
    printf("Podaj miesiac: ");
    scanf("%hhu", &msc);
    printf("Podaj rok: ");
    scanf("%hu", &rok);

    // Wyswietlanie daty
    printf("Data: %02d/%02d/%04d\n", dz, msc, rok);

    switch (msc)
    {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
        // Sprawdzenie czy dzien nalezy do miesiaca
        if (dz > 31 || dz < 0)
        {
            printf("Nie jest to poprawna data\n");
            return;
        }
        break;

    case 4:
    case 6:
    case 9:
    case 11:
        // Sprawdzenie czy dzien nalezy do miesiaca
        if (dz > 30 || dz < 0)
        {
            printf("Nie jest to poprawna data\n");
            return;
        }
        break;

    case 2:
        // Sprawdzenie czy dzien nalezy do miesiaca w zaleznosci od roku parzystego
        if (dz > 28 + jestPrzystepny(rok) || dz < 0)
        {
            printf("Nie jest to poprawna data\n");
            return;
        }
        break;

    default:
        // Zly miesiac
        printf("Nie jest to poprawna data\n");
        return;
        break;
    }

    printf("Jest to poprawna data\n");
}

void zadanie3()
{
    /*
    Zadanie 3
    */

    cout << "\n\n\nZadanie 3\n";

    // Definiujemy 3 zmienne
    float a, b, c;

    // Wprowadzamy dane
    cout << "Wpisz trzy dlugosci odcinkow" << endl;
    cin >> a >> b >> c;

    // Warunek budowy trojkata
    if (!(a + b > c && a + c > b && c + b > a))
    {
        cout << "Nie mozna zbudowac trojkata" << endl;
        return;
    }

    // Sprawdzamy wlasnosci tego trojkata
    if (a == b || b == c || c == a)
    {
        cout << "Trojkat jest rownoramienny" << endl;
    }
    if (a == b && b == c)
    {
        cout << "Trojkat jest rownoboczny" << endl;
    }

    if (a * a + b * b == c * c || a * a + c * c == b * b || c * c + b * b == a * a)
    {
        cout << "Trojkat jest prostokatny" << endl;
    }
    else if ((a * a + b * b > c * c && a * a + c * c > b * b && c * c + b * b > a * a))
    {
        cout << "Trojkat jest ostrokatny" << endl;
    }
    else
    {
        cout << "Trojkat jest rozwartokatny" << endl;
    }
}

void zadanie4()
{
    /*
    Wariant 4
    */
    printf("\n\n\nWariant 4\n");

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
        return;
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
}

int main()
{
    // OBOWIaZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)");

    /*
    Zadanie 1
    */
    zadanie1();
    system("PAUSE");

    /*
    Zadanie 2
    */
    zadanie2();
    system("PAUSE");

    /*
    Zadanie 3
    */
    zadanie3();
    system("PAUSE");

    /*
    Zadanie 4
    */
    zadanie4();
    system("PAUSE");

    return 0;
}