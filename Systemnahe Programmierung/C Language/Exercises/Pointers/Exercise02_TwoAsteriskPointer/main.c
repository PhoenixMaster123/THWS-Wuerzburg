// #include <stdio.h>
long **foo[10]; // pointer to a pointer

int main(void) {
    long a = 1;
    long *pa = &a; // I need temporary variable
    foo[0] = &pa;
    return 0;
}