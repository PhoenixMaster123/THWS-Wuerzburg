#include <semaphore.h>
#include <string.h>
#include<time.h>

sem_t sem, sem_data;
int balance;
struct timespec t;
char* ownerName, ownerAddress;

int main() {
    sem_init(&sem, 0, 1);

    sem_destroy(&sem);
}
// using the same semaphore:

void setCoreData(char *name, char *addr) {
    sem_wait(&sem_data);
    strcpy(ownerName, name);
    strcpy(ownerAddress, addr);
    sem_post(&sem_data);
}

void deposit(int amount) {
    int sw = sem_timedwait(&sem, &t);

    int temp = balance + amount;
    balance = temp;

    sem_post(&sem);
}
