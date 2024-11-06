#!/bin/bash


for file in "$dic"/*
do
        if [ -f "$file" ]
        then
                size=$(stat -c %s "$file")
                sizeinMB=$(( size / 1024 )) #KB
                if (( size < 1024 ))
                then
                        rm -r $file
                fi
        fi
find $1 -maxdepth 1 -type f -size -1k -delete
