# Exercise: Objects and Classes
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

## 1.	Advertisement Message
Write a program that generates random fake advertisement messages to extol some product. The messages must consist of 4 parts: laudatory phrase + event + author + city. Use the following predefined parts:

*	Phrases – {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."}
*	Events – {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"}
*	Authors – {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"}
*	Cities –  {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}

The format of the output message is: {phrase} {event} {author} – {city}.
As an input, you take the number of messages to be generated. Print each random message on a separate line.

### Examples
| Input | Output |
| --- | --- |
|3|Such a great product. Now I feel good. Elena – Ruse<br>Excelent product. Makes miracles. I am happy of the results! Katya – Varna<br>Best product of its category. That makes miracles. Eva – Sofia|
|4|I always use that product. Makes miracles. I am happy of the results! Iva - Ruse<br>I can’t live without this product. I cannot believe but now I feel awesome. Katya - Burgas<br>Such a great product. Try it yourself, I am very satisfied. Iva - Varna<br>Best product of its category. I cannot believe but now I feel awesome. Eva - Ruse|

## 2.	Articles
Create an article class with the following properties:

*	Title – a string
*	Content – a string
*	Author – a string

The class should have a constructor and the following methods:

*	Edit (new content) – change the old content with the new one
*	ChangeAuthor (new author) – change the author
*	Rename (new title) – change the title of the article
*	override ToString – print the article in the following format: 
"{title} - {content}:{author}"

Write a program that reads an article in the following format "{title}, {content}, {author}". On the next line, you will get a number n. On the next n lines, you will get one of the following commands: "Edit: {new content}"; "ChangeAuthor: {new author}"; "Rename: {new title}". At the end, print the final article.

### Examples
| Input | Output |
| --- | --- |
|some title, some content, some author<br>3<br>Edit: better content<br>ChangeAuthor:  better author<br>Rename: better title|better title - better content: better author|
|Holy Ghost, content, John Sandford<br>3<br>ChangeAuthor:  Mitch Albom<br>ChangeAuthor:  better author<br>ChangeAuthor:  Kim Heacox|Holy Ghost - content:  Kim Heacox|

## 3.	Opinion Poll
Using the Person class, write a program that reads from the console N lines of personal information and then prints all people whose age is more than 30 years.

### Examples
| Input | Output |
| --- | --- |
|3<br>Peter 12<br>Sam 31<br>Itan 48|Sam – 31<br>Itan - 48|
|5<br>Niko 33<br>Yana 88<br>Todor 22<br>Lisa 44<br>Sam 11|Niko - 33<br>Yana - 88<br>Lisa - 44|

## 4.	Articles 2.0
Change the program from the second problem, so you can store a list of articles. You will not need the methods anymore (except the ToString method). On the first line, you will get a number n. On the next n lines, you will get some articles in the same format as the previous task ("{title}, {content}, {author}"). Finally, you will get one of the three inputs: "title", "content", "author". Print the articles. 

### Examples
| Input | Output |
| --- | --- |
|2<br>Science, planets, Bill<br>Article, content, Johnny<br>title|Science - planets: Bill Article - content: Johnny|
|3<br>title1, C, author1<br>title2, B, author2<br>title3, A, author3<br>content|title1 - C: author1<br>title2 - B: author2<br>title3 - A: author3|

## 5.	Students
Write a program that receives n count of students and orders them by grade (in descending). Each student should have a first name (string), last name (string), and grade (a floating-point number). 

### Input
*	First-line will be a number n.
*	Next n lines you will get a student info in the format "{first name} {second name} {grade}".

### Output
*	Print each student in the following format "{first name} {second name}: {grade}".

### Examples
| Input | Output |
| --- | --- |
|4<br>Lakia Eason 3.90<br>Prince Messing 5.49<br>Akiko Segers 4.85<br>Rocco Erben 6.00|Rocco Erben: 6.00<br>Prince Messing: 5.49<br>Akiko Segers: 4.85<br>Lakia Eason: 3.90|
|4<br>Sydnie Britton 5.79<br>Amias Mathews 2.30<br>Mora Tod 2.78<br>Pete Kendrick 2.61|Sydnie Britton: 5.79<br>Mora Tod: 2.78<br>Pete Kendrick: 2.61<br>Amias Mathews: 2.30|

## 6.	Vehicle Catalogue
You have to make a catalog for vehicles. You will receive two types of vehicles - a car or a truck. 
Until you receive the command "End" you will receive lines of input in the format:

**{typeOfVehicle} {model} {color} {horsepower}**

After the "End" command, you will start receiving models of vehicles. Print for every received vehicle its data in the format:

**Type: {typeOfVehicle}
Model: {modelOfVehicle}
Color: {colorOfVehicle}
Horsepower: {horsepowerOfVehicle}**

When you receive the command "Close the Catalogue", stop receiving input and print the average horsepower for the cars and the trucks in the format:

**"{typeOfVehicles} have average horsepower of {averageHorsepower}."**

The average horsepower is calculated by dividing the sum of horsepower for all vehicles of the type by the total count of vehicles from the same type.

Format the answer to the 2nd decimal point.

### Constraints
*	The type of vehicle will always be a car or truck.
*	You will not receive the same model twice.
*	The received horsepower will be an integer in the interval [1…1000].
*	You will receive at most 50 vehicles.
*	Single whitespace will be used for the separator.

### Examples
| Input | Output |
| --- | --- |
|truck Man red 200<br>truck Mercedes blue 300<br>car Ford green 120<br>car Ferrari red 550<br>car Lamborghini orange 570<br>End<br>Ferrari<br>Ford<br>Man<br>Close the Catalogue|Type: Car<br>Model: Ferrari<br>Color: red<br>Horsepower: 550<br>Type: Car<br>Model: Ford<br>Color: green<br>Horsepower: 120<br>Type: Truck<br>Model: Man<br>Color: red<br>Horsepower: 200<br>Cars have average horsepower of: 413.33.<br>Trucks have average horsepower of: 250.00.|
|car Opel green 736<br>End<br>Close the Catalogue|Cars have average horsepower of: 736.00.<br>Trucks have average horsepower of: 0.00.|

## 7.	Order by Age
You will receive an unknown number of lines. On each line, you will receive an array with 3 elements. The first element will be a string and represents the name of the person. The second element will be a string and will represent the ID of the person. The last element will be an integer which represents the age of the person.
When you receive the command "End", stop taking input and print all the people, ordered by age.

### Examples
| Input | Output |
| --- | --- |
|George 123456 20<br>Peter 78911 15<br>Stephan 524244 10<br>End|Stephan with ID: 524244 is 10 years old.<br>Peter with ID: 78911 is 15 years old.<br>George with ID: 123456 is 20 years old.|
|Cindy 88611 2<br>Kaloyan 13967 3<br>Simona 53316 11<br>Gil 31837 72<br>End|Cindy with ID: 88611 is 2 years old.<br>Kaloyan with ID: 13967 is 3 years old.<br>Simona with ID: 53316 is 11 years old.<br>Gil with ID: 31837 is 72 years old.|
