#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 3072
#define COLS 16

unsigned long long getClock(int);
unsigned long long start, stop;
int main() {
	int array[ROWS][COLS];
  int tmp;
  start = getClock(0);
  tmp = array[0][0];
  stop = getClock(1);
  printf("%llu\n", stop-start);
  for (int i = 0; i < ROWS; i+=256) {
      tmp += array[i][0];
  }
  printf("%d\n", tmp);
  start = getClock(0);
  tmp = array[0][0];
  stop = getClock(1);
  printf("%llu\n", stop-start);
  return 0;
}
