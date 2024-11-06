#!/bin/bash


grep -rl "$2" $1 --include="*.txt"   

#for file in "$1"/*
#do
#	if [ -f "$file" ] 
#	then
#		cat $file | grep -i $2 #-i -> ignore case
#	fi
#done
