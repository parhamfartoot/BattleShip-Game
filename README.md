Battleship
===

A recreation of the world-renowned game, Battleship, using *java*.

A player has four ships to strategically place on their side of the game board. Players take turns firing shots at the opponent's pins. If a ship is placed on that pin, it is recorded as a *hit*. Otherwise, it is recorded as a *miss*. The objective of the game is to sink all of your opponent's ships.

---

Screenshots
---

![all](https://user-images.githubusercontent.com/47598577/54769544-c368fc00-4bd7-11e9-90a6-ae06c5ed0a89.jpg)

---

Installation
---

*Necessities*

Ensure that you have an updated *Java Runtime Environment* installed on your system. *Java SE Runtime Environment 8* or later suffices. A link to JRE8 is as follows

https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html

An integrated development environment is needed to run this game. We suggest using *Eclipse*. You can download Eclipse from

https://www.eclipse.org/downloads/

---

How to Run the Game
---

1. Clone or Download the game from our git repository.
2. Import the files into your integrated workspace environment.
3. Navigate to the Battleship.java class, located at `src -> Battleship -> Battleship.java`.
4. Run as Java Application using `Alt+Shift+X`.

---

How to Play
---

1. Click on the single or two player version of the game.
2. Choose between *small, medium, or large* for the size of the game board.
3. Player 1 must now place their four ships on the game board.
4. i) The following steps depend on the game mode. If the two-player mode was chosen, it is now Player 2's turn to place their ships.
   
   ii) If single-player mode was chosen, the AI will place its ships randomly.
5. Player 1's turn to attack. Do so by clicking on a pin on the top half of the game board. If the shot is a miss, the pin will turn yellow. If the shot is a hit, the pin will turn red.
6. Player 2 or AI's turn to attack.
7. Repeat steps 5 and 6 until one player eliminates the opposing player's ships.

---

Author Info
---
CSC290H5 Group - ShotCallers

*Team Members*

Parham Fartoot, 1004625355, fartootp

Shaquille David, 1001566931, davidsh4

Neraj Manamperi, 1004275394, manampe4

Sin Hwan Lee, 1001666084, leesin2

Li Rui, 1004056246, lirui31

---

License
---

Built by the group *ShotCallers* in CSC290H5S at the University of Toronto Mississauga, under the MIT License. 

You can find a copy of the License at https://ggyoungboy.wordpress.com/2019/03/21/shotcallers-mit-license/

---

Directory Structure
---

All source code can be found in our `src` directory. This directory contains three main folders, `Art`, `Battleship`, and `Sound`. The *Battleship* folder contains the majority of the code for our game, mainly utilizing the Model-View-Controller design pattern. All artwork can be found in the *Art* folder, and music can be found in the *Sound* folder.

---

Code Documentation
---

In this section, we will overview the major classes and functions in our code. 

`Board.java`

This class instantiates the canvas, which contains the background, pins, and ships. To populate the board, this class calls the `BoardBuilder.java` class. Using the Builder Design Pattern, the board is initialized with a specific height, width and pins. As well, our board class contains code that handles the mouse events for players when placing their ships.

`GameModel.java`

As this GameModel class extends Observable, it keeps track of the Board and all objects associated with it. As well, the GameModel uses the Singleton Design Pattern to ensure that there is only one GameModel being used. In this class, you can find code that allows the game to swtich between players, states, and modes. 

`View.java`

The view class contains the current GameModel, Stage, Menu and BorderPane. This class is imperative for our visual representation. This class handles transition screens and user prompts.


