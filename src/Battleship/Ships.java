package Battleship;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Point2D;

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

    public void setAction(){
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
        img.setFitWidth(Width);
        img.setFitHeight(Height);
    }
    protected ImageView getShip(){ return img; } //Return the ships artwork


    static void Align(Pin pin) {
        //Aligns the ship with the board, informing the pins that are contained by the ship
        ImageView ship = GameModel.getInstance().shipToPlace;
        GameModel.getInstance().GetPlayer().getChildren().remove(GameModel.getInstance().shipToPlace);

        //set the location of the ship's image
        ship.setLayoutX(pin.c.getCenterX() - 25);
        ship.setLayoutY(pin.c.getCenterY() - 25);
        GameModel.getInstance().GetPlayer().getChildren().add(GameModel.getInstance().shipToPlace);
        GameModel.getInstance().count++;

        if (Collides() || Bounded(GameModel.getInstance().shipToPlace)){
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
        Board board = GameModel.getInstance().GetPlayer();
        Point2D[] corners = getImageCorners(image);
        //Compare the edges of the ship with the edges of the board
        for (Point2D point : corners){
            if (point.getX()-10 < board.getLayoutX()-GameModel.getInstance().chooser.getWidth() || point.getX()-10 > board.getLayoutX()+board.getW()-GameModel.getInstance().chooser.getWidth()
                    || point.getY()-15 < board.getLayoutY() || point.getY()-15 > board.getLayoutY()+board.getHeight()){
                return true;}
        }
        return false;
    }
    private static Boolean Collides(){
        //Checks if any of the ships collide
        Board board = GameModel.getInstance().GetPlayer();
        for (Node n: board.getChildren()){
            if (n instanceof Circle){
                if (isContained((Circle) n, GameModel.getInstance().shipToPlace) && ((Circle) n).getFill() == Color.GREEN){
                    return true;
                }
            }
        } return false;
    }
    private static void ColorPin(){
        //Changes the color of the according pins
        Board board = GameModel.getInstance().GetPlayer();
        for (Node n: board.getChildren()){
            if (n instanceof Circle){
                if (isContained((Circle) n, GameModel.getInstance().shipToPlace)){
                    ((Circle) n).setFill(Color.GREEN);
                }
            }
        } GameModel.getInstance().shipToPlace = null;
    }


    private static boolean isContained(Circle circle,ImageView image) {
        //Checks to see if circle of component of a Pin object is inside the ships boundaries

        //Get circle center
        Point2D center = new Point2D(circle.getCenterX(), circle.getCenterY());

        //Get the corners of the ship
        Point2D[] corners = getImageCorners(image);

        //Checks if a circle is bounded by the ship or not
        if (center.getX() < corners[0].getX() || center.getX() > corners[1].getX()){ return false;}//Circle outside the ship on X-axis
        if (center.getY() < corners[1].getY() || center.getY() > corners[2].getY()){ return false;}//Circle outside of the ship on Y axis
        else return true;
    }

    private static Point2D[] getImageCorners(ImageView image) {
        //Finds the corners of the ship's artwork

        Point2D[] corners = new Point2D[4];
        corners[0] = new Point2D(image.getLayoutX(),image.getLayoutY());
        corners[1] = new Point2D(image.getLayoutX()+ image.getFitWidth(), image.getLayoutY());
        corners[2] = new Point2D(image.getLayoutX()+ image.getFitWidth(),image.getLayoutY()+ image.getFitHeight());
        corners[3] = new Point2D(image.getLayoutX(),image.getLayoutY()+ image.getFitHeight());
        return corners;
    }
}
