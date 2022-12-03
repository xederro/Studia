// Napisz program wczytujący 4 liczby rzeczywiste  
// i wyznaczający średnią arytmetyczną z liczb pozostałych  
// po odrzuceniu wartości skrajnych (tzn. maksimum i minimum).

#include <stdio.h>

using namespace std;

int main() {
    float a, b, c, d, min, max;

    printf("Wpisz 4 liczby rzeczywiste\n");
    scanf("%f%f%f%f", &a, &b, &c, &d);

    if (a <= b && a <= c && a <= d)
    {
        min = a;
    }
    if (b <= a && b <= c && b <= d)
    {
        min = b;
    }
    if (c <= b && c <= a && c <= d)
    {
        min = c;
    }
    if (d <= b && d <= c && d <= a)
    {
        min = d;
    }


    if (a >= b && a >= c && a >= d)
    {
        max = a;
    }
    if (b >= a && b >= c && b >= d)
    {
        max = b;
    }
    if (c >= b && c >= a && c >= d)
    {
        max = c;
    }
    if (d >= b && d >= c && d >= a)
    {
        max = d;
    }







    printf("\nSrednia jest rowna: %f", (a + b + c + d - min - max) / 2);
}