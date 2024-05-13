#include <stdio.h>

float calcIntegral(float a, float b, unsigned int n);
float calcIntegralXMM(float a, float b, unsigned int n);
unsigned long long getClock(int isBegin);

int main(int argc, char *argv[])
{
  float a, b, res;
  unsigned long long start, stop;
  unsigned int n;

  printf("Podaj poczatek calki:\n");
  scanf("%f", &a);
  
  printf("Podaj koniec calki:\n");
  scanf("%f", &b);

  printf("Podaj na ile podzielic:\n");
  scanf("%u", &n);

  start = getClock(0);
  res = calcIntegral(a,b,n);
  stop = getClock(1);
  
  printf("Calculated Integral:\t\t%.8f\tin: %llu\n", res, stop - start);
  
  start = getClock(0);
  res = calcIntegralXMM(a,b,n);
  stop = getClock(1);
  
  printf("Calculated Integral XMM:\t%.8f\tin: %llu\n", res, stop - start);
  return 0;
}
