#!/bin/bash

# Check Available Disk Space for Each Partition
# Write a script that uses df to display the available disk space for
# each partition, formatted for readability.

df -h | grep '^/dev/' | while read -r line; do
    # Split the line into fields using space as the delimiter
    filesystem=$(echo "$line" | cut -d ' ' -f 1)
    available=$(echo "$line" | cut -d ' ' -f 4)
    
    echo "$filesystem: $available free"
done
