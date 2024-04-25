#include <stdio.h>
#include <unistd.h>

unsigned long long getClock(int);

int main() {
  
    unsigned long long start = getClock(0);
    sleep(1);
    unsigned long long stop = getClock(1);

    printf("%llu\n", stop-start);
    fflush(stdout);

    return 0;
}
