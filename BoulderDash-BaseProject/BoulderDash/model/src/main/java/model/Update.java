package model;

public class Update {
	
	
	
	public static Game updateStone(int pierreX,int pierreY,Game game){
		int pierreBisX = pierreX,pierreBisY = pierreY-1;
    	while((game.map[pierreX][pierreY+1] == 0)&&(pierreY != 18)&&(checkMonster(game,game.map[pierreX][pierreY+1]) == false)){
            game.map[pierreX][pierreY] = 0;
            pierreY++;
            game.map[pierreX][pierreY] = 4;}
        if ((pierreY == 18)&&(game.map[pierreX][pierreY+1] == 0)&&(checkMonster(game,game.map[pierreX][pierreY+1]) == false)){
        	game.map[pierreX][pierreY] = 0;
            pierreY++;
            game.map[pierreX][pierreY] = 4;}
        if (checkMonster(game,game.map[pierreX][pierreY+1]) == true){killMonster(game,pierreX,pierreY+1);}//Kill the mosnter
        if (game.map[pierreBisX][pierreBisY] == 4){updateStone(pierreBisX,pierreBisY,game);}       //Update the stone at the top
        if (game.map[pierreBisX][pierreBisY] == 3){updateDiamond(pierreBisX,pierreBisY,game);}     //Update the diamond at the top
		return game;}

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

	public static boolean checkMonster(Game game,int block)
	{
		boolean monster = false;
		
		if((block == 2)||(block == 6))
		{
			return true;
		}
		
		
		
		
		return monster;
	}

	public static Game killMonster(Game game,int x,int y)
	{
		System.out.println("Kill monster !");
		game.map[x][y] = 0;
		if (game.map[x+1][y] != 2) game.map[x+1][y] = 0;
		if (game.map[x-1][y] != 2)game.map[x-1][y] = 0;
		if (game.map[x][y+1] != 2)game.map[x][y+1] = 0;
		game.map[x][y-1] = 0;
		if (checkMonster(game,game.map[x+1][y]) == true) killMonster(game,x+1,y);
		if (checkMonster(game,game.map[x-1][y]) == true) killMonster(game,x-1,y);
		if (checkMonster(game,game.map[x][y+1]) == true) killMonster(game,x,y+1);
		//updateDiamond(x-1,y,game);
		//updateDiamond(x+1,y,game);
		//updateDiamond(x,y+1,game);	
			return game;
	}
}
