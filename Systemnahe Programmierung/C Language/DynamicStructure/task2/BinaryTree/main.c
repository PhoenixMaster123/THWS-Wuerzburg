#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    int value;
    struct node *right;
    struct node *left;
} Node;

typedef struct BBT {
    Node *root;
    int max;
    int min;
} BBT;

void add(BBT **tree, int val);
void addSub(Node **root, Node **subtree);
void removeALL(BBT **tree, int val);
void print(BBT *tree);
void printInOrder(Node *tree);

int main() {
    BBT *tree = (BBT *)malloc(sizeof(tree));
    tree->root = NULL;

    Node* newNode = NULL;
    add(&tree, 50);
    add(&tree, 30);
    add(&tree, 20);
    add(&tree, 10);
    add(&tree, 70);
    add(&tree, 80);
    add(&tree, 90);
    add(&tree, 100);
    print(tree);

    removeALL(&tree, 30);
    print(tree);

    add(&tree, 50);
    add(&tree, 30);
    add(&tree, 20);
}

void add(BBT **tree, int val) {
    if (*tree == NULL) {
        printf("Tree is down\n");
        return;
    }

    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->value = val;
    newNode->left = NULL;
    newNode->right = NULL;

    if ((*tree)->root == NULL) {
        (*tree)->root = newNode;
        return;
    }

    Node *curr = (*tree)->root;
    while(curr != NULL) {
        if (val < curr->value) {
            //insert left
            if (curr->left != NULL) {
                curr = curr->left;
                continue;
            }
            curr->left = newNode;
            break;
        }
        else {
            //insert right
            if (curr->right != NULL) {
                curr = curr->right;
                continue;
            }
            curr->right = newNode;
            break;
        }
    }
}

void addSub(Node **root, Node **subtree) {
    if(*subtree == NULL) {
        return;
    }

    if (*root == NULL) {
        *root = *subtree;
    }

    Node *curr = *root;
    while(curr != NULL) {
        if ((*subtree)->value < curr->value) {
            //insert left
            if (curr->left != NULL) {
                curr = curr->left;
                continue;
            }
            curr->left = *subtree;
            break;
        }
        else {
            //insert right
            if (curr->right != NULL) {
                curr = curr->right;
                continue;
            }
            curr->right = *subtree;
            break;
        }
    }
}

void removeALL(BBT **tree, int val) {
    if (*tree == NULL) {
        printf("BBT is not da\n");
        return;
    }

    Node *curr = (*tree)->root;
    if(curr->value == val) {
        (*tree)->root = NULL;
        addSub(&curr, &(curr->left));
        addSub(&curr, &(curr->right));
        free(curr);
        return;
    }
    Node *prev = curr;
    int direction = 0;

    while(curr != NULL) {
        if(curr->value == val) {
            if(direction == 0) {
                prev->left = NULL;
            } else {
                prev->right = NULL;
            }
            addSub(&(*tree)->root, &(curr->left));
            addSub(&(*tree)->root, &(curr->right));
            free(curr);
            break;
        }

        prev = curr;

        if (val < curr->value) {
            //delete left
            if (curr->left != NULL) {
                direction = 0;
                curr = curr->left;
                continue;
            }
            printf("Dog, bist down (Element gibts net)\n");
            break;
        } else {
            //delete right
            if (curr->right != NULL) {
                direction = 1;
                curr = curr->right;
                continue;
            }
            printf("Dog, bist down (Element gibts net)\n");
            break;
        }
    }

}

void print(BBT *tree) {
printInOrder(tree->root);
printf("\n");
}

void printInOrder(Node *root) {
    if(root != NULL) {
        printInOrder(root->left);
        printf("%d ", root->value);
        printInOrder(root->right);
    }
}