package Battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class BoardBuilder {
    private Board board;
    private int height;
    private int width;

    public BoardBuilder(Board board) {
        this.board = board;
        this.height = this.board.getH();
        this.width = this.board.getW();
        this.Make_pin();
        this.Separate();

    }
    private void Separate() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(height/2);
        line.setEndX(500);
        line.setEndY(height/2);
        line.setStroke(Color.WHITE);
        this.board.getChildren().add(line);
    }

    private void Make_pin() {
        int y = 25;
        while (y < height) {
            int x = 25;
            while (x < width) {
                this.board.getChildren().add(new Pin(x, y).c);
                x += 50; }
            y += 50; }
        }

}
