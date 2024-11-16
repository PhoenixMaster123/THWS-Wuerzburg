#include <stdio.h>

int myStrlen(char * a) {
    char *x = a;

    while (*x != '\0') {
        x++;
    }
    return x - a;
}

int main(void) {
    char input[255];
    printf("Enter string: ");
    fgets(input, 255, stdin);
    printf("Lenght: %d\n", myStrlen(input));
    return 0;
}
