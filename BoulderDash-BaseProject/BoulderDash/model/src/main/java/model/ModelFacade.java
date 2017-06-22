package model;


import java.sql.SQLException;
import java.util.Observable;

import dataBase.databaseConnector;
import monster.MonsterUpdate;
import movement.Movement;
/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade extends Observable implements IModel {
	
	 //My Attributs
    public Game game; 
    
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
        game = new Game();
    }
  
    /**
     * Create the level with the dataBase
     * @throws SQLException
     * @return game when the map are load
     */
    public int[][] creationLevel() throws SQLException{    		
    	game = databaseConnector.loadingLevel(game);//Get the map update and the caracter position update 	
    	return this.game.map;}//return the map for the view
       
    /**
     * Return the map of the game
     * @return game.map
     */
    public int[][] getMap(){
    	return this.game.map;}
    
    /**
     * Return the score of the game
     * @return game.score
     */
    public int getScore(){
    	return this.game.score;}
    
    /**
     * The character move up
     * @return game.map when the map was update
     */
    public int[][] up(){
    	game = Movement.up(game);
    	return this.game.map;}
    /**
     * The character move down
     * @return game.map when the map was update
     */
    public int[][] down(){
    	game = Movement.down(game);
    	return this.game.map;}

    /**
     * The character move left
     * @return game.map when the map was update
     */
    public int[][] left(){
    	game = Movement.left(game);
    	return this.game.map;}
    
    /**
     * The character move right
     * @return game.map when the map was update
     */
    public int[][] right(){
    	game = Movement.right(game);
    	return this.game.map;}

    /**
     * @return game.pX
     */
    public int getpX(){
    	return game.getpX();}
    
    /**
     * @return game.pY
     */
    public int getpY(){
    	return game.getpY();}

    /**
     * @return game.status 
     */
    public String getStatus()
    {
    	return game.status;
    }

    /**
     * @return game.step
     */
    public int getStep()
    {
    	return game.step;
    }

    /**
     * Update all the monster of the map
     * @return game.map
     */
    public int[][] monster()
    {
    	MonsterUpdate.updateMonster(game);   	
    	return this.game.map;
    }

}
