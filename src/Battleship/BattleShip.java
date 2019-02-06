package Battleship;

import javafx.application.Application;
import javafx.stage.Stage;

public class BattleShip extends Application {

    private View view; // View + Controller

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception {

        this.view = new View(stage);

    }

}

