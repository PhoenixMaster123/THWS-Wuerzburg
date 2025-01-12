#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_SIZE 1000000
int numbers[ARRAY_SIZE];
#define NUM_ITERATIONS 1000
#define NUM_THREADS 3

// Parallel versions
void *findMax(void *arg) {
    int threadIndex = *(int *)arg;
    free(arg); // Free dynamically allocated memory

    int arraySize = sizeof(numbers) / sizeof(numbers[0]);
    int segmentSize = arraySize / NUM_THREADS;

    int start = threadIndex * segmentSize;
    int end = (threadIndex == NUM_THREADS - 1) ? arraySize : start + segmentSize;

    int *max = malloc(sizeof(int));
    *max = numbers[start];

    for (int i = start; i < end; i++) {
        if (numbers[i] > *max) {
            *max = numbers[i];
        }
    }
    pthread_exit(max);
}

// Sequential version
int findMaxSequential() {
    int arraySize = sizeof(numbers) / sizeof(numbers[0]);
    int max = numbers[0];

    for (int i = 1; i < arraySize; i++) {
        if (numbers[i] > max) {
            max = numbers[i];
        }
    }
    return max;
}

int main(void) {
    pthread_t threads[NUM_THREADS];
    int globalMax = 0;
    struct timespec start, end;

    // Parallel execution
    clock_gettime(CLOCK_MONOTONIC, &start);

    for (int i = 0; i < NUM_THREADS; i++) {
        int *threadIndex = malloc(sizeof(int));
        *threadIndex = i; // Index
        pthread_create(&threads[i], NULL, findMax, threadIndex);
    }

    for (int i = 0; i < NUM_THREADS; i++) {
        int *threadMax;
        pthread_join(threads[i], (void **)&threadMax);

        if (*threadMax > globalMax) {
            globalMax = *threadMax;
        }
        free(threadMax);
    }

    clock_gettime(CLOCK_MONOTONIC, &end);

    double parallelTime = (end.tv_sec - start.tv_sec) * 1000.0;
    parallelTime += (end.tv_nsec - start.tv_nsec) / 1000000.0;

    printf("Maximum value (parallel): %d\n", globalMax);
    printf("Time taken by threads: %.3f ms\n", parallelTime);

    // Sequential execution
    clock_gettime(CLOCK_MONOTONIC, &start);

    globalMax = findMaxSequential();

    clock_gettime(CLOCK_MONOTONIC, &end);

    double sequentialTime = (end.tv_sec - start.tv_sec) * 1000.0;
    sequentialTime += (end.tv_nsec - start.tv_nsec) / 1000000.0;

    printf("Maximum value (sequential): %d\n", globalMax);
    printf("Time taken sequentially: %f ms\n", sequentialTime);

    double averageParallelTime = parallelTime / NUM_THREADS;
    double averageSequentialTime = sequentialTime / NUM_THREADS;

    printf("The average parallel time is: %f ms\n", averageParallelTime);
    printf("The average sequential time is: %f ms\n", averageSequentialTime);

    // Gnuplot: Pipe data and commands
    FILE *gp = popen("gnuplot -persistent", "w");
    if (gp == NULL) {
        printf("Error opening gnuplot\n");
        exit(1);
    }

    // Send commands to gnuplot
    fprintf(gp, "set title 'Execution Time Comparison'\n");
    fprintf(gp, "set xlabel 'Execution Type'\n");
    fprintf(gp, "set ylabel 'Time (ms)'\n");
    fprintf(gp, "set style data histogram\n");
    fprintf(gp, "set style fill solid\n");
    fprintf(gp, "set boxwidth 0.5\n");
    fprintf(gp, "plot '-' using 2:xtic(1) title 'Time' lc rgb 'blue'\n");
    fprintf(gp, "'Parallel' %f\n", parallelTime);
    fprintf(gp, "'Sequential' %f\n", sequentialTime);
    fprintf(gp, "'AverageParallel %f\n", averageParallelTime);
    fprintf(gp, "'AverageSequential %f\n", averageSequentialTime);
    fprintf(gp, "e\n");

    pclose(gp);
    return 0;
}
