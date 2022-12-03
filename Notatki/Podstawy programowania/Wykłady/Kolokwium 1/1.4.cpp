// Napisz program wczytujący z klawiatury 3 liczby rzeczywiste  
// a następnie wyświetlający je w kolejności rosnących wartości.

#include <stdio.h>

using namespace std;

int main() {
    float a, b, c;

    printf("Wpisz 3 liczby rzeczywiste\n");
    scanf("%f%f%f", &a, &b, &c);

    if (a > b) {
        if (b > c) {
            printf("\n%f, %f, %f", a, b, c);
        }
        else {
            if (a > c) {
                printf("\n%f, %f, %f", a, c, b);
            }
            else {
                printf("\n%f, %f, %f", a, c, b);
            }
        }
    }
    else {
        if (a > c) {
            printf("\n%f, %f, %f", b, a, c);
        }
        else {
            if (b > c) {
                printf("\n%f, %f, %f", b, c, a);
            }
            else {
                printf("\n%f, %f, %f", c, b, a);
            }
        }
    }
}