#include<stdio.h>
#include<string.h>

// struct <=> class in Java

struct person { 
  char firstName[255]; // padding -> 256 bytes
  char lastName[255]; // padding -> 256 bytes
  unsigned int age;  // int -> 4 bytes
};

int main() {
  struct person oliver;

  strcpy(oliver.firstName, "Oliver"); // strcpy -> assign value to a string, otherwise it will be an error
  printf("%s\n", oliver.firstName);
  printf("The size of this struct is: %ld\n", sizeof(oliver));

  struct person p = {"Boby", "Fisher", 26};

  printf("%s %s %d \n", p.firstName, p.lastName, p.age);

  return 0;
}
