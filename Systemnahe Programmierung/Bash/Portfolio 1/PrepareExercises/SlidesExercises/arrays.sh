#!/bin/bash

VAR=(hallo welt guten tag hello world) #create an array
echo ${VAR[@]::2} # we can see only the two elements

echo ${#VAR[1]} # // what is the length of the second index in the array

VAR+=(samstag) # add to the last position in the array
echo ${VAR[@]}

echo ${VAR[@]/a/u}
