#!/bin/bash

dic=$1

find "$dic" -maxdepth 1 -type f -user kristian -writable 

