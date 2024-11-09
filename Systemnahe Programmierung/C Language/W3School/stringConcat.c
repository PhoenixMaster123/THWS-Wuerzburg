#include<stdio.h>
#include<string.h>

int main() {

	char str1[20] = "Hello ";
	char str2[20] = "World!";

	strcat(str1,str2); // concatenate str2 to str1

	printf("%s\n", str1);


	return 0;
}
