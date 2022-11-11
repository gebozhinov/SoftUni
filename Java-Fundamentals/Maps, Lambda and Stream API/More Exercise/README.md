# More Exercises: Associative Arrays, Lambda and Stream API
Problems for exercises and homework for the "Programming Fundamentals" course @ SoftUni.

## 1.	Ranking
Here comes the final and the most interesting part - the Final ranking of the candidate-interns. The final ranking is determined by the points of the interview tasks and from the exams in SoftUni. Here is your final task. You will receive some lines of input in the format "{contest}:{password for contest}" until you receive "end of contests". Save that data because you will need it later. After that, you will receive another type of inputs in the format "{contest}=>{password}=>{username}=>{points}" until you receive "end of submissions". Here is what you need to do: 

*	Check if the contest is valid (if you received it in the first type of input);
*	Check if the password is correct for the given contest;
*	Save the user with the contest they take part in (a user can take part in many contests) and the points the user has in the given contest. If you receive the same contest and the same user, update the points only if the new ones are more than the older ones.

In the end, you have to print the info for the user with the most points in the format "Best candidate is {user} with total {total points} points.". After that print all students ordered by their names. For each user print each contest with the points in descending order. See the examples.

### Input
*	Strings in format "{contest}:{password for contest}" until the "end of contests" command. There will be no case with two equal contests.
*	Strings in format "{contest}=>{password}=>{username}=>{points}" until the "end of submissions" command.
*	There will be no case with 2 or more users with the same total points!

### Output
*	On the first line print the best user in a format:
"Best candidate is {user} with total {total points} points.".
*	Then print all students ordered as mentioned above in format:
"{user1 name}
  {contest1} -> {points}
  {contest2} -> {points}"

### Constraints
*	The strings may contain any ASCII character except (:, =, >).
*	The numbers will be in the range [0 - 10000].
*	The second input is always valid.

### Examples
| Input | Output |
| --- | --- |
|Part One Interview:success<br>Js Fundamentals:Pesho<br>C# Fundamentals:fundPass<br>Algorithms:fun<br>end of contests<br>C# Fundamentals=>fundPass=>Tanya=>350<br>Algorithms=>fun=>Tanya=>380<br>Part One Interview=>success=>Nikola=>120<br>Java Basics Exam=>pesho=>Petkan=>400<br>Part One Interview=>success=>Tanya=>220<br>OOP Advanced=>password123=>BaiIvan=>231<br>C# Fundamentals=>fundPass=>Tanya=>250<br>C# Fundamentals=>fundPass=>Nikola=>200<br>Js Fundamentals=>Pesho=>Tanya=>400<br>end of submissions|Best candidate is Tanya with total 1350 points.<br>Ranking: <br>Nikola<br>\#  C# Fundamentals -> 200<br>\#  Part One Interview -> 120<br>Tanya<br>\#  Js Fundamentals -> 400<br>\#  Algorithms -> 380<br>\#  C# Fundamentals -> 350<br>\#  Part One Interview -> 220|

## 2.	Judge
You know the Judge system, right?! Your job is to create a program similar to the Judge system. 

You will receive several input lines in the following format:

"{username} -> {contest} -> {points}"

The constestName and username are strings, the given points will be an integer number. You need to keep track of every contest and individual statistics of every user. You should check if such a contest already exists, and if not, add it, otherwise, check if the current user is participating in the contest, if he is participating take the higher score, otherwise, just add it.

Also, you need to keep individual statistics for each user - the total points of all contests.

You should end your program when you receive the command "no more time". At that point, you should print each contest in order of input, for each contest print the participants ordered by points in descending order, then ordered by name in ascending order. After that, you should print individual statistics for every participant ordered by total points in descending order, and then by alphabetical order.

### Input / Constraints
*	The input comes in the form of commands in the format specified above.
*	Username and contest name always will be one word.
*	Points will be an integer in the range [0, 1000].
*	There will be no invalid input lines.
*	If all sorting criteria fail, the order should be by order of input.
*	The input ends when you receive the command "no more time".

### Output
*	The output format for the contests is:
"{constestName}: {participants.Count} participants
{position}. {username} <::> {points}"
*	After you print all contests, print the individual statistics for every participant.
*	The output format is:
"Individual standings:
{position}. {username} -> {totalPoints}"

### Examples
| Input | Output |
| --- | --- |
|Peter -> Algo -> 400<br>George -> Algo -> 300<br>Sam -> Algo -> 200<br>Peter -> DS -> 150<br>Maria -> DS -> 600<br>no more time|Algo: 3 participants<br>1. Peter <::> 400<br>2. George <::> 300<br>3. Sam <::> 200<br>DS: 2 participants<br>1. Maria <::> 600<br>2. Peter <::> 150<br>Individual standings:<br>1. Maria -> 600<br>2. Peter -> 550<br>3. George -> 300<br>4. Sam -> 200|
|Peter -> OOP -> 350<br>George -> OOP -> 250<br>Sam -> Advanced -> 600<br>George -> OOP -> 300<br>Pitter -> OOP -> 300<br>Pitter -> Advanced -> 250<br>Anna -> JSCore -> 400<br>no more time|OOP: 3 participants<br>1. Peter <::> 350<br>2. George <::> 300<br>3. Pitter <::> 300<br>Advanced: 2 participants<br>1. Sam <::> 600<br>2. Pitter <::> 250<br>JSCore: 1 participants<br>1. Anna <::> 400<br>Individual standings:<br>1. Sam -> 600<br>2. Pitter -> 550<br>3. Anna -> 400<br>4. Peter -> 350<br>5. George -> 300|

## 3.	MOBA Challenger
Peter is a pro MOBA player, he is struggling to become a master of the Challenger tier. So he watches carefully the statistics in the tier.

You will receive several input lines in one of the following formats:

"{player} -> {position} -> {skill}"

"{player} vs {player}"

The player and position are strings, the given skill will be an integer number. You need to keep track of every player.

When you receive a player and his position and skill, add him to the player pool, if he isn't present, else add his position and skill or update his skill, only if the current position skill is lower than the new value.

If you receive "{player} vs {player}" and both players exist in the tier, they duel with the following rules:

Compare their positions, if they got at least one in common, the player with better total skill points wins and the other is demoted from the tier -> remove him. If they have the same total skill points, the duel is a tie and they both continue in the Season.

If they don't have positions in common, the duel isn't happening and both continue in the Season.

You should end your program when you receive the command "Season end". At that point, you should print the players, ordered by total skill in descending order, then ordered by player name in ascending order. For each player print, their position and skill are ordered descending by skill, then ordered by position name in ascending order.

### Input / Constraints
*	The input comes in the form of commands in one of the formats specified above.
*	Player and position will always be one-word string, containing no whitespaces.
*	Skill will be an integer in the range [0, 1000].
*	There will be no invalid input lines.
*	The program ends when you receive the command "Season end".

### Output
*	The output format for each player is:
"{player}: {totalSkill} skill

- {position} <::> {skill}"

### Examples
| Input | Output | Comments |
| --- | --- | --- |
|Peter -> Adc -> 400<br>George -> Jungle -> 300<br>Sam -> Mid -> 200<br>Sam -> Support -> 250<br>Season end|Sam: 450 skill<br>- Support <::> 250<br>- Mid <::> 200<br>Peter: 400 skill<br>- Adc <::> 400<br>George: 300 skill<br>- Jungle <::> 300|We order the players by total skill points descending, then by name. We print every position along its skill ordered descending by skill, then by position name.|
|Peter -> Adc -> 400<br>Bush -> Tank -> 150<br>Faker -> Mid -> 200<br>Faker -> Support -> 250<br>Faker -> Tank -> 250<br>Peter vs Faker<br>Faker vs Bush<br>Faker vs Hide<br>Season end|Faker: 700 skill<br>- Support <::> 250<br>- Tank <::> 250<br>- Mid <::> 200<br>Peter: 400 skill<br>- Adc <::> 400|Faker and Peter don't have a common position, so the duel isn't valid.<br>Faker wins vs Bush /common position: "Tank". Bush is demoted.<br>Hide doesn't exist so the duel isn't valid.<br>We print every player left in the tier.|

## 4.	Snowwhite
Snow White loves her dwarfs, but there are so many and she doesn't know how to order them. Does she order them by name? Or by the color of their hat? Or by physics? She can't decide, so it's up to you to write a program that does it for her.

You will be receiving several input lines which contain data about dwarfs in the following format:

"{dwarfName} <:> {dwarfHatColor} <:> {dwarfPhysics}"

The dwarfName and the dwarfHatColor are strings. The dwarfPhysics is an integer.

You must store the dwarfs in your program. There are several rules though:
*	If 2 dwarfs have the same name but different hat colors, they should be considered different dwarfs, and you should store both of them.
*	If 2 dwarfs have the same name and the same hat color, store the one with the higher physics.

When you receive the command "Once upon a time", the input ends. You must order the dwarfs by physics in descending order and then by the total count of dwarfs with the same hat color in descending order. 
Then you must print them all.

### Input
*	The input will consist of several input lines, containing dwarf data in the format, specified above.
*	The input ends when you receive the command "Once upon a time".

### Output
*	As output, you must print the dwarfs, ordered in the way, specified above.
*	The output format is: "({hatColor}) {name} <-> {physics}".

### Examples
| Input | Output |
| --- | --- |
|Peter <:> Red <:> 2000<br>Todor <:> Blue <:> 1000<br>George <:> Green <:> 1000<br>Smith <:> Yellow <:> 4500<br>Premis <:> Sam <:> 1000<br>Once upon a time|(Yellow) Smith <-> 4500<br>(Red) Peter <-> 2000<br>(Blue) Todor <-> 1000<br>(Green) George <-> 1000<br>(Sam) Premis <-> 1000|
|Peter <:> Red <:> 5000<br>Peter <:> Blue <:> 10000<br>Peter <:> Red <:> 10000<br>George <:> Blue <:> 10000<br>Once upon a time|(Blue) Peter <-> 10000<br>(Blue) George <-> 10000<br>(Red) Peter <-> 10000|

## 5.	Dragon Army
Heroes III is the best game ever. Everyone loves it and everyone plays it all the time. John is no exclusion to this rule. His favorite units in the game are all types of dragons - black, red, gold, azure, etc… He likes them so much that he gives them names and keeps logs of their stats: damage, health, and armor. The process of aggregating all the data is quite tedious, so he would like to have a program doing it. Since he is no programmer, it's your task to help him.

You need to categorize dragons by their type. For each dragon, identified by name, keep information about his stats. Type is preserved as in the order of input, but dragons are sorted alphabetically by name. For each type, you should also print the average damage, health, and armor of the dragons. For each dragon, print his stats.

There may be missing stats in the input, though. If a stat is missing, you should assign its default values. Default values are as follows: health 250, damage 45, and armor 10. Missing stat will be marked by null.

The input is in the following format "{type} {name} {damage} {health} {armor}". Any of the integers may be assigned null value. See the examples below for better understanding of your task.

If the same dragon is added a second time, the new stats should overwrite the previous ones. Two dragons are considered equal if they match by both name and type.

### Input
*	On the first line, you are given number N - the number of dragons to follow.
*	On the next N lines, you are given input in the format described above. There will be a single space separating each element.

### Output
*	Print the aggregated data on the console.
*	For each type print average stats of its dragons in format "{Type}::({damage}/{health}/{armor})".
*	Damage, health, and armor should be rounded to two digits after the decimal separator.
*	For each dragon print its stats in the format:
"-{Name} -> damage: {damage}, health: {health}, armor: {armor}"

### Constraints
*	N is in range [1…100].
*	The dragon type and name are one word only, starting with a capital letter.
*	Damage, health, and armor are integers in range [0 … 100000] or null.

### Examples
| Input | Output |
| --- | --- |
|5<br>Red Bazgargal 100 2500 25<br>Black Dargonax 200 3500 18<br>Red Obsidion 220 2200 35<br>Blue Kerizsa 60 2100 20<br>Blue Algordox 65 1800 50|Red::(160.00/2350.00/30.00)<br>-Bazgargal -> damage: 100, health: 2500, armor: 25<br>-Obsidion -> damage: 220, health: 2200, armor: 35<br>Black::(200.00/3500.00/18.00)<br>-Dargonax -> damage: 200, health: 3500, armor: 18<br>Blue::(62.50/1950.00/35.00)<br>-Algordox -> damage: 65, health: 1800, armor: 50<br>-Kerizsa -> damage: 60, health: 2100, armor: 20|
|4<br>Gold Zzazx null 1000 10<brGold Traxx 500 null 0<brGold Xaarxx 250 1000 null<brGold Ardrax 100 1055 50|Gold::(223.75/826.25/17.50)<br>-Ardrax -> damage: 100, health: 1055, armor: 50<br>-Traxx -> damage: 500, health: 250, armor: 0<br>-Xaarxx -> damage: 250, health: 1000, armor: 10<br>-Zzazx -> damage: 45, health: 1000, armor: 10|
