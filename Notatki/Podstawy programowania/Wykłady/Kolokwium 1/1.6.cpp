// Napisz program, który policzy pierwiastki trójmianu kwadratowego
// A*x2 + B*x + C = 0,  o współczynnikach A, B, C wprowadzanych z klawiatury

#include <stdio.h>
#include <math.h>

using namespace std;

int main() {
    float a, b, c = 0;

    printf("Wpisz 3 liczby rzeczywiste odpowiadajace A,B,C trojmiany Ax^2 + Bx + C = 0\n");
    scanf("%f%f%f", &a, &b, &c);

    double delta = b * b - 4 * a * c;

    if (delta > 0) {
        printf("Rozwiazania: X1 = %f, X2 = %f", (-b + sqrt(delta)) / (2 * a), (-b - sqrt(delta)) / (2 * a));
    }
    else if (delta == 0) {
        printf("Rozwiazanie: X = %f", (-b) / (2 * a));
    }
    else {
        printf("Brak rozwiazan rzeczywistych");
    }
}