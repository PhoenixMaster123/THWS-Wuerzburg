#!/bin/bash

dic=$1
find $dic -maxdepth 1 -mtime 30+ -type f -name "*" -exec rm {} \; 
