#!/bin/bash

length=${2:-20}

while read line
do
	if [ ${#line} -lt ${length} ]
	then
		echo $line
	fi
done
