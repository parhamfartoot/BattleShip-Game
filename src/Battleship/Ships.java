package Battleship;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Ships {
    protected ArrayList<Pin> Crtitical = new ArrayList<Pin>();
    private int Width;
    private int Height;
    private ImageView img;
    private Image Ship;

    protected Ships(){

    }

    protected void setW(int W){ this.Width = W; }
    protected void setH(int H){this.Height = H; }

    int getW(int W){ return Width; }
    int getH(int H){return Height; }

    protected void setArt(String s){
        this.Ship= new Image(s);
        this.img =new ImageView(Ship);
        img.setFitWidth(Width);
        img.setFitHeight(Height);
    }
    protected ImageView getShip(){
        return img;
    }

    protected Image getImage(){
        return this.Ship;
    }

}
