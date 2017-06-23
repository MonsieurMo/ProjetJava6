package model.movement;

import model.Game;
import model.monster.Monster;

public class Update {
	
	
	/**
	 * Update a stone when she fall
	 * @param stoneX
	 * @param stoneY
	 * @param game
	 * @return game
	 */
	public static Game updateStone(int stoneX,int stoneY,Game game){
		int stoneBisX = stoneX,stoneBisY = stoneY-1;
    	while((game.map[stoneX][stoneY+1] == 0)&&(stoneY != 18)&&(checkMonster(game,game.map[stoneX][stoneY+1]) == false)){
            game.map[stoneX][stoneY] = 0;
            stoneY++;
            game.map[stoneX][stoneY] = 4;}
        if ((stoneY == 18)&&(game.map[stoneX][stoneY+1] == 0)&&(checkMonster(game,game.map[stoneX][stoneY+1]) == false)){
        	game.map[stoneX][stoneY] = 0;
            stoneY++;
            game.map[stoneX][stoneY] = 4;}
        if (checkMonster(game,game.map[stoneX][stoneY+1]) == true){killMonster(game,stoneX,stoneY+1);}//Kill the monster
        if (game.map[stoneBisX][stoneBisY] == 4){updateStone(stoneBisX,stoneBisY,game);}       //Update the stone at the top
        if (game.map[stoneBisX][stoneBisY] == 3){updateDiamond(stoneBisX,stoneBisY,game);}     //Update the diamond at the top
		return game;}

	/**
	 * Update a diamond when he fall
	 * @param diamondX
	 * @param diamondY
	 * @param game
	 * @return game
	 */
	public static Game updateDiamond(int diamondX,int diamondY,Game game){
		int diamondBisX = diamondX,diamondBisY = diamondY-1;
    	while((game.map[diamondX][diamondY+1] == 0)&&(diamondY != 18)&&(checkMonster(game,game.map[diamondX][diamondY+1]) == false)){
            game.map[diamondX][diamondY] = 0;
            diamondY++;
            game.map[diamondX][diamondY] = 3;}
        if ((diamondY == 18)&&(game.map[diamondX][diamondY+1] == 0)&&(checkMonster(game,game.map[diamondX][diamondY+1]) == false)){
        	game.map[diamondX][diamondY] = 0;
        	diamondY++;
            game.map[diamondX][diamondY] = 3;}
        if (checkMonster(game,game.map[diamondX][diamondY+1]) == true){killMonster(game,diamondX,diamondY+1);}//Kill the mosnter
        if (game.map[diamondBisX][diamondBisY] == 4){updateStone(diamondBisX,diamondBisY,game);}        
        if (game.map[diamondBisX][diamondBisY] == 3){updateDiamond(diamondBisX,diamondBisY,game);}	
		return game;}

	/**
	 * Update the game when the character move down
	 * @param game
	 * @return game
	 */
	public static Game updateDown(Game game)
	{
        if  (game.map[game.pX][game.pY-2] == 4){//IF stone at the top
            game.map[game.pX][game.pY-2] = 0;
            game.map[game.pX][game.pY-1] = 4;
            game.status = "die";
            }//END OF THE GAME
        if  (game.map[game.pX][game.pY-2] == 3){//IF diamond at the top
            game.map[game.pX][game.pY-2] = 0;
            game.map[game.pX][game.pY-1] = 3;
            game.status = "die";
        }//END OF GAME
        return game;}

	/**
	 * Check if a monster is under the stone or diamond
	 * @param game
	 * @param block
	 * @return game
	 */
	public static boolean checkMonster(Game game,int block)
	{
		boolean monster = false;
		
		if((block == 2)||(block == 6)||(block == 7)||(block == 9))
		{
			return true;
		}
		
		
		
		
		return monster;
	}

	/**
	 * kill a monster on the map
	 * @param game
	 * @param x
	 * @param y
	 * @return game
	 */
	public static Game killMonster(Game game,int x,int y)
	{
		deleteMonster(game,x,y);
		game.map[x][y] = 0;
		if (game.map[x+1][y] != 2) game.map[x+1][y] = 0;
		if (game.map[x-1][y] != 2)game.map[x-1][y] = 0;
		if (game.map[x][y+1] != 2)game.map[x][y+1] = 0;
		game.map[x][y-1] = 0;
		if (checkMonster(game,game.map[x+1][y]) == true) killMonster(game,x+1,y);if (checkMonster(game,game.map[x-1][y]) == true) killMonster(game,x-1,y);
		if (checkMonster(game,game.map[x][y+1]) == true) killMonster(game,x,y+1);
			return game;}


	/**
	 * Delete a monster of the game when he is kill
	 * @param game
	 * @param x
	 * @param y
	 * @return game
	 */
	public static Game deleteMonster(Game game,int x,int y)
	{
		//Search in the list the ennemy at this position and delete him
		for(int i = 0; i < game.monster2.size(); i++)//Monster 2 
		{
			Monster monst = (Monster) game.monster2.get(i);
			if ((x == monst.getX())&&(y == monst.getY())) game.monster2.remove(i);     //Delete this monster of the list
		}
		for(int i = 0; i < game.monster3.size(); i++)//Monster 3
		{
			Monster monst = (Monster) game.monster3.get(i);
			if ((x == monst.getX())&&(y == monst.getY())) game.monster3.remove(i);     //Delete this monster of the list
		}
		for(int i = 0; i < game.monster4.size(); i++)//Monster 3
		{
			Monster monst = (Monster) game.monster4.get(i);
			if ((x == monst.getX())&&(y == monst.getY())) game.monster4.remove(i);     //Delete this monster of the list
		}
		return game;
	}
	
	}
