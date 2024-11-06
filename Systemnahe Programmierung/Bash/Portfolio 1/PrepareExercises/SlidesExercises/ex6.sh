#!/bin/bash

n=$1
for ((i=1;i<=$n;i++))
do
	sum=$(expr $sum + $i )
done
echo $sum
