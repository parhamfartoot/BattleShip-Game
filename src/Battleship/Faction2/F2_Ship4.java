package Battleship.Faction2;

import Battleship.Ships;

public class F2_Ship4 extends Ships {
    /*
    A child of Ships
    A ship has an appropriate artwork set at instantiation
    A ship has a Mouse Listener
    */
    public F2_Ship4() {

        setH(100);
        setW(50); //Set the size of the ship

        setArt("Art/SpaceShips/Faction2/Ship4.png"); //Set the artwork of the ship
    }
}
