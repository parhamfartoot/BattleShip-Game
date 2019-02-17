package Battleship;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ShipChooser extends GridPane {
    F1_Ship1 F1_S1 = new F1_Ship1();

    public ShipChooser(){

        this.add(F1_S1.getShip(),0,0);

    }
}
