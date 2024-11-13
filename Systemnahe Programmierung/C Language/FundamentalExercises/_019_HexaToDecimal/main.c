#include <math.h>
#include <stdio.h>
#include <string.h>

int hexCharToDecimal(char hexChar) {
    if (hexChar >= '0' && hexChar <= '9') {
        return hexChar - '0';
    } else if (hexChar >= 'A' && hexChar <= 'F') {
        return hexChar - 'A' + 10;
    } else if (hexChar >= 'a' && hexChar <= 'f') {
        return hexChar - 'a' + 10;
    } else {
        return -1;  // Invalid character for hexadecimal
    }
}

int convertHexaToDecimal(char hexString[]) {
    int decimal = 0;
    int length = strlen(hexString);

    for (int i = 0; i < length; i++) {
        int currentDigit = hexCharToDecimal(hexString[i]);
        if (currentDigit == -1) {
            printf("Invalid hexadecimal character: %c\n", hexString[i]);
            return -1;
        }
        decimal = decimal * 16 + currentDigit;
    }
    return decimal;
}

int main(void) {
    char hexString[100];
    printf("Enter a hexadecimal number: ");
    fgets(hexString, 100, stdin);
    hexString[strlen(hexString) - 1] = '\0';

    int convertResult = convertHexaToDecimal(hexString);
    if (convertResult != -1) {
        printf("The decimal number is: %d\n", convertResult);
    }
    return 0;
}
