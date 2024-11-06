#!/bin/bash

#Calculate File Size Percentage in a Directory
#
total_size=$(du -sb . | cut -f1)  # Calculate total size in bytes

echo "Total size of directory: $total_size bytes"

for file in *; do
    if [[ -f "$file" ]]; then
        file_size=$(stat -c%s "$file")  # Get file size in bytes
        percent=$(( 100 * file_size / total_size ))  # Calculate percentage as an integer
        echo "$file: $percent% of total size"
    fi
done
