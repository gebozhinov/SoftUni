# Lab: Data Types and Variables
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

# I.	Integer and Real Numbers

## 1.	Convert Meters to Kilometers
You will be given an integer that will be a distance in meters. Write a program that converts meters to kilometers formatted to the second decimal point.

### Examples
| Input | Output |
| --- | --- |
|1852|1.85|
|798|0.80|

## 2.	Pounds to Dollars
Write a program that converts British pounds to US dollars formatted to the 3rd decimal point.
1 British Pound = 1.36 Dollars

### Examples
| Input | Output |
| --- | --- |
|80|108.800|
|39|53.040|

## 3.	Exact Sum of Real Numbers
Write a program to enter n numbers and calculate and print their exact sum (without rounding).

### Examples
| Input | Output |
| --- | --- |
|3<br>1000000000000000000<br>5<br>10|1000000000000000015|
|2<br>0.00000000003<br>333333333333.3|333333333333.30000000003|

### Hints
Use BigDecimal to not lose precision.

# II.	Data Types and Type Conversion

## 4.	Town Info
You will be given 3 lines of input. On the first line you will be given the name of the town, on the second – the population and on the third the area. Use the correct data types and print the result in the following format:
"Town {town name} has population of {population} and area {area} square km.".

### Examples
| Input | Output |
| --- | --- |
|Sofia<br>1286383<br>492|Town Sofia has population of 1286383 and area 492 square km.
|Plovdiv<br>343424<br>101|Town Plovdiv has population of 343424 and area 101 square km.

## 5.	Concat Names
Read two names and a delimiter. Print the names joined by the delimiter.

### Examples
| Input | Output |
| --- | --- |
|John<br>Smith<br>->|John->Smith|
|Jan<br>White<br><->|Jan<->White|
|Linda<br>Terry<br>=>|Linda=>Terry|

## 6.	Chars to String
Write a program that reads 3 lines of input. On each line, you get a single character. Combine all the characters into one string and print it on the console.

### Examples
| Input | Output |
| --- | --- |
|a<br>b<br>c|abc|
|%<br>2<br>o|%2o|
|1<br>5<br>p|15p|

## 7.	Reversed Chars
Write a program that takes 3 lines of characters and prints them in reversed order with a space between them.

### Examples
| Input | Output |
| --- | --- |
|A<br>B<br>C|C B A|
|1<br>L<br>&|& L 1|

## 8.	Lower or Upper
Write a program that prints whether a given character is upper-case or lower-case.

### Examples
| Input | Output |
| --- | --- |
|L|upper-case|
|f|lower-case|

## 9.	Centuries to Minutes
Write a program to enter an integer number of centuries and convert it to years, days, hours, and minutes.

### Examples
| Input | Output |
| --- | --- |
|1|1 centuries = 100 years = 36524 days = 876581 hours = 52594877 minutes|
|5|5 centuries = 500 years = 182621 days = 4382906 hours = 262974384 minutes|

### Hints
*	Use appropriate data types to fit the result after each data conversion.
*	Assume that a year has 365.2422 days on average (the Tropical year).

## 10.	Special Numbers
A number is special when its sum of digits is 5, 7, or 11.
Write a program to read an integer n and for all numbers in the range 1…n to print the number and if it is special or not (True / False).

### Examples
| Input | Output |
| --- | --- |
|15|1 -> False<br>2 -> False<br>3 -> False<br>4 -> False<br>5 -> True<br>6 -> False<br>7 -> True<br>8 -> False<br>9 -> False<br>10 -> False<br>11 -> False<br>12 -> False<br>13 -> False<br>14 -> True<br>15 -> False|
|9|1 -> False<br>2 -> False<br>3 -> False<br>4 -> False<br>5 -> True<br>6 -> False<br>7 -> True<br>8 -> False<br>9 -> False|

### Hints
To calculate the sum of digits of given number num, you might repeat the following: sum the last digit (num % 10) and remove it (sum = sum / 10) until num reaches 0.

# III.	Variables

## 11.	Refactor Volume of Pyramid 
You are given a working code that finds the volume of a pyramid. However, you should consider that the variables exceed their optimum span and have improper naming. Also, search for variables that have multiple purposes.

### Code
| Sample Code | 
| --- |
|Scanner scanner = new Scanner(System.in);<br>double dul, sh, V = 0;<br>System.out.print("Length: ");<br>dul = Double.parseDouble(scanner.nextLine());<br>System.out.print("Width: ");<br>sh = Double.parseDouble(scanner.nextLine());<br>System.out.print("Height: ");<br>V = Double.parseDouble(scanner.nextLine());<br>V = (dul * sh * V) / 3;<br>System.out.printf("Pyramid Volume: %.2f", V);|

### Hints
*	Reduce the span of the variables by declaring them at the moment they receive a value, not before
*	Rename your variables to represent their real purpose (example: "dul" should become length, etc.)
*	Search for variables that have multiple purposes. If you find any, introduce a new variable.


## 12.	Refactor Special Numbers
You are given a working code that is a solution to Problem 9. Special Numbers. However, the variables are improperly named, declared before they are needed and some of them are used for multiple things. Without using your previous solution, modify the code so that it is easy to read and understand.

### Code
| Sample Code | 
| --- |
| Scanner scanner = new Scanner(System.in);<br>int kolkko = Integer.parseInt(scanner.nextLine());<br>int obshto = 0;<br>int takova = 0;<br>boolean toe = false;<br>for (int ch = 1; ch <= kolkko; ch++) {<br>    takova = ch;<br>    while (ch > 0) {<br>        obshto += ch % 10;<br>        ch = ch / 10;<br>    }<br>    toe = (obshto == 5) || (obshto == 7) || (obshto == 11);<br>    System.out.printf("%d -> %b%n", takova, toe);<br>    obshto = 0;<br>    ch = takova;<br>}|

### Hints
*	Reduce the span of the variables by declaring them at the moment they receive a value, not before
*	Rename your variables to represent their real purpose (example: "toe" should become isSpecialNum, etc.)
*	Search for variables that have multiple purposes. If you find any, introduce a new variable
