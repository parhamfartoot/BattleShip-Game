package Battleship;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
}
