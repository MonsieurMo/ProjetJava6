package model;

import java.sql.SQLException;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleById(int id) throws SQLException;

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleByName(String name) throws SQLException;

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    List<Example> getAllExamples() throws SQLException;
    
    
    
    //Methodes
    public int[][] creationLevel()throws SQLException;
    
    public int[][] getMap();
    
    public int[][] up();
    
    public int[][] down();
    
    public void updateDown();
    
    public int[][] left();
    
    public int[][] right();
    
    
    public int getScore();
   
    public int getpX();
    
    public int getpY();
    
    public void updateStone(int pierreX,int pierreY);
    
    public void updateDiamond(int diamondX,int diamondY);
    
}
