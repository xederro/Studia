
#include <stdio.h>

int main()
{
        //##########################################################################
        //       PRZYK�AD 1 - prosta zmienna
        //##########################################################################

        printf("Przyklad 1: prosta zmienna\n");
        short x = 6;    //  deklaracja zmiennej x
        short* wsk;     //  deklaracja zmiennej wska�nikowej wsk

        wsk = &x;       // adres zmiennj x

        printf("      x = %-8d      sizeof(x) = %d \n", x, sizeof(x));
        printf("    wsk = %p    sizeof(wsk) = %d    sizeof(*wsk) = %d \n",
                wsk, sizeof(wsk), sizeof(*wsk));
        printf("      x = %d \n", x);       // bezpo�rednie odwo�anie do zmiennej 
        printf("   *wsk = %d \n", *wsk);    // odwo�anie za pomoc� wska�nika
        printf(" wsk[0] = %d \n", wsk[0]);  // odwo�anie za indeksu



        //##########################################################################
        //       PRZYK�AD 2 - tablica jednowymiarowa
        //##########################################################################

        printf("\n\n");
        printf("Przyklad 2: trzyelementowa tablica liczb\n");
        short tab1[3] = { 1, 3, 9 };  // 3-elementowa tablica typu short
        short* wsk1;                // wska�nik na typ short
        short(*wsk2)[3];           // wska�nik na 3-elementow� tablic� 
        // typu short 

        wsk1 = tab1;                //  adres pierwszego elementu tablicy
        wsk2 = &tab1;               // adres 3-elementowej tablicy


        // wydruk warto�ci wska�nik�w oraz rozmiaru danych, na kt�re wskazuj� 
        printf("    tab1 = %p    sizeof(tab1) = %d    sizeof(*tab1) = %d \n",
                tab1, sizeof(tab1), sizeof(*tab1));
        printf("    wsk1 = %p    sizeof(wsk1) = %d    sizeof(*wsk1) = %d \n",
                wsk1, sizeof(wsk1), sizeof(*wsk1));
        printf("    wsk2 = %p    sizeof(wsk2) = %d    sizeof(*wsk2) = %d \n\n",
                wsk2, sizeof(wsk2), sizeof(*wsk2));

        // wydruk warto�ci elementu tablicy oznaczonego kolorem szarym
        printf("     tab1[2] = %d\n", tab1[2]);  // notacja indeksowa
        printf("   *(tab1+2) = %d\n", *(tab1 + 2));  // notacja wska�nikowa
        printf("     wsk1[2] = %d\n", wsk1[2]);  // notacja indeksowa
        printf("   *(wsk1+2) = %d\n", *(wsk1 + 2));  // notacja wska�nikowa
        printf("  wsk2[0][2] = %d\n", wsk2[0][2]);  // notacja indeksowa
        printf(" *(*wsk2 +2) = %d\n", *(*wsk2 + 2));  // notacja wska�nikowa


        //##########################################################################
        //       PRZYK�AD 3 - dwuwymiarowa tablica liczb
        //##########################################################################

        printf("\n\n");
        printf("Przyklad 3: dwuwymiarowa tablica liczb\n");

        int tab2[4][3] = { {1,7,5},{1,4,0},{2,5,9},{8,9,0} };

        // Tu prosz� dopisa� deklaracj� wska�nik�w wsk3, wsk4, wsk5
        // Tu prosz� nada� warto�ci wska�nikom wsk3, wsk4, wsk5


        int* wsk3 = &(tab2[0][0]);
        int(*wsk4)[3] = &(tab2[0]);
        int(*wsk5)[4][3] = &tab2;


        // Tu prosz� dopisa� wydruk warto�ci wska�nik�w tab2, wsk3, wsk4, wsk5
        // oraz rozmiaru danych,  na kt�re wskazuj�. 


        printf("    tab2 = %p    sizeof(tab2) = %d    sizeof(*tab2) = %d \n",
                tab2, sizeof(tab2), sizeof(*tab2));
        printf("    wsk3 = %p    sizeof(wsk3) = %d    sizeof(*wsk3) = %d \n",
                wsk3, sizeof(wsk3), sizeof(*wsk3));
        printf("    wsk4 = %p    sizeof(wsk4) = %d    sizeof(*wsk4) = %d \n",
                wsk4, sizeof(wsk4), sizeof(*wsk4));
        printf("    wsk5 = %p    sizeof(wsk5) = %d    sizeof(*wsk5) = %d \n\n",
                wsk5, sizeof(wsk5), sizeof(*wsk5));


        // Tu prosz� dopisa� wydruk warto�ci elementu tablicy oznaczonego
        // kolorem szarym. odwo�ania do tego elementu prosz� robi� za pomoc�
        // identyfikatora tab2 oraz wska�nik�w wsk3, wsk4, wsk5. W ka�dym
        // przypadku prosz� zrobi� dwa warianty (z u�yciem notacji indeksowej 
        // oraz notacji wska�nikowej)        

        printf("     tab2[3][0] = %d\n", tab2[3][0]);
        printf("     *(wsk3 + (3 * 3)) = %d\n", *(wsk3 + (3 * 3)));
        printf("     *((&wsk3[0]) + 3 * 3) = %d\n", *((&wsk3[0]) + 3 * 3));
        printf("     *(*(wsk4 + 3)) = %d\n", *(*(wsk4 + 3)));
        printf("     wsk4[3][0] = %d\n", wsk4[3][0]);
        printf("     **(*(wsk5)+3) = %d\n", **(*(wsk5)+3));
        printf("     wsk5[3][0] = %d\n", *wsk5[0][3]);



        //##########################################################################
        //       PRZYK�AD 4 - dwywymiarowa tablica o zmiennaj liczbie kolumn
        //##########################################################################

        printf("\n\n");
        printf("Przyklad 4: dwuwymiarowa tablica liczb,\n");
        printf("ktora zawiera trzy wiersze o roznaj liczbie kolumn\n");


        char tab3a[] = { 1, 5, 0 };
        char tab3b[] = { 6, 2, 9, 8, 1, 0 };
        char tab3c[] = { 3, 4, 7, 0 };

        char* tab3[3] = { tab3a, tab3b, tab3c };

        // Tu prosz� dopisa� deklaracj� wska�nik�w wsk6, wsk7
        // Tu prosz� nada� warto�ci wska�nikom wsk6, wsk7


        char** wsk6 = tab3;
        char* (*wsk7)[3] = &tab3;


        // Tu prosz� dopisa� wydruk warto�ci wska�nik�w tab3, wsk6, wsk7
        // oraz rozmiaru danych,  na kt�re wskazuj�.


        printf("    tab3 = %p    sizeof(tab3) = %d    sizeof(*tab3) = %d \n\n",
                &tab3, sizeof(tab3), sizeof(*tab3));
        printf("    wsk6 = %p    sizeof(wsk6) = %d    sizeof(*wsk6) = %d \n\n",
                &wsk6, sizeof(wsk6), sizeof(*wsk6));
        printf("    wsk7 = %p    sizeof(wsk7) = %d    sizeof(*wsk7) = %d \n\n",
                wsk7, sizeof(wsk7), sizeof(*wsk7));


        // Tu prosz� dopisa� wydruk warto�ci elementu tablicy oznaczonego
        // kolorem szarym. odwo�ania do tego elementu prosz� robi� za pomoc�
        // identyfikatora tab3 oraz wska�nik�w wsk6, wsk7. W ka�dym
        // przypadku prosz� zrobi� dwa warianty (z u�yciem notacji indeksowej 
        // oraz notacji wska�nikowej)                  


        printf("tab3[2][1]: %d\n", tab3[2][1]);
        printf("*(*(tab3 + 2) + 1): %d\n", *(*(tab3 + 2) + 1));
        printf("wsk6[2][1]: %d\n", wsk6[2][1]);
        printf("*(*(wsk6 + 2) + 1): %d\n", *(*(wsk6 + 2) + 1));
        printf("wsk7[0][2][1]: %d\n", wsk7[0][2][1]);
        printf("*(*(tab3 + 2) + 1): %d\n", *(*(*wsk7 + 2) + 1));

        return 0;
}