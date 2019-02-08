package Battleship;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    private GameModel model;
    private Board board;
    private Stage stage;
    private BorderPane root = new BorderPane();

    protected View(Stage stage) {

        this.model = GameModel.getInstance();
        this.stage = stage;
        setObservable();

        initUI(stage);
    }

    private void initUI(Stage stage) {

        //root.setLeft(layout);
        root.setCenter(new Transition());

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Player " + Integer.toString(model.Turn()));
        stage.show();
    }

    private void setObservable() {
        GameModel.getInstance().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        root.getChildren().clear();

        if (model.State()){
            this.board = model.GetPlayer();
            this.root.setCenter(this.board);

            //draws the current Pin Object
            /*
            for (Pin pin : this.board.getPins()) {
                root.getChildren().add(pin.c);

            } */
    }
        else{
            root.setCenter(new Transition());

        }
        stage.setTitle("Player " + Integer.toString(model.Turn()));
    }
}