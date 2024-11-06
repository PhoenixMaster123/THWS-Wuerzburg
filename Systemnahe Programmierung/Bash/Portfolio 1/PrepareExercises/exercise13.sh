#!/bin/bash


file=/etc/passwd

user=$1

if grep "$user" "$file"
then
	echo "User $user exist"
else
	echo "User $user don't exist"
fi
