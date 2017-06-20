package model;

import java.sql.SQLException;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    
    
    //Methodes
    public int[][] creationLevel()throws SQLException;
    
    public int[][] getMap();
    
    public int[][] up();
    
    public int[][] down();
    
    public int[][] left();
    
    public int[][] right();
       
    public int getScore();
   
    public int getpX();
    
    public int getpY();
    
    
}
