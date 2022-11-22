/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadania Laboratorium 4
Data:   22 listopada 2022r.
*/

#include <stdio.h>

/*

2.
ala ma 2 koty
ala ma  koty
zwraca ilość usuniętych cyfr

3.
”\/*”  do  sekwencji  ”*\/”    oraz  wszystkie  znaki  począwszy  od  ciągu  ”//""

4.
wypisać jako %p na 16 zamieni

*/

void zadanie2(char(*tab)[100]) {
    for (char i = 0; (*tab)[i] != 0; i++) {
        if ((*tab)[i] < '9' && (*tab)[i] > '0') {
            for (char k = i; (*tab)[i] != 0; k++)
            {
                (*tab)[i] = (*tab)[i + 1];
            }
        }
    }
}


void zadanie3() {

}


void zadanie4() {

}


int main() {

    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)");


    // wybór zadania
    unsigned short int wybor = 0;
    do
    {
        printf("\n0- Wyjscie z programu\n1- Zadanie 2\n2- Zadanie 3\n3- Zadanie 4\n\n");
        scanf("%hhd", &wybor);

        switch (wybor)
        {
        case 0:
            printf("Do widzenia");
            break;
        case 1:
            /*
                Zadanie 2
            */
            char tab[100];
            printf("Wbisz zdanie:\n");

            scanf("%s", &tab);
            zadanie2(&tab);
            for (char i = 0; tab[i] != 0; i++) {
                printf("%c\n", tab[i]);
            }
            break;
            // case 2:
            //     /*
            //         Zadanie 3
            //     */
            //     zadanie3();
            //     break;
            // case 3:
            //     /*
            //         Zadanie 4
            //     */
            //     zadanie4();
            //     break;

        default:
            printf("Zly Wybor");
            break;
        }
    } while (wybor != 0);

    return 0;
}