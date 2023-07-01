// Napisz funkcję, która sprawdzi czy tablica **N** liczb rzeczywistych  
// (podawana jako parametr funkcji) ma symetryczną zawartość  
// tzn. czy element pierwszy jest równy ostatniemu, drugi – przedostatniemu, itd.
#include <stdio.h>
#include <math.h>

using namespace std;

#define N 51


void symetrzyczna(int tab[N]) {
    bool sym = 1;

    for (int i = 0; i <= N / 2; i++)
    {
        if (tab[i] != tab[N - 1 - i])
        {
            sym = 0;
            break;
        }
    }


    printf("Symetryczna: %s", sym ? "tak" : "nie");
}

int main() {
    int tab[N];

    for (int i = 0; i < N; i++)
    {
        tab[i] = abs(N / 2 - i);
    }


    symetrzyczna(tab);


    for (int i = 0; i < N; i++)
    {
        printf("\n%d", tab[i]);
    }
}