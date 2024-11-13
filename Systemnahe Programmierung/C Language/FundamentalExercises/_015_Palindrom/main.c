#include <ctype.h>
#include <stdio.h>
#include <string.h>

void isPolindrom(char str[]) {
  int len = strlen(str);
  char reversed[len];

  int reverseIndex = 0;
  for (int i = len - 1; i >= 0; i--) {
    reversed[reverseIndex] = str[i];
    reverseIndex++;
  }
  reversed[reverseIndex] = '\0';

  if(strcmp(str, reversed) == 0) {
    printf("The reversed string is palindrome\n");
  } else {
    printf("The reversed string is not palindrome\n");
  }
}

int main(void) {
  char str[100];
  printf("Enter a string: ");
  fgets(str, 100, stdin);

  str[strlen(str) - 1] = '\0';

  for(int i = 0; i < strlen(str); i++) {
    str[i] = toupper(str[i]);
  }

  isPolindrom(str);

}
