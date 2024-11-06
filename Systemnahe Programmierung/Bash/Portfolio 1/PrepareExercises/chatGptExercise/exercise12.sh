#!/bin/bash

# Display the N Oldest Files in a Directory

# Write a script that accepts a directory and a number N as 
# arguments and displays the N oldest files in that directory.

directory=$1
N=$2

if [[ -z "$directory" || -z "$N" ]]; then
    echo "Usage: $0 <directory> <number_of_files>"
    exit 1
fi

find "$directory" -type f -printf '%T+ %p\n' | sort | head -n "$N" | cut -d ' ' -f 2
