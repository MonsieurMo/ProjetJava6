package model;

public class Monster {
	
	private int i1;
	private int i2;
	private String direction = "up";
	private int count = 0;
	
	public Monster(int i1, int i2)
	{
		this.i1 = i1;
		this.i2 = i2;
	}
	
	public int getX()
	{
		return i1;
	}
	
	public int getY()
	{
		return i2;
	}
	
	public String getDirection()
	{
		return this.direction;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void setX(int x)
	{
		this.i1 = x;
	}
	
	public void setY(int y)
	{
		this.i2 = y;
	}
	
	public void setDirection(String direction)
	{
		this.direction = direction;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	

}
