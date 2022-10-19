# Exercises: Methods
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

## 1.	Smallest of Three Numbers
Write a method to print the smallest of three integer numbers. Use an appropriate name for the method.

### Examples
| Input | Output |
| --- | --- |
|2<br>5<br>3|2|
|600<br>342<br>123|123|
|25<br>-21<br>4|-21|

## 2.	Vowels Count
Write a method that receives a single string and prints the count of the vowels. Use an appropriate name for the method.

### Examples
| Input | Output |
| --- | --- |
|SoftUni|3|
|Cats|1|
|JS|0|

##  3.	Characters in Range
Write a method that receives two characters and prints on a single line all the characters in between them according to ASCII.

### Examples
| Input | Output |
| --- | --- |
|a<br>d|b c|
|#<br>:|$ % & ' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9|
|C<br>#|$ % & ' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9 : ; < = > ? @ A B|

## 4.	Password Validator
Write a program that checks if a given password is valid. Password rules are:
*	6 – 10 characters (inclusive);
*	Consists only of letters and digits;
*	Have at least 2 digits.
If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule print a message:
*	"Password must be between 6 and 10 characters";
*	"Password must consist only of letters and digits";
*	"Password must have at least 2 digits".

### Examples
| Input | Output |
| --- | --- |
|logIn|Password must be between 6 and 10 characters<br>Password must have at least 2 digits|
|MyPass123|Password is valid|
|Pa$s$s|Password must consist only of letters and digits<br>Password must have at least 2 digits

## 5.	Add and Subtract
You will receive 3 integers. Write a method sum to get the sum of the first two integers and subtract the method that subtracts the third integer from the result from the sum method. 

### Examples
| Input | Output |
| --- | --- |
|23<br>6<br>10|19|
|1<br>17<br>30|-12|
|42<br>58<br>100|0|

## 6.	Middle Characters
You will receive a single string. Write a method that prints the middle character. If the length of the string is even, there are two middle characters.

### Examples
| Input | Output |
| --- | --- |
|aString|r|
|someText|eT|
|3245|24|

## 7.	NxN Matrix
Write a method that receives a single integer n and prints nxn matrix with that number.

### Examples
| Input | Output |
| --- | --- |
|3|3 3 3<br>3 3 3<br>3 3 3|
|7|7 7 7 7 7 7 7	<br>7 7 7 7 7 7 7<br>7 7 7 7 7 7 7<br>7 7 7 7 7 7 7<br>7 7 7 7 7 7 7<br>7 7 7 7 7 7 7<br>7 7 7 7 7 7 7|
|2|2 2<br>2 2|

## 8.	Factorial Division
Read two integer numbers. Calculate the factorial of each number. Divide the first result by the second and print the division formatted to the second decimal point.

### Examples
| Input | Output |
| --- | --- |
|5<br>2|60.00|
|6<br>2|360.00|

## 9.	Palindrome Integers
A palindrome is a number that reads the same backward as forward, such as 323 or 1001. Write a program that reads a positive integer number until you receive "END". For each numbered print whether the number is palindrome or not.

### Examples
| Input | Output |
| --- | --- |
|123<br>323<br>421<br>121<br>END|false<br>true<br>false<br>true|
|32<br>2<br>232<br>1010<br>END|false<br>true<br>true<br>false|

## 10.	Top Number
Read an integer n from the console. Find all top numbers in the range [1 … n] and print them. A top number holds the following properties:
*	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
*	Holds at least one odd digit, e.g. 232, 707, 87578.

### Examples
| Input | Output |
| --- | --- |
|50|17<br>35|
|100|17<br>35<br>53<br>71<br>79<br>97|
