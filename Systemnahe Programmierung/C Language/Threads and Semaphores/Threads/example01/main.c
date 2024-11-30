#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *hello(void *i) {
    printf("Hello World %d\n", i);
    pthread_exit(NULL);
}

int main(void) {
   pthread_t threads[10];
   for (int i = 0; i < 10; ++i) {
       pthread_create(&threads[i], NULL, hello, (void*)i);
   }
   for (int i = 0; i < 10; ++i) {
       pthread_join(threads[i], NULL);
   }
    pthread_exit(NULL);
}
