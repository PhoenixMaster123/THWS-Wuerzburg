#!/bin/bash


num1=$1
num2=$2

if [ $num1 -gt $num2 ]
then
	#num3=$(( $num1 * $num1 + $num2))
	num3=$(echo "$num1 * $num2 + $num2" | bc)
	echo $num3
elif [ $num1 -lt $num2 ]
then	
	num3=$(($num2 * $num2))
	echo $num3
else
	if [ $(expr $num2 % 2) -eq 0 ]
	then
		num3=$((($num2 * $num2) / $num1))
		echo $num3
	else
		echo "It's not even number"
	fi
fi
