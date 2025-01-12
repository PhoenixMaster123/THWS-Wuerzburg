#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct TreeNode
{
    int value;
    struct TreeNode *left;
    struct TreeNode *right;
} TreeNode;

typedef struct QueueElement
{
    TreeNode *tree_node;
    struct QueueElement *next;
} QueueElement;

typedef struct Queue
{
    QueueElement *first_element;
    QueueElement *last_element;
} Queue;

/*
 * Count the number of upper and lower-case letters in the
 * given text and store the values in the given parameters.
 *
 * The function must initialize both counters with 0 (zero).
 * You MUST use a pointer to interate over all characters in
 * the given text. Only consider upper and lower-case letters
 * and don't care about other letters such as white-space
 * or digits. You MUST use the functions isupper and islower
 * that are declared in ctype.h. You MUST include file ctype.h.
 */
void count_upper_lower(const char *text, int *upper, int *lower)
{
    *upper = 0;
    *lower = 0;

    // Variant 1:

    while (*text) {
        if (isupper(*text)) {
            (*upper)++;
        } else if (islower(*text)) {
            (*lower)++;
        }
        text++;
    }

    // Variant 2:

    /*int len = strlen(text);

    for (int i = 0; i < len; ++i) {
        if(isupper(*text)) {
            (*upper)++;
        } else if (islower(*text)) {
            (*lower)++;
        }
        text++;
    }
    */
}

void initializeQueue(Queue *q)
{
    q->first_element = q->last_element = NULL;
}

int isEmpty(Queue *q)
{
    return q->first_element == NULL;
}

void enqueue(Queue *q, TreeNode *tree_node)
{
    if (tree_node == NULL)
        return;

    QueueElement *newQueueElement = malloc(sizeof(QueueElement));
    newQueueElement->tree_node = tree_node;
    newQueueElement->next = NULL;

    if (q->last_element == NULL)
    {
        q->first_element = q->last_element = newQueueElement;
    }
    else
    {
        q->last_element->next = newQueueElement;
        q->last_element = newQueueElement;
    }
}

/*
 * This function removes the first element from the given
 * queue and copies the tree node stored in the queue element
 * to the given parameter value. After the last element was
 * removed from the queue, both attributes first_element
 * and last_element of q MUST be set to NULL.
 *
 * The function returns 0 if the operation was successful
 * and returns -1 if the queue was already empty.
 * Don't forget to free the memory of the queue element!
 *
 * Parameters:
 * q:     a pointer to a queue
 * value: a pointer to a pointer to a TreeNode where the data
 *        of the queue element can be stored. This allows
 *        the caller to access the tree node.
 */
int dequeue(Queue *q, TreeNode **value) {
    if (isEmpty(q))
    {
        return -1;
    }
    /*if(*value == NULL) {
        return -1;
    }
    */

    QueueElement *tempElement = q->first_element;

    q->first_element = q->first_element->next;

    *value = tempElement->tree_node;

    if (q->first_element == NULL) {
        q->last_element = NULL;
    }
    free(tempElement);
    return 0;
}


TreeNode *newNode(int value)
{
    TreeNode *node = malloc(sizeof(TreeNode));
    node->value = value;
    node->left = NULL;
    node->right = NULL;
    return node;
}

/*
 * This function inserts a new value into the given tree so that
 * the leaves are ordered ascending. It is guaranteed that
 * all values in the left sub-tree are smaller than the value of the
 * current node and all values in the right sub-tree are greater
 * or equal than the value of the current node. Note, that the tree
 * is not balanced by intention.
 */
void insert(TreeNode **root, int value)
{
    if (*root == NULL)
    {
        *root = newNode(value);
        return;
    }

    TreeNode *current = *root;
    while (1)
    {
        if (value < current->value)
        {
            if (current->left == NULL)
            {
                current->left = newNode(value);
                break;
            }
            current = current->left;
        }
        else
        {
            if (current->right == NULL)
            {
                current->right = newNode(value);
                break;
            }
            current = current->right;
        }
    }
}

/*
 * Print all values of the given tree.
 */
void inorder(TreeNode *root)
{
    if (root != NULL)
    {
        inorder(root->left);
        printf("%d ", root->value);
        inorder(root->right);
    }
}

/*
 * Iterate over the elements of the given tree using
 * a breadth-first approach, i.e., print the value of
 * the current element before printing the values of
 * all children.
 *
 * DON't try to implement this using recursion but use
 * the given queue implementation!
 */
void breadth_first_search(TreeNode *root)
{
    if (root == NULL) { // Check if the root is null, if it is the stop the method.
        return;
    }

    Queue queue;
    initializeQueue(&queue); // First, I initialize the queue
    enqueue(&queue, root);

    while (!isEmpty(&queue))
    {
        TreeNode *currentNode;
        dequeue(&queue, &currentNode);

        printf("%d ", currentNode->value);

        if (currentNode->left != NULL) {
            enqueue(&queue, currentNode->left);
        }
        if (currentNode->right != NULL) {
            enqueue(&queue, currentNode->right);
        }
    }
}

int main()
{
    int upper, lower;
    char *text = "HellO";
    count_upper_lower(text, &upper, &lower);
    printf("Text: %s with %d upper and %d lower letters\n", text, upper, lower);

    TreeNode *root = NULL;

    insert(&root, 50);
    insert(&root, 30);
    insert(&root, 20);
    insert(&root, 40);
    insert(&root, 70);
    insert(&root, 60);
    insert(&root, 80);

    printf("Inorder Traversal: ");
    inorder(root); // Expected: 20, 30, 40, 50, 60, 70, 80
    printf("\nBreadth-First-Search: ");
    breadth_first_search(root); // Expected: 50, 30, 70, 20, 40, 60, 80
    printf("\n");

    return 0;
}