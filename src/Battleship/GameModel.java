package Battleship;

import javafx.scene.shape.Circle;

import java.util.Observable;

public class GameModel extends Observable{

    private boolean InitPhase = true;
    private int player =1;
    private Board player1 = new Board();
    private Board player2 = new Board();
    private Boolean state = false;
    private Boolean mutliplayer = true;
    private int boardsize = 0;
    private int selection = 0;
    protected Circle shot = null;
    public Ships shipToPlace;

    int count =1;
    private int init=0;

    private static GameModel single_instance = null;

    public static GameModel getInstance()
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

    void NextSelection(){
    	this.selection++;
    	setChanged(); notifyObservers();
    }
    
    public void setSelection(int sel){
    	this.selection = sel;
    }

    void setMultiplayer(Boolean multi){
    	this.mutliplayer = multi;
    }
    
    boolean State(){
        return state;
    }
    
    public void Start(){
        init++;
        if(init >=2)
            this.InitPhase = false;
    }

    boolean IsInitPhase(){return this.InitPhase;}
    int Turn(){return this.player;}

    public int getSelection(){
    	return this.selection;
    }

    int Player(){return this.player;}


    public Board GetPlayer(){
        if (this.player == 1){
            return player1;
        } else return player2; }

    public Board GetEnemy(){
        if (this.player == 2){
            return player1;
        } else return player2; }
}
