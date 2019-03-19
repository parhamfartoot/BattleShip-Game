package Battleship;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
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

        //Add a listener to the board
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){public void handle(MouseEvent e){
            //Draw the image on the board, as the coarser is moved around
                Board.this.setOnMouseMoved(
                    new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent e){
                        if (GameModel.getInstance().shipToPlace != null){
                            //Removes the ship at the old location
                                GameModel.getInstance().GetPlayer().getChildren().remove(GameModel.getInstance().shipToPlace);
                            //Draws the ship at the new location
                            GameModel.getInstance().shipToPlace.setLayoutX(e.getX()-15);
                            GameModel.getInstance().shipToPlace.setLayoutY(e.getY()-15);
                            Board.this.getChildren().add(GameModel.getInstance().shipToPlace);
                            }
                        }
                    });
                }
            });
    }


    public int getH(){return (int)this.canvas.getHeight(); } // returns the height of the canvas

    public int getW(){return (int)this.canvas.getWidth(); } // returns the width of the canvas

    }

