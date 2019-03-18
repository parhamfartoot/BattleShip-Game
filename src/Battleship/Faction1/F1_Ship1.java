package Battleship.Faction1;

import Battleship.Ships;

public class F1_Ship1 extends Ships {
    /*
    A child of Ships
    A ship has an appropriate artwork set at instantiation
    A ship has a Mouse Listener
    */

    public F1_Ship1() {
        setH(150);
        setW(100);//Set the size of the ship
        setArt("Art/SpaceShips/Faction1/Ship1.png");//Set the artwork of the ship
    }
}
