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
---

How to Run the Game
---

1. Clone or Download the game from our git repository.
2. Import the files into your integrated workspace environment.
3. Navigate to the Luncher.jar, located at `GameLuncher -> Luncher.jar `.
4. Run the Java Application by clicking on Luncher.jar.

---

How to Play
---

1. Click on the single or two player version of the game.
2. Choose between *small, medium, or large* for the size of the game board.
3. Player 1 must now place their four ships on the game board.
	3.1 Player can Rotate their pressing keys "Q" and "E".
	3.2 player can player their ship by clicking on a pin that's located at the lower half of the screen.
	3.3 The pin that the players click on will be the top, left most part of the ship based on the rotation. 

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

---
Main Classes:
	
	Functions.java: This class contains all the main static functions used in the game
		IsHit(Circle c): Checks if a shot fired was a hit and then changes the pins accordingly
		
		Align(Circle c): Aligns the ship that player has chosen to place with the board and places it on the board.
		
		Play(View view): Plays the game and chooses what should be displayed based on the state of the game
	
	GameModel.java: This is a singleton class that stores important information about the game such as the boards for each player, the ships 		that need to be placed and etc.

	Pin.java: This class represents the pins that populate the board, when clicked, based on the location of the pin and the state of the game these 	pins call the according functions such as Align() or IsHit().

	Board.java: The board class is what players interact with in order to play the game. At instantiation it call the BoardBuilder to populate the 		board with pins. Also when the mouse is moved on the board , if the player has chosen a ship to place, that ship will be drawn as the cursor 		moves.
	
	View.java: View is our view class in mvc and it is also the observer of GameModel it creates a stage and every time the state of the game and 		the player in GameModel is changed it plays the nest turn.

