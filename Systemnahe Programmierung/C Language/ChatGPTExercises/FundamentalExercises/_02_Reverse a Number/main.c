#include <stdio.h>
#include <string.h>

int reverseNumber(int number);

int main(void) {
    int number;
    printf("Enter a number: ");
    scanf("%d", &number);

    char convert[30];
    sprintf(convert, "%d", number);
    char reverse[30];

    int len = strlen(convert); // Note: the length need to be before the loop in another variable otherwise is a problem
    int counter = 0;

    if(number > 0) {
        for(int i = len - 1; i >= 0; i--) {
            reverse[counter] = convert[i];
            counter++;
        }
    } else {
        counter = 1;
        for(int i = len - 1; i > 0; i--) {
            reverse[counter] = convert[i];
            counter++;
        }
        reverse[0] = '-';
    }
    reverse[counter] = '\0';
    printf("The reverse of the given number is %s\n", reverse);
    return 0;
}
