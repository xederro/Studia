// Napisz program wczytujący 4 liczby rzeczywiste i wyznaczający średnią  
// arytmetyczną z liczb pozostałych po odrzuceniu dwóch najmniejszych wartości.

#include <stdio.h>

using namespace std;

int main() {
    float a, b, temp;

    printf("Wpisz 4 liczby rzeczywiste\n");
    scanf("%f%f%f", &a, &b, &temp);
    if (temp > a)
    {
        if (a > b)
        {
            b = a;
        }
        a = temp;
    }
    scanf("%f", &temp);
    if (temp > a)
    {
        if (a > b)
        {
            b = a;
        }
        a = temp;
    }

    printf("\nSrednia liczb %f i %f jest rowna: %f", a, b, (a + b) / 2);
}