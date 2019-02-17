package Battleship;

import javafx.scene.shape.Circle;

import java.util.Observable;

public class GameModel extends Observable{

    private boolean InitPhase = true;
    private int player =1;
    private Board player1 = new Board();
    private Board player2 = new Board();
    private Boolean state = false;
    protected Circle shot = null;

    int count =1;
    private int init=0;

    private static GameModel single_instance = null;

    static GameModel getInstance()
    {
        if (single_instance == null)
            single_instance = new GameModel();
        return single_instance;
    }

    void ChangePlayer(){

        if(this.player ==1)
            this.player = 2;
        else this.player =1;
        setChanged();notifyObservers();
    }

    void ChangeState(){
        state = !state;
        setChanged(); notifyObservers();
    }

    boolean State(){
        return state;
    }
    void Start(){
        init++;
        if(init >=2)
            this.InitPhase = false;
    }

    boolean IsInitPhase(){return this.InitPhase;}
    int Turn(){return this.player;}

    int Player(){return this.player;}

    Board GetPlayer(){
        if (this.player == 1){
            return player1;
        } else return player2; }

    public Board GetEnemy(){
        if (this.player == 2){
            return player1;
        } else return player2; }
}
