package Battleship;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

class Board extends Pane {

    private Canvas canvas;

    public Board() {

        this.canvas = new Canvas(Integer.parseInt(Settings.getInstance().GetSize()[0]), Integer.parseInt(Settings.getInstance().GetSize()[1]));
        this.getChildren().add(this.canvas);
        // Set the background image
        this.setStyle("-fx-background-image: url('" + "/Art/BackGround/nebula_1.gif" + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;"+"-fx-background-size: cover;");

        //Calls BoardBuilder to populate the board
        new BoardBuilder(this);

    }

    public int getH(){return (int)this.canvas.getHeight(); }

    public int getW(){return (int)this.canvas.getWidth(); }

    }
