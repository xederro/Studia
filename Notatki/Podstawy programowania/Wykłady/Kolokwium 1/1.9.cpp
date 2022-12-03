// Napisz program wczytujący 4 dowolne znaki z klawiatury  
// i sprawdzający czy więcej z nich jest literami czy cyframi.

#include <conio.h>
#include <stdio.h>

using namespace std;

int main() {
    printf("Wpisz 4 znaki\n");

    char licz = 0;

    for (char i = 0; i < 4; i++)
    {
        char a;
        scanf("%c", &a);
        if (a <= '9' && a >= '0')
        {
            licz++;
        }

        if (a <= 'z' && a >= 'A')
        {
            licz--;
        }

    }

    if (licz > 0)
    {
        printf("\nWiecej liczb\n");
    }
    else if (licz < 0)
    {
        printf("\nWiecej znakow\n");
    }
    else
    {
        printf("\nTyle samo liczb co znakow\n");
    }


}