#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 30720
#define COLS 16

unsigned long long getClock(int);
unsigned long long start, stop;
int main() {
	int array[ROWS][COLS];
  int tmp;
  start = getClock(0);
  tmp = array[0][0];
  stop = getClock(1);
  for (int i = 0; i < ROWS; i+=256) {
    start = getClock(0);
    tmp = array[0][0];
    stop = getClock(1);
    start = getClock(0);
    tmp = array[i][0];
    stop = getClock(1);
    printf("%llu\n", stop-start);
  }
  start = getClock(0);
  tmp = array[0][0];
  stop = getClock(1);
  return 0;
}

