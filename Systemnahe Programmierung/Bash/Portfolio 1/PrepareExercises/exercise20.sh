#!/bin/bash
zipfile="filesBigger5MB.zip"

for file in "$dic"/*
do      
    if [ -f "$file" ] && [[ $file == *.log ]]
    then    
        size=$(stat -c %s "$file")
        sizeinMB=$(( size / 1048576 ))

        if (( sizeinMB > 5 ))
        then
            zip -u "$zipfile" "$file"  # Update the zip file
        fi
    fi
done



