// Napisz program wczytujący 4 dowolne znaki z klawiatury  
// i sprawdzający czy da się z nich ułożyć słowo “ bajt ”.

#include <conio.h>
#include <stdio.h>

using namespace std;

int main() {
    printf("Wpisz 4 znaki\n");
    char wynik = 15, temp;

    for (char i = 0; i < 4; i++)
    {
        scanf("%c", &temp);
        switch (temp)
        {
        case 'b':
            wynik = wynik ^ 8;
            break;
        case 'a':
            wynik = wynik ^ 4;
            break;
        case 'j':
            wynik = wynik ^ 2;
            break;
        case 't':
            wynik = wynik ^ 1;
            break;
        default:
            break;
        }
    }

    if (!wynik) {
        printf("\nMozna napisac bajt\n");
    }
    else
    {
        printf("\nNie mozna napisac bajt\n");
    }












}