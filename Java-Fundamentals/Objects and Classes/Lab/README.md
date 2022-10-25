# Lab: Objects and Classes
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

# I.	Using the Built-in Java Classes

## 1.	Randomize Words
You are given a list of words in one line. Randomize their order and print each word on a separate line

### Examples
| Input | Output | Comments |
| --- | --- | --- |
|Welcome to SoftUni and have fun learning programming|learning<br>Welcome<br>SoftUni<br>and<br>fun<br>programming<br>have<br>to|The order of the words in the output will be different after each program execution.|
|Java is the best programming language|the<br>programming<br>best<br>language<br>is<br>Java||

### Hints
*	Split the input string (by space) and create an array of words.
*	Create a random number generator - an object rnd of type Random.
*	In a for-loop exchange each number at positions 0, 1, …, words.Length-1 by a number at a random. position. To generate a random number in range use rnd.nextInt(words.length).
*	Print each word in the array on a new line.

## 2.	Sum Big Numbers
You will receive two numbers (0 to 1050), print their sum. 

### Examples
| Input | Output |
| --- | --- |
|923847238931983192462832102<br>934572893617836459843471846187346|934573817465075391826664309019448|
|4<br>100|104|

### Hints
Use the class BigInteger

## 3.	Big Factorial
You will receive N - the number in the range [0 - 1000]. Calculate the Factorial of N and print the result.

### Examples
| Input | Output |
| --- | --- |
|5|120|
|50|30414093201713378043612608166064768844377641568960512000000000000|

# II.	Defining Simple Classes

## 4.	Songs
Define a class Song, which holds the following information about songs: Type List, Name, and Time.

On the first line, you will receive the number of songs - N. 

On the next N-lines you will be receiving data in the following format: "{typeList}_{name}_{time}".

On the last line, you will receive "Type List" / "all". Print only the names of the songs which are from that Type List / All songs. 

### Examples
| Input | Output |
| --- | --- |
|3<br>favourite_DownTown_3:14<br>favourite_Kiss_4:16<br>favourite_Smooth Criminal_4:01<br>favourite|DownTown<br>Kiss<br>Smooth Criminal|
|4<br>favourite_DownTown_3:14<br>listenLater_Andalouse_3:24<br>favourite_In To The Night_3:58<br>favourite_Live It Up_3:48<br>listenLater|Andalouse|
|2<br>like_Replay_3:15<br>ban_Photoshop_3:48<br>all|Replay<br>Photoshop|

## 5.	Students
Define a class Student, which holds the following information about students: first name, last name, age, and hometown. 

Read the list of students until you receive the "end" command. After that, you will receive a city name. Print only students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".

### Examples
| Input | Output |
| --- | --- |
|John Smith 15 Sofia<br>Peter Ivanov 14 Plovdiv<br>Linda Bridge 16 Sofia<br>Simon Stone 12 Varna<br>end<br>Sofia|John Smith is 15 years old<br>Linda Bridge is 16 years old|
|Anthony Taylor 15 Chicago<br>David Anderson 16 Washington<br>Jack Lewis 14 Chicago<br>David Lee 14 Chicago<br>end<br>Chicago|Anthony Taylor is 15 years old<br>Jack Lewis is 14 years old<br>David Lee is 14 years old|

## 6.	Students 2.0
Use the class from the previous problem. If you receive a student which already exists (first name and last name should be unique) overwrite the information.

### Examples
| Input | Output |
| --- | --- |
|John Smith 15 Sofia<br>John Smith 16 Sofia<br>Linda Bridge 17 Sofia<br>Simon Stone 12 Varna<br>end<br>Sofia|John Smith is 16 years old<br>Linda Bridge is 17 years old|
|J S 3 S<br>Peter Ivanov 14 P<br>P J 104 S<br>J P 61 S<br>Simon Stone 12 Varna<br>Simon Sone 12 Varna<br>end<br>Varna|Simon Stone is 12 years old<br>Simon Sone is 12 years old|
