
## Blackjack Project
### Week 4 Skill Distillery Homework Project

#### Overview
This is a java program for simulating a blackjack game. The user can play hands of blackjack against the dealer.

Once initialized the program will loop prompts for user input until the user exits the program with the corresponding menu option. The program utilizes the shell to display text to the user and take keyboard input. 

The program utilizes many classes as well as Enumerators. Ten in total organized in four separate packages. There are object classes for Players, Hands, Cards and Decks. The card class is defined by its Rank and Suit Enumerators. The BlackjackDealer class is a child of the same Player class as the user BlackjackPlayer is derived from but contains more methods as well as a Deck object to interact with. The application class utilizes all of these object classes to create communication interactions with each other in a way that simulates a blackjack game.

#### Technologies Used
_Java_ 
- OOP
- Constructors
- Instantiation 
- Array Lists
- Enumerators
- Polymorphism
- Abstraction
- Inheritance
- Encapsulation
- Override Methods

_Eclipse_

#### How to Run
1. Launch the Java application.
2. The program will display to the user a menu from which they can pick from 2 options to play blackjack or quit the application by entering the corresponding integer value of their choice.
3. The user may select to play play a game of blackjack at which point the will be dealt into a game and displayed their hand, the dealers hand, and another menu from which they can choose to hit, stay or fold.
4. Once the player stays or busts the dealer will play, then the program will then calculate and display the winner before redisplaying the menu from step 2.
5. Should the user fold they will be redisplayed the menu from step 2.

#### Lessons Learned
This food truck application really challenged me in the right way and enforced the solidification of my understanding of objects and object oriented programming in general. Working with arrays of objects and their data from a different/separate (application) class was the most important thing I learned from this project. It is important to keep data as private and protected as possible and this requires constructors as well as getters and setters along with other methods for interacting with objects and their data. 

Understanding the static keyword and its purpose has been valuable in refining the working structure of my programs. There were instances in both classes of the program in which I used static variables in order maintain a single entity shared by all instantiations.

Although the final keyword did not end up in my final program I did use it a few times in development and after coming to a better understanding of what does it was removed from the application but I am glad I worked with it as I feel more knowledgeable in its use.


