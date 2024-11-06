#!/bin/bash

#Read User Input Until 'STOP'

while read -r line; do
    [[ "$line" == "STOP" ]] && break
    lines+=("$line")
done
