#!/bin/bash

#dic=$1

for file in "$dic"/*; do
    if [ -f "$file" ]; then
        size=$(stat -c %s "$file")             # Get the size in bytes
        sizeinMB=$(( size / 1048576 ))         # Convert bytes to MB
        if (( sizeinMB > 1 )); then             # Check if size is greater than 1MB
            echo "$file - ${sizeinMB}MB"        # Output the file name and size
        fi
    fi
done

#find "$1" -maxdepth 1 -type f -size +1M -print0 | sort -z | xargs -0 du -h | sort -h


