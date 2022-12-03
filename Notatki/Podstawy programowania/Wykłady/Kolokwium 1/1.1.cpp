// Napisz program wczytujący 4 liczby całkowite i sprawdzający  
// ile jest wśród nich powtórzeń (dwójek, trójek lub czwórek).

#include <stdio.h>

using namespace std;

int main() {
    int a, b, c, d = 0;

    printf("Wpisz 4 liczby calkowite\n");
    scanf("%d%d%d%d", &a, &b, &c, &d);

    int rowne = 0;

    if (a == b) rowne++;
    if (a == c) rowne++;
    if (a == d) rowne++;
    if (b == c) rowne++;
    if (b == d) rowne++;
    if (c == d) rowne++;

    switch (rowne)
    {
    case 6:
        printf("1 Czworka\n");
        break;
    case 3:
        printf("1 Trojka\n");
        break;
    case 2:
        printf("2 Dwojki\n");
        break;
    case 1:
        printf("1 Dwojka\n");
        break;
    case 0:
        printf("Brak rownych\n");
        break;
    default:
        break;
    }

}