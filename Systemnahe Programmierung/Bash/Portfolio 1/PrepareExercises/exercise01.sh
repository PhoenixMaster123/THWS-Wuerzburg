#!/bin/bash

#egrep "*.txt$" pwd

directory=$1

find $directory -maxdepth 1 -type f -name "*.txt" -empty

#ls -l | egrep "*.txt" pwd

