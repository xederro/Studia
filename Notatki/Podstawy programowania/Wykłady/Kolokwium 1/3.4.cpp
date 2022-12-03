// Napisz funkcję sprawdzającą ile różnych liter 'a'-'z'  
// występuje więcej niż jeden raz w 200-elementowej tablicy znaków  
// podawanej jako dane wejściowe tej funkcji.

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define N 200

using namespace std;

void ileWystepuje(char tab[N]) {
    char alf[26] = { 0 };

    for (int i = 0; i < N; i++)
    {
        alf[tab[i] - 'a']++;
    }

    for (int i = 0; i < 26; i++)
    {
        if (alf[i])
        {
            printf("\n%c wystapilo %d razy", i + 'a', alf[i]);
        }
    }
}

int main() {
    srand(time(NULL));

    char tab[N];

    for (int i = 0; i < N; i++)
    {
        tab[i] = (rand() % 26) + 'a';
    }


    ileWystepuje(tab);


    for (int i = 0; i < N; i++)
    {
        printf("\n%c", tab[i]);
    }
}