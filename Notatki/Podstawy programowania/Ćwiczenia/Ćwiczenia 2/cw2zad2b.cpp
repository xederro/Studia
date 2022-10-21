#include <stdio.h>

using namespace std;

int main()
{
    int height;
    printf("Enter height: ");
    scanf("%d", &height);

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j <= (2 * height) - 1; j++)
        {

            if (
                j == 0 ||
                j == (2 * height) - 1 ||
                j == i ||
                j == (2 * height) - 1 - i)
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