package view;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends JFrame implements IView,KeyListener {

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
        System.out.println("Création of window...");
      
    	
    	this.setFocusable(true);

        this.setTitle("Score : 0");
        this.setSize(980,680);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);


        this.setContentPane(panel);
        panel.setLayout(null);
        
        this.setVisible(true);
    }
    
    
    

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
        
    }
    
    
    /**
     * My CODE
     */
    
    //Attribut
    JPanel panel = new JPanel();
    JLabel[][] block = new JLabel[30][20];
    private int keyType;
    private boolean Press = false;
    
    public void creationLevel(int[][] map)//Take the map and assign the texture
    {
    	//ASssign the texture
    	System.out.println("Loading Texture...");
    	int x = 0,y=0;
        for (int i = 0;i<30;i++)
        {
            for (int j = 0;j<20;j++)
            {
                
                block[i][j] = new JLabel();
                block[i][j].setBounds(x,y,32,32);
                if (map[i][j] == 8)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\caracter.png"));
                }
                if (map[i][j] == 0)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\noir.png"));
                }
                if (map[i][j] == 1)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\dirt.png"));
                }
                if (map[i][j] == 3)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\diamant.png"));
                }
                if (map[i][j] == 4)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\stone.png"));
                }
                if (map[i][j] == 5)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\bedrock.png"));
                }
                panel.add(block[i][j]);
                y +=32;
            }
            x += 32;
            y = 0;
        }
        this.repaint();
        System.out.println("Loading Texture ended");
        
        //Keylistener
        this.addKeyListener(this);
        this.requestFocus();
    }
    
    public void updateScore(int score)
    {
    	this.setTitle("Score : " + score);
    }
    
    public void printScreen(int[][] map,String pos)
    {
    	int x = 0,y=0;
        for (int i = 0;i<30;i++)
        {
            for (int j = 0;j<20;j++)
            {
                
                if (map[i][j] == 8)
                {
                	if (pos == "UP")
                		block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\caracter.png"));
                	else if (pos == "LEFT")
                		block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\LEFT.png"));
                	else if (pos == "RIGHT")
                		block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\RIGHT.png"));
                	else 
                		block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\caracter.png"));
                }
                if (map[i][j] == 0)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\noir.png"));
                }
                if (map[i][j] == 1)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\dirt.png"));
                }
                if (map[i][j] == 3)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\diamant.png"));
                }
                if (map[i][j] == 4)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\stone.png"));
                }
                if (map[i][j] == 5)
                {
                	block[i][j].setIcon(new ImageIcon("C:\\Users\\Etienne\\Documents\\GITHUB\\ProjetJava6\\textures\\bedrock.png"));
                } 
                y +=32;
            }
            x += 32;
            y = 0;
        }
        this.repaint();
    }
    
    public int getKey()
    { 
    	if (this.Press == true)
    	{
    		this.Press = false;
    		return this.keyType;
    	}
    	
    	return 0;
    }
    
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
    	this.Press = true;
    	this.keyType = e.getKeyCode();

       
    }

    public void keyReleased(KeyEvent e) {

    }
    
   

}
