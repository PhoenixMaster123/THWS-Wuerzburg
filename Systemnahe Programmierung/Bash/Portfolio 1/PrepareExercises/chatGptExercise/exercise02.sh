#!/bin/bash

# Display Top N Largest Files

# Write a script that accepts a number N as an argument and displays 
# the N largest files in the current directory.

directory=$1
num=$2

 sortedFile=$(find "$directory" -type f -exec du -b {} + | sort -rn)sortedFile=$(find "$directory" -type f -exec du -b {} + | sort -rn) # -rn -> sort numerical reversed

# Print the top N largest file names
echo "$sortedFile" | head -n "$num" | cut -f2 



# find $directory -type f -exec ls -lh {} + | sort -k5 -rh | head -n "$num"
