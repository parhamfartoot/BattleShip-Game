package Battleship;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

class Board extends Pane {

    private Canvas canvas;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    GraphicsContext gc;

    public Board() {

        this.canvas = new Canvas(Integer.parseInt(Settings.getInstance().GetSize()[0]), Integer.parseInt(Settings.getInstance().GetSize()[1]));
        this.gc = canvas.getGraphicsContext2D();
        this.getChildren().add(this.canvas);

        // Set the background image
        this.setStyle(Settings.getInstance().backGround);
        //Calls BoardBuilder to populate the board
        new BoardBuilder(this);

        canvas.setOnMousePressed(canvasOnMousePressedEventHandler);
        canvas.setOnMouseDragged(canvasOnMouseDraggedEventHandler);

    }

    public int getH(){return (int)this.canvas.getHeight(); }

    public int getW(){return (int)this.canvas.getWidth(); }

    EventHandler<MouseEvent> canvasOnMousePressedEventHandler = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
            orgSceneX = mouseEvent.getSceneX();
            orgSceneY = mouseEvent.getSceneY();
            orgTranslateX = ((Canvas)(mouseEvent.getSource())).getTranslateX();
            orgTranslateY = ((Canvas) (mouseEvent.getSource())).getTranslateY();
        }
    };

    EventHandler<MouseEvent> canvasOnMouseDraggedEventHandler = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent) {
            double offsetX = mouseEvent.getSceneX() - orgSceneX;
            double offsetY = mouseEvent.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;

            ((Canvas) (mouseEvent.getSource())).setTranslateX(newTranslateX);  //transform the object
            ((Canvas) (mouseEvent.getSource())).setTranslateY(newTranslateY);
        }
    };

    }
