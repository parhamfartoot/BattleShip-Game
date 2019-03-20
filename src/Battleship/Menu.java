package Battleship;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

//author Sin Hwan Lee, 1001666084, leesin2

public class Menu extends FlowPane {
	/* Start Menu shown pre-game and contains settings for the
	 * game to be selected. 
	 */
    public Button button1, button2, button3;

    public Menu(int selection){
    	// Pane Settings

    	//this.setMinSize(Settings.getInstance().GetSize()[0], Settings.getInstance().GetSize()[1]);
		this.setMinSize(1000, 1000);
    	this.setPadding(new Insets(5, 0, 5, 0));

    	this.setVgap(4);
    	this.setHgap(4);
    	this.setStyle("-fx-background-color: DAE6F3");
    	
    	// Single or Multi-Player Selection Menu
    	if (selection == 0){
	    		this.button1= createMenuButton("Single Player!");
	            this.button2 = createMenuButton("Two Player!");
	            
	    		button1.addEventHandler(MouseEvent.MOUSE_CLICKED,
	                    new EventHandler<MouseEvent>() {
	                        @Override public void handle(MouseEvent e) {
	                        	SinglePlayerClicked(e);
	                        }
	                    });
	            
	            
	            
	            button2.addEventHandler(MouseEvent.MOUSE_CLICKED,
	                    new EventHandler<MouseEvent>() {
	                        @Override public void handle(MouseEvent e) {
	                            MultiPlayerClicked(e);
	                        }
	                    });
	            
	            this.getChildren().add(button1);
	            this.getChildren().add(button2);
	            
	    //  Board Size Selection Menu
    	} else if (selection == 1){
    		
    		this.button1= createMenuButton("Small");
            this.button2 = createMenuButton("Medium");
            this.button3 = createMenuButton("Large");

    		button1.addEventHandler(MouseEvent.MOUSE_CLICKED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                        	SmallClicked(e);
                        }
                    });

            button2.addEventHandler(MouseEvent.MOUSE_CLICKED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                        	MediumClicked(e);
                        }
                    });
            
            button3.addEventHandler(MouseEvent.MOUSE_CLICKED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                        	LargeClicked(e);
                        }
                    });
            
            this.getChildren().add(button1);            
            this.getChildren().add(button2);
            this.getChildren().add(button3);
    	}
    }
    public Button createMenuButton(String msg){
    	Button button = new Button(msg);
		button.setPrefWidth(1000+100);
		button.setPrefHeight(100);
    	return button;
    }
    private void SinglePlayerClicked(MouseEvent e) {
    	GameModel.getInstance().setMultiplayer(false);
        GameModel.getInstance().NextSelection();
    }
    private void MultiPlayerClicked(MouseEvent e) {
    	GameModel.getInstance().setMultiplayer(true);
        GameModel.getInstance().NextSelection();
    }
    private void SmallClicked(MouseEvent e) {
		//Set the size of board to small
    	Settings.getInstance().SetSize(350,500);
		GameModel.getInstance().stage.setMaxHeight(525);
		GameModel.getInstance().MakeBoard();
        GameModel.getInstance().NextSelection();
    }
    private void MediumClicked(MouseEvent e) {
		//Set the size of board to medium
    	Settings.getInstance().SetSize(500,700);
		GameModel.getInstance().stage.setMaxHeight(725);
		GameModel.getInstance().MakeBoard();
		GameModel.getInstance().NextSelection();

    }
    private void LargeClicked(MouseEvent e) {
		//Set the size of board to large
		Settings.getInstance().SetSize(650,900);
		GameModel.getInstance().stage.setMaxHeight(925);
		GameModel.getInstance().MakeBoard();
        GameModel.getInstance().NextSelection();
    }
}