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
	
	static Game updateMonster4(Game game)
	{
		for(int i = 0; i < game.monster4.size(); i++){
			Monster monst = (Monster) game.monster4.get(i);
			int x = monst.getX();int y = monst.getY();
			Random r = new Random();
			int t = 0 + r.nextInt(5 - 0);
			if((monst.getCount() < 6)&&(monst.getCount() > 1))
			{
				if ((t == 1 )&&(game.map[x][y-1] == 0)||(game.map[x][y-1] == 8)){			
				game.map[x][y] = 0;
				if (game.map[x][y-1] == 8) game.status = "die";
				y--; 
				game.map[x][y] = 9;		
				}     //UP
			else if ((t == 2 )&&(game.map[x][y+1] == 0)||(game.map[x][y+1] == 8)){
				game.map[x][y] = 0;
				if (game.map[x][y+1] == 8) game.status = "die";
				y++; 
				game.map[x][y] = 9;				
				}   //DOWN
			else if ((t == 3 )&&(game.map[x-1][y] == 0)||(game.map[x-1][y] == 8)){
				game.map[x][y] = 0;
				if (game.map[x-1][y] == 8) game.status = "die";
				x--; 
				game.map[x][y] = 9;	
				}   //LEFT
			else if ((t == 4 )&&(game.map[x+1][y] == 0)||(game.map[x+1][y] == 8)){
				game.map[x][y] = 0;
				if (game.map[x+1][y] == 8) game.status = "die";
				x++; 
				game.map[x][y] = 9;			
				}//RIGHT
			monst.setX(x);monst.setY(y);
			System.out.println(monst.getCount());
			monst.setCount(monst.getCount()+1);
			game.monster4.set(i,monst);
			}
			else if(monst.getCount() > 5)
			{
				game.map[x][y] = 5;
				game.monster4.remove(i);
			}
			else{monst.setCount(monst.getCount()+1);}
			
				
		}	
		return game;
	}
	
	
static Game updateMonster(Game game)
	{
		if (game.time + 300 < System.currentTimeMillis() ){
			game.time = System.currentTimeMillis();
			updateMonster2(game);
			updateMonster3(game);		
			updateMonster4(game);
		}
			
		return game;
	}


	static Game createMonster4(Game game,String direction)
	{
		Random r = new Random();
		int y = 0 + r.nextInt(100 - 0);
		if (y < 6)
		{
			if(direction == "up"){game.monster4.add(new Monster(game.pX,game.pY+1));game.map[game.pX][game.pY+1] = 9;}
			if(direction == "down"){game.monster4.add(new Monster(game.pX,game.pY-1));game.map[game.pX][game.pY-1] = 9;}
			if(direction == "right"){game.monster4.add(new Monster(game.pX-1,game.pY));game.map[game.pX-1][game.pY] = 9;}
			if(direction == "left"){game.monster4.add(new Monster(game.pX+1,game.pY));game.map[game.pX+1][game.pY] = 9;}
			System.out.println("Spawn silver Fish");
		}	
		return game;
	}
}
