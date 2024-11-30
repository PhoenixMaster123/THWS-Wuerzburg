#include <semaphore.h>
#include <string.h>
#include<time.h>

sem_t sem;
int balance;
struct timespec t;
char* ownerName, ownerAddress;

int main() {
    sem_init(&sem, 0, 1);

    sem_destroy(&sem);
}
// using the same semaphore:

void setCoreData(char *name, char *addr) {
    sem_wait(&sem);
    strcpy(ownerName, name);
    strcpy(ownerAddress, addr);
    sem_post(&sem);
}

void deposit(int amount) {
    int sw = sem_timedwait(&sem, &t);

    int temp = balance + amount;
    balance = temp;

    sem_post(&sem);
}
