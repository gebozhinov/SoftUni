# Exercise: Data Types and Variables
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

## 1.	Integer Operations
Read four integer numbers. Add first to the second, divide (integer) the sum by the third number, and multiply the result by the fourth number. Print the result.

### Constraints 
* The four numbers from the input are in the range [-2,147,483,648… 2,147,483,647]

### Examples
| Input | Output |
| --- | --- |
|10<br>20<br>3<br>3|30|
|15<br>14<br>2<br>3|42|

## 2.	Sum Digits
You will be given a single integer. Your task is to find the sum of its digits.

### Examples
| Input | Output |
| --- | --- |
|245678|32|
|97561|28|
|543|12|

## 3.	Elevator
Calculate how many courses will be needed to elevate n persons by using an elevator with a capacity of p persons. 
The input holds two lines: the number of people n and the capacity p of the elevator.

### Examples
| Input | Output |
| --- | --- |
|17<br>3|6|
|4<br>5|1|
|10<br>5|2|

## 4.	Sum of Chars
Write a program, which sums the ASCII codes of n characters. Print the sum on the console.

### Input
*	On the first line, you will receive n – the number of lines, which will follow.
*	On the next n lines – you will receive letters from the Latin alphabet.

### Output
Print the total sum in the following format:
"The sum equals: {totalSum}"

### Constraints
*	n will be in the interval [1…20].
*	The characters will always be either upper or lower-case letters from the English alphabet.
*	You will always receive one letter per line.

### Examples
| Input | Output |
| --- | --- |
|5<br>A<br>b<br>C<br>d<br>E|The sum equals: 399|
|12<br>S<br>o<br>f<br>t<br>U<br>n<br>i<br>R<br>u<br>l<br>z<br>z|The sum equals: 1263|


## 5.	Print Part of the ASCII Table
Find online more information about ASCII (American Standard Code for Information Interchange) and write a program that prints part of the ASCII table of characters at the console.  
On the first line of input, you will receive the char index you should start with, and on the 
second line - the index of the last character you should print.

### Examples
| Input | Output |
| --- | --- |
|60<br>65|< = > ? @ A|
|69<br>79|E F G H I J K L M N O|
|97<br>104|a b c d e f g h|
|40<br>55|( ) * + , - . / 0 1 2 3 4 5 6 7|


## 6.	Triples of Latin Letters
Write a program to read an integer n and print all triples of the first n small Latin letters, ordered alphabetically:

### Examples
| Input | Output |
| --- | --- |
|3|aaa<br>aab<br>aac<br>aba<br>abb<br>abc<br>aca<br>acb<br>acc<br>baa<br>bab<br>bac<br>bba<br>bbb<br>bbc<br>bca<br>bcb<br>bcc<br>caa<br>cab<br>cac<br>cba<br>cbb<br>cbc<br>cca<br>ccb<br>ccc|
|2|aaa<br>aab<br>aba<br>abb<br>baa<br>bab<br>bba<br>bbb|


## 7.	Water Overflow
You have a water tank with a capacity of 255 liters. 
On the next n lines, you will receive liters of water, which you have to pour into your tank. 
If the capacity is not enough, print "Insufficient capacity!" and continue reading the next line. On the last line, print the liters in the tank.

### Input
The input will be on two lines:
*	On the first line, you will receive n – the number of lines, which will follow
*	On the next n lines – you receive quantities of water, which you have to pour into the tank

### Output
Every time you do not have enough capacity in the tank to pour the given liters, print:
"Insufficient capacity!".
On the last line, print only the liters in the tank.

### Constraints
*	n will be in the interval [1…20]
*	liters will be in the interval [1…1000]

### Examples
| Input | Output |
| --- | --- |
|5<br>20<br>100<br>100<br>100<br>20|Insufficient capacity!<br>240|
|1<br>1000|Insufficient capacity!<br>0|
|7<br>10<br>20<br>30<br>10<br>5<br>10<br>20|105|
|4<br>250<br>10<br>20<br>40|Insufficient capacity!<br>Insufficient capacity!<br>Insufficient capacity!<br>250|

## 8.	Beer Kegs
Write a program, which calculates the volume of n beer kegs. 
You will receive in total 3 * n lines. Every three lines will hold information for a single keg. 
First up is the model of the keg, after that is the radius of the keg, and lastly is the height of the keg.
Calculate the volume using the following formula: π * r^2 * h. 
In the end, print the model of the biggest keg.

### Input
You will receive 3 * n lines. Each group of lines will be on a new line:
*	First – model – string
*	Second –radius – floating-point number
*	Third – height – integer number

### Output
Print the model of the biggest keg.

### Constraints
*	n will be in the interval [1…10].
*	The radius will be a floating-point number in the interval [1…3.402823E+38].
*	The height will be an integer in the interval [1…2147483647].

### Examples
| Input | Output |
| --- | --- |
|3<br>Keg 1<br>10<br>10<br>Keg 2<br>20<br>20<br>Keg 3<br>10<br>30|Keg 2|
|2<br>Smaller Keg<br>2.41<br>10<br>Bigger Keg<br>5.12<br>20|Bigger Keg|

## 9.	*Spice Must Flow 

Spice is Love, Spice is Life. And most importantly, Spice must flow. It must be extracted from the scorching sands of Arrakis, under the constant threat of giant sandworms. To make the work as efficient as possible, the Duke has tasked you with the creation of management software. 
Write a program that calculates the total amount of spice that can be extracted from a source. 
The source has a starting yield, which indicates how much spice can be mined on the first day. After it has been mined for a day, the yield drops by 10, meaning on the second day it’ll produce 10 less spice than on the first, on the third day 10 less than on the second, and so on (see examples). 
A source is considered profitable only while its yield is at least 100 – when less than 100 spices are expected in a day, abandon the source. 
The mining crew consumes 26 spices every day at the end of their shift and an additional 26 after the mine has been exhausted. Note that the workers cannot consume more spice than there is in storage. 
When the operation is complete, print on the console on two separate lines how many days the mine has operated and the total amount of spice extracted. 

### Input 
You will receive a number, representing the starting yield of the source. 

### Output 
Print on the console on two separate lines how many days the mine has operated and the total amount of spice extracted.

### Constraints 
*	The starting yield will be a positive integer within the range [0 … 2 147 483 647]

### Examples
| Input | Output | Explanation |
| --- | --- | --- |
|111|2<br>134|Day 1 we extract 111 spices and at the end of the shift, the workers consume 26, leaving 85. The yield drops by 10 to 101. <br>On day 2 we extract 101 spices, the workers consume 26, leaving 75. The total is 160 and the yield has dropped to 91.<br>Since the expected yield is less than 100, we abandon the source. The workers take another 26, leaving 134. The mine has operated for 2 days.|
|200|11<br>1338||

## 10.	*Poke Mon
A Poke Mon is a special type of pokemon which likes to Poke others. But at the end of the day, the Poke Mon wants to keep statistics, about how many pokes it has managed to make.
The Poke Mon pokes his target and then proceeds to poke another target. The distance between his targets reduces his poke power.
You will be given the poke power the Poke Mon has, N – an integer.
Then you will be given the distance between the poke targets, M – an integer.
Then you will be given the exhaustionFactor Y – an integer.
Your task is to start subtracting M from N until N becomes less than M, i.e. the Poke Mon does not have enough power to reach the next target. 
Every time you subtract M from N that means you’ve reached a target and poked it successfully. COUNT how many targets you’ve poked – you’ll need that count.
The Poke Mon becomes gradually more exhausted. IF N becomes equal to EXACTLY 50 % of its original value, you must divide N by Y, if it is POSSIBLE. This DIVISION is between integers.
If a division is not possible, you should NOT do it. Instead, you should continue subtracting.
After dividing, you should continue subtracting from N, until it becomes less than M.
When N becomes less than M, you must take what has remained of N and the count of targets you’ve poked, and print them as output.

**NOTE:** When you are calculating percentages, you should be PRECISE at maximum.

**Example:** 505 is NOT EXACTLY 50 % from 1000, its 50.5 %.

### Input
*	The input consists of 3 lines.
*	On the first line, you will receive N – an integer.
*	On the second line, you will receive M – an integer.
*	On the third line, you will receive Y – an integer.

### Output
*	The output consists of 2 lines.
*	On the first line, print what has remained of N, after subtracting from it.
*	On the second line, print the count of targets, you’ve managed to poke.

### Constrains
*	The integer N will be in the range [1, 2.000.000.000].
*	The integer M will be in the range [1, 1.000.000].
*	The integer Y will be in the range [0, 9].
*	Allowed time / memory: 16 MB / 100ms.

### Examples
| Input | Output | Comments |
| --- | --- | --- |
|5<br>2<br>3|1<br>2|N = 5, M = 2, Y = 3.<br>We start subtracting M from N.<br>N – M = 3. 1 target poked.<br>N – M = 1. 2 targets poked.<br>N < M.<br>We print what has remained of N, which is 1.<br>We print the count of targets, which is 2.|
|10<br>5<br>2|2<br>1|N = 10, M = 5, Y = 2.<br>We start subtracting M from N.<br>N – M = 5. (N is still not less than M, they are equal).<br>N became EXACTLY 50 % of its original value.<br>5 is 50 % from 10. So we divide N by Y.<br>N / Y = 5 / 2 = 2. (INTEGER DIVISION).|

## 11.	*Snowballs
Tony and Andi love playing in the snow and having snowball fights, but they always argue about which makes the best snowballs. They have decided to involve you in their fray, by making you write a program that calculates snowball data and outputs the best snowball value.
You will receive N – an integer, the number of snowballs being made by Tony and Andi.
For each snowball you will receive 3 input lines:
*	On the first line, you will get the snowballSnow – an integer.
*	On the second line, you will get the snowballTime – an integer.
*	On the third line, you will get the snowballQuality – an integer.
For each snowball you must calculate its snowballValue by the following formula:
(snowballSnow / snowballTime) ^ snowballQuality
In the end, you must print the highest calculated snowballValue.

### Input
*	On the first input line, you will receive N – the number of snowballs.
*	On the next N * 3 input lines you will be receiving data about snowballs. 

### Output
*	As output, you must print the highest calculated snowballValue, by the formula, specified above. 
*	The output format is: 
"{snowballSnow} : {snowballTime} = {snowballValue} ({snowballQuality})"

### Constraints
*	The number of snowballs (N) will be an integer in the range [0, 100].
*	The snowballSnow is an integer in the range [0, 1000].
*	The snowballTime is an integer in the range [1, 500].
*	The snowballQuality is an integer in the range [0, 100].
*	Allowed working time / memory: 100ms / 16MB.

### Examples
| Input | Output |
| --- | --- |
|2<br>10<br>2<br>3<br>5<br>5<br>5|10 : 2 = 125 (3)|
|3<br>10<br>5<br>7<br>16<br>4<br>2<br>20<br>2<br>2|10 : 5 = 128 (7)|
