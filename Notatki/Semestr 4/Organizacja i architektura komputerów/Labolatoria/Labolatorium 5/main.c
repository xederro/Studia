#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 1024
#define COLS 1024

unsigned long long getClock(int);
unsigned long long start, stop;
int main() { 
	int array[ROWS][COLS];
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            start = getClock(0);
            int tmp = array[i][j];
            stop = getClock(1);
            printf("%llu\n", stop-start);
        }
    }
    return 0;
}
