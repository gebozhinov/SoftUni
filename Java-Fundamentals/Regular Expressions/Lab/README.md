# Lab: Regular Expressions
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

## 1.	Match Full Name
Write a Java Program to match full names from a list of names and print them on the console.
### Writing the Regular Expression
First, write a regular expression to match a valid full name, according to these conditions:
*	A valid full name has the following characteristics:
    *	It consists of two words.
    *	Each word starts with a capital letter.
    *	After the first letter, it only contains lowercase letters afterward.
    *	Each of the two words should be at least two letters long.
    *	The two words are separated by a single space.

To help you out, we've outlined several steps:

1.	Use an online regex tester like https://regex101.com/ 
2.	Check out how to use character sets (denoted with square brackets - '[]')
3.	Specify that you want two words with a space between them (the space character ' ', and not any whitespace symbol)
4.	For each word, specify that it should begin with an uppercase letter using a character set. The desired characters are in a range – from 'A' to 'Z'.
5.	For each word, specify that what follows the first letter are only lowercase letters, one or more – use another character set and the correct quantifier.
6.	To prevent capturing of letters across new lines, put "\b" at the beginning and the end of your regex. This will ensure that what precedes and what follows the match is a word boundary (like a new line).

To check your RegEx, use these values for reference (paste all of them in the Test String field):

| Match ALL of these | Match NONE of these |
| --- | --- |
|Ivan Ivanov|Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Georgi Georgiev, Ivan	Ivanov|
|Peter Georgiev|peter georgiev, peter GeOrgiev, Peter   GeORgiev, PEter GEorgiev, Peter Georgiev, Anna Petrova|

After you’ve constructed your regular expression, it’s time to write the solution in Java.

### Implementing the Solution in Java
Create a new Java project and copy your regular expression into a String variable:

Now, it’s time to read the input and create two classes to help us work with regular expressions:
*	Pattern Class − A Pattern object is a compiled representation of a regular expression.
*	Matcher Class − A Matcher object is the engine that interprets the pattern and performs match operations against an input string.

Now, it’s time to extract all the matches from our input and print them. We use the matcher method find(), which attempts to find the next subsequence of the input sequence that matches the pattern. To get our matches, we need to use method group().

### Examples
| Input | Output |
| --- | --- |
|**Ivan Ivanov**, Ivan ivanov, ivan Ivanov, IVan Ivanov, **Georgi Georgiev**, Ivan	Ivanov|Ivan Ivanov Georgi Georgiev|
|peter georgiev, peter Georgiev, Peter GeoRgiev, PEter GEorgiev, **Peter Georgiev**, **Anna Petrova**|Peter Georgiev Anna Petrova|

## 2.	Match Phone Number
Write a regular expression to match a valid phone number from Sofia. After you find all valid phones, print them on the console, separated by a comma and a space ", ".

### Compose the Regular Expression
A valid number has the following characteristics:
*	It starts with "+359".
*	Then, it is followed by the area code (always 2).
*	After that, it’s followed by the number itself:
    *	The number consists of 7 digits (separated into two groups of 3 and 4 digits respectively). 
*	The different parts are separated by either a space or a hyphen ('-').

You can use the following RegEx properties to help with the matching: 

*	Use quantifiers to match a specific number of digits.
*	Use a capturing group to make sure the delimiter is only one of the allowed characters (space or hyphen) and not a combination of both (e.g. +359 2-111 111 has mixed delimiters, it is invalid). Use a group back reference to achieve this.
*	Add a word boundary at the end of the match to avoid partial matches (the last example on the right-hand side).
*	Ensure that before the '+' sign there is either a space or the beginning of the string.

You can use the following table of values to test your RegEx against:

| Match ALL of these | Match NONE of these |
| --- | --- |
|+359 2 222 2222<br>+359-2-222-2222|359-2-222-2222, +359/2/222/2222, +359-2 222 2222<br>+359 2-222-2222, +359-2-222-222, +359-2-222-22222|

### Examples
| Input | Output |
| --- | --- |
|**+359 2 222 2222**,359-2-222-2222, +359/2/222/2222, +359-2 222 2222 +359 2-222-2222, +359-2-222-222, +359-2-222-22222 **+359-2-222-2222**|+359 2 222 2222, +359-2-222-2222|
|+359 2 222 2222,359-2-222-2222, +359/2/222/2222, +359-2 222 2222 +359 2-222-2222, +359-2-222-222, +359-2-222-22222 +359-2-222-2222|+359 2 222 2222, +359-2-222-2222|

## 3.	Match Dates
Write a program, which matches a date in the format "dd{separator}MMM{separator}yyyy". Use named capturing groups in your regular expression.

### Compose the Regular Expression
Every valid date has the following characteristics:

*	Always starts with two digits, followed by a separator.
*	After that, it has one uppercase and two lowercase letters (e.g. Jan, Mar).
*	After that, it has a separator and exactly 4 digits (for the year).
*	The separator could be either of three things: a period ("."), a hyphen ("-") or a forward-slash ("/").
*	The separator needs to be the same for the whole date (e.g. 13.03.2016 is valid, 13.03/2016 is NOT). Use a group back reference to check for this.

You can follow the table below to help with composing your RegEx:

| Match ALL of these | Match NONE of these |
| --- | --- |
|13/Jul/1928, 10-Nov-1934, 25.Dec.1937|01/Jan-1951, 23/sept/1973, 1/Feb/2016|

Use named capturing groups for the day, month, and year.

### Examples
| Input | Output |
| --- | --- |
|**13/Jul/1928**, **10-Nov-1934**, , 01/Jan-1951,f **25.Dec.1937** 23/09/1973, 1/Feb/2016|Day: 13, Month: Jul, Year: 1928<br>Day: 10, Month: Nov, Year: 1934<br>Day: 25, Month: Dec, Year: 1937|
|01/Jan-1951 29/Feb/2024 1/Jan-1951 27-Feb-2007 1/Jan-1951 1/Mar/2016 23/october/197|Day: 29, Month: Feb, Year: 2024<br>Day: 27, Month: Feb, Year: 2007|
