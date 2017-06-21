package model;

import model.Update;

public class Movement {
	
	
	
	public static Game up(Game game){
		if (game.pY > 0){
            if ((game.map[game.pX][game.pY-1] != 4)&&(game.map[game.pX][game.pY-1] != 5)){
                if (game.map[game.pX][game.pY-1] == 3){//If a diamond is in front of
                	game.score ++;
                	if (game.score > 9) game.status = "end";}
                game.map[game.pX][game.pY] = 0;//The caracter moove up
                game.pY--;game.step++;
                game.map[game.pX][game.pY] = 8;}}
		return game;}
	
	public static Game down(Game game){
		if (game.pY < 19){
            if ((game.map[game.pX][game.pY+1] != 4)&&(game.map[game.pX][game.pY+1] != 5)){
                if (game.map[game.pX][game.pY+1] == 3){//If a diamond is bellow
                	game.score ++;
                	if (game.score > 9) game.status = "end";}
                game.map[game.pX][game.pY] = 0;//The caracter move
                game.pY++;game.step++;
                game.map[game.pX][game.pY] = 8;}
            if (game.pY-1 > 0){
            	Update.updateDown(game);}}
		return game;}

	public static Game left(Game game){
    	if (game.pX > 0){
    		if ((game.map[game.pX-1][game.pY] == 4)&&(game.map[game.pX-2][game.pY] == 0)){
            	game.map[game.pX-2][game.pY] = 4;game.map[game.pX][game.pY] = 0;game.pX--;game.map[game.pX][game.pY] = 8;
            	Update.updateStone(game.pX-1,game.pY,game);game.step++;}//When the case behind the stop is a tunnel the caracter push
            if ((game.map[game.pX-1][game.pY] != 4)&&(game.map[game.pX-1][game.pY] != 5)){
                if (game.map[game.pX-1][game.pY] == 3){ //IF DIAMOND
                    game.score ++;
                    if (game.score > 9) game.status = "end";}
                game.map[game.pX][game.pY] = 0;//Caracter move
                game.pX--;game.step++;
                game.map[game.pX][game.pY] = 8;}
            if (game.map[game.pX+1][game.pY-1] == 4){//If stone at the top of the last position of player : 
            	Update.updateStone(game.pX+1,game.pY-1,game);}            
            if (game.map[game.pX+1][game.pY-1] == 3){//If diamond at the top of the last position of player : 
            	Update.updateDiamond(game.pX+1,game.pY-1,game);}}
		return game;}
	
	public static Game right(Game game){
			if (game.pX < 29){
			if ((game.map[game.pX+1][game.pY] == 4)&&(game.map[game.pX+2][game.pY] == 0)){
	            game.map[game.pX+2][game.pY] = 4;game.map[game.pX][game.pY] = 0;game.pX++;game.map[game.pX][game.pY] = 8;
	            Update.updateStone(game.pX+1,game.pY,game);game.step++;}//When the case behind the stone is a tunnel the caracter push the stone 
            if ((game.map[game.pX+1][game.pY] != 4)&&(game.map[game.pX+1][game.pY] != 5)){
                if (game.map[game.pX+1][game.pY] == 3){ //IF diamond
                    game.score ++;
                    if (game.score > 9) game.status = "end";}
                game.map[game.pX][game.pY] = 0;//The caracter moove
                game.pX++;game.step++;
                game.map[game.pX][game.pY] = 8;}           
            if (game.map[game.pX-1][game.pY-1] == 4){
            	Update.updateStone(game.pX-1,game.pY-1,game);}
            if (game.map[game.pX-1][game.pY-1] == 3){
            	Update.updateDiamond(game.pX-1,game.pY-1,game);}}
		return game;}


}
