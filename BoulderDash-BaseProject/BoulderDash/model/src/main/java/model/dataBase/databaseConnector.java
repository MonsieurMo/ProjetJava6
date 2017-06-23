package model.dataBase;
import model.Game;
import model.monster.Monster;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Data Base connector for laod the map
 * @author Etienne
 *
 */
public class databaseConnector {
	
    private final static String PROCE = "CALL lvl1";
    private final static String URL = "jdbc:mysql://localhost/boulderdash";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "";
	
    /**
     * Connection to the dataBase for loading level later
     * @return	connection	the Connection at the database
     * @throws	SQLException SQLEXCEPTION
     */
	private static Connection connection() throws SQLException{
	     Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD); //Connexion to the dataBase
	     System.out.println("Connexion to Data Base ready !");
		return  conn;}
	
	/**
	 * After the connection to the data base load the map in the object Game
	 * @param game the game
	 * @return game	with the map load
	 * @throws SQLException	SQLEXEPT
	 */
	public static Game loadingLevel(Game game) throws SQLException{
		try{Connection conn = connection();
			Statement state = conn.createStatement();
		    ResultSet result = state.executeQuery(PROCE);      
		    result.next();
		    for (int j = 0;j<20;j++){
		            for (int i = 0;i<30;i++){game.map[i][j] =  Integer.parseInt(result.getObject(i+2).toString());
		            	if (game.map[i][j] == 6) game.monster2.add(new Monster(i,j));
		            	if (game.map[i][j] == 7) game.monster3.add(new Monster(i,j));//We add a monster to the list of monster
		                if (Integer.parseInt(result.getObject(i+2).toString()) == 8){ game.setpX(i); game.setpY(j);}}
		            result.next();}	        
		        result.close();
		        state.close();}
		catch (Exception e) { e.printStackTrace();} 	    
		return game;}
	
	

}
