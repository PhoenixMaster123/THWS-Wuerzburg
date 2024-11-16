#include <stdio.h>

int main(void) {
    char input[255];
    char *pe1 = input;
    char *pe2 = &input[0];

    fgets(input, 255, stdin);

    printf("%c\n", input[5]); // take the 4th element
    printf("%c\n", *(input + 5)); // take the 4th element
    printf("%c\n", *(pe1 + 5)); // take the 4th element

    pe1++;
    printf("%c\n", *pe1);

    return 0;
}
