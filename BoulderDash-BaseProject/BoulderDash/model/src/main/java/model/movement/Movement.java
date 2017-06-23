package model.movement;

import model.Game;
import model.monster.MonsterUpdate;
import model.movement.Update;

/**
 * Moves the player
 * @author Etienne
 *
 */
public class Movement {
	
	
	/**
	 * Update the position of character when  he move up
	 * @param game
	 * @return game
	 */
	public static Game up(Game game){
		if (game.pY > 0){
            if ((game.map[game.pX][game.pY-1] != 4)&&(game.map[game.pX][game.pY-1] != 5)){
                if (game.map[game.pX][game.pY-1] == 3){//If a diamond is in front of
                	game.score ++;
                	if (game.score > 9) game.status = "end";}
                if ((game.map[game.pX][game.pY-1] == 2)||(game.map[game.pX][game.pY-1] == 6)||(game.map[game.pX][game.pY-1] == 7)||(game.map[game.pX][game.pY-1] == 9))game.status = "die";//If the character hit a monster
                game.map[game.pX][game.pY] = 0;//The character move up
                game.pY--;game.step++;
                game.map[game.pX][game.pY] = 8;
                MonsterUpdate.createMonster4(game,"up");}}
		return game;}
	
	/**
	 * Update the position of character when  he move down
	 * @param game
	 * @return game
	 */
	public static Game down(Game game){
		if (game.pY < 19){
            if ((game.map[game.pX][game.pY+1] != 4)&&(game.map[game.pX][game.pY+1] != 5)){
                if (game.map[game.pX][game.pY+1] == 3){//If a diamond is bellow
                	game.score ++;
                	if (game.score > 9) game.status = "end";}
                if ((game.map[game.pX][game.pY+1] == 2)||(game.map[game.pX][game.pY+1] == 6)||(game.map[game.pX][game.pY+1] == 7)||(game.map[game.pX][game.pY+1] == 9))game.status = "die";//If the character hit a monster
                game.map[game.pX][game.pY] = 0;//The character move
                game.pY++;game.step++;
                game.map[game.pX][game.pY] = 8;
                MonsterUpdate.createMonster4(game,"down");}
            if (game.pY-1 > 0){
            	Update.updateDown(game);}}
		return game;}

	/**
	 * Update the position of character when  he move left
	 * @param game
	 * @return game
	 */
	public static Game left(Game game){
    	if (game.pX > 0){
    		if ((game.map[game.pX-1][game.pY] == 4)&&(game.map[game.pX-2][game.pY] == 0)){
            	game.map[game.pX-2][game.pY] = 4;game.map[game.pX][game.pY] = 0;game.pX--;game.map[game.pX][game.pY] = 8;
            	Update.updateStone(game.pX-1,game.pY,game);game.step++;}//When the case behind the stop is a tunnel the caracter push
            if ((game.map[game.pX-1][game.pY] != 4)&&(game.map[game.pX-1][game.pY] != 5)){
                if (game.map[game.pX-1][game.pY] == 3){ //IF DIAMOND
                    game.score ++;if (game.score > 9) game.status = "end";}
                if ((game.map[game.pX-1][game.pY] == 2)||(game.map[game.pX-1][game.pY] == 6)||(game.map[game.pX-1][game.pY] == 7)||(game.map[game.pX-1][game.pY] == 9))game.status = "die";//If the character hit a monster
                game.map[game.pX][game.pY] = 0;//Character move
                game.pX--;game.step++;
                game.map[game.pX][game.pY] = 8;
                MonsterUpdate.createMonster4(game,"left");}
            if (game.map[game.pX+1][game.pY-1] == 4){//If stone at the top of the last position of player : 
            	Update.updateStone(game.pX+1,game.pY-1,game);}            
            if (game.map[game.pX+1][game.pY-1] == 3){//If diamond at the top of the last position of player : 
            	Update.updateDiamond(game.pX+1,game.pY-1,game);}}
		return game;}
	
	/**
	 * Update the position of character when  he move right
	 * @param game
	 * @return game
	 */
	public static Game right(Game game){
			if (game.pX < 29){
			if ((game.map[game.pX+1][game.pY] == 4)&&(game.map[game.pX+2][game.pY] == 0)){
	            game.map[game.pX+2][game.pY] = 4;game.map[game.pX][game.pY] = 0;game.pX++;game.map[game.pX][game.pY] = 8;
	            Update.updateStone(game.pX+1,game.pY,game);game.step++;}//When the case behind the stone is a tunnel the caracter push the stone 
            if ((game.map[game.pX+1][game.pY] != 4)&&(game.map[game.pX+1][game.pY] != 5)){
                if (game.map[game.pX+1][game.pY] == 3){ //IF diamond
                    game.score ++;
                    if (game.score > 9) game.status = "end";}
                if (( game.map[game.pX+1][game.pY]== 2 )||(game.map[game.pX+1][game.pY]== 6)||(game.map[game.pX+1][game.pY]== 7)||(game.map[game.pX+1][game.pY]== 9))game.status = "die";//If a character hit a monster
                game.map[game.pX][game.pY] = 0;//The character moove
                game.pX++;game.step++;
                game.map[game.pX][game.pY] = 8;
                MonsterUpdate.createMonster4(game,"right");}           
            if (game.map[game.pX-1][game.pY-1] == 4){
            	Update.updateStone(game.pX-1,game.pY-1,game);}
            if (game.map[game.pX-1][game.pY-1] == 3){
            	Update.updateDiamond(game.pX-1,game.pY-1,game);}}
		return game;}


}
