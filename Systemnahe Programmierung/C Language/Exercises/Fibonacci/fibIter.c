#include<stdio.h>

long fib(unsigned int n) {
  if(n == 0) 
    return 0;
  else if(n == 1) 
      return 1;
  else {
     unsigned long t1 = 0, t2 = 1;
     unsigned long next = 0;

    for(int i = 2; i <= n; i++) {
      next = t1 + t2;
      t1 = t2;
      t2 = next;
    }
    return next;
  }
}

int main()
{
  unsigned int n;
  scanf("%d", &n);
  unsigned long result = fib(n);
  printf("The result is: %ld\n", result);

  return 0;
}

