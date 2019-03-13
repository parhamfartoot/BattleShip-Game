package Battleship;

import Battleship.Faction1.F1_Ship1;
import Battleship.Faction1.F1_Ship2;
import Battleship.Faction1.F1_Ship3;
import Battleship.Faction1.F1_Ship4;
import Battleship.Faction2.F2_Ship1;
import Battleship.Faction2.F2_Ship2;
import Battleship.Faction2.F2_Ship3;
import Battleship.Faction2.F2_Ship4;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

class ShipChooser extends GridPane {

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    ShipChooser(){

        F1_Ship1 f1_S1 = new F1_Ship1();
        F1_Ship2 f1_S2 = new F1_Ship2();
        F1_Ship3 f1_S3 = new F1_Ship3();
        F1_Ship4 f1_S4 = new F1_Ship4();

        F2_Ship1 f2_S1 = new F2_Ship1();
        F2_Ship2 f2_S2 = new F2_Ship2();
        F2_Ship3 f2_S3 = new F2_Ship3();
        F2_Ship4 f2_S4 = new F2_Ship4();

        if (GameModel.getInstance().Player() ==1){

            this.add(f1_S1.getShip(),0,0);
            this.add(f1_S2.getShip(),0,2);
            this.add(f1_S3.getShip(),0,1);
            this.add(f1_S4.getShip(),0,3);

        }else {
            this.add(f2_S1.getShip(),0,0);
            this.add(f2_S2.getShip(),0,2);
            this.add(f2_S3.getShip(),0,1);
            this.add(f2_S4.getShip(),0,3);

        }
    }
}
