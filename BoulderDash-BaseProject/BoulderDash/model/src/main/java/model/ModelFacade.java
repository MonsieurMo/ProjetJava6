package model;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {
	
	 //My Attributs
    int[][] map = new int[30][20];
    int pX =0, pY = 0;
    int score = 0;
    
    
    final String PROCE = "CALL lvl1";


    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     */
    @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }
    
    
    
    
    /**
     * MY CODE
     */
    
   
    
    public int[][] creationLevel() throws SQLException
    {    		
    	try {

    	      String URL = "jdbc:mysql://localhost/boulderdash";
    	      String LOGIN = "root";
    	      String PASSWORD = "";

    	      Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD); //Connexion to the dataBase
    	      System.out.println("Connexion to Data Base ready !");
    	      
    	      Statement state = conn.createStatement();
    	      ResultSet result = state.executeQuery(PROCE);
   	      
    	      ResultSetMetaData resultMeta = result.getMetaData();
    	      
    	      result.next();
    	        for (int j = 0;j<20;j++)
    	        {
    	            for (int i = 0;i<30;i++)
    	            {    	          	                
    	                map[i][j] =  Integer.parseInt(result.getObject(i+2).toString());
    	                if (Integer.parseInt(result.getObject(i+2).toString()) == 8)
    	                {
    	                	pX = i;
    	                	pY = j;
    	                }
    	            }
    	            result.next();
    	        }
    	        
    	        result.close();
    	        state.close();
    	         	         
    	    } catch (Exception e) {
    	      e.printStackTrace();
    	    } 
    	
    	
    	
    	
    	
    	return this.map;
    }
    
    public int[][] getMap()
    {
    	return this.map;
    }
    
    public int getScore()
    {
    	return this.score;
    }
    
    
    /**
     * MOOVEMENT
     */
    
    public int[][] up()
    {
    	if (pY > 0)
        {
            if ((map[pX][pY-1] != 4)&&(map[pX][pY-1] != 5))
            {
                //Si diamant
                if (map[pX][pY-1] == 3)
                {
                    score ++;
                }
                //Déplacement basique si y'a rie
                map[pX][pY] = 0;
                pY--;
                map[pX][pY] = 8;
            }

        }
    	
    	return this.map;
    }
    
    public int[][] down()
    {
    	if (pY < 19)
        {
            if ((map[pX][pY+1] != 4)&&(map[pX][pY+1] != 5))
            {
                //Si diamant
                if (map[pX][pY+1] == 3)
                {
                    score ++;
                }
                //Déplacement basique si y'a rien
                map[pX][pY] = 0;
                pY++;
                map[pX][pY] = 8;
            }
            if (pY-1 > 0)
            {
            	updateDown();
            }
        }
    	return this.map;
    }

    public void updateDown()
    {
    	//Update des blocs au dessus
            //Si pierre
            if  (map[pX][pY-2] == 4)
            {
                map[pX][pY-2] = 0;
                map[pX][pY-1] = 4;

                //END OF GAME HERE

            }

            //Si diamant
            if  (map[pX][pY-2] == 3)
            {
                map[pX][pY-2] = 0;
                map[pX][pY-1] = 3;

                //END OF GAME

            }
        
    }

    public int[][] left()
    {
    	if (pX > 0)
        {
            if ((map[pX-1][pY] != 4)&&(map[pX-1][pY] != 5))
            {
                //Si diamant
                if (map[pX-1][pY] == 3)
                {
                    score ++;
                }
                //Déplacement basique si y'a rien
                map[pX][pY] = 0;
                pX--;
                map[pX][pY] = 8;
            }
            
            //If stone at the top of the last position of player : 
            if (map[pX+1][pY-1] == 4)
            {
            	updateStone(pX+1,pY-1);
            }
            
            if (map[pX+1][pY-1] == 3)
            {
            	updateDiamond(pX+1,pY-1);
            }
        }
    	
    	
    	
    	
    	return this.map;
    }
    
    public int[][] right()
    {
    	if (pX < 29)
        {
            if ((map[pX+1][pY] != 4)&&(map[pX+1][pY] != 5))
            {
                //Si diamant
                if (map[pX+1][pY] == 3)
                {
                    score ++;
                }
                //Déplacement basique si y'a rien
                map[pX][pY] = 0;
                pX++;
                map[pX][pY] = 8;
            }
           
            
            if (map[pX-1][pY-1] == 4)
            {
            	updateStone(pX-1,pY-1);
            }
            
            if (map[pX-1][pY-1] == 3)
            {
            	updateDiamond(pX-1,pY-1);
            }

        }
    	
    	
    	
    	return this.map;
    }

    public int getpX()
    {
    	return pX;
    }
    
    public int getpY()
    {
    	return pY;
    }

    public void updateStone(int pierreX,int pierreY)
    {
    	int pierreBisX = pierreX;
    	int pierreBisY = pierreY-1;
    	while((map[pierreX][pierreY+1] == 0)&&(pierreY != 18))
        {
            map[pierreX][pierreY] = 0;
            pierreY++;
            map[pierreX][pierreY] = 4;
        }
        if ((pierreY == 18)&&(map[pierreX][pierreY+1] == 0))
        {
        	map[pierreX][pierreY] = 0;
            pierreY++;
            map[pierreX][pierreY] = 4;
        }
        
        if (map[pierreBisX][pierreBisY] == 4)
        {
        	updateStone(pierreBisX,pierreBisY);
        }
        
        if (map[pierreBisX][pierreBisY] == 3)
        {
        	updateDiamond(pierreBisX,pierreBisY);
        }
        
        
    }
    
    public void updateDiamond(int diamondX,int diamondY)
    {
    	int diamondBisX = diamondX;
    	int diamondBisY = diamondY-1;
    	while((map[diamondX][diamondY+1] == 0)&&(diamondY != 18))
        {
            map[diamondX][diamondY] = 0;
            diamondY++;
            map[diamondX][diamondY] = 3;
        }
        if ((diamondY == 18)&&(map[diamondX][diamondY+1] == 0))
        {
        	map[diamondX][diamondY] = 0;
        	diamondY++;
            map[diamondX][diamondY] = 3;
        }
        
        if (map[diamondBisX][diamondBisY] == 4)
        {
        	updateStone(diamondBisX,diamondBisY);
        }
        
        if (map[diamondBisX][diamondBisY] == 3)
        {
        	updateDiamond(diamondBisX,diamondBisY);
        }
    }



}


