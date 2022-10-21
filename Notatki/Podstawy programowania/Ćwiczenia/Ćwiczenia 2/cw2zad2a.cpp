#include <stdio.h>

using namespace std;

int main()
{
    int height;
    printf("Wprowadz wysokosc: ");
    scanf("%d", &height);

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            printf("#");
        }
        printf("\n");
    }

    printf("\n\n\n\n");

    for (int i = height; i >= 0; i--)
    {
        for (int j = 0; j < i; j++)
        {
            printf("#");
        }
        printf("\n");
    }

    printf("\n\n\n\n");

    for (int i = 0; i < height * 2; i += 2)
    {
        for (int j = 0; j < height - (i / 2) - 1; j++)
        {
            printf(" ");
        }

        for (int j = 0; j <= i; j++)
        {
            printf("#");
        }
        printf("\n");
    }

    return 0;
}