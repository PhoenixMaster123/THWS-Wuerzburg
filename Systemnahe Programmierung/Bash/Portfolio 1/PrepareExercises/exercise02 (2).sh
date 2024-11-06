#!/bin/bash

file=$1
num=$2

if [ $# -eq 0 ]; then
    #display_help
    exit 0
fi

if [ ! -f "$1" ]; then
    echo "Error: File '$1' not found."
    exit 1
fi


n=${2:-1}

#fileLines=$(wc -l file)

#if [ $fileLines -lt $n ]
#  then 
#    echo "The number of lines is less then the given number"
#fi

if [ "$n" -le 0 ]; then
    echo "Error: The value for n must be a positive integer."
    exit 1
fi
line_num=1

line_num=1

while IFS= read -r line; do
    if (( line_num % n == 0 )); then
        echo "$line"
    fi
    ((line_num++))
done < "$1"





