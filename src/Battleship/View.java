package Battleship;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.Observable;
import java.util.Observer;

import static Battleship.AI.AI_FleetPlacement;

public class View implements Observer {
    /* View is an observer, it has GameModel, Stage, BorderPane and Menu
     * View has GameModel as its observer and when change is made to GameModel the view will update, displaying the appropriate view for the game
     */

    private GameModel model;
    private Stage stage;
    private BorderPane root = new BorderPane();
    private Menu gamemenu = new Menu(0);

    protected View(Stage stage) {
        this.model = GameModel.getInstance();
        model.stage =stage;
        this.stage = stage;
        setObservable();
        initUI(stage);
    }

    private void initUI(Stage stage) {
        //Instantiate the view with Start Menu
        root.setCenter(gamemenu);
        Scene scene = new Scene(root);
        Rotate(scene);
        stage.setScene(scene);
        stage.setTitle("Welcome to BattleShips!");
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
        //If game options were selected during Start Menu
        if (model.getSelection() > 1) {
            // Play the Game
            Play();
            // Sets the title to the current player
            stage.setTitle("Player " + model.Turn());
            // Start Menu Selection
        } else {
            this.root.setCenter(new Menu(model.getSelection()));
            // Sets the title to the current player
            stage.setTitle("Player " + model.Turn());

        }
        stage.sizeToScene();}

    static void Rotate(Scene scene) {
        //set the keyHandler to implement rotation
        scene.setOnKeyPressed((event) -> {
            if (GameModel.getInstance().shipToPlace != null){
            if (event.getCode() == KeyCode.E) {
                //If E is pressed rotate clockwise
                GameModel.getInstance().shipToPlace.setRotate(GameModel.getInstance().shipToPlace.getRotate()+90);
            }
            else if (event.getCode() == KeyCode.Q) {
                //If Q is pressed rotate Counter-Clockwise
                GameModel.getInstance().shipToPlace.setRotate(GameModel.getInstance().shipToPlace.getRotate()-90);
            }}
        });
    }

    private void Play(){
        // If the game is in transition phase Displays the Transition, otherwise the according board
        if (model.State()) {
            this.root.setCenter(model.GetPlayer());
            if (GameModel.getInstance().GetMode() && GameModel.getInstance().Player() ==2){
                if (model.IsInitPhase()){AI_FleetPlacement(GameModel.getInstance().AI_Pins());}

            }
            if (model.IsInitPhase()){
                GameModel.getInstance().chooser = new ShipChooser();
                root.setLeft(GameModel.getInstance().chooser);}
        } else {
            //Check if a player has won the game
            if (GameModel.getInstance().GetScore() == 700) {root.setCenter(new WinScreen());}
            else root.setCenter(new Transition());
        }
    }
}
