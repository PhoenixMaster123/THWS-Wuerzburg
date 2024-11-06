#!/bin/bash

#Replace a String in Files
#Create a script that searches for all .txt files in a directory 
#and replaces every occurrence of a specific string (first argument) 
#with another string (second argument).

stringSearch=$1
stringReplace=$2
directory=$3

#allTxtFiles=$(find $directory -maxdepth 1 -type f -name "*.txt")

if [[ -z "$stringSearch" || -z "$stringReplace" ]]; then
    echo "Usage: $0 <stringSearch> <stringReplace>"
    exit 1
fi

for file in *.txt
do  

  if [[ ! -f "$file" ]]; then
        echo "File $file does not exist."
        continue
    fi  

     : > "$file.tmp"

    # Read each line and replace the search string with the replacement string
    while IFS= read -r line; do
        modified_line="${line//$stringSearch/$stringReplace}"
        echo "$modified_line" >> "$file.tmp"
    done < "$file"
    
    # Read each line and replace the search string with the replacement string
    #while IFS= read -r line; do
        # Perform search and replace in each line
      #  modified_line="${line//$stringSearch/$stringReplace}"
        
        # Append modified line to a temporary file
      #  echo "$modified_line" >> "$file.txt"
  #  done < "$file"
    
    # Replace original file with the modified temporary file
  #  mv "$file.tmp" "$file"
done
