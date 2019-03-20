package Battleship;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class WinScreen extends StackPane {
    /* WinScreen is a stack pane and has a canvas and a button.
     * WinScreen is instantiated at the 1000 by 1000 and shares the same background as board.
     */
    WinScreen(){
        this.setStyle(Settings.getInstance().backGround);
        //Winning message
        Text win = new Text("CONGRATS PLAYER "+GameModel.getInstance().Enemy()+" YOU HAVE WON THE GAME WITH THE SCORE OF: "+Integer.toString(GameModel.getInstance().GetScore()));
        //Setting the font of the text
        win.setFont(Font.font(null, FontWeight.BOLD, 25));
        //Setting the color of the text
        win.setFill(Color.WHITE);
        //setting the position of the text
        win.setTranslateY(-200);
        //Adds the component to the StackPane
        this.getChildren().add(win);
        //Set the size of the stage
        this.setMinSize(1000,1000);
        GameModel.getInstance().stage.setMaxWidth(1000);GameModel.getInstance().stage.setMaxWidth(1000);

    }
}
