// Napisz funkcję otrzymującą jako parametr wejściowy 100 -elementową  
// tablicę liczb całkowitych **Tab**. Funkcja powinna zwracać wartość minimalną  
// z dodatnich elementów tablicy **Tab**.
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

using namespace std;

#define N 100


int min(int tab[N]) {
    int min = tab[0];

    for (int i = 1; i < N; i++)
    {
        if (tab[i] > 0 && min >= tab[i])
        {
            min = tab[i];
        }
    }
    return min;
}

int main() {
    srand(time(NULL));

    int tab[N];

    for (int i = 0; i < N; i++)
    {
        tab[i] = (rand() % 1001) - 500;
    }


    printf("%d", min(tab));


    for (int i = 0; i < N; i++)
    {
        printf("\n%d", tab[i]);
    }
}