package Battleship.Faction1;

import Battleship.GameModel;

import Battleship.Ships;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class F1_Ship3 extends Ships {
    /*
    A child of Ships
    A ship has an appropriate artwork set at instantiation
    A ship has a Mouse Listener
    */

    public F1_Ship3() {
        setH(100);
        setW(100);//Set the size of the ship

        setArt("Art/SpaceShips/Faction1/Ship3.png");//Set the artwork of the ship
    }
}

