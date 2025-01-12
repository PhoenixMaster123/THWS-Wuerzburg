#include <stdio.h>
#include <string.h>

int main(int args, char *argv[]) {
    if (args == 1) {
        printf("No options provided. Use -h or --help for usage information.\n");
        return 0;
    }
    for (int i = 1; i < args; i++) {
        char *command = argv[i];
        if(strcmp(command, "-h") == 0 || strcmp(command, "--help") == 0) {
            printf("Usage: %s [command]\n", command);
        } else {
            printf("The wrong command was: %s\n", command);
        }
    }
}
