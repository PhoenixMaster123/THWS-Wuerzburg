// Critical Region example explanation:
#include <pthread.h>
#include <stdio.h>
int x = 5;

void foo(int s) {
    printf("Hello World\n");
    // Begin a critical section
    int y = x;
    y = y + s;
    x = y;
    printf("Good Bye\n");
    // End a critical section
}