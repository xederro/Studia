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
    short int liczZnaki[26] = { 0 }; // tablica z liczba wystapien znakow

    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)\n");

    char znak = 0; // numer znaku
    short int licz = -1; // liczba klikniec -1 kompensuje za policzenie klawisza esc

    printf("Wprowadz ciag znakow:");

    do
    {
        znak = getch();// pobranie znaku

        printf("%c", znak);

        licz++;// zwiekszenie liczby klikniec
        if (znak >= 'A' && znak <= 'Z')
            liczZnaki[znak - 'A']++;// zwiekszenie liczby wystapien znaku A - A = 0 , B - A = 1 itd.
        else if (znak >= 'a' && znak <= 'z')
            liczZnaki[znak - 'a']++;// zwiekszenie liczby wystapien znaku a - a = 0 , b - a = 1 itd.

    } while (znak != 27);// petla wykonuje sie dopoki nie zostanie wcisniety klawisz esc

    printf("Wpisales %hd znakow w tym:\n", licz);

    for (char i = 0; i < 26; i++)
    {
        printf("%c pojawilo sie %hd razy: ", 'A' + i, liczZnaki[i]); // wypisanie liczby wystapien znaku
        for (short int j = 0; j < liczZnaki[i]; j++)
        {
            printf("#"); // wypisanie znaku # tyle razy ile wystapil znak
        }
        printf("\n");
    }

    return 0;
}