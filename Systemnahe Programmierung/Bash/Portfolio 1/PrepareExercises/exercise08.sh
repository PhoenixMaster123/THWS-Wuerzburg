#!/bin/bash

dict=$1
find $dict -maxdepth 1 -type f -name "*.txt" >> all_txt_files.txt

#$allFile cat > all_txt_files.txt
