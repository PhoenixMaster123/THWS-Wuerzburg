#include<stdio.h>

const int size = 20;
#define SIZE 20; // macro
// int data[size]; // -> I will receive an error, because is const
// int data[20]; // -> works
// int data[SIZE] // works

int main() {
  print("Hello World");
  return 0;
}
