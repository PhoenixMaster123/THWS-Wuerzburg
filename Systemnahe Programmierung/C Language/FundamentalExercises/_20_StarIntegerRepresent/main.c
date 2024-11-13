#include <stdio.h>

int main() {
    int numbers[] = {3, 5, 1, 7, 4};

    int length = sizeof(numbers) / sizeof(numbers[0]);

    for (int i = 0; i < length; i++) {
        for (int j = 0; j < numbers[i]; j++) {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}
