#!/bin/bash

string=$1
numChar=$2

americanPath=/usr/share/dict/american-english

egrep "^${string}.{${numChar}}$" "${americanPath}"


