#!/bin/bash


#Generate a List of Prime Numbers
#Write a script that accepts a number N and prints all prime numbers up to N.

num=$1

if [ $num -le 1 ] 
then
  echo "no prime numbers"
fi  

for ((i=2; i<num; i++)); do
    is_prime=1  # Assume the number is prime until proven otherwise
    for ((j=2; j*j<=i; j++)); do
        if (( i % j == 0 )); then
            is_prime=0  # Number is not prime
            break
        fi
    done
     if (( is_prime )); then
        echo $i  # Print the prime number
    fi  
  done
