package Battleship;
import javafx.scene.paint.Color;

//author Shaquille David, 1001566931, davidsh4

public class Ship{
	/* A Ship has a name, colour, length, location, and direction placement.
	 * A ship can be placed vertically or horizontally. Diagonal placement
	 * is not allowed. Ships may not overlap each other.
	 */
	private String name;
	private int length;
	private int x;
	private int y;
	private String direction_placement;
	
	public Ship(String name){
		//retrieved the five types of ships from https://www.cs.nmsu.edu/~bdu/TA/487/brules.htm
		this.name = name;
		this.x = NULL;
		this.y = NULL;
		this.direction_placement = NULL; 

		if (name == "Carrier"){
			this.length = 5; }
		if (name == "Battleship"){
			this.length = 4; }
		if (name == "Cruiser"){
			this.length = 3; }
		if (name == "Submarine"){
			this.length = 3; }
		if (name == "Destroyer") {
			this.length = 2; }
	}

	public int getX(){
		//return the x coordinate of the ship
		return x;
	}

	public int getY(){
		//return the y coordinate of the ship
		return y;
	}

	public void setX(int x){
		// set the x position of the ship
		this.x = x;
	}

	public void setY(int y){
		//set the y position of the ship
		this.y = y;
	}

	public void set_direction_placement(String placement){
		// a ship can only be placed HORIZONTAL or VERTICAL
		if ((placement == "HORIZONTAL") || (placement == "VERTICAL")){
			this.direction_placement = placement;
		}
	}

	public String toString(){
		//return a string representation of this ship
		return "Type of Ship: " + this.name + ", located at (" + this.x + ", " + this.y + "). Length of " + this.length + "units, placed " + this.direction_placement + ".";
	}
}
		
