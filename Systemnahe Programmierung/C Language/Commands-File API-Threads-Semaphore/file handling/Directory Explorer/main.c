#include <dirent.h>
#include <stdio.h>
int main() {
    struct dirent *dir;  // Pointer for directory entry

    DIR *directory = opendir(".");
    if(directory == NULL) {
        printf("Current directory count not open");
        return 1;
    }
    while((dir = readdir(directory))) {
        printf("%s\n", dir->d_name);
    }
    closedir(directory);
    return 0;
}