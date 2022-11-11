# Lab: Text Processing
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

## 1.	Reverse Strings
You will be given a series of strings until you receive an "end" command. Write a program that reverses strings and prints each pair on a separate line in the format "{word} = {reversed word}".

### Examples
| Input | Output |
| --- | --- |
|helLo<br>Softuni<br>bottle<br>end|helLo = oLleh<br>Softuni = inutfoS<br>bottle = elttob|
|Dog<br>caT<br>chAir<br>end|Dog = goD<br>caT = Tac<br>chAir = riAhc|

## 2.	Repeat Strings
Write a Program That Reads an Array of Strings. Each String is Repeated N Times, Where N is the length of the String. Print the Concatenated String.

### Examples
| Input | Output |
| --- | --- |
|hi abc add|hihiabcabcabcaddaddadd|
|work|workworkworkwork|
|ball|ballballballball|

## 3.	Substring
On the first line, you will receive a string. On the second line, you will receive a second string. Write a program that removes all of the occurrences of the first string in the second until there is no match. At the end print the remaining string.

### Examples
| Input | Output | Comment |
| --- | --- | --- |
|ice<br>kicegiciceeb|kgb|We remove ice once and we get "kgiciceeb"<br>We match "ice" one more time and we get "kgiceb"<br>There is one more match. The final result is "kgb"|
|e<br>fixture|fixtur||

## 4.	Text Filter
Write a program that takes a text and a string of banned words. All words included in the ban list should be replaced with asterisks "*", equal to the word's length. The entries in the ban list will be separated by a comma and space ", ".

The ban list should be entered on the first input line and the text on the second input line. 

### Examples
| Input | Output |
| --- | --- |
|Linux, Windows<br>It is not Linux, it is GNU/Linux. Linux is merely the kernel, while GNU adds the functionality. Therefore we owe it to them by calling the OS GNU/Linux! Sincerely, a Windows client|It is not *****, it is GNU/*****. ***** is merely the kernel, while GNU adds the functionality. Therefore we owe it to them by calling the OS GNU/*****! Sincerely, a ******* client|
|computer, programming, set<br>In computer programming, an application programming interface (API) is a set of subroutine definitions, communication protocols, and tools for building software.|In ******** ***********, an application *********** interface (API) is a *** of subroutine definitions, communication protocols, and tools for building software.|

### Hints
*	Read the input.
*	Replace all ban words in the text with an asterisk (*).
    *	Use the built-in method replace(banWord, replacement).

## 5.	Digits, Letters and Other
Write a program that receives a single string and on the first line prints all the digits, on the second – all the letters, and on the third – all the other characters. There will always be at least one digit, one letter, and one other character.

### Examples
| Input | Output |
| --- | --- |
|Agd#53Dfg^&4F53|53453<br>AgdDfgF<br>#^&|
|a1!|1<br>a<br>!|

### Hints
*	Read the input.
*	Use a loop to iterate through all characters in the text. If the char is digit print it, otherwise ignore it.
    *	Use Character.isDigit(char symbol)
*	Do the same for the letters and other chars.
    *	Find something like isDigit method for the letters.
