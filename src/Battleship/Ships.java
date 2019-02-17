package Battleship;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

class Ships {
    ArrayList<Pin> Crtitical = new ArrayList<Pin>();
    private int Width;
    private int Height;
    private ImageView img;

    public Ships(){

    }

    void setW(int W){ this.Width = W; }
    void setH(int H){this.Height = H; }

    void setArt(String s){
        Image Ship = new Image(s);
        this.img =new ImageView(Ship);
        img.setFitWidth(Width);
        img.setFitHeight(Height);
    }
    ImageView getShip(){
        return img;
    }

}
