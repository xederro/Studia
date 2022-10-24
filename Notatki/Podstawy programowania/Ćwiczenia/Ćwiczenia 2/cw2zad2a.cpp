#include <stdio.h>

using namespace std;

int main()
{
    unsigned int height;
    printf("Wprowadz wysokosc: ");
    scanf("%u", &height);

    for (unsigned int i = 0; i < height; i++)
    {
        for (unsigned int j = 0; j <= i; j++)
        {
            printf("#");
        }
        printf("\n");
    }

    printf("\n\n\n\n");

    for (long int i = height; i >= 0; i--)
    {
        for (unsigned int j = 0; j < i; j++)
        {
            printf("#");
        }
        printf("\n");
    }

    printf("\n\n\n\n");

    for (unsigned int i = 0; i < height * 2; i += 2)
    {
        for (unsigned int j = 0; j < height - (i / 2) - 1; j++)
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