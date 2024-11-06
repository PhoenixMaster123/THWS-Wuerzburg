

#Check Disk Usage and Warn
#Write a script that checks disk usage and sends a 
#warning message to the console if disk usage exceeds 80%


# Get disk usage percentage without using awk or sed
usage=$(df / | grep / | cut -d' ' -f5 | tr -d '%')

# Check if usage is greater than 80%
if [[ $usage -gt 80 ]]; then
    echo "Warning: Disk usage is at $usage%"
fi

# Variant 2:

#usage=$(df / | grep / | cut -d' ' -f5 | cut -d'%' -f1)

# Check if usage is greater than 80%
#if [[ $usage -gt 80 ]]; then
#    echo "Warning: Disk usage is at $usage%"
#fi
