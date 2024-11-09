#include<stdio.h>
#include<string.h>

typedef struct person {
	char firstName[255];
	char lastName[255];
	int age;
} Person;

Person change(Person newPerson) {
	
        // Person p;	
	strcpy(newPerson.firstName, "Shon");
	strcpy(newPerson.lastName, "Peter");
        newPerson.age = 30;
	
        return newPerson;	
}


int main() {
	Person p = {"Oliver","Tree", 25};

	printf("%s %s %d\n", p.firstName, p.lastName, p.age);

	Person pChange = change(p);

	printf("%s %s %d\n", pChange.firstName, pChange.lastName, pChange.age);

}


