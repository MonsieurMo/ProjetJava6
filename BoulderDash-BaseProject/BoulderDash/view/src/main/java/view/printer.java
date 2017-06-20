package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class printer extends JFrame {
	
	public static JLabel[][] creation(int[][] map,int pX,int pY,JLabel[][] block){
    	System.out.println("Loading Texture...");
    	int x = 0,y=0,w = 0,v = 0,floor = 0;//Creation of variables
    	for (int i = 0;i<15;i++){//Filling the the board of sprite with the texture
    		int j = 0;
    		for (j= 0;j<15;j++){
    			try {floor = map[w+pX-7][v+pY-7];}//Try to read the block of the map
            	catch(ArrayIndexOutOfBoundsException e){floor = 1;}//Else the block is out of the board set the floor at 1
    			block[i][j].setBounds(x,y,32,32);//Set the location of the block on the screen
    			if (floor == 8){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\caracter.png"));}
                if (floor == 0){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\noir.png"));}
                if (floor == 1){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\dirt.png"));}
                if (floor == 3){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\diamant.png"));}
                if (floor == 4){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\stone.png"));}
                if (floor == 5){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\bedrock.png"));}
                y +=32;v++;}
    		w++;v = 0;x += 32;y = 0;}		
		return block;}
	
	public static JLabel[][] print(int[][] map,int pX,int pY,JLabel[][] block,String pos){
		int floor = 0,w = 0, v = 0;
		for (int i = 0;i<15;i++){//Filling the the board of sprite with the texture
    		int j = 0;
    		for (j= 0;j<15;j++){
    			try {floor = map[w+pX-7][v+pY-7];}//Try to read the block of the map
            	catch(ArrayIndexOutOfBoundsException e){floor = 1;}//Else the block is out of the board set the floor at 1
    			if (floor == 8){//Set the sprite of caracter in depend of the last direction
    				if (pos == "UP") block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\caracter.png"));
    				else if (pos == "LEFT") block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\LEFT.png"));
    				else if (pos == "RIGHT") block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\RIGHT.png"));
    				else block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\caracter.png"));}
                if (floor == 0){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\noir.png"));}
                if (floor == 1){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\dirt.png"));}
                if (floor == 3){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\diamant.png"));}
                if (floor == 4){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\stone.png"));}
                if (floor == 5){block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\bedrock.png"));}
                ;v++;}
    		w++;v = 0;}
		return block;}
	
}
