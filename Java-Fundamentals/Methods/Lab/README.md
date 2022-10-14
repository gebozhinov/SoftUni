# Lab: Methods
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

# I.	Declaring and Invoking Methods

## 1.	Sign of Integer
Create a method that prints the sign of an integer number.

### Examples
| Input | Output |
| --- | --- |
|2|The number 2 is positive.|
|-5|The number -5 is negative.|
|0|The number 0 is zero.|

## 2.	Grades
Write a method that receives a grade between 2.00 and 6.00 and prints the corresponding grade in words:
*	2.00 – 2.99 - "Fail"
*	3.00 – 3.49 - "Poor"
*	3.50 – 4.49 - "Good"
*	4.50 – 5.49 - "Very good"
*	5.50 – 6.00 - "Excellent"

### Examples
| Input | Output |
| --- | --- |
|3.33|Poor|
|4.50|Very good|
|2.99|Fail|

## 3.	Printing Triangle
Create a method for printing triangles as shown below:

### Examples
| Input | Output |
| --- | --- |
|3|1<br>1 2<br>1 2 3<br>1 2<br>1|
|4|1<br>1 2<br>1 2 3 <br>1 2 3 4<br>1 2 3<br>1 2<br>1|

## 4.	Calculations
Write a program that receives a string on the first line ("add", "multiply", "subtract", "divide") and on the next two lines receives two numbers. Create four methods (for each calculation) and invoke the right one depending on the command. The method should also print the result (needs to be void).

### Examples
| Input | Output |
| --- | --- |
|subtract<br>5<br>4|1|
|divide<br>8<br>4|2|

## 5.	Orders
Write a method that calculates the total price of an order and prints it on the console. The method should receive one of the following products: coffee, water, coke, snacks; and a quantity of the product. The prices for a single piece of each product are:
*	coffee – 1.50
*	water – 1.00
*	coke – 1.40
*	snacks – 2.00

Print the result rounded to the second decimal place.

### Examples
| Input | Output |
| --- | --- |
|water<br>5|5.00|
|coffee<br>2|3.00|

# II.	Returning Values and Overloading

## 6.	Calculate Rectangle Area
Create a method that calculates and returns the area of a rectangle by given width and length.

### Examples
| Input | Output |
| --- | --- |
|3<br>4|12|
|5<br>7|35|

## 7.	Repeat String
Write a method that receives a string and a repeat count n (integer). The method should return a new string (the old one repeated n times).

### Examples
| Input | Output |
| --- | --- |
|abc<br>3|abcabcabc|
|String<br>2|StringString|

## 8.	Math Power
Create a method that calculates and returns the value of a number raised to a given power.

### Examples
| Input | Output |
| --- | --- |
|2<br>8|256|
|5.5<br>3|166.375|

## 9.	Greater of Two Values
You are given two values of the same type as input. The values can be of type int, char of String. Create a method getMax() that returns the greater of the two values: 

### Examples
| Input | Output |
| --- | --- |
|int<br>2<br>16|16|
|char<br>a<br>z|z|
|string<br>Ivan<br>Todor|Todor|

## 10.	Multiply Evens by Odds
Create a program that reads an integer number and multiplies the sum of all its even digits by the sum of all its odd digits:

### Examples
| Input | Output | Comments |
| --- | --- | --- |
|12345|54|12345 has 2 even digits - 2 and 4. Even digits have a sum of 6. Also, it has 3 odd digits - 1, 3, and 5. Odd digits have a sum of 9. Multiply 6 by 9 and you get 54.|
|-12345|54||

## 11.	Math Operations
Write a method that receives two numbers and an operator, calculates the result, and returns it. You will be given three lines of input. The first will be the first number, the second one will be the operator and the last one will be the second number. The possible operators are: / * + -

Print the result rounded up to the second decimal point.

### Examples
| Input | Output |
| --- | --- |
|5<br>\*<br>5|25|
|4<br>+<br>8|12|
