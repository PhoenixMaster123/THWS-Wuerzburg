#!/bin/bash

# Count Unique Words in a File
# Write a script that takes a file as an argument, 
# counts the number of unique words in it, and prints the count.


file=$1

if [[ ! -f $file ]]; then
    echo "File not found!"
    exit 1
fi

# Count unique words
tr ' ' '\n' < "$file" | sort | uniq -c | wc -l
