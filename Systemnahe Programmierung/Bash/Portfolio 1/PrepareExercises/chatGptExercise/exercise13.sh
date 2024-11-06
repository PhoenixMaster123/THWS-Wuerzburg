#!/bin/bash

# Generate a File with Fibonacci Sequence
# Write a script that generates a file containing the first N Fibonacci numbers,
# where N is provided by the user.

N=$1

if [[ -z "$N" ]]; then
    echo "Usage: $0 <number_of_terms>"
    exit 1
fi

a=0
b=1
echo "Fibonacci sequence up to $N terms:" > fibonacci.txt
echo $a >> fibonacci.txt
echo $b >> fibonacci.txt

for (( i=3; i<=N; i++ )); do
    fib=$((a + b))
    echo $fib >> fibonacci.txt
    a=$b
    b=$fib
done

echo "Fibonacci sequence saved to fibonacci.txt"
