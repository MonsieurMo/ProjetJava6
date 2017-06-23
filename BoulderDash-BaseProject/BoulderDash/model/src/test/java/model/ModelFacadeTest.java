package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelFacadeTest {
	
	/**
	 * Test of getX
	 */
	@Test
	public void testgetpX()
	{
		final int expected = 10;
		ModelFacade model = new ModelFacade();
		model.game.setpX(10);
		
		assertEquals(expected,model.getpX());
	}
	/**
	 * Test of getY
	 */
	@Test
	public void testgetpY()
	{
		final int expected = 11;
		ModelFacade model = new ModelFacade();
		model.game.setpY(11);
		
		assertEquals(expected,model.getpY());
	}
	
	/**
	 * Test get of Status
	 */
	@Test
	public void testgetStatus()
	{
		final String expected = "run";
		ModelFacade model = new ModelFacade();
		assertEquals(expected,model.getStatus());
	}
	
	/**
	 * Test of getScore
	 */
	@Test
	public void testgetScore()
	{
		final int expected = 10;
		ModelFacade model = new ModelFacade();
		model.game.score = 10;
		
		assertEquals(expected,model.getScore());
	}
	
	/**
	 * Test of getStep
	 */
	@Test
	public void testgetStep()
	{
		final int expected = 127;
		ModelFacade model = new ModelFacade();
		model.game.step = 127;
		
		assertEquals(expected,model.getStep());
	}

}
