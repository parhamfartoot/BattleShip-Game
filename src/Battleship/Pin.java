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
                if (model.count == 8) {
                    model.count = 1;
                    model.Start();
                    model.ChangeState();
                    model.ChangePlayer();
                }
                else {
                    model.count++;
                }
                this.c.setFill(Color.RED);
            }
        }
        else {
                if(this.c.getCenterY() < Integer.parseInt(Settings.getInstance().GetSize()[1])/2){
                    this.c.setFill(Color.RED);
                    model.ChangeState();
                    model.ChangePlayer();
                }}

        }
    }
