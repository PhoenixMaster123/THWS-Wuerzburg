#include<stdio.h>

double addNumbers(int, double);

void main()
{
  double result = addNumbers(5, 5.5);
  printf("%.2f", result);
}

double addNumbers(int num1, double num2) 
{
  return num1 + num2;
}


