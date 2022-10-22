# Lab: Lists
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

## 1.	Sum Adjacent Equal Numbers
Write a program to sum all adjacent equal numbers in a list of decimal numbers, starting from left to right.
    *	After two numbers are summed, the obtained result could be equal to some of its neighbors and should be summed as well (see the examples below).
    *	Always sum the leftmost two equal neighbors (if several couples of equal neighbors are available).

### Examples
| Input | Output | Explanation |
| --- | --- | --- |
|3 3 6 1|12 1|3 3 6 1 > 6 6 1 > 12 |
|8 2 2 4 8 16|16 8 16|8 2 2 4 8 16 > 8 4 4 8 16 > 8 8 8 16 > 16 8 16|
|5 4 2 1 1 4|5 8 4|5 4 2 1 1 4 > 5 4 2 2 4 > 5 4 4 4 > 5 8 4|
|0.1 0.1 5 -5|0.2 5 -5|0.1 0.1 5 -5  0.2 5 -5|

## 2.	Gauss' Trick
Write a program that sum all numbers in a list in the following order: 
first + last, first + 1 + last - 1, first + 2 + last - 2, … first + n, last - n.

### Examples
| Input | Output |
| --- | --- |
|1 2 3 4 5|6 6 3|
|1 2 3 4|5 5|

## 3.	Merging Lists
You are going to receive two lists with numbers. Create a result list that contains the numbers from both of the lists. The first element should be from the first list, the second from the second list, and so on. If the length of the two lists is not equal, just add the remaining elements at the end of the list.

### Examples
| Input | Output |
| --- | --- |
|3 5 2 43 12 3 54 10 23<br>76 5 34 2 4 12|3 76 5 5 2 34 43 2 12 4 3 12 54 10 23|
|76 5 34 2 4 12<br>3 5 2 43 12 3 54 10 23|76 3 5 5 34 2 2 43 4 12 12 3 54 10 23|

### Hint
*	Read the two lists.
*	Create a result list.
*	Start looping through them until you reach the end of the smallest one.
*	Finally, add the remaining elements (if any) to the end of the list.

## 4.	List Manipulation Basics
Write a program that reads a list of integers. Then until you receive "end", you will be given different commands:
Add {number}: add a number to the end of the list
Remove {number}: remove a number from the list
RemoveAt {index}: remove a number at a given index
Insert {number} {index}: insert a number at a given index
Note: All the indices will be valid!
When you receive the "end" command print the final state of the list (separated by spaces).

### Examples
| Input | Output |
| --- | --- |
|4 19 2 53 6 43<br>Add 3<br>Remove 2<br>RemoveAt 1<br>Insert 8 3<br>end|4 53 6 8 43 3|
|12 34 100 1 45 2 8<br>Add 30<br>Remove 12<br>Remove 3<br>RemoveAt 3<br>Insert 2 3<br>end|34 100 1 2 2 8 30|

## 5.	List Manipulation Advanced
Now we will implement more complicated list commands. Again, read a list, and until you receive "end" read commands:
Contains {number} – check if the list contains the number. If yes print "Yes", otherwise print "No such number"
Print even – print all the numbers that are even separated by a space
Print odd – print all the numbers that are oddly separated by a space
Get sum – print the sum of all the numbers
Filter {condition} {number} – print all the numbers that fulfill that condition. The condition will be either '<', '>', ">=", "<="

### Examples
| Input | Output |
| --- | --- |
|2 13 43 876 342 23 543<br>Contains 100<br>Contains 543<br>Print even<br>Print odd<br>Get sum<br>Filter >= 43<br>Filter < 100<br>end|No such number<br>Yes<br>2 876 342<br>13 43 23 543<br>1842<br>43 876 342 543<br>2 13 43 23|
|12 3 123 546 222 45 7<br>Contains 3<br>Contains 121<br>Print even<br>Print odd<br>Get sum<br>Filter >= 100<br>Filter < 45<br>end|Yes<br>No such number<br>12 546 222<br>3 123 45 7<br>958<br>123 546 222<br>12 3 7|

## 6.	List of Products
Read a number n and n lines of products. Print a numbered list of all the products ordered by name.

### Examples
| Input | Output |
| --- | --- |
|4<br>Potatoes<br>Tomatoes<br>Onions<br>Apples|1.Apples<br>2.Onions<br>3.Potatoes<br>4.Tomatoes|
|3<br>Orange<br>Grape<br>Strawberry|1.Grape<br>2.Orange<br>3.Strawberry|


## 7.	Remove Negatives and Reverse
Read a list of integers, remove all negative numbers from it and print the remaining elements in reversed order. In case of no elements left in the list, print "empty".

### Examples
| Input | Output |
| --- | --- |
|0 -5 7 9 -33 50|50 9 7 10|
|7 -2 -10 1|1 7|
|-1 -2 -3|empty|

