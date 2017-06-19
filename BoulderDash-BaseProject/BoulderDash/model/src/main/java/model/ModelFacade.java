package model;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
   
    
    @Override
    public int[][] creationLevel()//Return the map with all the element;
    {
    	pY = 0;pX = 0;
    	int x = 0,y=0;

        //Création de la map remplie
    	System.out.println("Création of the carte...");
        for (int i = 0;i<30;i++)
        {
            for (int j = 0;j<20;j++)
            {
                y +=32;
                
                map[i][j] = 1;
            }
            x += 32;
            y = 0;
        }
        
      //Init of Player
        map[0][0] = 8;

        //Set of Diamonds
        map[10][10] = 3;
        map[16][7] = 3;
        map[3][17] = 3;

        //Set of Stone
        map[12][1] = 4;
        map[23][15] = 4;
        map[4][18] = 4;
        
        System.out.println("Creation of the map ended");
        return map;
    	
    }
    
    public int[][] newMapLoading() throws SQLException
    {    		
    	try {
    	      //Class.forName("org.postgresql.Driver");
    	      System.out.println("Driver O.K.");

    	      String url = "jdbc:postgresql://localhost/boulderdash";
    	      String user = "postgres";
    	      String passwd = "postgres";

    	      Connection conn = DriverManager.getConnection(url, user, passwd);
    	      System.out.println("Connexion effective !");         
    	         
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
            if (map[pX][pY-1] != 4)
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
            if (map[pX][pY+1] != 4)
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
            if (map[pX-1][pY] != 4)
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
            updateLeft();
        }
    	
    	
    	
    	
    	return this.map;
    }
    
    public int[][] right()
    {
    	if (pX < 29)
        {
            if (map[pX+1][pY] != 4)
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
           
            updateRight();

        }
    	
    	
    	
    	return this.map;
    }
   
    public void updateLeft()
    {
    	if (pY !=0) //Si le joueur n'est pas en haut de la carte
        {
            //Si pierre
            if  (map[pX+1][pY-1] == 4)
            {

                //Pierre
                int pierreX = pX+1,pierreY = pY-1;

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
            }

            //Diamant
            if  (map[pX+1][pY-1] == 3)
            {
                int diamX = pX+1,diamY = pY-1;

                while((map[diamX][diamY+1] == 0)&&(diamY !=18))
                {
                    map[diamX][diamY] = 0;
                    diamY++;
                    map[diamX][diamY] = 3;
                }
                if ((diamY == 18)&&(map[diamX][diamY+1] == 0))
                {
                	map[diamX][diamY] = 0;
                    diamY++;
                    map[diamX][diamY] = 3;
                }
            }
        }
    }
    
    public void updateRight()
    {
    	if (pY != 0)//Si le joueur n'est pas en haut de la carte
        {
            //Pierre
            if  (map[pX-1][pY-1] == 4)
            {
                int pierreX = pX-1,pierreY = pY-1;

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
            }
            
           //Diamant
            if  (map[pX-1][pY-1] == 3)
            {

                int diamX = pX-1,diamY = pY-1;

                while((map[diamX][diamY+1] == 0)&&(diamY !=18))
                {
                    map[diamX][diamY] = 0;
                    diamY++;
                    map[diamX][diamY] = 3;

                }
                if ((diamY == 18)&&(map[diamX][diamY+1] == 0))
                {
                	map[diamX][diamY] = 0;
                    diamY++;
                    map[diamX][diamY] = 3;
                }

            }
        }
    	
    }


}


