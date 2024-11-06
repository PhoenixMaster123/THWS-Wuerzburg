#!/bin/bash
FILE="image.jpg"
echo ${FILE/"jpg"/"png"}

FILE2="image.tex"
echo ${FILE2/"."/"_v2"}

#FILE3="${image_v$1.c}"

FILE1="image.jpg"
FILE_RENAMED=${FILE1%.jpg}.png
echo $FILE_RENAMED

FILE2V="text.tex"
FILE_RENAMED=${FILE2V%.tex}_v2.tex
echo $FILE_RENAMED

FILE3V="main_v9.c"
PREFIX=${FILE3V%.c}
NUMBER=${PREFIX/[a-z]*_v/}
echo ${NUMBER}
PART=${PREFIX//[0-9]/}
echo $PART
NUMBER=$((NUMBER+1))
FILE_RENAMED=${PART}${NUMBER}.c
echo $FILE_RENAMED
