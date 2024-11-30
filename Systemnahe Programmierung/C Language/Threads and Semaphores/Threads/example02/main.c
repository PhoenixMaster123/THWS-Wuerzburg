#include <stdio.h>

int currentBalance = 300;

int getBalance() {
    return currentBalance;
}

void deposit(int balance, int amount) {
    int temp = balance + amount;
    currentBalance = temp;
}

void withdraw(int balance, int amount) {
    int temp = balance - amount;
    currentBalance = temp;
}

int main(void) {

}