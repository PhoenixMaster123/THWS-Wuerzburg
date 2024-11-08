#include<stdio.h>

int fib(int); // We also can implement the logic here

int main()
{
  int n; // unsigned int n is better, because we want the number to be positive (non-negative) range: 0 to 2^32
  scanf("%d", &n);

  int result = fib(n); // unsigned long result
  printf("%d", result); // %ld (long) 
  return 0;
}

// recursiv
int fib(int n)
{
  if(n == 0 || n == 1)
  {
    return n;
  }
  return fib(n - 1) + fib(n - 2);
}
