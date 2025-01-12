#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>

int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

void* sum(void *args) {
    int index = *((int*)args); // Retrieve the starting index passed as an argument
    int sum = 0;
    for (int i = 0; i < 5; i++) {
        sum += numbers[index + 1];
    }
    printf("Local Sum: %d\n", sum);
    *((int*)args) = sum;  // Store the result back in the memory location pointed by args
    return args; // Return the result pointer
}

int main(void) {

    pthread_t threads[2];
    for (int i = 0; i < 2; i++) {
        int *argument = malloc(sizeof(int)); // Dynamically allocate memory for the thread argument

        // For i = 1, the second thread processes the next 5 elements of the array (index = 5).
        *argument = i * 5; // Set the starting index for the array segment

        if(pthread_create(&threads[i], NULL, &sum, argument) != 0 ) {
            perror("Failed to create thread");
        }
    }
    int globalSum = 0;
    for (int i = 0; i < 2; i++) {
        int *result; // Pointer to capture the result returned by the thread
        if(pthread_join(threads[i], (void**) &result) != 0) {
            perror("Failed to join thread");
        }
        globalSum += *result;
        free(result);
    }
    printf("Global Sum: %d\n", globalSum);
    return 0;
}
