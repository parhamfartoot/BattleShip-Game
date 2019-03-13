package Battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Pin
{
    protected Circle c;

    public Pin(int x1, int y1) {

        this.c = new Circle(x1, y1,9, Color.WHITE);

        this.c.setOnMouseClicked(
            new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    Clicked(e);
                }
            });
    }

    private void Clicked(MouseEvent e) {
        GameModel model = GameModel.getInstance();

        if (model.IsInitPhase()){
            if (this.c.getCenterY() > Integer.parseInt(Settings.getInstance().GetSize()[1])/2){

                if (GameModel.getInstance().shipToPlace != null) {

                    model.shipToPlace.getShip().setX(c.getCenterX() - 25);
                    model.shipToPlace.getShip().setY(c.getCenterY() - 25);
                    model.GetPlayer().getChildren().add(0,model.shipToPlace.getShip());
                    model.shipToPlace.Align();

                    if (model.count == 4) {
                        model.count = 1;
                        model.Start();
                        model.ChangeState();
                        model.ChangePlayer();
                    }
                    else {
                        model.count++;
                    }
                }
                GameModel.getInstance().shipToPlace = null;


            }
        }
        else {
                if(this.c.getCenterY() < Integer.parseInt(Settings.getInstance().GetSize()[1])/2){
                    this.c.setFill(Color.RED);

                    //int i =model.GetPlayer().getChildren().indexOf(c);
                    //System.out.println(model.GetEnemy().getChildren().get(i));

                    model.ChangeState();
                    model.ChangePlayer();
                }}

        }
        /*
        private void Shot(Circle c){
            Board enemy = GameModel.getInstance().GetEnemy();
            list = enemy.getChildren().subList(1,(enemy.getChildren().size())-1);
            for (Circle : enemy.getChildren()){


           }

        } */
    }
