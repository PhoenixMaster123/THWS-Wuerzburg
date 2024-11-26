cmake_minimum_required(VERSION 3.29)
project(DynamicStructure C)

set(CMAKE_C_STANDARD 11)

# Data Structures:

add_executable(linkedList task2/LinkedList/main.c)
add_executable(stack task2/Stack/main.c)
add_executable(arrayList task2/ArrayList/main.c)
add_executable(binaryTree task2/BinaryTree/main.c)
add_executable(binaryTreeString task2/BinaryTreeV2/main.c)
add_executable(doubleLinkedList task2/DoubleLinkedList/main.c)
add_executable(doubleLinkedList2 task2/DoubleLinkedListV2/main.c)
add_executable(graph task2/Graph/main.c)
add_executable(graph2 task2/GraphV2/main.c)

# Beginner Exercises

add_executable(arraySumAndAverage task1/arraySumAndAverage/main.c)
add_executable(reverseAnArray task1/reverseAnArray/main.c)
add_executable(maxAndMin task1/maxAndMin/main.c)

# Intermediate Exercises:

add_executable(bubbleSort task1/bubbleSort/main.c)
add_executable(matrixAddition task1/matrixAddition/main.c)
add_executable(frequencyOfElements task1/frequencyOfElements/main.c)
add_executable(rotateAnArray task1/rotatingAnArray/main.c)

# Advanced Exercises:

add_executable(binarySearch task1/binarySearch/main.c)
add_executable(mergeTwoArrays task1/mergeTwoSortedArrays/main.c)

# Exams:

add_executable(insertBetween exams/InsertCharachterBetween/main.c)



