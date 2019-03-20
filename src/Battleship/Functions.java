package Battleship;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static Battleship.AI.AI_Fire;
import static Battleship.AI.AI_FleetPlacement;
import static Battleship.AudioController.playExplosionSound;
import static Battleship.AudioController.playLaserSound;

public class Functions {
    Functions(){}

    static Boolean Align(Circle c) {
        //Aligns the ship with the board, informing the pins that are contained by the ship
        GameModel.getInstance().GetPlayer().getChildren().remove(GameModel.getInstance().shipToPlace);
        //set the location of the ship's image

        //Check for rotation
        if (GameModel.getInstance().shipToPlace.getRotate()%180 ==0){
            GameModel.getInstance().shipToPlace.setLayoutX(c.getCenterX()-25);
            GameModel.getInstance().shipToPlace.setLayoutY(c.getCenterY() -25);
        }else {
            if (GameModel.getInstance().shipToPlace.getFitWidth() ==50)
            {
                GameModel.getInstance().shipToPlace.setLayoutX(c.getCenterX()+GameModel.getInstance().shipToPlace.getFitHeight()/2
                        -GameModel.getInstance().shipToPlace.getFitWidth());
                GameModel.getInstance().shipToPlace.setLayoutY(c.getCenterY()+GameModel.getInstance().shipToPlace.getFitWidth()/2
                        -GameModel.getInstance().shipToPlace.getFitHeight()/2 -25);
            }else {
                GameModel.getInstance().shipToPlace.setLayoutX(c.getCenterX()+GameModel.getInstance().shipToPlace.getFitHeight()/2
                        -GameModel.getInstance().shipToPlace.getFitWidth()+25);
                GameModel.getInstance().shipToPlace.setLayoutY(c.getCenterY()+GameModel.getInstance().shipToPlace.getFitWidth()/2
                        -GameModel.getInstance().shipToPlace.getFitHeight()/2 -25);}

        }
        GameModel.getInstance().GetPlayer().getChildren().add(0,
                GameModel.getInstance().shipToPlace);
        GameModel.getInstance().count++;

        if (Collides() || !Bounded()){
            //if the ship collides, remove the ship

            GameModel.getInstance().GetPlayer().getChildren().remove(GameModel.getInstance().shipToPlace);
            GameModel.getInstance().count--;
            return false;
        } else {
            //if the ship doesnt collide , color the pins and disable them
            ColorPin();return true;
        }

    }
    private static Boolean Bounded(){
        //Check if the ship is bounded by the board
        Bounds r1Bounds = GameModel.getInstance().shipToPlace.getBoundsInParent();
        Bounds r2Bounds = GameModel.getInstance().GetPlayer().getLayoutBounds();
        //Compare the edges of the ship with the edges of the board
        if(r2Bounds.contains(r1Bounds)){return true;}
        return false;
    }
    private static Boolean Collides(){
        //Checks if any of the ships collide
        Bounds r1Bounds = GameModel.getInstance().shipToPlace.getBoundsInParent();
        Board board = GameModel.getInstance().GetPlayer();
        for (Node n: board.getChildren()){
            if (n instanceof Circle){
                Bounds r2Bounds = n.getBoundsInParent();
                //if any of the pins bounded by ship are green that would mean, collision
                if (r2Bounds.intersects(r1Bounds) && ((Circle) n).getFill() == Color.GREEN){
                    return true;
                }
            }
        }
        return false;
    }
    private static void ColorPin(){
        //Changes the color of the Pins that are bounded by the image
        Board board = GameModel.getInstance().GetPlayer();
        Bounds r1Bounds = GameModel.getInstance().shipToPlace.getBoundsInParent();
        for (Node n: board.getChildren()){
            if (n instanceof Circle){
                Bounds c1Bounds = n.getBoundsInParent();
                if (c1Bounds.intersects(r1Bounds)){
                    ((Circle) n).setFill(Color.GREEN);
                }
            }
        } GameModel.getInstance().shipToPlace = null;
    }
    static void Rotate(Scene scene) {
        //set the keyHandler to implement rotation
        scene.setOnKeyPressed((event) -> {
            if (GameModel.getInstance().shipToPlace != null){
                if (event.getCode() == KeyCode.E) {
                    //If E is pressed rotate clockwise
                    GameModel.getInstance().shipToPlace.setRotate(GameModel.getInstance().shipToPlace.getRotate()+90);
                }
                else if (event.getCode() == KeyCode.Q) {
                    //If Q is pressed rotate Counter-Clockwise
                    GameModel.getInstance().shipToPlace.setRotate(GameModel.getInstance().shipToPlace.getRotate()-90);
                }}
        });
    }

    static void Play(View view){

        // If the game is in transition phase Displays the Transition, otherwise the according board
        if (GameModel.getInstance().State()) {
            view.getRoot().setCenter(GameModel.getInstance().GetPlayer());
            if (!GameModel.getInstance().GetMode() && GameModel.getInstance().Player() ==2){
                if (GameModel.getInstance().IsInitPhase()){AI_FleetPlacement();}
                else  AI_Fire();
            }
            if (GameModel.getInstance().IsInitPhase()){
                GameModel.getInstance().chooser = new ShipChooser();
                view.getRoot().setLeft(GameModel.getInstance().chooser);}
        } else {
            //Check if a player has won the game
            if (GameModel.getInstance().GetScore() == 700) {view.getRoot().setCenter(new WinScreen());}
            else view.getRoot().setCenter(new Transition());
        }
    }
    static void IsHit(Circle c){
        //Checks if the shot fires was a hit and acts accordingly
        playLaserSound();
        double hitX = c.getCenterX(); //appropriate X-axis value of shot fired on enemy board
        double hitY = c.getCenterY() + Settings.getInstance().GetSize()[1]/2; //appropriate Y-axis value of shot fired on enemy board
        Board board = GameModel.getInstance().GetEnemy(); //Enemies board

        for (Node n: board.getChildren()){
            if (n instanceof Circle){
                if (((Circle) n).getCenterY() == hitY && ((Circle) n).getCenterX() == hitX)
                {
                    if (((Circle) n).getFill().equals(Color.GREEN)) //Checks if a ship has been placed on that pin
                    {
                        // Changes the color of pins to red if shot was a hit
                        ((Circle) n).setFill(Color.RED);
                        c.setFill(Color.RED);
                        playExplosionSound();
                        //Adds to the players score
                        GameModel.getInstance().AddScore();
                        //Set the text accordingly
                        GameModel.getInstance().setShot("Your shot was a hit");
                    }
                    else {c.setFill(Color.YELLOW);GameModel.getInstance().setShot("Your shot was a miss");} //Change color to yellow if the shot was a miss

                }
            }
        }if (GameModel.getInstance().GetScore() == 700) {GameModel.getInstance().view.getRoot().setCenter(new WinScreen());}else {
        GameModel.getInstance().ChangeState();
            GameModel.getInstance().ChangePlayer();}
    }
}
