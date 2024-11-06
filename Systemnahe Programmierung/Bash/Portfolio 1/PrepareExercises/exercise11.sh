#!/bin/bash


fileToCopy=/etc/passwd
currentDate=$(date +%A)
#sortedFile=$(cat $fileToCopy | sort -u)
sortedFile=$(cat "$fileToCopy" | sort -u)
cd $HOME

echo $sortedFile >> passwd-on-${currentDate}.txt

