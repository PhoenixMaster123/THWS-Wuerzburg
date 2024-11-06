#!/bin/bash

#Calculate Factorial
#Write a script that takes a single integer as 
#input and calculates its factorial.
#Print the result to the console.

fact=$1

result=1;

for ((i=fact; i>0; i--)) 
do  
  result=$(( $result * $i ))
done

echo $result
