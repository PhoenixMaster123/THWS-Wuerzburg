#include <stdio.h>
#include <pthread.h>

typedef struct thread_data {
    int* start;
    int* end;
    long long sum;
} pthread_data;

void* sum(void* arg) {
    pthread_data* data = (pthread_data*)arg;
    data->sum = 0;
    for (int* temp = data->start; temp < data->end; temp++) {
        data->sum += *temp;
    }
    return NULL;
}

int main() {
    pthread_t thread[2];
    int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int numbers_length = sizeof(numbers) / sizeof(int);

    pthread_data data[2];
    int chunk_size = numbers_length / 2;

    // Partition data for threads
    for (int i = 0; i < 2; i++) {
        data[i].start = numbers + i * chunk_size;
        data[i].end = (i == 1) ? (numbers + numbers_length) : (numbers + (i + 1) * chunk_size);
        data[i].sum = 0;
        pthread_create(&thread[i], NULL, sum, &data[i]);
    }

    long long total_sum = 0;

    // Wait for threads and accumulate results
    for (int i = 0; i < 2; i++) {
        pthread_join(thread[i], NULL);
        total_sum += data[i].sum;
    }

    printf("Total Sum: %lld\n", total_sum);
    return 0;
}
