#!/bin/bash

# Variant 1

dict=$1

txtFiles=$(find $dict -maxdepth 1 -type f -name "*.txt" | wc -l)
jpgFiles=$(find $dict -maxdepth 1 -type f -name "*.jpg" | wc -l)
pngFiles=$(find $dict -maxdepth 1 -type f -name "*.png" | wc -l)

arrFilesCount=($txtFiles $jpgFiles $pngFiles)

for (( i=0; i<${#arrFilesCount[@]}; i++ ))
do
	echo ${arrFilesCount[$i]}
done

# Variant 2

#files=$(find -type f -name "*.txt" -o -name "*.jpg" -o -name "*.png" )

#file_count=0

#for file in $files
#do
#  file_count=$(expr $file_count + 1)
#done

#echo $file_count
