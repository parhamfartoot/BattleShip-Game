package Battleship;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

class Board extends Pane {
    /* A has a canvas, the size of this canvas is determined by the setting
     * At instantiation the background of the board is set and BoardBuilder is called to populate the board
     */

    private Canvas canvas;

    public Board() {

        //Create the canvas and add it to the childrens
        this.canvas = new Canvas(Integer.parseInt(Settings.getInstance().GetSize()[0]), Integer.parseInt(Settings.getInstance().GetSize()[1]));
        this.getChildren().add(this.canvas);

        // Set the background image
        this.setStyle(Settings.getInstance().backGround);
        //Calls BoardBuilder to populate the board
        new BoardBuilder(this);

    }

    public int getH(){return (int)this.canvas.getHeight(); } // returns the height of the canvas

    public int getW(){return (int)this.canvas.getWidth(); } // returns the width of the canvas

    }

