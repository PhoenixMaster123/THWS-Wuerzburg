#!/bin/bash

if [ $# -eq 3 ];

then

echo "The first file is: $1"
echo "The second file is: $2"
echo "The third file is: $3"

cat "$1" "$2" > "$3"

else

echo "Wrong number of arguments"

fi
