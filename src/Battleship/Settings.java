package Battleship;

public class Settings {

    private static Settings single_instance = null;

    private int width = 500;
    private int height = 1000;
    private String ar[] = new String[2];

    public Settings(){
        ar[0]= Integer.toString(width);
        ar[1] =Integer.toString(height);
    }

    public static Settings getInstance()
    {
        if (single_instance == null)
            single_instance = new Settings();

        return single_instance;
    }

    public String[] GetSize(){

        return ar;
    }
}
