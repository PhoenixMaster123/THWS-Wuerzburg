#include<semaphore.h>
#include<time.h>

sem_t sem;
struct timespec t;
int balance = 300;

int main() {
    sem_init(&sem, 0, 1);

    sem_destroy(&sem);
}

void deposit(int amount) {
    int sw = sem_timedwait(&sem, &t);

    int temp = balance + amount;
    balance = temp;

    sem_post(&sem);
}