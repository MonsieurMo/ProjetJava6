package model;

import java.util.Random;

public class Monster {
	

	static Game updateMonster(Game game)
	{
		if (game.time + 300 < System.currentTimeMillis() ){
			game.time = System.currentTimeMillis();
			for(int i = 0; i < game.monster2.size(); i++){
				game.time = System.currentTimeMillis();
				
				Monster2 monst = (Monster2) game.monster2.get(i);//Get the mosnter
				int x = monst.getX();
				int y = monst.getY();
				
				Random r = new Random();
				int yy = 0 + r.nextInt(19 - 0);
				int xx = 0 + r.nextInt(19 - 0);
				
				if (game.map[xx][yy] == 0)
				{
					game.map[x][y] = 0;
					game.map[xx][yy] = 6;
					
					monst.setX(xx);
					monst.setY(yy);
				}
				
				game.monster2.set(i,monst);
			  }
		}
		return game;
	}
	
	
	
	

}
