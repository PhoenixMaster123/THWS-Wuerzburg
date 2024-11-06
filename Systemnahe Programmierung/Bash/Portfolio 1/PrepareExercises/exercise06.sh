#!/bin/bash

num=$1

for (( i=1; i<=$num; i++))
do
	sum=$(expr $sum + $i )
done
echo $sum

# Variant 2
#echo "Summe von 1 bis ${1}: $((($1*($1+1)/2)))"
