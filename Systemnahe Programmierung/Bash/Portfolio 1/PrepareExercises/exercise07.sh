#!/bin/bash


#zip -r example.com.zip leer01.txt leer02.txt leer03.txt

# Variant 1:
#dic=$1

#for file in "$dic"/*
#do
#	if [ -f $file ] && [[ $file == *.txt ]]
#	then
#		zip example.zip $file
#	fi
#done

# Variant 2

find $1 -maxdepth 1 -type f -name "*.txt" -exec zip examples.zip {} +
