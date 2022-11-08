/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadania Laboratorium 3 zadanie 4 dla ambitnych
Data:   8 listopada 2022r.
*/

#include <stdio.h>
#include <conio.h>

int main()
{
    short int liczZnaki[26] = {0};

    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)\n");

    char znak = 0;
    short int licz = -1;

    printf("Wprowadz ciag znakow:");

    do
    {
        znak = getch();

        printf("%c", znak);

        licz++;
        if (znak >= 'A' && znak <= 'Z')
            liczZnaki[znak - 'A']++;
        else if (znak >= 'a' && znak <= 'z')
            liczZnaki[znak - 'a']++;

    } while (znak != 27);

    printf("Wpisales %hd znakow w tym:\n", licz);

    for (char i = 0; i < 26; i++)
    {
        printf("%c pojawilo sie %hd razy: ", 'A' + i, liczZnaki[i]);
        for (short int j = 0; j < liczZnaki[i]; j++)
        {
            printf("#");
        }
        printf("\n");
    }

    return 0;
}