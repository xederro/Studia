// Napisz funkcję wczytującą znaki z klawiatury tak długo,  
// aż zostaną podane trzy kolejne znaki o takich samych kodach.  
// Na zakończenie program powinien wyświetlić podsumowanie  
// czy więcej naciśniętych klawiszy było "literami" czy "cyframi".

#include <stdio.h>
#include <conio.h>

using namespace std;

void sprawdz() {

    char a, b, c = 0;
    int licz = 0;
    do
    {
        c = b;
        b = a;
        a = getch();
        printf("%c", a);

        if (a <= '9' && a >= '0')
        {
            licz++;
        }

        if (a <= 'z' && a >= 'A')
        {
            licz--;
        }

    } while (!(a == b && b == c));

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

int main() {
    sprawdz();
}