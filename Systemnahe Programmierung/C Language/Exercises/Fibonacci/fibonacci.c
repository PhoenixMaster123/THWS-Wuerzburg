#include<stdio.h>

int fib(int);

int main()
{
  int n;
  scanf("%d", &n);

  int result = fib(n);
  printf("%d", result);
  return 0;
}

int fib(int n) 
{
  if(n == 0 || n == 1)
  {
    return n;
  }
  return fib(n - 1) + fib(n - 2);
}
