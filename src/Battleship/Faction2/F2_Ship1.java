package Battleship.Faction2;

import Battleship.Pin;
import Battleship.Ships;

public class F2_Ship1 extends Ships {

    public F2_Ship1() {
        Crtitical.add(new Pin(50,50));
        Crtitical.add(new Pin(50,100));
        Crtitical.add(new Pin(50,150));

        setH(150);setW(100);

        setArt("Art/SpaceShips/Faction2/Ship1.png");

    }
}
