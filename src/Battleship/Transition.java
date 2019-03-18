package Battleship;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

class Transition extends StackPane {
    /* Transition is a stack pane and has a canvas and a button.
     * Transition is instantiated at the same size of the board and shares the same background.
     * Transition has a button that when clicked, moves to the next player, allowing them to play
     */
    Transition(){
        Canvas canvas = new Canvas(Integer.parseInt(Settings.getInstance().GetSize()[0]), Integer.parseInt(Settings.getInstance().GetSize()[1]));
        this.setStyle(Settings.getInstance().backGround);

        //Shows the state of the players shot
        Text shotState = new Text(GameModel.getInstance().HitState());
        //Setting the font of the text
        shotState.setFont(Font.font(null, FontWeight.BOLD, 25));
        //Setting the color of the text
        shotState.setFill(Color.WHITE);
        //setting the position of the text
        shotState.setTranslateY(-150);

        //Score board that shows the player score
        Text score = new Text("Your score is : "+Integer.toString(GameModel.getInstance().GetScore()));
        //Setting the font of the text
        score.setFont(Font.font(null, FontWeight.BOLD, 25));
        //Setting the color of the text
        score.setFill(Color.WHITE);
        //setting the position of the text
        score.setTranslateY(-200);

        //Button used for moving to the next player so they can play their turn
        Button button= new Button("Next Player!");

        button.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        Clicked(e);
                    }
                });
        //Sets the size of the button
        button.setPrefWidth(200);
        button.setPrefHeight(100);

        //Adds the components to the StackPane
        this.getChildren().add(canvas);
        this.getChildren().add(button);
        this.getChildren().add(0,score);
        //Show the state of the shot if a shot has been made
        if (!GameModel.getInstance().IsInitPhase()) this.getChildren().add(shotState);
    }
    private void Clicked(MouseEvent e) {
        GameModel.getInstance().ChangeState();
    }
}
