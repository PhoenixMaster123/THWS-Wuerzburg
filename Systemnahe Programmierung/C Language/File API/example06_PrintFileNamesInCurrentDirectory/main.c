#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <dirent.h>

int main() {
    DIR *dir;
    struct dirent *direntry;

    if((dir = opendir(".")) != NULL) {
        while((direntry = readdir(dir)) != NULL) {
            printf("%s\n", (*direntry).d_name);
        }
    }
    closedir(dir);

    return EXIT_SUCCESS;

}
