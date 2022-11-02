# Lab: Associative Arrays, Lambda and Stream API
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

# I.	Associative Arrays

## 1.	Count Real Numbers
Read a list of real numbers and print them in ascending order along with their number of occurrences

### Examples
| Input | Output |
| --- | --- |
|8 2 2 8 2|2 -> 3<br>8 -> 2|
|1 5 1 3|1 -> 2<br>3 -> 1<br>5 -> 1|
|-2 0 0 2|-2 -> 1<br>0 -> 2<br>2 -> 1|

## 2.	Word Synonyms
Write a program that keeps a map with synonyms. The key of the map will be the word. The value will be a list of all the synonyms of that word. You will be given a number n. On the next 2 * n lines you will be given a word and a synonym each on a separate line like this:

*	{word}
*	{synonym}

If you get the same word for the second time, just add the new synonym to the list. 
Print the words in the following format:

**{word} - {synonym1, synonym2… synonymN}**

### Examples
| Input | Output |
| --- | --- |
|3<br>cute<br>adorable<br>cute<br>charming<br>smart<br>clever|cute - adorable, charming<br>smart - clever|
|2<br>task<br>problem<br>task<br>assignment|task – problem, assignment|

## 3.	Odd Occurrences
Write a program that extracts from a given sequence of words all elements that are present in it an odd number of times (case-insensitive).

*	Words are given in a single line, space-separated.
*	Print the result elements in lowercase in their order of appearance.

### Examples
| Input | Output |
| --- | --- |
|Java C# PHP PHP JAVA C java|java, c#, c|
|3 5 5 hi pi HO Hi 5 ho 3 hi pi|5, hi|
|a a A SQL xx a xx a A a XX c|a, sql, xx, c|

# II.	Stream API

## 4.	Word Filter
Read an array of strings, take only words which length is even. Print each word on a new line.

### Examples
| Input | Output |
| --- | --- |
|kiwi orange banana apple|kiwi<br>orange<br>banana|
|pizza cake pasta chips|cake|
