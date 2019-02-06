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

    public View(Stage stage) {

        this.model = GameModel.getInstance();
        this.stage = stage;
        setObservable();

        initUI(stage);
    }

    private void initUI(Stage stage) {

        //this.layout = new GridPane();
        BorderPane root = new BorderPane();
        if (model.State()){
        this.board = model.GetPlayer();
        root.setCenter(this.board);

        ArrayList<Pin> pins = this.board.getPins();
        for (Pin pin : pins) {
            //draws the current Pin Object
            root.getChildren().add(pin.c);
        }}
        else{
            root.setCenter(new Transition());

        }
        //root.setLeft(layout);

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
        new View(stage);


    }
}