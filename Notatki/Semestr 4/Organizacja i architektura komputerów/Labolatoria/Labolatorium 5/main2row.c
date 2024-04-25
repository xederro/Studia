#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 1024
#define COLS 1024

unsigned long long getClock(int);

int main() { 
	int array[ROWS][COLS];
    unsigned long long stop, start;
	
	start = getClock(0);
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            int tmp = array[i][j];
        }
    }
    stop = getClock(1);
    printf("%llu cycles\n", stop-start);
    return 0;
}
