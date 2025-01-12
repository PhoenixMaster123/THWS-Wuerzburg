#include <stdio.h>
#include <ctype.h>

void count_upper_lower(const char *text, int *upper, int *lower) {
    *upper = 0;
    *lower = 0;

    while (*text) {
        if (isupper(*text)) {
            (*upper)++;
        } else if (islower(*text)) {
            (*lower)++;
        }
        text++;
    }
}

int main() {
    const char *sample_text = "Hello, World! 123";
    int upper_count = 0, lower_count = 0;

    // Call the function to count upper and lower case characters
    count_upper_lower(sample_text, &upper_count, &lower_count);

    // Print the results
    printf("Uppercase letters: %d\n", upper_count);
    printf("Lowercase letters: %d\n", lower_count);

    return 0;
}
