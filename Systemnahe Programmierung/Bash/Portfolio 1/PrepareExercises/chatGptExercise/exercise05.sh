#!/bin/bash

#Count Word Occurrences in Files

# Write a script that takes a word as an argument 
# and searches through all .txt files in the current 
# directory to count and print the number of occurrences
# of that word in each file.

sumOccurrences=0

word=$1

for file in *.txt
do  
  sumOccurrences=$(grep -o -i $word $file | wc -l)
  echo "$file: $sumOccurrences occurrences of $word" 
done

#for file in *.txt
#do  
  # Count occurrences in the current file and update totalOccurrences
#  fileOccurrences=$(grep -o -i "$word" "$file" | wc -l)
#  echo "$file: $fileOccurrences occurrences of '$word'"
#  totalOccurrences=$((totalOccurrences + fileOccurrences))
#done
