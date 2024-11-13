#include <stdio.h>

// Variant 1:
void binaryConvert(int number) {
    char binary[10];
    int counter = 0;

    if (number == 0) {  // Edge case for zero
        printf("0");
        return;
    }

    while (number != 0) {
        binary[counter++] = (number % 2) ? '1' : '0';
        number = number / 2;
    }
    binary[counter] = '\0';

    for (int i = counter - 1; i >= 0; i--) {
        printf("%c", binary[i]);
    }
    printf("\n");
}
// Variant 2:
unsigned int int_to_int(unsigned int k) {
    return (k == 0 || k == 1 ? k : ((k % 2) + 10 * int_to_int(k / 2)));
}

int main(void) {

    int number;
    printf("Enter a number: ");
    scanf("%d", &number);

    binaryConvert(number);

    // Variant 2:
    int result = int_to_int(number);
    printf("Binary representation of %d is: %d\n", number, result);
    return 0;
}
