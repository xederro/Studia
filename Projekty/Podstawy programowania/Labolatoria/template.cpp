#include <stdio.h>
int main()
{
    int a = 6, b = 4;
    char c = 'A';
    float x = 3, y = 8;

    printf("A=%d B=%3d A-B=%-3d A/B=%+3d\n", a, b, a - b, a / b);
    printf("X=%f ,Y=%5.1f\n", x, y, x - y, x / y);
    printf("X-Y=%+5.1f, X/Y=%-5.1f\n", x - y, x / y);
    printf("B-A=(b-a), Y-X=%+5d%-5.0f\n", b - a, y - x);
    printf("%c+%+3d+%-5.1f=%%e-3d%d", ++c, a++ + ++b, x * x, a);
    return 0;
}