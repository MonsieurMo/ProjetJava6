package sprite;

public abstract class IBlock {
	
	protected Sprite cobble = new CobbleSprite();
	protected Sprite diamond = new DiamondSprite();
	protected Sprite left = new LeftSprite();
	protected Sprite right = new RightSprite();
	protected Sprite stone = new StoneSprite();
	protected Sprite tunnel = new TunnelSprite();
	protected Sprite up = new UpSprite();
	protected Sprite wall = new WallSprite();
	
	public IBlock(){}
	
	public String getCobble()
	{
		return cobble.sprite();
	}
	
	public String getDiamond()
	{
		return diamond.sprite();
	}

	public String getLeft()
	{
		return left.sprite();
	}
	
	public String getRight()
	{
		return right.sprite();
	}
	
	public String getStone()
	{
		return stone.sprite();
	}
	
	public String getTunnel()
	{
		return tunnel.sprite();
	}
	
	public String getUp()
	{
		return up.sprite();
	}
	
	public String getWall()
	{
		return wall.sprite();
	}

	

}
