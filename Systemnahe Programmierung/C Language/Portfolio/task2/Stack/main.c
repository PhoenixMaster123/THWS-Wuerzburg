#include <stdio.h>
#include <stdlib.h>

typedef struct Stack {
    int top;
    int capacity;
    int size;
    int *arr;
} Stack;

void push(int x) {
    Stack stack;
    if(stack.top == stack.size - 1) {
        printf("Stack is full\n");
        return;
    }
    stack.arr[++stack.top] = x;
};
int pop() {
    Stack stack;
    if(stack.top == -1) {
        printf("Stack is empty\n");
        return -1;
    }
    return stack.arr[stack.top--];
};

int main(void) {
    Stack *stack = (Stack *)malloc(sizeof(Stack));
    stack->top = -1;
    stack->capacity = 10;
    stack->arr = (int *)malloc(stack->capacity * sizeof(int));
    for (int i = 0; i < stack->capacity; i++) {
        stack->arr[i] = 0;
    }

    return 0;
}
