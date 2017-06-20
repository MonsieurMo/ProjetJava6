package model;

public class Update {
	
	
	
	public static Game updateStone(int pierreX,int pierreY,Game game){
		int pierreBisX = pierreX,pierreBisY = pierreY-1;
    	while((game.map[pierreX][pierreY+1] == 0)&&(pierreY != 18)){
            game.map[pierreX][pierreY] = 0;
            pierreY++;
            game.map[pierreX][pierreY] = 4;}
        if ((pierreY == 18)&&(game.map[pierreX][pierreY+1] == 0)){
        	game.map[pierreX][pierreY] = 0;
            pierreY++;
            game.map[pierreX][pierreY] = 4;}        
        if (game.map[pierreBisX][pierreBisY] == 4){updateStone(pierreBisX,pierreBisY,game);}       
        if (game.map[pierreBisX][pierreBisY] == 3){updateDiamond(pierreBisX,pierreBisY,game);}		
		return game;}

	public static Game updateDiamond(int diamondX,int diamondY,Game game){
		int diamondBisX = diamondX,diamondBisY = diamondY-1;
    	while((game.map[diamondX][diamondY+1] == 0)&&(diamondY != 18)){
            game.map[diamondX][diamondY] = 0;
            diamondY++;
            game.map[diamondX][diamondY] = 3;}
        if ((diamondY == 18)&&(game.map[diamondX][diamondY+1] == 0)){
        	game.map[diamondX][diamondY] = 0;
        	diamondY++;
            game.map[diamondX][diamondY] = 3;}
        if (game.map[diamondBisX][diamondBisY] == 4){updateStone(diamondBisX,diamondBisY,game);}        
        if (game.map[diamondBisX][diamondBisY] == 3){updateDiamond(diamondBisX,diamondBisY,game);}	
		return game;}

	public static Game updateDown(Game game)
	{
        if  (game.map[game.pX][game.pY-2] == 4){//IF stone at the top
            game.map[game.pX][game.pY-2] = 0;
            game.map[game.pX][game.pY-1] = 4;
            }//END OF THE GAME
        if  (game.map[game.pX][game.pY-2] == 3){//IF diamond at the top
            game.map[game.pX][game.pY-2] = 0;
            game.map[game.pX][game.pY-1] = 3;
        }//END OF GAME
        return game;}
}
