package Battleship;

import Battleship.Faction1.F1_Ship1;
import Battleship.Faction1.F1_Ship2;
import Battleship.Faction1.F1_Ship3;
import Battleship.Faction1.F1_Ship4;
import Battleship.Faction2.F2_Ship1;
import Battleship.Faction2.F2_Ship2;
import Battleship.Faction2.F2_Ship3;
import Battleship.Faction2.F2_Ship4;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;

class ShipChooser extends GridPane {
/* ShapeChooser is a GridPane that has the Ships players can chose from for placement
 *
 */
    ArrayList<Ships> ships = new ArrayList<Ships>();

    ShipChooser() {
        // There are 8 ship models, 4 in each faction and each player will be one of the factions
        Collections.addAll(ships,new F1_Ship1(),new F1_Ship2(),new F1_Ship3(),new F1_Ship4(),new F2_Ship1(),new F2_Ship2(),new F2_Ship3(),new F2_Ship4());
        for (Ships ship : ships){ship.setAction();}

        //Shows the appropriate Ship model for the player
        if (GameModel.getInstance().Player() == 1) {

            this.add(ships.get(0).getShip(), 0, 0);
            this.add(ships.get(1).getShip(), 0, 1);
            this.add(ships.get(2).getShip(), 0, 2);
            this.add(ships.get(3).getShip(), 0, 3);

        } else {
            this.add(ships.get(4).getShip(), 0, 0);
            this.add(ships.get(5).getShip(), 0, 1);
            this.add(ships.get(6).getShip(), 0, 2);
            this.add(ships.get(7).getShip(), 0, 3);

        }
    }
}
