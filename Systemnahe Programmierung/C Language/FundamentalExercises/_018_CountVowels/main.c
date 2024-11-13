#include <stdbool.h>
#include <stdio.h>
#include <string.h>

bool isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

int countVowels(char str[]) {
    int count = 0;
    for (int i = 0; i < strlen(str); i++) {
        if(isVowel(str[i])) {
            count++;
        }
    }
    return count;
}

int main(void) {
    char str[255];
    printf("Enter a string: ");
    fgets(str, 255, stdin);

    int vowels = countVowels(str);
    printf("Number of vowels: %d\n", vowels);
    return 0;
}
