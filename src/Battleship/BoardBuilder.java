package Battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class BoardBuilder {
    /* The BoardBuilder has a board, height and width
     * At instantiation the board builder separates the board into two halves and the creates pins and populate the board with them
     */

    private Board board;
    private int height;
    private int width;

    public BoardBuilder(Board board) {
        this.board = board;
        this.height = this.board.getH();
        this.width = this.board.getW();
        this.Separate();
        this.Make_pin();

    }
    private void Separate() {
        // Creates a line in the middle of the board, separating the board into two halves horizontally
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(height/2);
        line.setEndX(500);
        line.setEndY(height/2);
        line.setStroke(Color.WHITE);
        this.board.getChildren().add(line);
    }

    private void Make_pin() {
        // Populates the board with pins starting at 25 units away from x-axis and y-axis, after that every pin is 50 units apart
        // from other pins on both x-axis and y-axis

        int y = 25;
        while (y < height) {
            int x = 25;
            while (x < width) {
                this.board.getChildren().add(new Pin(x, y).c);
                x += 50; }
            y += 50; }
        }

}
