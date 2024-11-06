#!/bin/bash


#NAME=${1:-"defaultValue"} # -> 1 is argument(if exist) otherwise use default value
#echo ${NAME}

#NAME=${1:?"It can not be empty value"}
#echo ${NAME}

NAME=${1:+"file.txt"}
echo ${NAME}

