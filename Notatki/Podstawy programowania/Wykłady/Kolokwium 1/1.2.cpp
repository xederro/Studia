// Napisz program wczytujący znaki z klawiatury  
// do momentu aż da się z nich złożyć słowo “ **tato** ”

#include <conio.h>
#include <stdio.h>

using namespace std;

int main() {
    printf("Wpisuj znaki puki nie da sie zlozyc 'tato'\n");

    char t = 2, a = 1, o = 1, character;

    do
    {
        character = getch();
        printf("%c", character);
        switch (character)
        {
        case 't':
            t--;
            break;
        case 'a':
            a--;
            break;
        case 'o':
            o--;
            break;
        default:
            break;
        }
    } while (t > 0 || a > 0 || o > 0);


    printf("\nMozna napisac tato\n");



}