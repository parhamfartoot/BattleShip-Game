Battleship
===

A recreation of the world-renowned game, Battleship, using *Java* and *JavaFX*.

A player has four ships to strategically place on their side of the game board. Players take turns firing shots at the opponent's pins. If a ship is placed on that pin, it is recorded as a *hit*. Otherwise, it is recorded as a *miss*. The objective of the game is to sink all of your opponent's ships.

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
From the IDE:
1. Clone or Download the game from our git repository.
2. Import the files into your integrated workspace environment.
3. Navigate to the Battleship.java class, located at `src -> Battleship -> Battleship.java`.
4. Run as Java Application using `Alt+Shift+X`.

From Luncher:
1. Clone or Download the game from our git repository.
3. Navigate to the Luncher.jar , located at `GameLuncher -> Luncher.jar`.
4. Run as Java Application.


---

How to Play
---

1. Click on the single or two player version of the game.
2. Choose between *small, medium, or large* for the size of the game board.
3. Player 1 must now place their four ships on the game board.
    i) Player can select their ships by clicking on the ship icons located at the left most side of the screen.
    ii) After selecting a ship the player can rotate the ship by pressing "Q" or "E".
    ii) By clicking on a pin that located at the lower hakf of the board you can place your ship. The top-left part of your ship considering rotation will be the pin you have clicked.
4. i) The following steps depend on the game mode. If the two-player mode was chosen, it is now Player 2's turn to place their ships.
   
   ii) If single-player mode was chosen, the AI will place its ships randomly.
5. Player 1's turn to attack. Do so by clicking on a pin on the top half of the game board. If the shot is a miss, the pin will turn yellow. If the shot is a hit, the pin will turn red.
6. Player 2 or AI's turn to attack.
7. Repeat steps 5 and 6 until one player eliminates the opposing player's ships.

---

Directory Structure
---

All source code can be found in our `src` directory. This directory contains three main folders, `Art`, `Battleship`, and `Sound`. The *Battleship* folder contains the majority of the code for our game, mainly utilizing the Model-View-Controller design pattern. All artwork can be found in the *Art* folder, and music can be found in the *Sound* folder.

---

Code Documentation
---

In this section, we will overview the major classes and functions in our code. 

**`Board.java`**

This class instantiates the canvas, which contains the background, pins, and ships. To populate the board, this class calls the `BoardBuilder.java` class. Using the Builder Design Pattern, the board is initialized with a specific height, width and pins. Most importantly, the board class contains code that handles the mouse events for players when placing their ships:

```
 private void Move(MouseEvent e){     
        if (GameModel.getInstance().shipToPlace != null){
            GameModel.getInstance().GetPlayer().getChildren().remove(GameModel.getInstance().shipToPlace);
            GameModel.getInstance().shipToPlace.setLayoutX(e.getX()+15);
            GameModel.getInstance().shipToPlace.setLayoutY(e.getY()+15);
            Board.this.getChildren().add(GameModel.getInstance().shipToPlace);
        }
    }
```

When the player clicks on the ship, it removes it from the ChooserPanel and follows the mouse cursor. When clicked on an appropriate pin, the ship is placed on the Board. To make it easier for the player to see which pin their ship is being placed on, we offset the x and y location by 15 units each. 

**`GameModel.java`**

As this GameModel class extends Observable, it keeps track of the Board and all objects associated with it. As well, the GameModel uses the Singleton Design Pattern to ensure that there is only one GameModel being used. We see this as `static GameModel getInstance()` is automatically set to `single_instance`. 

This class contains code that allows the game to swtich between players, states, and modes. This class contains many helper functions that are used across the repository, such as `int GetScore()`, `void MakeBoard()`, and `void setMultiplayer`. 

**`View.java`**

The view class contains the current GameModel, Stage, Menu and BorderPane. This class is imperative for our visual representation. This class handles transition screens and user prompts.

The main function in this class `public void update`:

```
public void update(Observable o, Object arg) {
        root.getChildren().clear();
        if (model.getSelection() > 1) {
            try {
                Play(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.setTitle("Player " + model.Turn());
        } else {
            this.root.setCenter(new Menu(model.getSelection()));
            stage.setTitle("Player " + model.Turn());
        }
```
        
First, `public void update` ensures that the Pane is clear. Then, in a try-catch block, it runs the game if possible. This presents the Start Menu to the user. Otherwise, it will recognize that the game is already in progress. Update will identify which player is to take their turn, and will prompt them with a visual. Behind the scences, `update` notifies observers when it is time to switch.

**`Functions.java`**
The Function class contains all static functions used in the game. These functions handle some of the main parts of the game throughout the code.
The functions include but are not limited to :
`static void IsHit(Circle c) `:
        Checks to see if a shot was a hit or not, and then reacts accordingly by changing the color of the pin and changing the player.
        
`static void Play(View view)`:
        Plays the game and chooses what to do and what other static functions to call based on the player and the state of the game store in the GameModel.
`static Boolean Align(Circle c)`:
        Places the ship on the board by aliugning it with the Pin that has been clicked. Then it checks to see if the placed ship follows all the game rules (inside the boundries of the board, overlapping ships and etc.) accordingly it choses to remove the ship or to change the color of the pins contained by the ship.
        

=======
---

License
---

Built by the group *ShotCallers* in CSC290H5S at the University of Toronto Mississauga, under the MIT License. 

You can find a copy of the License at https://ggyoungboy.wordpress.com/2019/03/21/shotcallers-mit-license/



