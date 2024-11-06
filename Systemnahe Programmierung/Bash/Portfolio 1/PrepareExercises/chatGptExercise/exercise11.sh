#!/bin/bash

# Sort Files by Extension
# Write a script that organizes files in a directory by their extensions. 
# Move each file into a folder named after its extension

directory=$1

if [[ -z "$directory" ]]; then
    echo "Usage: $0 <directory>"
    exit 1
fi

for file in "$directory"/*.*; do
    ext="${file##*.}"
    mkdir -p "$directory/$ext"
    mv "$file" "$directory/$ext/"
done
