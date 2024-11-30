#include <semaphore.h>
#include <stdio.h>

sem_t mutex;
int counter;

int addAndGet(int x) {
    sem_wait(&mutex);
    counter += x;

    int r = counter;
    sem_post(&mutex);
    return r;
}

int main() {
    sem_init(&mutex, 0, 1);
    printf("%d\n", addAndGet(10));
    sem_destroy(&mutex);
}

int get() {
    sem_wait(&mutex);
    int r = counter;
    sem_post(&mutex);
    return r;
}

int subAndGet(int x) {
    sem_wait(&mutex);
    counter -= x;
    int r = counter;
    sem_post(&mutex);
    return r;
}
