#!/bin/bash

if [ $# -ne 3 ]
then
echo "The number is wrong. Provide 3 Arguments"
exit 1
else cat $1 $2 > $3
fi
exit 0
