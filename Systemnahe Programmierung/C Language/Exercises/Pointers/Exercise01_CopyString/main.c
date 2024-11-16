#include <stdio.h>
#include <string.h>

void myStrCry(char *dest, char *src) {
    char *address = dest;
    while (*src != '\0') {
        *address++ = *src;
        src++;
    }
    *address = '\0';
}
void myStrCry2(char *dest, char *src) {
    while ((*dest++ = *src++) != '\0');
}


int main(void) {
    char a[] = "Hello";
    char b[20];
    myStrCry(b, a);
    printf("%s\n", b);
    char c[] = "Hello World";
    myStrCry2(b, c);
    printf("%s\n", b);

    return 0;
}
