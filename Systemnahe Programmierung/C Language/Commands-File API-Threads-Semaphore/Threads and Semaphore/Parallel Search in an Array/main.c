#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define NUM_THREADS 5

int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
int numberToSearch;
bool found = false;  // Shared flag to indicate if the number is found
pthread_mutex_t lock;  // Mutex to synchronize access to `found`

void *search(void *arg) {
    int startIndex = *(int *)arg;
    free(arg);  // Free the dynamically allocated memory

    int segmentSize = sizeof(numbers) / sizeof(numbers[0]) / NUM_THREADS;

    // Calculate the segment range
    int start = startIndex * segmentSize;
    int end = (startIndex == NUM_THREADS - 1) ? sizeof(numbers) / sizeof(numbers[0]) : start + segmentSize;

    for (int i = start; i < end; i++) {
        pthread_mutex_lock(&lock);
        if (found) {  // If already found by another thread, exit
            pthread_mutex_unlock(&lock);
            return NULL;
        }
        if (numbers[i] == numberToSearch) {
            found = true;
            printf("Number %d found at index %d by thread %d\n", numberToSearch, i, startIndex);
            pthread_mutex_unlock(&lock);
            return NULL;
        }
        pthread_mutex_unlock(&lock);
    }
    return NULL;
}

int main() {
    pthread_t threads[NUM_THREADS];

    // Initialize mutex
    if (pthread_mutex_init(&lock, NULL) != 0) {
        perror("Mutex initialization failed");
        return 1;
    }

    printf("Enter the number to search: ");
    scanf("%d", &numberToSearch);

    // Create threads
    for (int i = 0; i < NUM_THREADS; i++) {
        int *arg = malloc(sizeof(int));
        *arg = i;
        if (pthread_create(&threads[i], NULL, &search, arg) != 0) {
            perror("Failed to create thread");
            return 1;
        }
    }

    // Wait for all threads to finish
    for (int i = 0; i < NUM_THREADS; i++) {
        if (pthread_join(threads[i], NULL) != 0) {
            perror("Failed to join thread");
        }
    }

    // Check if the number was found
    if (!found) {
        printf("Number %d not found in the array.\n", numberToSearch);
    }

    // Destroy mutex
    pthread_mutex_destroy(&lock);

    return 0;
}
