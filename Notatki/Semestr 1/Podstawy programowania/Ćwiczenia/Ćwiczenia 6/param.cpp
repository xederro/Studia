
#include <stdio.h> 
#include <conio.h>

void funkcja_1(int war);   // parametr przekazywany przez WARTOSC   (C/C++)
void funkcja_2(int *wsk);  // parametr przekazywany przez WSKAZNIK  (C/C++)
void funkcja_3(int &ref);  // parametr przekazywany przez REFERENCJE  (tylko C++)

int main()
{  int PAR;


   PAR = 1;
   printf("PRZEKAZYWANIE PARAMETRU PRZEZ WARTOSC: (C/C++)\n");
   printf(" main: PAR = %d  (przed wywolaniem funkcji 1)\n", PAR);
   funkcja_1( PAR );
   printf(" main: PAR = %d  (po wywolaniu funkcji 1)\n", PAR);
   getch(); printf("\n\n");

   PAR = 2;
   printf("PRZEKAZYWANIE PARAMETRU PRZEZ WSKAZNIK: (C/C++)\n");
   printf("czyli przekazywanie przez wartosc adresu parametru\n");
   printf(" main: PAR = %d  (przed wywolaniem funkcji 2)\n", PAR);
   funkcja_2( &PAR );
   printf(" main: PAR = %d  (po wywolaniu funkcji 2)\n", PAR);
   getch(); printf("\n\n");
   
   PAR = 3;
   printf("PRZEKAZYWANIE PARAMETRU PRZEZ REFERENCJE: (tylko C++)\n");
   printf(" main: PAR = %d  (przed wywolaniem funkcji 3)\n", PAR);
   funkcja_3( PAR );
   printf(" main: PAR = %d  (po wywolaniu funkcji 3)\n", PAR);
   getch();
}


void funkcja_1(int war)
{
  printf("       funkcja_1: war = %d  (przed modyfikacja)\n", war);
  war += 10;
  printf("       funkcja_1: war = %d  (po modyfikacji)\n", war);
}

void funkcja_2(int *wsk)
{
  printf("       funkcja_2: *wsk = %d  (przed modyfikacja)\n", *wsk);
  *wsk += 10;
  printf("       funkcja_2: *wsk = %d  (po modyfikacji)\n", *wsk);
}

void funkcja_3(int &ref)
{
  printf("       funkcja_3: ref = %d  (przed modyfikacja)\n", ref);
  ref += 10;
  printf("       funkcja_3: ref = %d  (po modyfikacji)\n", ref);
}
