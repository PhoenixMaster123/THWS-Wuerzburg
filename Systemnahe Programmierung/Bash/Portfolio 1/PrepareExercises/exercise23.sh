#!/bin/bash

cd /home/kristian/PortfolioExam
mkdir "number_series"
cd number_series

for (( i=2; i<=9; i++ ))
do
	touch rowof${i}.txt

	cat rowof${i}.txt
        
        # Variant 2	
	echo $(seq 2 2 100) >> rowof${i}.txt
	# Variant 1
	#for (( j=2; j<=100; j++ ))
	#do
	#	if (( j % 2 == 0 ))
	#	then
	# 	   echo $j >> rowof${i}.txt
	#	fi
	#done
done
