#!/bin/bash


num=$1

if [ $(expr $num % 2) -eq 0 ]
then
	echo "The $num is even"
else
	echo "The $num is odd"
fi
