package Battleship;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Board extends Pane {

    private Canvas canvas;
    private ArrayList<Pin> pins = new ArrayList<Pin>();

    public Board() {

        this.canvas = new Canvas(Integer.parseInt(Settings.getInstance().GetSize()[0]), Integer.parseInt(Settings.getInstance().GetSize()[1]));
        this.getChildren().add(this.canvas);
        // Set the background image
        this.setStyle("-fx-background-image: url('" + "/Art/BackGround/nebula_1.gif" + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;"+"-fx-background-size: cover;");

        new BoardBuilder(this);

    }
    public void addPin(Pin pin){this.pins.add(pin);}

    public ArrayList<Pin> getPins() {return pins;}

    public int getH(){return (int)this.canvas.getHeight(); }

    public int getW(){return (int)this.canvas.getWidth(); }

    }
