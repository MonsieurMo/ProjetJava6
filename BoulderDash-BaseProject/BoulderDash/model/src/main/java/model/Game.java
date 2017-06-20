package model;

public class Game {
	
	public int map[][] = new int[30][20];	
	public int score = 0;
	
	public int pX,pY;
	
	public Game()
	{
		
	}
	
	
	//GETTER SETTER
	
	public int getpX()
	{
		return this.pX;
	}
	
	public int getpY()
	{
		return this.pY;
	}
	
	public void setpX(int pX)
	{
		this.pX = pX;
	}
	
	public void setpY(int pY)
	{
		this.pY = pY;
	}
	
}
