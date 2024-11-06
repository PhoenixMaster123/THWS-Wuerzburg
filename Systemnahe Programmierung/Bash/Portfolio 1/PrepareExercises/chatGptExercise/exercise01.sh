#!/bin/bash

# Find Files by Size

# Write a script that lists all files in the current directory 
# larger than a specified size (passed as an argument) in bytes.
# Display each file’s name and size.


directory=$1

specifiedSize=$2

for file in "$directory"/*
do  
  if [[ -f $file ]] && [[ $file == *.txt ]]
  then
    getSize=$(stat -c %s $file)

    #setInKB=$((getSize / 1024))

    if [ $getSize -gt $specifiedSize ]
    then
      echo $file ${getSize}K
     fi 
  fi  
done  

