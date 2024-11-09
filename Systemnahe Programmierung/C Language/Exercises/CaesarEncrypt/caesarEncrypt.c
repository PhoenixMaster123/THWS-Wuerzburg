#include<stdio.h>
#include <string.h>

// Variant 1:
void encrypt(char str[]) {

  int length = strlen(str);

  for(int i = 0; i < length; i++) {
    
    int ascii = str[i];

    if (ascii >= 65 && ascii <= 90) {

            ascii = ((ascii - 65 + 3) % 26) + 65;
    }
    else if(ascii >= 97 && ascii <= 122) {
      ascii = (((ascii - 97 + 3) % 26) + 97) - 32;
    }
     printf("%c", ascii);
  }
}

int main() {
  char word[255];
  printf("Give me a word to encrypt: ");
  //scanf("%s", word); // Variant 1
  //encrypt(word); // Variant 1
  
  // Variant 2:
  
  fgets(word, 255, stdin );

  for(int i = 0; i < strlen(word); i++) {
    char c = word[i];

    if(c >= 'A' && c <= 'Z') {
      c = ((c - 65 + 3) % 26) + 65; // % 26 -> not to overflow
    }
    else if(c >= 'a' && c <= 'z') {
      c = ((c - 97 + 3) % 26) + 97;
    }
    word[i] = c;
  }

  printf("The result is: %s\n", word);


  return 0;
}
