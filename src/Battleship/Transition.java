package Battleship;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

public class Transition extends StackPane {
    private Canvas canvas;
    public Button button;

    public Transition(){
        this.canvas = new Canvas(Integer.parseInt(Settings.getInstance().GetSize()[0])+100, Integer.parseInt(Settings.getInstance().GetSize()[1]));
        this.setStyle(Settings.getInstance().backGround);

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
