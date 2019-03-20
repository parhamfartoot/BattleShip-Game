package Battleship;

import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.Random;

import static Battleship.Functions.Align;

public class AI {


    AI(){

    }
    static void AI_FleetPlacement( ArrayList<Circle> nodes){
        ArrayList<Ships> ships = new ArrayList<Ships>(GameModel.getInstance().chooser.ships.subList(4,8));
        Random rand = new Random();
        int n;
        while (ships.size() != 0){
            if (ships.size() > 1){
            n = rand.nextInt(ships.size() -1);}
            else { n =0;}
            Ships ShipToPlace = ships.get(n);
            GameModel.getInstance().shipToPlace = ShipToPlace.getShip();
            int r = rand.nextInt(3);
            if (r == 0){GameModel.getInstance().shipToPlace.setRotate(GameModel.getInstance().shipToPlace.getRotate()+90);}
            if (r == 1){GameModel.getInstance().shipToPlace.setRotate(GameModel.getInstance().shipToPlace.getRotate()-90);}
        GameModel.getInstance().GetPlayer().getChildren().add(ShipToPlace.getShip());

        int p = rand.nextInt( nodes.size()-1);
        Circle circle = nodes.get(p);
            GameModel.getInstance().stage.setMaxWidth(Settings.getInstance().GetSize()[0]+GameModel.getInstance().chooser.getWidth());
            GameModel.getInstance().stage.sizeToScene();

        if (Align(nodes.get(p))){nodes.remove(circle);ships.remove(n);}
        }

    }

}
