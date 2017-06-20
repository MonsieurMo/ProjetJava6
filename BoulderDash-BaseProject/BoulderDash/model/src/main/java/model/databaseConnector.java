package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnector {
	
    final static String PROCE = "CALL lvl1";
	
	private static Connection connection() throws SQLException{
		 String URL = "jdbc:mysql://localhost/boulderdash";
	     String LOGIN = "root";
	     String PASSWORD = "";
	     Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD); //Connexion to the dataBase
	     System.out.println("Connexion to Data Base ready !");
		return  conn;}
	
	public static Game loadingLevel(Game game) throws SQLException{
		try{Connection conn = connection();
			Statement state = conn.createStatement();
		    ResultSet result = state.executeQuery(PROCE);      
		    result.next();
		    for (int j = 0;j<20;j++){
		            for (int i = 0;i<30;i++){    	          	                
		                game.map[i][j] =  Integer.parseInt(result.getObject(i+2).toString());
		                if (Integer.parseInt(result.getObject(i+2).toString()) == 8){ game.setpX(i); game.setpY(j);}}
		            result.next();}	        
		        result.close();
		        state.close();}
		catch (Exception e) { e.printStackTrace();} 	    
		return game;}
	
	

}
