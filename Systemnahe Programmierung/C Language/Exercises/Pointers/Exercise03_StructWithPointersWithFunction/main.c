#include <stdio.h>

typedef struct person {
    char firstName[255];
    char lastName[255];
} Person;

void readData(Person *person) {
    printf("Enter first name: ");
    scanf("%s", person->firstName);
    printf("Enter last name: ");
    scanf("%s", person->lastName);
}

int main() {
    // Read a struct without pointers syntax:

    /*Person p1;
    scanf("%s", p1.firstName);
    scanf("%s", p1.lastName);

    printf("%s\n", p1.firstName);
    printf("%s\n", p1.lastName);
    */

    // Variant 1:
    Person p2;
    Person *ptr = &p2;
    //readData(ptr);

    // different approuch:

    //printf("%s %s", ptr->firstName, ptr->lastName);

    // Variant 2:
    Person p3;
    readData(&p3);
    printf("%s %s", p3.firstName, p3.lastName);

    /*scanf("%s", &ptr->firstName);
    scanf("%s", &ptr->lastName);

    printf("%s\n", ptr->firstName);
    printf("%s\n", ptr->lastName);
    */

    return 0;
}
