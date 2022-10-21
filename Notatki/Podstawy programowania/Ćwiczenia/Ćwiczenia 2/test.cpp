#include <stdio.h>

using namespace std;

int main()
{

    int height;
    printf("Enter height: ");
    scanf("%d", &height);

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            printf("#");
        }
        printf("\n");
    }



    return 0;
}