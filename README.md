
## Blackjack Project
### Week 4 Skill Distillery Homework Project

#### Overview
This is a java program for simulating a blackjack game. The user can "buy" chips to bet with while playing hands of blackjack against the dealer.
Once initialized the program will loop prompts for user input until the user exits the program with the corresponding menu option. The program utilizes the shell to display text to the user and take keyboard input. 

The program utilizes many classes as well as Enumerators. Eleven in total organized in four separate packages. There are object classes for Players, Hands, Pots, Cards and Decks. The card class is defined by its Rank and Suit Enumerators. The BlackjackDealer class is a child of the same Player class as the user BlackjackPlayer is derived from but contains more methods as well as a Deck object to interact with. The application class utilizes all of these object classes to create communication interactions with each other in a way that simulates a blackjack game.

#### Technologies Used
_Java_ 
- OOP
- Enumerators
- Polymorphism
- Abstraction
- Inheritance
- Encapsulation
- Override Methods
- Overloaded Constructors

_Eclipse_

#### How to Run
1. Launch the Java application.
2. The program will display to the user a menu from which they can pick from 3 options to play blackjack, buy chips or quit the application by entering the corresponding integer value of their choice.
3. The user may select to buy chips with which they can bet on games of blackjack through menu option 2.
4. The user can play a game of blackjack at which point they will be asked to enter how much they would like to bet. Then they will be dealt into a game and displayed their hand, the dealers hand, and another menu from which they can choose to hit, stay or fold.
5. Once the player stays, busts or hits 21 the dealer will play, then the program will then calculate and display the winner before redisplaying the menu from step 2.
6. Should the user fold they will be redisplayed the menu from step 2.

#### Lessons Learned
It was easy to learn from the building of this application on top of the enjoyment I gained working on it. I could see myself getting lost in adding features to the game should I have the time. I made it a point to add betting to the game even though it was not required, but I feel my ability to do so further proves to myself the understanding I have established of Java and OOP. The application felt like a fun logical puzzle I had to fit the pieces (or objects) into in the desired order.

Another new concept I implemented was the use of Enumerators to define a set of values for a couple variables. I used these to define both the Card class's Rank and Suit. I can definitely see the use for these special objects in java applications and will be utilizing them in the future.
