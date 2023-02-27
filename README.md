Project Description

This is a Java project for a Christmas gift distribution program. The program receives input data about children's preferences and nice scores, as well as updates to this data for subsequent years, and then calculates a score for each child based on their average nice score and age group. The program also calculates the total score for each city based on the average score of its children and the number of children in the city.

The project contains the following files:

Main.java: the main class used to run the program and call the Checker class to calculate the score
Input.java: a class used to represent the input data
Output.java: a class used to represent the output data
Child.java: a class used to represent the children's data, such as id, name, age, city, nice scores, and preferences
ChildUpdate.java: a class used to represent the updates to the children's data for subsequent years
AnnualChanges.java: a class used to represent the updates to the children's data for each year
Score.java: a class used to represent the children's scores, with id and average score
City.java: a class used to represent the cities' scores, with city name, total score, and number of people
Present.java: a class used to represent the presents' data, such as id, name, size, and price
Checker.java: a class used to calculate the score for each child and city based on the input data
The project also includes a set of input files (test*.json) that can be used to test the program.

How to Use

To run the program, simply compile and run the Main.java class. The program will read the input data from the test*.json files and calculate the score for each child and city based on the input data. The program will then output the results to the console.

Dependencies
The project uses the following dependencies:

com.fasterxml.jackson.databind.ObjectMapper: a library used to read the input data from the test*.json files
To compile and run the program, make sure that these dependencies are installed and included in the classpath.

License
This project is licensed under the MIT License - see the LICENSE file for details.
