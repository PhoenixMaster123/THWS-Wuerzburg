#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
int numberToSearch;
#define NUM_THREADS 3

void *search(void *arg) {
    int threadIndex = *(int *)arg;
    free(arg);  // Free dynamically allocated memory

    int arraySize = sizeof(numbers) / sizeof(numbers[0]);
    int segmentSize = arraySize / NUM_THREADS;

    int start = threadIndex * segmentSize;
    int end = (threadIndex == NUM_THREADS - 1) ? arraySize : start + segmentSize;

    for (int i = start; i < end; i++) {
        if (numbers[i] == numberToSearch) {
            printf("Number %d found at index %d by thread %d\n", numberToSearch, i, threadIndex);
            pthread_exit((void *)1);  // Return a success flag
        }
    }

    pthread_exit((void *)0);  // Return a failure flag
}

int main() {
    pthread_t threads[NUM_THREADS];
    int found = 0;

    printf("Enter the number to search: ");
    scanf("%d", &numberToSearch);

    // Create threads
    for (int i = 0; i < NUM_THREADS; i++) {
        int *arg = malloc(sizeof(int));
        *arg = i;  // Thread index
        if (pthread_create(&threads[i], NULL, &search, arg) != 0) {
            perror("Failed to create thread");
            return 1;
        }
    }

    // Wait for threads and check results
    for (int i = 0; i < NUM_THREADS; i++) {
        void *result;
        if (pthread_join(threads[i], &result) != 0) {
            perror("Failed to join thread");
        }
        if ((int)result == 1) {
            found = 1;
        }
    }

    if (!found) {
        printf("Number %d not found in the array.\n", numberToSearch);
    }

    return 0;
}