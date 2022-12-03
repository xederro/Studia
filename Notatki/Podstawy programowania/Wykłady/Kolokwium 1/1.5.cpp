// Napisz program, który wczyta z klawiatury 4 liczby rzeczywiste,  
// a następnie wyświetli informację ile z nich ma wartości ujemne.

#include <stdio.h>

using namespace std;

int main() {
    float temp;
    int ujemne = 0;
    printf("Wpisz 4 liczby rzeczywiste\n");

    for (int i = 0; i < 4; i++) {
        scanf("%f", &temp);
        if (temp < 0)
        {
            ujemne++;
        }
    }

    printf("%d byly ujemne\n", ujemne);
}