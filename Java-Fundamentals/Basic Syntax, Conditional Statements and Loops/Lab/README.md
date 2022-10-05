# Lab: Basic Syntax, Conditional Statements and Loops
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

## 1.	Student Information

You will be given 3 lines of input – student name, age, and average grade. Your task is to print all the info about the student in the following format: **"Name: {student name}, Age: {student age}, Grade: {student grade}".**

### Examples

| Input | Output |
| --- | --- |
|John<br>15<br>5.40| Name: John, Age: 15, Grade: 5.40| 
|Steve<br>16<br>2.50| Name: Steve, Age: 16, Grade: 2.50|
|Marry<br>12<br>6.00| Name: Marry, Age: 12, Grade: 6.00|

## 2.	Passed
Write a program, which takes as an input a grade and prints "Passed!" if the grade is equal or more than 3.00.

### Input
The input comes as a single floating-point number.
### Output
The output is either "Passed!" if the grade is equal or more than 3.00, otherwise you should print nothing.
### Examples
| Input | Output |
| --- | --- |
|5.32| Passed!|
|2.34|(no output)|

## 3.	Passed or Failed
Modify the above program, so it will print "Failed!" if the grade is lower than 3.00.

### Input
The input comes as a single double number.
### Output
The output is either "Passed!" if the grade is more than 2.99, otherwise you should print "Failed!".
### Examples
| Input | Output |
| --- | --- |
|5.32| Passed!|
|2.36|Failed!|

## 4.	Back in 30 Minutes.
Every time John tries to pay his bills he sees on the cash desk the sign: "I will be back in 30 minutes". One day John was sick of waiting and decided he needs a program, which prints the time after 30 minutes. That way he won’t have to wait at the desk and come at the appropriate time. He gave the assignment to you, so you have to do it.

## Input
The input will be on two lines. On the first line, you will receive the hours and on the second you will receive the minutes.
### Output
Print on the console the time after 30 minutes. The result should be in the format "hh:mm". The hours have one or two numbers and the minutes have always two numbers (with leading zero).
### Constraints
* The hours will be between 0 and 23.
*	The minutes will be between 0 and 59.
### Examples
| Input | Output |
| --- | --- |
|1<br>46|2:16|
|0<br>01|0:31|
|23<br>59|0:29|
|11<br>08|11:38|
|11<br>32|12:02|

## 5.	Month Printer
Write a program, which takes an integer from the console and prints the corresponding month. If the number is more than 12 or less than 1 print "Error!".

### Input
You will receive a single integer on a single line.
### Output
If the number is within the boundaries print the corresponding month, otherwise print "Error!".
### Examples
| Input | Output |
| --- | --- |
|2|February|
|13|Error!|

## 6.	Foreign Languages
Write a program, which prints the language, that a given country speaks. You can receive only the following combinations: English is spoken in England and USA; Spanish is spoken in Spain, Argentina, and Mexico; for the others, we should print "unknown".

### Input
You will receive a single country name on a single line.
### Output
Print the language, which the country speaks, or if it is unknown for your program, print "unknown".
### Examples
| Input | Output |
| --- | --- |
|USA|English|
|Germany|unknown|

## 7.	Theatre Promotions
A theatre is doing a ticket sale, but they need a program to calculate the price of a single ticket. If the given age does not fit one of the categories, you should print "Error!".  You can see the prices in the table below:
| Day / Age | 0 <= age <= 18 | 18 < age <= 64 | 64 < age <= 122 |
| --------- | -------------- | -------------- | --------------- |
| Weekday | 12$| 18$|12$|
|Weekend|15$|20$|15$|
|Holiday|5$|12$|10$|




