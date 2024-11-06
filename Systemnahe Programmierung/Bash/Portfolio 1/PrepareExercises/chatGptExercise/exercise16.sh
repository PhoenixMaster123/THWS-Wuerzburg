#!/bin/bash


file1=$1
file2=$2

if [[ -z "$file1" || -z "$file2" ]]; then
    echo "Usage: $0 <file1> <file2>"
    exit 1
fi

# Use `diff` to compare the two files and display the output
diff -u "$file1" "$file2"
