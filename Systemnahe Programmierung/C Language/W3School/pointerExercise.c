#include<stdio.h>

int main() {

	//There are two ways to declare pointer variables in C:

	// int* myNum;
	// int *myNum;

	int myAge = 43;     // An int variable
	int* ptr = &myAge;  // A pointer variable, with the name ptr, that stores the address of 
        
	// Output the value of myAge (43)
	printf("%d\n", myAge);

	// Output the memory address of myAge (0x7ffe5367e044)
	printf("%p\n", &myAge);
	
	// Output the memory address of myAge with the pointer (0x7ffe5367e044)
	printf("%p\n", ptr);
	
	printf("%d\n", *ptr);

	int myNumbers[4] = {25, 50, 75, 100}; // it reserves pro arr element 4 bytes, because int is 4 bytes


	for (int i = 0; i < 4; i++) {
	       	printf("%p\n", &myNumbers[i]);
	}

	// Pointers + Arrays:
	
	// Get the value of the first element in myNumbers
	printf("%d\n", *myNumbers); // return 25
	
	// Get the value of the second element in myNumbers
	printf("%d\n", *(myNumbers + 1));

	// Get the value of the third element in myNumbers
	printf("%d\n", *(myNumbers + 2));


	// Change the value of the first element to 13
	*myNumbers = 13;
	printf("%d\n", *myNumbers);
       // Change the value of the second element to 17
       *(myNumbers + 1) = 17;
       printf("%d\n", *(myNumbers + 1));

	return 0;
}
