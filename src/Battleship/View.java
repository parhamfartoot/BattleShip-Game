package Battleship;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    private GameModel model;
    private Stage stage;
    private BorderPane root = new BorderPane();

    protected View(Stage stage) {

        this.model = GameModel.getInstance();
        this.stage = stage;
        setObservable();
        initUI(stage);
    }

    private void initUI(Stage stage) {

        //Instantiate the view with Transition
        Transition trans = new Transition();
        trans.button.setText("Start !");
        root.setCenter(trans);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Player " + model.Turn());
        stage.show();
    }

    private void setObservable() {
        // Sets the view as GameModel's observer
        GameModel.getInstance().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        // Clears the Pane
        root.getChildren().clear();

        // If the game is in transition phase Displays the Transition, otherwise the according board
        if (model.State()){
            this.root.setCenter(model.GetPlayer());
    }
        else{
            root.setCenter(new Transition());
        }
        // Sets the title to the current player
        stage.setTitle("Player " + model.Turn());

        root.setLeft(new ShipChooser());
    }
}