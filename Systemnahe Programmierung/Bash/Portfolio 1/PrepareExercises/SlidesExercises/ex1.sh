#!/bin/bash

#if [ -z "$1" ] # checks whether a string is empty or not (string is null)
#then
#	echo "Please provide a directory"
#fi
DIC="$1"
if [ -d "$DIC" ] # checks if a directory exists in a shell script and if it is a directory
then
#egrep '.txt$' "$DIC"
#find "$DIC" -maxdepth 1 -type f -name "*.txt" # result: find in this directory and to go max one directory -type f (I specify what type I search f (files)) name (search by name) (pattern
# find <path> -type f -name "<pattern>"
ls -p "$DIC" | grep -E '\.txt$' | grep -v /
else 
	echo "This is not a directory"
fi
