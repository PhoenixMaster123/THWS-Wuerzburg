#!/bin/bash

completePath=$1
IFS='/' read -ra array <<< "$completePath"  # Split completePath by '/' into an array

arrayLength=${#array[@]}  # Get the length of the array
#echo "${array[arrayLength - 1]}"
echo "${array[-1]}"
