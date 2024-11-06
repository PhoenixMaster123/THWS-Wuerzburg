#!/bin/bash

dic="/home/kristian/PortfolioExam"
mkdir -p backupFolder
for file in "$dic"/*
do
	if [ -f "$file" ] && [[ $file == *.txt ]]
	then 
		cp $file backupFolder
	fi
done

