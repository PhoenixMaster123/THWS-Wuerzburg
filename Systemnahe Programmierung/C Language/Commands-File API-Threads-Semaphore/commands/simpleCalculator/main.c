

#include <stdio.h>
#include <stdlib.h>

int main(int args, char *argv[]) {
    if (args != 4) {
        printf("Wrong number of arguments\n");
        return -1;
    }
    int num1 = strtol(argv[1], NULL, 10);
    int num2 = strtol(argv[2], NULL, 10);
    char op = argv[3][0];
    int result;
    switch (op) {
        case '+':
            result = num1 + num2;
        break;
        case '-':
            result = num1 - num2;
        break;
        case '*':
            result = num1 * num2;
        break;
        case '/':
            if (num2 == 0) {
                printf("Division by zero is not allowed\n");
                return -1;
            }
        result = num1 / num2;
        break;
        default:
            printf("Unknown error\n");
        return -1;
    }
    printf("Result: %d\n", result);

}
