package Battleship.Faction1;

import Battleship.Pin;
import Battleship.Ships;

public class F1_Ship3 extends Ships {

    public F1_Ship3() {
        Crtitical.add(new Pin(50,50));
        Crtitical.add(new Pin(50,100));
        Crtitical.add(new Pin(50,150));

        setH(100);setW(100);

        setArt("Art/SpaceShips/Faction1/Ship3.png");

    }
}
