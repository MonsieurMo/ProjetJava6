package model;

import java.util.LinkedList;

import model.monster.Monster;
/**
 * The model of the game, countains the map, the postion of player, the list of monster....
 * @author Etienne
 *
 */
public class Game {
	
	public int map[][] = new int[30][20];	
	public int score = 0;
	public String status = "";
	public int step = 0;
	
	public int pX,pY;
	public long time = 0;
	public LinkedList monster2 = new LinkedList<Monster>();
	public LinkedList monster3 = new LinkedList<Monster>();
	public LinkedList monster4 = new LinkedList<Monster>();
	
	/**
	 * Set the game status at "run"
	 */
	public Game()
	{
		this.status = "run";
	}
	
	
	//GETTER SETTER
	
	/**
	 * @return pX the position X of the player
	 */
	public int getpX()
	{
		return this.pX;
	}
	
	/**
	 * @return pY the position Y of the player
	 */
	public int getpY()
	{
		return this.pY;
	}
	
	/**
	 * Set pX
	 * @param pX
	 */
	public void setpX(int pX)
	{
		this.pX = pX;
	}
	
	/**
	 * Set pY
	 * @param pY
	 */
	public void setpY(int pY)
	{
		this.pY = pY;
	}
	
}
