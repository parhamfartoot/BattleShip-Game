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

    public int count =1;
    private int init=0;

    private static GameModel single_instance = null;

    public static GameModel getInstance()
    {
        if (single_instance == null)
            single_instance = new GameModel();
        return single_instance;
    }

    public void ChangePlayer(){

        if(this.player ==1)
            this.player = 2;
        else this.player =1;
        setChanged();notifyObservers();
    }

    public void ChangeState(){
        if (state == true)
            state=false;
        else state = true;
        setChanged(); notifyObservers();
    }

    public boolean State(){
        return state;
    }
    public void Start(){
        init++;
        if(init >=2)
            this.InitPhase = false;
    }

    public boolean IsInitPhase(){return this.InitPhase;}
    public int Turn(){return this.player;}

    public Board GetPlayer(){
        if (this.player == 1){
            return player1;
        } else return player2; }

    public Board GetEnemy(){
        if (this.player == 2){
            return player1;
        } else return player2; }
}
