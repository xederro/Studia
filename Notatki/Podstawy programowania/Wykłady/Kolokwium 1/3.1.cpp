// Napisz funkcję przesuwającą całą zawartość tablicy 50 liczb całkowitych  
// “o jedno miejsce w górę” (tzn. pierwszy element na drugą pozycję,  
// element o indeksie “i” na pozycję o indeksie “i+1”,  
// a element ostatni na pierwszą pozycję w tablicy)

#include <stdio.h>

using namespace std;


void przesun(int tab[50]) {
    int temp = tab[49];

    for (int i = 49; i > 0; i--)
    {
        tab[i] = tab[i - 1];
    }

    tab[0] = temp;
}

int main() {
    int tab[50];

    for (int i = 0; i < 50; i++)
    {
        tab[i] = i + 1;
    }


    przesun(tab);


    for (int i = 0; i < 50; i++)
    {
        printf("%d\n", tab[i]);
    }
}