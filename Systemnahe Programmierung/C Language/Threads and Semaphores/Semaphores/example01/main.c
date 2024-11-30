#include<semaphore.h>

sem_t sem;
int balance = 300;

int main() {
    sem_init(&sem, 0, 1);

    sem_destroy(&sem);
}

void deposit(int amount) {
    sem_wait(&sem);

    int temp = balance + amount;
    balance = temp;

    sem_post(&sem);
}