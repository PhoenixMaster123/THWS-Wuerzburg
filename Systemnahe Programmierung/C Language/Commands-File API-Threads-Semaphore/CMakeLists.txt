cmake_minimum_required(VERSION 3.29)
project(Commands_File_API_Threads_Semaphore C)

set(CMAKE_C_STANDARD 11)

# Processing Command Line Arguments:

add_executable(helpCommand "commands/Command Line Arguments/main.c")
add_executable(simpleCalculator "commands/simpleCalculator/main.c")

# Working with stdin and stdout:

add_executable(lineCounter "stdin and stdout/Line counter/main.c")
add_executable(inputReverser "stdin and stdout/Input Reverser/main.c")

# File Handling:

add_executable(fileCopy "file handling/File Copy/main.c")
add_executable(wordCount "file handling/Word Count in a File/main.c")
add_executable(directoryExplorer "file handling/Directory Explorer/main.c")
add_executable(contentSearch "file handling/File Content Search/main.c")

# Threads and Semaphore:
add_executable(sumArrayWithThreads "Threads and Semaphore/SumArrayWithThreads/main.c")
add_executable(sumArrayWithThreads2 "Threads and Semaphore/SumArrayWithThreadsV2/main.c")
add_executable(searchInAnArray "Threads and Semaphore/Parallel Search in an Array/main.c")
add_executable(searchInAnArray2 "Threads and Semaphore/ParallelSearchInAnArrayV2/main.c")
add_executable(producerConsumer "Threads and Semaphore/Producer-Consumer Problem/main.c")
