#include <pthread_time.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>

void my_signal_handler(int sig) {
    printf("I got signal %d\n", sig);
    signal(SIGINT, SIG_DFL);
}


int main(void) {
    signal(SIGINT, my_signal_handler);

    while (1) {
        printf("Waiting for signal...\n");
       _sleep(1);
    }
}
