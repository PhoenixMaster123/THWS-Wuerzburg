#!/bin/bash


#Search and Sort Logs by Keyword
#Write a script that takes a keyword as input and searches all .log files
#in the current directory for lines containing that keyword. 
#Print the matching lines, sorted by date.


if [[ -z $1 ]]; then
    echo "Provide a keyword."
    exit 1
fi

grep -i "$1" *.log | sort -k1,1
