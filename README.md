This project is a Java application that calculates the score of children based on their behavior and gift preferences. The program reads data from JSON files containing information about children, their ages, behaviors, and gift preferences, and calculates their average score. The program also calculates the total score of cities based on the average score of their children.

Requirements
Java 8 or higher
Jackson Databind Library
How to use
Clone the repository to your local machine
Install the Jackson Databind Library
Create JSON files containing information about children, their ages, behaviors, and gift preferences in the tests directory
Run the Main class to calculate the scores
The program will read each JSON file in the tests directory and calculate the average score of each child. It will also calculate the total score of each city based on the average score of their children. The program will output the results to the console.

Classes
Main
This is the main class of the program. It reads the input data from the JSON files and calculates the scores of the children.

Checker
This class contains the methods used to calculate the score of each child.

Input
This class represents the input data read from the JSON files.

Output
This class represents the output data calculated by the program.

Child
This class represents a child and contains information about their age, behavior, and gift preferences.

ChildUpdate
This class represents an update to a child's behavior or gift preferences.

Score
This class represents the score of a child.

Present
This class represents a gift.

City
This class represents a city and contains information about the average score of its children.

License
This project is licensed under the MIT License. See the LICENSE file for details.
