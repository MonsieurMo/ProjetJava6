package view;

import static org.junit.Assert.*;

import org.junit.Test;

import view.sprite.Blockk;

public class BlockkTest {
	
	Blockk blockk = new Blockk();
	
	
	/**
	 * Check the sprite of cobble
	 */
	@Test
	public void getTextureCobble()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\cobble.png";
		assertEquals(expected,blockk.getCobble());
	}
	
	/**
	 * Check the sprite of diamond
	 */
	@Test
	public void getTextureDiamond()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\diamond.png";
		assertEquals(expected,blockk.getDiamond());
	}
	
	/**
	 * Check the sprite of left movement
	 */
	@Test
	public void getTextureLeft()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\LEFT.png";
		assertEquals(expected,blockk.getLeft());
	}
	
	/**
	 * Check the sprite of right movement
	 */
	@Test
	public void getTextureRight()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\RIGHT.png";
		assertEquals(expected,blockk.getRight());
	}
	
	/**
	 * Check the sprite of Stone
	 */
	@Test
	public void getTextureStone()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\stone.png";
		assertEquals(expected,blockk.getStone());
	}
	
	/**
	 * Check the sprite of Tunnel
	 */
	@Test
	public void getTextureTunnel()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\tunnel.png";
		assertEquals(expected,blockk.getTunnel());
	}
	
	/**
	 * Check the sprite of  up movement
	 */
	@Test
	public void getTextureUp()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\caracter.png";
		assertEquals(expected,blockk.getUp());
	}
	
	/**
	 * Check the sprite of Wall
	 */
	@Test
	public void getTextureWall()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\bedrock.png";
		assertEquals(expected,blockk.getWall());
	}
	
	/**
	 * Check the sprite of Monster1
	 */
	@Test
	public void getTextureMonster1()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\creeper.png";
		assertEquals(expected,blockk.getMonster1());
	}
	
	/**
	 * Check the sprite of Monster2
	 */
	@Test
	public void getTextureMonster2()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\enderman.png";
		assertEquals(expected,blockk.getMonster2());
	}
	
	/**
	 * Check the sprite of Monster3
	 */
	@Test
	public void getTextureMonster3()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\zombie.png";
		assertEquals(expected,blockk.getMonster3());
	}
	
	/**
	 * Check the sprite of Monster4
	 */
	@Test
	public void getTextureMonster4()
	{
		final String expected = "C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\silverfish.png";
		assertEquals(expected,blockk.getMonster4());
	}
	
	
	
	
	
	
	
	
	

}
