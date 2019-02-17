package Battleship.Faction2;

import Battleship.Pin;
import Battleship.Ships;

public class F2_Ship2 extends Ships {

    public F2_Ship2() {
        Crtitical.add(new Pin(50,50));
        Crtitical.add(new Pin(50,100));
        Crtitical.add(new Pin(50,150));

        setH(100);setW(50);

        setArt("Art/SpaceShips/Faction2/Ship2.png");

    }
}
