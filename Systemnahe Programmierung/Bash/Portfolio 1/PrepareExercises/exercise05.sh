#!/bin/bash

num=$1

binaryNum=$(echo "obase=2;$num"| bc)
echo $binaryNum
