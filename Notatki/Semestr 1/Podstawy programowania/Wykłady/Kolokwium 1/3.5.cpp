// Napisz funkcję wyświetlającą w odwrotnej kolejności (od ostatniego do pierwszego)  
// zawartość 20-elementowej tablicy TAB liczb typu całkowitego.  
// Tablica TAB powinna być przekazywana jako parametr funkcji.  
// (Jeżeli potrafisz to napisz dwie wersje tej samej funkcji  
//  stosujące w pierwszej wersji zapis indeksowy  
//  a w drugiej zapis wskaźnikowy)

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

using namespace std;

#define N 20


void odTyluAleToWskaznik(int* tab) {
    for (int i = N - 1; i >= 0; i--)
    {
        printf("%d\n", *(tab + i));
    }
}

int main() {
    srand(time(NULL));

    int tab[N];

    for (int i = 0; i < N; i++)
    {
        tab[i] = (rand() % 1001) - 500;
    }

    for (int i = 0; i < N; i++)
    {
        printf("\n%d", tab[i]);
    }
    printf("\n\n\n\n");

    odTyluAleToWskaznik(tab);
}