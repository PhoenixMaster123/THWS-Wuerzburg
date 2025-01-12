#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node *left;
    struct node *right;
} Node;

typedef struct tree {
    Node *root;
    int maxDepth;
    int minDepth;
} BinaryTree;

void insert(BinaryTree **tree, int value);
void insertSubTree(BinaryTree **root, Node **subtree);
void removeAll(BinaryTree **tree, int value);
void printTree(BinaryTree **tree);

int main(void) {

}

void insert(BinaryTree **tree, int value) {
    if(*tree == NULL) {
        printf("Tree is NULL\n");
        return;
    }
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->value = value;
    newNode->left = NULL;
    newNode->right = NULL;

    if((*tree)->root == NULL) {
        (*tree)->root = newNode;
    }
    Node *current = (*tree)->root;
    while(current != NULL) {
        if(value < current->value) {
            // insert left:
            if((*tree)->root->left == NULL) {
                current = current->left;
               continue;
            }
            current->left = newNode;
            break;
        } else {
            // insert right:
            if((*tree)->root->right == NULL) {
                current = current->right;
                continue;
            } else {
                current->right = newNode;
                break;
            }
        }
    }

}
void removeAll(BinaryTree **tree, int value) {
    if(*tree == NULL) {
        printf("Tree is NULL\n");
        return;
    }
    Node *current = (*tree)->root;
    Node *previous = NULL;
    int direction = 0;
    while(current != NULL) {
        if(value == current->value) {
            if(direction == 0) {
                previous->left = NULL;
                // add current->left
                // add current->right
                // free(current)
            } else {
                previous->left = NULL;
                // add current->left
                // add current->right
                // free(current)
            }
            // delete left
            if(current->left != NULL) {
                direction = 0;
                current = current->left;
            }
            printf("No elements");
            break;
        } else {
            if(direction == 0) {
                previous->right = NULL;
                insertSubTree(&(*tree)->root, &current->left);
                insertSubTree(&(*tree)->root, &current->right);
                free(current);
                // add current->left
                // add current->right
                // free(current)
            } else {
                previous->right = NULL;
                // add current->left
                // add current->right
                // free(current)
            }
            // delete left
            if(current->right != NULL) {
                direction = 0;
                current = current->right;
            }
            printf("No elements");
            break;
        }
    }
}
void insertSubTree(BinaryTree **tree, Node **subtree) {
    if(*subtree == NULL) {
        return;
    }
    if(*root == NULL) {
        (*root)->root = *subtree;
    }
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->value = value;
    newNode->left = NULL;
    newNode->right = NULL;

    if((*tree)->root == NULL) {
        (*tree)->root = newNode;
    }
    Node *current = (*tree)->root;
    while(current != NULL) {
        if(value < current->value) {
            // insert left:
            if((*tree)->root->left == NULL) {
                current = current->left;
                continue;
            }
            current->left = newNode;
            break;
        } else {
            // insert right:
            if((*tree)->root->right == NULL) {
                current = current->right;
                continue;
            } else {
                current->right = newNode;
                break;
            }
        }

}
void printTree(BinaryTree *tree) {

}