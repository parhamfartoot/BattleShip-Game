package Battleship;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Observable;

public class GameModel extends Observable{
    /* GameModel is a singleton class that extends observable
     * GameModel keeps track of the boards used in game, the ship that should be placed on board(if any) and also which player should play next
     * as well as which phase of the game it currently is (placement phase or attack phase)
     * every time a turn ends the GameModel is changed and notifies it observer
     */

    private boolean InitPhase = true; //The placement phase
    private int player =1; //the player whom turn it is
    private Board player1; // Player1's board
    private Board player2; // Player2's board
    private Boolean state = false;
    private Boolean mutliplayer = true;
    private int boardsize = 0;
    private int selection = 0;
    ImageView shipToPlace; // The ship that needs to be placed on board
    int count =0;
    private int init=0;
    private int[] score = new int[2];
    private String hitState;
    Stage stage;
    ShipChooser chooser;

    //declares the GameModel as singleton
    private static GameModel single_instance = null;
    static GameModel getInstance()
    {
        if (single_instance == null)
            single_instance = new GameModel();
        return single_instance;
    }

    void ChangePlayer(){
        //Changes the player that should play and notifies the observer
        if(this.player ==1)
            this.player = 2;
        else this.player =1;
        setChanged();notifyObservers();
    }
    void MakeBoard(){
        //Creates the boards for players
        this.player1 = new Board(); // Player1's board
        this.player2 = new Board(); // Player2's board
    }

    void ChangeState(){
        //Changes the state of the game and notifies the observer
        state = !state;
        setChanged(); notifyObservers();
    }

    void NextSelection(){
        //Goes to the next selection menu and notifies the observer
    	this.selection++;
    	setChanged(); notifyObservers();
    }
    
    //public void setSelection(int sel){this.selection = sel;}

    void setMultiplayer(Boolean multi){
    	this.mutliplayer = multi;
    }
    
    boolean State(){
        // return the current state
        return state;
    }
    
    void Start(){
        // starts the game for one player
        init++;
        if(init >=2)
            this.InitPhase = false;
    }

    boolean IsInitPhase(){return this.InitPhase;} //returns if the player is still in the placement phase
    int Turn(){return this.player;}

    int getSelection(){
    	return this.selection;
    }

    int Player(){return this.player;}
    int Enemy(){if(this.player ==1) return 2;else return 1;}


    Board GetPlayer(){
        //Returns the board of the player who is currently playing
        if (this.player == 1){
            return player1;
        } else return player2; }

    Board GetEnemy(){
        //Returns the board of the next player
        if (this.player == 2){
            return player1;
        } else return player2; }

    int GetScore(){
        //Returns the score of the player
        if (player ==1) return score[1];
        else return score[0];
    }
    int GetEnemyScore(){
        //Returns the score of the player
        if (player ==1) return score[0];
        else return score[1];
    }
    void AddScore(){
        //Adds to the score of the player
        score[Player()-1] += 50;
    }

    void setShot(String state){
        //Set the string for players shot
        hitState = state;
    }
    String HitState(){
        //Returns the string representative of your last shot
        return hitState;
    }
    void Update(){setChanged();notifyObservers();}
}
