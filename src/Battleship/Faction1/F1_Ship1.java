package Battleship.Faction1;

import Battleship.Pin;
import Battleship.Ships;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class F1_Ship1 extends Ships {

    public F1_Ship1() {
        Crtitical.add(new Pin(50,50));
        Crtitical.add(new Pin(50,100));
        Crtitical.add(new Pin(50,150));

        setH(150);setW(100);

        setArt("Art/SpaceShips/Faction1/Ship1.png");

    }
}
