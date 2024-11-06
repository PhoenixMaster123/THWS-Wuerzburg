#!/bin/bash

value1=$1
value2=$2
value3=$((value1+value2))
echo $value3

# Short version:
echo $(($1+$2))
