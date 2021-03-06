package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.sprite.*;

public class printer extends JFrame {
	
	private static Blockk texture = new Blockk();
	
	private static final long serialVersionUID = 1L;

	/**
	 * Print for the first time the screen
	 * 
	 * @param map	map
	 * @param pX	pX
	 * @param pY	pY
	 * @param block	block
	 * @return block	The map of texture
	 */
	
	
	public static JLabel[][] creation(int[][] map,int pX,int pY,JLabel[][] block){
    	System.out.println("Loading Texture...");
    	int x = 0,y=0,w = 0,v = 0,floor = 0;//Creation of variables
    	for (int i = 0;i<15;i++){//Filling the the board of sprite with the texture
    		int j = 0;
    		for (j= 0;j<15;j++){
    			try {floor = map[w+pX-7][v+pY-7];}//Try to read the block of the map
            	catch(ArrayIndexOutOfBoundsException e){floor = 1;}//Else the block is out of the board set the floor at 1
    			block[i][j].setBounds(x,y,32,32);//Set the location of the block on the screen
    			if (floor == 8){block[i][j].setIcon(new ImageIcon(texture.getUp()));}
                if (floor == 0){block[i][j].setIcon(new ImageIcon(texture.getTunnel()));}
                if (floor == 1){block[i][j].setIcon(new ImageIcon(texture.getCobble()));}
                if (floor == 3){block[i][j].setIcon(new ImageIcon(texture.getDiamond()));}
                if (floor == 4){block[i][j].setIcon(new ImageIcon(texture.getStone()));}
                if (floor == 5){block[i][j].setIcon(new ImageIcon(texture.getWall()));}
                if (floor == 2){block[i][j].setIcon(new ImageIcon(texture.getMonster1()));}
                if (floor == 6){block[i][j].setIcon(new ImageIcon(texture.getMonster2()));}
                if (floor == 7){block[i][j].setIcon(new ImageIcon(texture.getMonster3()));}
                y +=32;v++;}
    		w++;v = 0;x += 32;y = 0;}		
		return block;}
	
	/**
	 * Print the screen with the map around the player;
	 * 
	 * 
	 * @param map	map
	 * @param pX	pX
	 * @param pY	pY
	 * @param block	block
	 * @param pos	pos
	 * @return block	The map of texture
	 */
	
	
	public static JLabel[][] print(int[][] map,int pX,int pY,JLabel[][] block,String pos){
		int floor = 0,w = 0, v = 0;
		for (int i = 0;i<15;i++){//Filling the the board of sprite with the texture
    		int j = 0;
    		for (j= 0;j<15;j++){
    			try {floor = map[w+pX-7][v+pY-7];}//Try to read the block of the map
            	catch(ArrayIndexOutOfBoundsException e){floor = 1;}//Else the block is out of the board set the floor at 1
    			if (floor == 8){//Set the sprite of caracter in depend of the last direction
    				if (pos == "LEFT") block[i][j].setIcon(new ImageIcon(texture.getLeft()));
    				else if (pos == "RIGHT") block[i][j].setIcon(new ImageIcon(texture.getRight()));
    				else if (pos == "UP") block[i][j].setIcon(new ImageIcon(texture.getUp()));}
                if (floor == 0){block[i][j].setIcon(new ImageIcon(texture.getTunnel()));}
                if (floor == 1){block[i][j].setIcon(new ImageIcon(texture.getCobble()));}
                if (floor == 3){block[i][j].setIcon(new ImageIcon(texture.getDiamond()));}
                if (floor == 4){block[i][j].setIcon(new ImageIcon(texture.getStone()));}
                if (floor == 5){block[i][j].setIcon(new ImageIcon(texture.getWall()));}
                if (floor == 2){block[i][j].setIcon(new ImageIcon(texture.getMonster1()));}
                if (floor == 6){block[i][j].setIcon(new ImageIcon(texture.getMonster2()));}
                if (floor == 7){block[i][j].setIcon(new ImageIcon(texture.getMonster3()));}
                if (floor == 9){block[i][j].setIcon(new ImageIcon(texture.getMonster4()));}
                ;v++;}
    		w++;v = 0;}
		return block;}
	
}
