package model;
import java.sql.SQLException;
import java.util.Observable;

import model.Movement;
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
  
    public int[][] creationLevel() throws SQLException{    		
    	game = databaseConnector.loadingLevel(game);//Get the map update and the caracter position update 	
    	return this.game.map;}//return the map for the view
       
    public int[][] getMap(){
    	return this.game.map;}
    
    public int getScore(){
    	return this.game.score;}
    
    
    /**
     * MOOVEMENT
     */
    
    public int[][] up(){
    	game = Movement.up(game);
    	return this.game.map;}
    
    public int[][] down(){
    	game = Movement.down(game);
    	return this.game.map;}

    public int[][] left(){
    	game = Movement.left(game);
    	return this.game.map;}
    
    public int[][] right(){
    	game = Movement.right(game);
    	return this.game.map;}

    public int getpX(){
    	return game.getpX();}
    
    public int getpY(){
    	return game.getpY();}

    public String getStatus()
    {
    	return game.status;
    }
}
