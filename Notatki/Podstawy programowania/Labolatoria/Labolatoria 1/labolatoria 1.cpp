/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytuł:  Zadania Laboratorium 0
Data:   8 października 2022r.
*/

#include <iostream>
#include <stdio.h>
// #include <math.h>

using namespace std;

// void zadanie1()
// {
//     /*
//     Zadanie 1
//     */

//     cout << "\n\n\nZadanie 1\n";

//     // Definiujemy 3 zmienne
//     float a, b, c;

//     // Wprowadzamy dane
//     cout << "Wpisz A,B,C będące współczynnikami równania kwadratowego : Ax2 + Bx + C = 0" << endl;
//     cin >> a >> b >> c;

//     // Błędne dane, a==0
//     if (a == 0)
//     {
//         cout << "Nie jest to równanie kwadratowe" << endl;
//         return;
//     }

//     // Liczymy delte i sprawdzamy czy jest ona większa, równa lub mniejsza od 0
//     float delta = (b * b) - (4 * a * c);

//     if (delta > 0)
//     {
//         float x1, x2;
//         x1 = (-b - sqrt(delta)) / (2 * a);
//         x2 = (-b + sqrt(delta)) / (2 * a);

//         cout << "Są dwa rozwiązania: " << x1 << " oraz " << x2 << endl;
//     }
//     else if (delta == 0)
//     {
//         float x;
//         x = (-b - sqrt(delta)) / (2 * a);

//         cout << "Jest jedno rozwiązanie: " << x << endl;
//     }
//     else
//     {
//         cout << "Brak pierwiastków rzeczywistych" << endl;
//     }
// }

// // Funkcja zwraca true jeżeli rok jest przystępny
// bool jestPrzystepny(unsigned short rok)
// {
//     /*
//     rok  nie  jest  przestępny  (rok  zwykły)  jeśli:
//         - nie dzieli się przez 4
//         - lub dzieli się przez 100, ale nie dzieli się przez 400.
//     */
//     return !(rok % 4 != 0 || (rok % 100 == 0 && rok % 400 != 0));
// }

// void zadanie2()
// {
//     /*
//     Zadanie 2
//     */
//     printf("\n\n\nZadanie 2\n");

//     unsigned char dz, msc;
//     unsigned short rok;

//     // Pobieranie danych od użytkownika
//     printf("Podaj dzień: ");
//     scanf("%hhu", &dz);
//     printf("Podaj miesiąc: ");
//     scanf("%hhu", &msc);
//     printf("Podaj rok: ");
//     scanf("%hu", &rok);

//     // Wyświetlanie daty
//     printf("Data: %02d/%02d/%04d\n", dz, msc, rok);

//     switch (msc)
//     {
//     case 1:
//     case 3:
//     case 5:
//     case 7:
//     case 8:
//     case 10:
//     case 12:
//         // Sprawdzenie czy dzień należy do miesiąca
//         if (dz > 31)
//         {
//             printf("Nie jest to poprawna data\n");
//             return;
//         }
//         break;

//     case 4:
//     case 6:
//     case 9:
//     case 11:
//         // Sprawdzenie czy dzień należy do miesiąca
//         if (dz > 30)
//         {
//             printf("Nie jest to poprawna data\n");
//             return;
//         }
//         break;

//     case 2:
//         // Sprawdzenie czy dzień należy do miesiąca w zależności od roku parzystego
//         if (dz > 28 + jestPrzystepny(rok))
//         {
//             printf("Nie jest to poprawna data\n");
//             return;
//         }
//         break;

//     default:
//         // Zły miesiąc
//         printf("Nie jest to poprawna data\n");
//         return;
//         break;
//     }

//     printf("Jest to poprawna data\n");
// }

// void zadanie3()
// {
//     /*
//     Zadanie 1
//     */

//     cout << "\n\n\nZadanie 3\n";

//     // Definiujemy 3 zmienne
//     float a, b, c;

//     // Wprowadzamy dane
//     cout << "Wpisz trzy długości odcinków" << endl;
//     cin >> a >> b >> c;

//     // Warunek budowy trójkąta
//     if (!(a + b > c || a + c > b || c + b > a))
//     {
//         cout << "Nie można zbudować trójkąta" << endl;
//         return;
//     }

//     // Sprawdzamy własności tego trójkąta
//     if (a == b || b == c || c == a)
//     {
//         cout << "Trójkąt jest równoramienny" << endl;
//     }
//     if (a == b && b == c)
//     {
//         cout << "Trójkąt jest równoboczny" << endl;
//     }

//     if (a * a + b * b == c * c || a * a + c * c == b * b || c * c + b * b == a * a)
//     {
//         cout << "Trójkąt jest prostokątny" << endl;
//     }
//     else if ((a * a + b * b > c * c && a * a + c * c > b * b && c * c + b * b > a * a))
//     {
//         cout << "Trójkąt jest ostrokątny" << endl;
//     }
//     else
//     {
//         cout << "Trójkąt jest rozwartokątny" << endl;
//     }
// }

void zadanie4()
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

    // /*
    // Zadanie 1
    // */
    // zadanie1();
    // system("PAUSE");

    /*
    Zadanie 2
    */
    // zadanie2();
    // system("PAUSE");

    // /*
    // Zadanie 3
    // */
    // zadanie3();
    // system("PAUSE");

    // /*
    // Zadanie 4
    // */
    zadanie4();
    // system("PAUSE");

    return 0;
}