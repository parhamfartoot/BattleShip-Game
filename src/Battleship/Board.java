package Battleship;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


class Board extends Pane {
	/* A Board has a canvas, the size of this canvas is determined by the setting
	 * at instantiation the background of the board is set and BoardBuilder is called to populate the board.
	 */
    Canvas canvas;

     Board() {

        this.setStyle(Settings.getInstance().backGround);
        //Calls BoardBuilder to populate the board
        new BoardBuilder(this);
        //Add a listener to the board
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){public void handle(MouseEvent e){
            //Handles cursor movement to draw the image on the board
            Move(e);
                Board.this.setOnMouseMoved(
                    new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent e){
                        Move(e);
                        }
                    });
                //Changes the size of stage accordingly
            GameModel.getInstance().stage.setMaxWidth(Settings.getInstance().GetSize()[0]+GameModel.getInstance().chooser.getWidth());
            GameModel.getInstance().stage.sizeToScene();}
            });
    }
    private void Move(MouseEvent e){
        //Draws the ships at the location of the cursor

        if (GameModel.getInstance().shipToPlace != null){
            GameModel.getInstance().GetPlayer().getChildren().remove(GameModel.getInstance().shipToPlace);
            GameModel.getInstance().shipToPlace.setLayoutX(e.getX()+15);
            GameModel.getInstance().shipToPlace.setLayoutY(e.getY()+15);
            Board.this.getChildren().add(GameModel.getInstance().shipToPlace);
        }
    }
    
    /*** Return the Height of this canvas
	 * 
	 */
    public int getH(){
    	return (int)this.canvas.getHeight();
    	}
    
    /*** Return the width of this canvas
	 * 
	 */
    public int getW(){
    	return (int)this.canvas.getWidth();
    	}

    }

