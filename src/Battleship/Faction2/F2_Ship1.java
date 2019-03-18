package Battleship.Faction2;

import Battleship.Faction1.F1_Ship4;
import Battleship.GameModel;
import Battleship.Pin;
import Battleship.Ships;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class F2_Ship1 extends Ships {
    /*
    A child of Ships
    A ship has an appropriate artwork set at instantiation
    A ship has a Mouse Listener
    */

    public F2_Ship1() {

        setH(150);
        setW(100);//Set the size of the ship
        setArt("Art/SpaceShips/Faction2/Ship1.png"); //Set the artwork of the ship
    }
}
