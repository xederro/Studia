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

int main() {

    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)");


    // wybór zadania
    unsigned short int wybor = 0;
    do
    {
        printf("\n0- Wyjscie z programu\n1- Zadanie 1\n2- Zadanie 2\n3- Zadanie 3\n\n");
        scanf("%hhd", &wybor);

        switch (wybor)
        {
        case 0:
            printf("Do widzenia");
            break;
            // case 1:
            //     /*
            //         Zadanie 1
            //     */
            //     zadanie1();
            //     break;
            // case 2:
            //     /*
            //         Zadanie 2
            //     */
            //     zadanie2();
            //     break;
            // case 3:
            //     /*
            //         Zadanie 3
            //     */
            //     zadanie3();
            //     break;

        default:
            printf("Zly Wybor");
            break;
        }
    } while (wybor != 0);

    return 0;
}