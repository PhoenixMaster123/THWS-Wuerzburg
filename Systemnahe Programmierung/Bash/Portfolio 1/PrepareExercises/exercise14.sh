#/bin/bash

largest_file=""
largest_size=0

# Loop through each file in the specified directory
for file in "$1"/*; do
    if [ -f "$file" ]; then  # Only consider regular files
        size=$(stat -c %s "$file")
        
        if [ size > largest_size ]
       	then
            largest_size=$size
           largest_file=$file
        fi
    fi
done

# Display the result
if [ -n "$largest_file" ]; then
    echo "Largest file: $largest_file"
    echo "Size: $largest_size bytes"
else
    echo "No files found in the directory."
fi
