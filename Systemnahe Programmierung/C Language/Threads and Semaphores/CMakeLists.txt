cmake_minimum_required(VERSION 3.29)
project(Threads_and_Semaphores C)

set(CMAKE_C_STANDARD 11)

# Threads:

add_executable(example01 Threads/example01/main.c)
add_executable(example02 Threads/example02/main.c)
add_executable(exercise01 Threads/exercise01/main.c)

# Semaphores:

add_executable(example01Sem Semaphores/example01/main.c)
add_executable(example02Sem Semaphores/example02/main.c)
add_executable(example03Sem Semaphores/example03/main.c)
add_executable(example04Sem Semaphores/example04/main.c)

add_executable(atomicCounter Semaphores/exercise01_Atomic_Counter/main.c)