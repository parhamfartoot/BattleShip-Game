package Battleship;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

class Board extends StackPane{

    private Canvas canvas;
    private ArrayList<Pin> pins = new ArrayList<Pin>();

    public Board() {

        this.canvas = new Canvas(Integer.parseInt(Settings.getInstance().GetSize()[0]), Integer.parseInt(Settings.getInstance().GetSize()[1]));
        this.getChildren().add(this.canvas);
        // The canvas is transparent, so the background color of the
        // containing pane serves as the background color of the canvas.
        this.setStyle("-fx-background-color: white");
        new BoardBuilder(this);

    }
    public void addPin(Pin pin){this.pins.add(pin);}

    public ArrayList<Pin> getPins() {return pins;}

    public int getH(){return (int)this.canvas.getHeight(); }

    public int getW(){return (int)this.canvas.getWidth(); }

    }
