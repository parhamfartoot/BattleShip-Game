package Battleship;

public class Settings {
    /* Settings is a Singleton class.
     * Settings has a array of ints holding information about the size of the board that has been chosen.
     * Settings also has a background, which will be the background of the game.
     */

    private static Settings single_instance = null;
    private Integer ar[] = new Integer[2];

    //Background of the board
    String backGround = "-fx-background-image: url('" + "/Art/BackGround/nebula_1.gif" + "'); " +
            "-fx-background-position: center center; " +
            "-fx-background-repeat: stretch;"+"-fx-background-size: cover;";

    private Settings(){

    }

    public static Settings getInstance()
    {
        if (single_instance == null)
            single_instance = new Settings();

        return single_instance;
    }

    Integer[] GetSize(){
        //returns the array containing the size of the board
        return ar;
    }
    void SetSize(int x, int y){
        //Set the size of the board
        ar[0] = x;
        ar[1] = y;
    }
}
