
## Blackjack Project
### Week 4 Skill Distillery Homework Project

#### Overview
This is a java program for entering data for a number of food trucks and processing their ratings. The program can calculate the average rating as well as the highest rated truck and display it to the user.
Once initialized the program will loop prompts for user input until the user exits the program with the corresponding menu option. The program utilizes the shell to display text to the user and take keyboard input. 

The program is two classes. One food truck object class and an application class which instantiates an array of food truck objects of the user's desired length. The object class contains several fields but only one of them is static, the food truck count. The food truck object class also contains overridden constructors as well as getters and setters. The application classes main method calls two other classes, one for the input of the food truck data and one for processing it.

#### Technologies Used
_Java_ 
- Object Oriented Programming
- Constructors
- Compartmentalization
- Instantiation 
- Static Fields and Methods
- Object Arrays

_Eclipse_

#### How to Run
1. Launch the Java application.
2. The program will prompt the user to enter the number of food trucks for which data will be entered. Enter with the keyboard a numerical value of type integer and press Enter.
3. The user will be prompted to enter the name of the first food truck. Enter with the keyboard a String value and press Enter.
	* 3a. The user may enter "quit" here to exit data entry. This food truck will be ignored in data processing later.
4. The user will be prompted to enter the type of the first food truck. Enter with the keyboard a String value and press Enter.
	* 4a. The user may enter "quit" here to exit data entry but this food truck will be given default values which will affect data processing later. This should be avoided until data can be modified.
5. The user will be prompted to enter the rating of the first food truck. Enter with the keyboard a double value between 0 and 5 and press Enter.
	* 5a. The user may enter "quit" here to exit data entry but this food truck will be given default values which will affect data processing later. This should be avoided until data can be modified.
6. Steps 3 through 5 will be repeated for the number food trucks entered in step 2.
7. The program will display to the user a menu from which they can pick from 4 options to process data or quit the application by entering the corresponding integer value of their choice.
	* 7a. The menu will be displayed again after each choice unless the user should pick option 4 which will terminate the application.

#### Lessons Learned
This food truck application really challenged me in the right way and enforced the solidification of my understanding of objects and object oriented programming in general. Working with arrays of objects and their data from a different/separate (application) class was the most important thing I learned from this project. It is important to keep data as private and protected as possible and this requires constructors as well as getters and setters along with other methods for interacting with objects and their data. 

Understanding the static keyword and its purpose has been valuable in refining the working structure of my programs. There were instances in both classes of the program in which I used static variables in order maintain a single entity shared by all instantiations.

Although the final keyword did not end up in my final program I did use it a few times in development and after coming to a better understanding of what does it was removed from the application but I am glad I worked with it as I feel more knowledgeable in its use.


