#!/bin/bash

dic=$1
n=$2

touch copyFile

for file in "$dic"/*
do
  if [ -f "$file" ] && [[ "$file" == *.txt ]]
  then  
       
     head -n $n $file > copyFile
    echo "" >> copyFile
  fi  
done

