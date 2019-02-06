package Battleship;
import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class Pin implements EventHandler<MouseEvent>
{
    public  Circle c;



    public Pin(int x1, int y1)
    {

        this.c = new Circle(x1,y1,5,Color.GREEN);
        this.c.setOnMouseClicked(
            new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    Clicked(e);

                }
            });

    }

    private void Clicked(MouseEvent e) {
        GameModel model = GameModel.getInstance();
                if(this.c.getCenterY() < Integer.parseInt(Settings.getInstance().GetSize()[1])/2 && model.IsInitPhase() == false){
                    this.c.setFill(Color.RED);
                    model.ChangeState();
                    model.ChangePlayer();

                }
                else if (model.IsInitPhase() && this.c.getCenterY() > Integer.parseInt(Settings.getInstance().GetSize()[1])/2){
                    if (model.count < 5){model.count++;this.c.setFill(Color.RED);}
                    if (model.count == 5) {model.count = 0;model.Start();model.ChangeState();model.ChangePlayer();}
                }
        }

        public void handle(MouseEvent e) {

    }

    }
