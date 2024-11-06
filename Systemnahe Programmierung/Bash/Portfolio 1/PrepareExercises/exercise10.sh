#!/bin/bash

N=$1

mkdir "ManyTexts"

cd ManyTexts
# check if the number is not smaller than 0 and check if the dir exists
for (( i=1; i<=N; i++ ))
do
	touch text$i.txt
done
