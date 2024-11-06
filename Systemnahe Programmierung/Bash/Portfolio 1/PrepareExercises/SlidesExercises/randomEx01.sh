#!/bin/bash

#for file in "$1"/*
#do

#if [ -f "$file" ] && [[ $file == *.txt ]]
#then
#	lines=$(cat "$file" | wc -l)
#       echo $lines
#fi
#done

n=$1

for (( i=1; i<=n; i++ ))
do
	echo $(($n+$i))
done
