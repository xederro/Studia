#include <stdlib.h>
#include <stdio.h>

#define  ROZMIAR    10

/*#############################################
    Deklaracja tablicy
#############################################*/

float  *TAB = NULL;        // wskaŸnik na dynamiczn¹ tablicê liczb
unsigned  N = 0;           // liczba elementów tablicy zawieraj¹cych dane

/*#############################################
    Prototypy funkcji operuj¹cych na tablicy
#############################################*/

// void Drukuj( float tab[ ],   unsigned n );
void Drukuj( float *tab,     unsigned n );

int DodajDane( float dane, float *&tab,  unsigned &n );

int UsunDane( unsigned ktory,  float *&tab,  unsigned &n );


int main()
{ 
  DodajDane( 12.34, TAB, N);    // dodanie do tablicy liczby
  DodajDane( 23.45, TAB, N);    // dodanie do tablicy liczby 
  DodajDane( 34.56, TAB, N);    // dodanie do tablicy liczby
  DodajDane( 45.67, TAB, N);    // dodanie do tablicy liczby
   
  Drukuj(TAB, N);               // drukowanie zawartoœci tablicy
  
  UsunDane(1, TAB, N);          // usuniêcie elementu tablicy o indeksie 0
  
  Drukuj(TAB, N);               // drukowanie zawartoœci tablicy
  
  return 0;
}


/*#############################################
    Definicje funkcji operuj¹cych na tablicy
#############################################*/

// void Drukuj( float *tab,  unsigned n )
   void Drukuj( float tab[ ], unsigned n )       
   { printf("\nTablica zawiera %d liczby \n", n); 
     for ( unsigned i = 0; i<n; i++)
          {    printf( "  TAB[%2d] = %f \n", i, tab[ i ] );       
          }
     printf("\n");
   }


// int DodajDane( float dane,  float *tab,   unsigned &n )
   int DodajDane( float dane,  float tab[ ],  unsigned &n ) 
   { printf("Dodanie do tablicy liczby %f \n", dane);
     if ( n == ROZMIAR )
        { printf( "Brak miejsca w tablicy ! \n" );
          return 1;
        }
     tab[ n ] = dane;       
     n++;
     return 0;
   }


//  int UsunDane( unsigned ktory,  float *tab,   unsigned &n )
    int UsunDane( unsigned ktory,  float tab[ ],  unsigned &n )
    { printf("Usuwanie z tablicy liczby o indeksie %d \n", ktory);
     if ( ktory >= n )
        { printf( "Brak danych na podanej pozycji ! \n" );
          return 1;
        }
     for ( int i = ktory;  i < n-1;  i++ )  
           tab[ i ] = tab[ i+1 ];                 
      n--;
      return 0;
    }
   
    int DodajDane( float dane, float *&tab, unsigned &n )
    {  printf("Dodanie do tablicy liczby %f \n", dane);  
    
       float *tmptab; 
       
       tmptab = ( float * ) realloc( tab, (n+1)*sizeof(float) );
       if ( tmptab == NULL )
         { printf( "Brak pamiêci ! \n" );
           return 1;
         }
       tab = tmptab;
       tab[ n ] = dane;       
       n++;
       return 0;
    }


    int UsunDane( unsigned ktory, float *&tab, unsigned &n ) 
    { printf("Usuwanie z tablicy liczby o indeksie %d \n", ktory); 
      if ( ktory >= n )
         { printf("Brak danych na podanej pozycji ! \n");
           return 1;
         }
      for ( int i = ktory;  i < n-1;  i++ )  
            tab[ i ] = tab[ i+1 ];              
      n--;
      tab = ( float * ) realloc( tab, n*sizeof( float) );
      return 0;
    }


