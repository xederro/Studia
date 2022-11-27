/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadanie 1a Laboratorium 4
Data:   22 listopada 2022r.
*/

#include <stdio.h>

using namespace std;

void CzytajRownanie(float& a, float& b, float& c);
void WypiszRozwiazanie(int N, float x, float y);
float ObliczWyznacznik(float p1, float p2, float p3, float p4);
int ObliczRozwiazanie(float a1, float b1, float c1, float a2, float b2, float c2, float& x, float& y);

int main() {

    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)\n");


    float A1, B1, C1; // pierwsze równanie,
    float A2, B2, C2; // drugie równanie,
    float X, Y; // rozwiązanie,
    int N; // liczba rozwiazan.

    CzytajRownanie(A1, B1, C1);
    CzytajRownanie(A2, B2, C2);
    N = ObliczRozwiazanie(A1, B1, C1, A2, B2, C2, X, Y);
    WypiszRozwiazanie(N, X, Y);

    return 0;
}

void CzytajRownanie(float& a, float& b, float& c) {
    printf("Podaj A funkcji: Ax+By=C\n");
    scanf("%f", &a);
    printf("Podaj B funkcji: Ax+By=C\n");
    scanf("%f", &b);
    printf("Podaj C funkcji: Ax+By=C\n");
    scanf("%f", &c);
}

void WypiszRozwiazanie(int N, float x, float y) {
    switch (N)
    {
    case -1:
        printf("Wystapil problem w funkcji ObliczWyznacznik\n");
        break;
    case 0:
        printf("Rownanie nie posiada rozwiazan\n");
        break;

    case 1:
        printf("Rownanie ma dokladnie 1 rozwiazanie: x=%f oraz y=%f\n", x, y);
        break;

    case 2:
        printf("Rownanie ma nieskonczenie wiele rozwazan\n");
        break;

    default:
        printf("Wystapil problem w funkcji WypiszRozwiazanie\n");
        break;
    }
}

float ObliczWyznacznik(float p1, float p2, float p3, float p4) {
    return (p1 * p4) - (p2 * p3);
}

int ObliczRozwiazanie(float a1, float b1, float c1, float a2, float b2, float c2, float& x, float& y) {
    float wyznacznik = ObliczWyznacznik(a1, b1, a2, b2);
    float wyznacznikX = ObliczWyznacznik(c1, b1, c2, b2);
    float wyznacznikY = ObliczWyznacznik(a1, c1, a2, c2);

    if (wyznacznik != 0) // dokładnie 1
    {
        x = wyznacznikX / wyznacznik;
        y = wyznacznikY / wyznacznik;
        return 1;
    }

    if (wyznacznikX == 0 && wyznacznikY == 0) { // nieskończenie wiele
        return 2;
    }

    if (wyznacznikX != 0 && wyznacznikY != 0) { // brak
        return 0;
    }

    return -1;
}
