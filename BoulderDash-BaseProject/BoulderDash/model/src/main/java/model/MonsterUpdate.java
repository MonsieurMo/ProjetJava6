package model;

import java.util.Random;

public class MonsterUpdate {
	

	static Game updateMonster2(Game game){
			for(int i = 0; i < game.monster2.size(); i++){
				Monster monst = (Monster) game.monster2.get(i);//Get the mosnter
				int x = monst.getX();
				int y = monst.getY();
				Random r = new Random();
				int yy = 0 + r.nextInt(19 - 0);int xx = 0 + r.nextInt(19 - 0);
				if (game.map[xx][yy] == 0){
					game.map[x][y] = 0;game.map[xx][yy] = 6;
					monst.setX(xx);monst.setY(yy);
					game.monster2.set(i,monst);}}
		return game;}

	static Game updateMonster3(Game game){
		for(int i = 0; i < game.monster3.size(); i++){
			Monster monst = (Monster) game.monster3.get(i);//Get the mosnter
			int x = monst.getX();int y = monst.getY();
			if (monst.getDirection() == "up"){if ((game.map[x-1][y] == 0)||(game.map[x-1][y] == 8)){if (game.map[x-1][y] == 8) game.status = "die";
				game.map[x][y] = 0; x--;game.map[x][y] = 7;}else monst.setDirection("right");}
			if (monst.getDirection() == "right"){if ((game.map[x][y+1] == 0)||(game.map[x][y+1] == 8)){if(game.map[x][y+1] == 8) game.status = "die";
				game.map[x][y] = 0; y++;game.map[x][y] = 7;}
				else monst.setDirection("down");}
			if (monst.getDirection() == "down"){if ((game.map[x+1][y] == 0)||(game.map[x+1][y] == 8)){
					if (game.map[x+1][y] == 8) game.status = "die";game.map[x][y] = 0; x++;game.map[x][y] = 7;}
				else monst.setDirection("left");}
			if (monst.getDirection() == "left"){if ((game.map[x][y-1] == 0)||(game.map[x][y-1] == 8)){if (game.map[x][y-1] == 8) game.status = "die";
					game.map[x][y] = 0; y--;game.map[x][y] = 7;}
				else monst.setDirection("up");}	
			monst.setX(x);monst.setY(y);
			game.monster3.set(i, monst);}
		return game;}
	
	static Game updateMonster(Game game)
	{
		if (game.time + 300 < System.currentTimeMillis() ){
			game.time = System.currentTimeMillis();
			updateMonster2(game);
			updateMonster3(game);		
		}
			
		return game;
	}

}
