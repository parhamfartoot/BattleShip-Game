package Battleship;

public class Settings {
    /* Settings is a Singleton class.
     * Settings has a width, height and a string holding information about the size of the board that has been chosen.
     * Settings also has a background, which will be the background of the game.
     */

    private static Settings single_instance = null;

    //private int width = 700; // Width of the board
    //private int height = 800; // height of the board
    private Integer ar[] = new Integer[2];

    //Background of the board
    protected String backGround = "-fx-background-image: url('" + "/Art/BackGround/nebula_1.gif" + "'); " +
            "-fx-background-position: center center; " +
            "-fx-background-repeat: stretch;"+"-fx-background-size: cover;";

    public Settings(){
        //ar[0]= width;
        //ar[1] =height;
    }

    public static Settings getInstance()
    {
        if (single_instance == null)
            single_instance = new Settings();

        return single_instance;
    }

    Integer[] GetSize(){

        return ar;
    }
    void SetSize(int x, int y){
        ar[0] = x;
        ar[1] = y;
    }
}
