package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {
	
	/**
	 * Test if the method return the same x who's stock in the game
	 */
	@Test
	public void testGetX()
	{
		final int expected = 10;
		Game game = new Game();
		game.setpX(10);
		assertEquals(expected,game.getpX());
		
	}
	
	/**
	 * Test if the method return the same y who's stock in the game
	 */
	@Test
	public void testGetY()
	{
		final int expected = 15;
		Game game = new Game();
		game.setpY(15);
		assertEquals(expected,game.getpY());
		
	}
}
