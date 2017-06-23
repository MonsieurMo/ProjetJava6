package model.monster;

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
	
	/**
	 * Return X position
	 * @return X
	 */
	public int getX()
	{
		return i1;
	}
	
	/**
	 * Return Y position
	 * @return X
	 */
	public int getY()
	{
		return i2;
	}
	
	/**
	 * Return last direction of the monster
	 * @return direction
	 */
	public String getDirection()
	{
		return this.direction;
	}
	
	/**
	 * Return the count of step of monster
	 * @return count
	 */
	public int getCount()
	{
		return this.count;
	}
	
	/**
	 * Set X
	 * @param x
	 */
	public void setX(int x)
	{
		this.i1 = x;
	}
	
	/**
	 * Set Y
	 * @param y
	 */
	public void setY(int y)
	{
		this.i2 = y;
	}
	
	/**
	 * Set direction
	 * @param direction
	 */
	public void setDirection(String direction)
	{
		this.direction = direction;
	}
	
	/**
	 * Set Count
	 * @param count
	 */
	public void setCount(int count)
	{
		this.count = count;
	}
	

}