package Battleship;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Point2D;
import java.util.ArrayList;

public class Ships {
    /* A Ship has a Width, Height and an Artwork
    each ship has a unique artwork that will be set at instantiation.
    After placement a ship need to be Aligned with the board so that the according pins will be notified of the change.
     */

    protected ArrayList<Pin> Crtitical = new ArrayList<Pin>();
    private int Width;
    private int Height;
    private ImageView img;

    protected Ships(){
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


    void Align(){
        //Aligns the ship with the board, informing the pins that are contained by the ship

        Board board = GameModel.getInstance().GetPlayer();
        for (Node n: board.getChildren()){
            if (n instanceof Circle){
                if (isContained((Circle) n, GameModel.getInstance().shipToPlace.getShip())){
                    ((Circle) n).setFill(Color.GREEN);
                }
            }
        }
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
        corners[0] = new Point2D(image.getX(),image.getY());
        corners[1] = new Point2D(image.getX()+ image.getFitWidth(), image.getY());
        corners[2] = new Point2D(image.getX()+ image.getFitWidth(),image.getY()+ image.getFitHeight());
        corners[3] = new Point2D(image.getX(),image.getY()+ image.getFitHeight());
        return corners;
    }


}
