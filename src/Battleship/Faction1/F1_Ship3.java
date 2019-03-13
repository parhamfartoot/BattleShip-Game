package Battleship.Faction1;

import Battleship.GameModel;
import Battleship.Pin;
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
        Crtitical.add(new Pin(50,50));
        Crtitical.add(new Pin(50,100));
        Crtitical.add(new Pin(50,150));

        setH(100);setW(100);//Set the size of the ship

        setArt("Art/SpaceShips/Faction1/Ship3.png");//Set the artwork of the ship
        this.getShip().setOnMousePressed(ShipOnMousePressedEventHandler);// Add a MouseOnPress listener to the ship
    }

    EventHandler<MouseEvent> ShipOnMousePressedEventHandler = new EventHandler<MouseEvent>()
    {
        //On mouse pressed the ship will be added to GameModel for placement
        @Override
        public void handle(MouseEvent mouseEvent)
        {
            GameModel.getInstance().shipToPlace = new F1_Ship3();
        }
    };

}

