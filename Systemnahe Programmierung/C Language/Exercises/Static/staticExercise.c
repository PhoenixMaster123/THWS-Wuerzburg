#include<stdio.h>

void foo(int a) {
  static int counter = 0;
  counter += a;
  printf("Counter: %d\n", counter);
}

void main() {
  foo(10);
  foo(20);

  // Result:
  // Counter: 10
  // Counter: 30
  // -> The counter static varible keeps the result from the privious called.
}




/*static int NUMBER = 5;

void increase()
{
  NUMBER++;
}

int main()
{
  printf("%d\n", NUMBER);
  
  for(int i = 0; i < 5; i++) {
    increase();
    printf("%d\n", NUMBER);
  }

  return 0;
}
*/

