#include <stdbool.h>
#include <stdio.h>

int main(void) {

    int number;
    printf("Enter a number: ");
    scanf("%d", &number);

    if(number < 2) {
        printf("The number is not a prime %d", number);
    }
    bool isPrime = true;
    for(int i = 2; i <= number / 2; i++) {
        if(number % i == 0) {
            printf("The number is not a prime %d", i);
            isPrime = false;
            break;
        }
    }
    if(isPrime) {
        printf("The number is prime %d", number);
    }

    return 0;
}
