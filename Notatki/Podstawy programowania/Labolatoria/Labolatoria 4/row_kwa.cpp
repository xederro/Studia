/*************************************************
     Plik: rownanieKwadratowe.cpp
    Temat: Pierwiastki rownania kwadratowego 
           - wersja z podzialem na funkcje
    Autor: Pawel Rogalinski
     Data: 17-11-2011
**************************************************/

#define  _CRT_SECURE_NO_WARNINGS

#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>

/**********************************************************************
  Program oblicza pierwiastki rownania kwadratowego
         A X^2  +  B x  +  C  =  0
   prototypy funkcji
**********************************************************************/
// Funkcja CzytajDane wczytuje wspolczynniki rownania kwadratowego.
//    Parametry:
//      A, B, C - wspolczyniki okreslajace postac rownania kwadratowego
void CzytajDane(float &A, float &B, float &C);

// Funkcja WypiszPierwiastki wypisuje pierwiastki rownania kwadratowego 
//    Parametry:
//      N - liczba pierwiastkow
//        2  - rownanie posiada dwa rozne pierwiastki rzeczywiste,
//        1  - rownanie posiada jeden podwojny pierwiastek, 
//             ktory jest zwracany w parametrze X1,            
//        0  - rownanie nie posiada pierwiastkow rzeczywistych
//       -1  - nie mozna obliczac pierwiastkow, poniewaz 
//             wspolczynnik A jest rowny zero
//      X1, X2  - pierwiastki rownania ( o ile istnieja)
void WypiszPierwiastki(int N, float X1, float X2);


// Funkcja Delta oblicza wartosc wyroznika rownania kwadratowego
//    Parametry:
//      A, B, C - wspolczyniki rownania kwadratowego
//    Zwracana wartosc:
//        - wartosc wyroznika delta.    
float Delta(float A, float B, float C);

// Funkcja ObliczPierwiastki oblicza pierwiastki rownania kwadratowego
//    Parametry:
//      A, B, C - wspolczyniki rownania kwadratowego
//      X1, X2  - pierwiastki rownania ( o ile istnieja)
//    Zwracana wartosc: ilosc pierwiastkow:
//        2  - rownanie posiada dwa rozne pierwiastki rzeczywiste,
//        1  - rownanie posiada jeden podwojny pierwiastek, 
//             ktory jest zwracany w parametrze X1,            
//        0  - rownanie nie posiada pierwiastkow rzeczywistych
//       -1  - nie mozna obliczac pierwiastkow, poniewaz 
//             wspolczynnik A jest rowny zero
int  ObliczPierwiastki(float A, float B, float C, float &X1, float &X2);


int main()
{ float A, B, C;  // wspolczynniki rownania
  float X1, X2;   // pierwiastki rownania
  int N;          // liczba pierwiastkow 

  CzytajDane(A, B, C);
  N = ObliczPierwiastki(A, B, C, X1, X2);
  WypiszPierwiastki(N, X1, X2);
  system("PAUSE");
}

void CzytajDane(float &A, float &B, float &C)
{ printf("Program liczy pierwiastki rownania kwadratowego\n");
  printf("\n     A x^2 + B x + C = 0 \n\n");
  printf("Podaj wspolczynniki A B C: ");
  scanf("%f %f %f", &A, &B, &C);
  printf("Rownanie kwadratowe ma postac:\n\n");
  printf("     %.2f x^2 + %.2f x + %.2f = 0\n\n", A, B, C);
}

void WypiszPierwiastki(int N, float X1, float X2)
{ switch(N)
    { case  2: printf("Rownanie posiada dwa pierwiastki:\n");
               printf("  x1 = %.2f\n", X1);
               printf("  x2 = %.2f\n", X2);
               break;
      case  1: printf("Rownanie posiada jeden pierwiastek:\n");
               printf("  x1 = %.2f\n", X1);
               break;
      case  0: printf("To rownanie nie posiada pierwiastkow !!!\n");
               break;
      case -1: printf("To nie jest rownanie kwadratowe !!!\n");
    }  
}


float Delta(float A, float B, float C)
{ return B * B - 4 * A * C;
}

int  ObliczPierwiastki(float A, float B, float C, float &X1, float &X2)
{ float delta;

  if (A==0) return -1;
  delta = Delta(A, B, C);
  if (delta>0)
     { X1 = (-B - sqrt(delta))/(2*A);
       X2 = (-B + sqrt(delta))/(2*A);
       return 2;
     }
  if (delta==0)
     { X1 = -B/(2*A);
       return 1;
     }
  return 0;
}
