#!/bin/bash

num=$1

if [ $(expr $num % 2) -eq 0 ]
then
	echo "The number is even"
else
	echo "The number is odd"
fi

#(( $num % 2 == 0 ))
