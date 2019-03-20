package Battleship;

import javafx.application.Application;
import javafx.stage.Stage;

import static Battleship.AudioController.playThemeSong;

public class BattleShip extends Application {

    private View view;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception {

        playThemeSong();
        this.view = new View(stage);

    }

}

