package Battleship;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static Battleship.Functions.Align;
import static Battleship.Functions.IsHit;

public class Pin
{
    /* The pin has a circle of radius 9 and color white.
     * Every time the circle component of a pin is clicked on, based on the information about the state of the game stored in GameModel
     * the pin will act accordingly (Change color, go to the next player and etc.)
     */
    Circle c;
    Boolean hasClicked;

    Pin(int x1, int y1) {
        // Create a circle object for the pin and add a listiner to the circle

        this.c = new Circle(x1, y1,9, Color.WHITE);//Add the circle for the pin
        this.hasClicked = false;//Shows if the pin has been clicked yet or not

        this.c.setOnMouseClicked(
            new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                        Clicked(e);
                }
            });
    }

    // The handler of the click
    void Clicked(MouseEvent e){
        GameModel model = GameModel.getInstance();

        if (model.IsInitPhase()){
            // Check if the game is at the placement phase
            if (this.c.getCenterY() > Settings.getInstance().GetSize()[1]/2){
                // Checks if the player has clicked on the appropriate half of the map and that pin has not been clicked before
                if ((model.shipToPlace != null)&& !this.hasClicked) {
                    // Places the ship that has been chosen by player on the board

                    if(Align(this.c)) this.hasClicked = true;

                    // If the player has placed all their ships, moves to the next player
                    if (model.count == 4) {
                        model.count = 0;
                        model.Start();
                        model.ChangeState();
                        model.ChangePlayer();
                    }
                }


            }
        }
        else { //The game is not in the placement phase
            //Checks if the enemy half of the board has been clicked
                if((this.c.getCenterY() < Settings.getInstance().GetSize()[1]/2)&& !this.hasClicked){
                    // Checks if the fire was a hit and Changes the player
                    IsHit(this.c);
                    this.hasClicked =true;
                        }
                    }
                }
}
