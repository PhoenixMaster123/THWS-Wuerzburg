cmake_minimum_required(VERSION 3.29)
project(File_API C)

set(CMAKE_C_STANDARD 11)

add_executable(reading example01_ReadingFile/main.c)
add_executable(writingByChar example02_WritingFileByCharacters/main.c)
add_executable(readingByChar example03_ReadingFileByCharacters/main.c)
add_executable(writingByLines example04_WritingFileByLines/main.c)
add_executable(readingByLines example05_ReadingFileByLines/main.c)
add_executable(printInDir example06_PrintFileNamesInCurrentDirectory/main.c)

add_executable(exercise01V1 exercise01V1/main.c)
add_executable(exercise01V2 exercise01V2/main.c)
add_executable(readPeopleFromFile readPeopleFromFile/main.c)
add_executable(exercise02 exercise02/main.c)
add_executable(exercise03 exercise03/main.c)
add_executable(exercise03V2 exercise03V2/main.c)

