#include <stdio.h>

using namespace std;

int main()
{
    int height;
    printf("Enter height: ");
    scanf("%d", &height);

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j <= (2 * height) - 2; j++)
        {

            if (
                j == 0 ||
                j == (2 * height) - 2 ||
                j == i ||
                j == (2 * height) - 2 - i)
            {
                printf("#");
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }

    printf("\n\n\n\n\n");

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < height; j++)
        {

            if (
                j == 0 ||
                j == height - 1 ||
                j == i)
            {
                printf("#");
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }

    printf("\n\n\n\n\n");

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < height; j++)
        {

            if (
                i == 0 ||
                i == height - 1 ||
                j == height - i - 1)
            {
                printf("#");
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}