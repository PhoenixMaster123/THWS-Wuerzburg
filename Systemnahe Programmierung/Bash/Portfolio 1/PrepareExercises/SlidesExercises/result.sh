#!/bin/bash
echo -n "I am..."
whoami
echo -n "Today is..."
date +%A
exit 0 # Terminatate
#!/bin/bash
echo -n "HI!, my name is "
whoami
echo -n "Today is "
date +%A
echo "The name of the script is: " $0
echo "Argument 1: " $1
echo "Argument 2: " $2
echo "Result is: " $1+$2
exit 0
