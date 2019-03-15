package Battleship;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

public class Transition extends StackPane {
    /* Transition is a stack pane and has a canvas and a button.
     * Transition is instantiated at the same size of the board and shares the same background.
     * Transition has a button that when clicked, moves to the next player, allowing them to play
     */
    private Canvas canvas;
    public Button button;

    public Transition(){
        this.canvas = new Canvas(Integer.parseInt(Settings.getInstance().GetSize()[0]), Integer.parseInt(Settings.getInstance().GetSize()[1]));
        this.setStyle(Settings.getInstance().backGround);

        //Button used for moving to the next player so they can play their turn
        this.button= new Button("Next Player!");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        Clicked(e);
                    }
                });
        button.setPrefWidth(200);
        button.setPrefHeight(100);
        this.getChildren().add(this.canvas);
        this.getChildren().add(button);
    }
    private void Clicked(MouseEvent e) {
        GameModel.getInstance().ChangeState();
    }
}
