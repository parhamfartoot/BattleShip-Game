package Battleship;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ships {
    /* A Ship has a Width, Height and an Artwork
    each ship has a unique artwork that will be set at instantiation.
    After placement a ship need to be Aligned with the board so that the according pins will be notified of the change.
     */
    private int Width;
    private int Height;
    private ImageView img;

    protected Ships(){
    }

    void setAction(){
        //Add a listener to the ship's image
            this.img.setOnMouseClicked(
                new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent e){
                        Clicked();
                    }
                });
    }
    private void Clicked() {
        // get the ships image on click to be placed
        if (GameModel.getInstance().shipToPlace == null && ! GameModel.getInstance().GetPlayer().getChildren().contains(this.getShip()))
            GameModel.getInstance().shipToPlace = this.getShip();

    }
    protected void setW(int W){ this.Width = W; } //Set the Width of ship
    protected void setH(int H){this.Height = H; } //Set the Height of ship

    protected void setArt(String s){
        //Sets the Artwork of the ship
        this.img =new ImageView(new Image(s));
        this.img.setFitWidth(Width);
        this.img.setFitHeight(Height);
    }
    protected ImageView getShip(){ return this.img; } //Return the ships artwork


    static void Align(Pin pin) {
        //Aligns the ship with the board, informing the pins that are contained by the ship
        GameModel.getInstance().GetPlayer().getChildren().remove(GameModel.getInstance().shipToPlace);
        //set the location of the ship's image

        //Check for rotation
        if (GameModel.getInstance().shipToPlace.getRotate()%180 ==0){
            GameModel.getInstance().shipToPlace.setLayoutX(pin.c.getCenterX()-25);
            GameModel.getInstance().shipToPlace.setLayoutY(pin.c.getCenterY() -25);
        }else {
            if (GameModel.getInstance().shipToPlace.getFitWidth() ==50)
            {
                GameModel.getInstance().shipToPlace.setLayoutX(pin.c.getCenterX()+GameModel.getInstance().shipToPlace.getFitHeight()/2
                        -GameModel.getInstance().shipToPlace.getFitWidth());
                GameModel.getInstance().shipToPlace.setLayoutY(pin.c.getCenterY()+GameModel.getInstance().shipToPlace.getFitWidth()/2
                        -GameModel.getInstance().shipToPlace.getFitHeight()/2 -25);
            }else {
            GameModel.getInstance().shipToPlace.setLayoutX(pin.c.getCenterX()+GameModel.getInstance().shipToPlace.getFitHeight()/2
                    -GameModel.getInstance().shipToPlace.getFitWidth()+25);
            GameModel.getInstance().shipToPlace.setLayoutY(pin.c.getCenterY()+GameModel.getInstance().shipToPlace.getFitWidth()/2
                    -GameModel.getInstance().shipToPlace.getFitHeight()/2 -25);}

        }
        GameModel.getInstance().GetPlayer().getChildren().add(GameModel.getInstance().shipToPlace);
        GameModel.getInstance().count++;

        if (Collides() || !Bounded(GameModel.getInstance().shipToPlace)){
            //if the ship collides, remove the ship
            GameModel.getInstance().GetPlayer().getChildren().remove(GameModel.getInstance().shipToPlace);
            GameModel.getInstance().count--;
        } else {
            //if the ship doesnt collide , color the pins and disable them
            ColorPin();pin.hasClicked =true;
        }

    }
    private static Boolean Bounded(ImageView image){
        //Check if the ship is bounded by the board
        Bounds r1Bounds = GameModel.getInstance().shipToPlace.getBoundsInParent();
        Bounds r2Bounds = GameModel.getInstance().GetPlayer().getBoundsInParent();
        //Compare the edges of the ship with the edges of the board
        if(r2Bounds.intersects(r1Bounds)){return true;}
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
        } return false;
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
}
