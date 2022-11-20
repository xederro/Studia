
#include <stdio.h>

int main()
{
    //##########################################################################
    //       PRZYK£AD 1 - prosta zmienna
    //##########################################################################
    
    printf("Przyklad 1: prosta zmienna\n");
    short x = 6;    //  deklaracja zmiennej x
    short *wsk;     //  deklaracja zmiennej wskaŸnikowej wsk

    wsk = &x;       // adres zmiennj x
    
    printf("      x = %-8d      sizeof(x) = %d \n", x, sizeof(x));
    printf("    wsk = %p    sizeof(wsk) = %d    sizeof(*wsk) = %d \n", 
           wsk, sizeof(wsk), sizeof(*wsk));
    printf("      x = %d \n",  x );       // bezpoœrednie odwo³anie do zmiennej 
    printf("   *wsk = %d \n",  *wsk );    // odwo³anie za pomoc¹ wska¿nika
    printf(" wsk[0] = %d \n",  wsk[0] );  // odwo³anie za indeksu
    
    
    
    //##########################################################################
    //       PRZYK£AD 2 - tablica jednowymiarowa
    //##########################################################################
    
    printf("\n\n");
    printf("Przyklad 2: trzyelementowa tablica liczb\n");
    short tab1[3] = {1, 3, 9};  // 3-elementowa tablica typu short
    short *wsk1;                // wskaŸnik na typ short
    short (*wsk2)[3];           // wskaŸnik na 3-elementow¹ tablicê 
                                // typu short 
                          
    wsk1 = tab1;                //  adres pierwszego elementu tablicy
    wsk2 = &tab1;               // adres 3-elementowej tablicy

   
    // wydruk wartoœci wskaŸników oraz rozmiaru danych, na które wskazuj¹ 
    printf("    tab1 = %p    sizeof(tab1) = %d    sizeof(*tab1) = %d \n",   
            tab1, sizeof(tab1), sizeof(*tab1));
    printf("    wsk1 = %p    sizeof(wsk1) = %d    sizeof(*wsk1) = %d \n",   
            wsk1, sizeof(wsk1), sizeof(*wsk1));
    printf("    wsk2 = %p    sizeof(wsk2) = %d    sizeof(*wsk2) = %d \n\n", 
            wsk2, sizeof(wsk2), sizeof(*wsk2));
    
    // wydruk wartoœci elementu tablicy oznaczonego kolorem szarym
    printf("     tab1[2] = %d\n",  tab1[2]      );  // notacja indeksowa
    printf("   *(tab1+2) = %d\n",  *(tab1+2)    );  // notacja wskaŸnikowa
    printf("     wsk1[2] = %d\n",  wsk1[2]      );  // notacja indeksowa
    printf("   *(wsk1+2) = %d\n",  *(wsk1+2)    );  // notacja wskaŸnikowa
    printf("  wsk2[0][2] = %d\n",  wsk2[0][2]   );  // notacja indeksowa
    printf(" *(*wsk2 +2) = %d\n",  *(*wsk2+2)   );  // notacja wskaŸnikowa

    
    //##########################################################################
    //       PRZYK£AD 3 - dwuwymiarowa tablica liczb
    //##########################################################################
    
    printf("\n\n");
    printf("Przyklad 3: dwuwymiarowa tablica liczb\n");
    
    int tab2[4][3] = {{1,7,5},{1,4,0},{2,5,9},{8,9,0}};

    // Tu proszê dopisaæ deklaracjê wskaŸników wsk3, wsk4, wsk5
    
    
    
    
   
    // Tu proszê nadaæ wartoœci wskaŸnikom wsk3, wsk4, wsk5
    
    
    
    
    
    
    // Tu proszê dopisaæ wydruk wartoœci wskaŸników tab2, wsk3, wsk4, wsk5
    // oraz rozmiaru danych,  na które wskazuj¹. 
    
    
    
    
    
    
    
    
    
            
    // Tu proszê dopisaæ wydruk wartoœci elementu tablicy oznaczonego
    // kolorem szarym. odwo³ania do tego elementu proszê robiæ za pomoc¹
    // identyfikatora tab2 oraz wskaŸników wsk3, wsk4, wsk5. W ka¿dym
    // przypadku proszê zrobiæ dwa warianty (z u¿yciem notacji indeksowej 
    // oraz notacji wskaŸnikowej)        
    
    
    
    
    
    
    
    
    
    

    
    //##########################################################################
    //       PRZYK£AD 4 - dwywymiarowa tablica o zmiennaj liczbie kolumn
    //##########################################################################
    
    printf("\n\n");
    printf("Przyklad 4: dwuwymiarowa tablica liczb,\n");
    printf("ktora zawiera trzy wiersze o roznaj liczbie kolumn\n");
    
    
    char tab3a[] = {1, 5, 0};
    char tab3b[] = {6, 2, 9, 8, 1, 0};
    char tab3c[] = {3, 4, 7, 0};

    char *tab3[3] = {tab3a, tab3b, tab3c};
    
    // Tu proszê dopisaæ deklaracjê wskaŸników wsk6, wsk7
    
    
    

    
    // Tu proszê nadaæ wartoœci wskaŸnikom wsk6, wsk7
    
    
    
    
    
    // Tu proszê dopisaæ wydruk wartoœci wskaŸników tab3, wsk6, wsk7
    // oraz rozmiaru danych,  na które wskazuj¹.
    
    
    
    
    
    

    // Tu proszê dopisaæ wydruk wartoœci elementu tablicy oznaczonego
    // kolorem szarym. odwo³ania do tego elementu proszê robiæ za pomoc¹
    // identyfikatora tab3 oraz wskaŸników wsk6, wsk7. W ka¿dym
    // przypadku proszê zrobiæ dwa warianty (z u¿yciem notacji indeksowej 
    // oraz notacji wskaŸnikowej)                  
   
    
    
    
    
    
    
    
    
       
    return 0;       
}