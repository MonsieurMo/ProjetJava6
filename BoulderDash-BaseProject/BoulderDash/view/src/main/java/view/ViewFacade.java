package view;

import javax.swing.*;

import java.awt.event.KeyEvent;//For KeyEvent
import java.awt.event.KeyListener;//For KeyListener
import java.util.Observable;
import java.util.Observer;

import view.printer;


/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends JFrame implements IView,KeyListener,Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//SET THE ATTRIBUTES
    JPanel panel = new JPanel(); //Creation of panel
    JLabel[][] block = new JLabel[30][20]; //creation of the board who stock the sprites
    private int keyType;//Creation of the varibales who stock the code of the KeyPressed
    private boolean Press = false;//Define if a key was pressed recently
    
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {//CONSTRUCTOR
        super();
        System.out.println("Création of window...");  	
    	this.setFocusable(true);
        this.setTitle("Score : 0");//Set of title
        this.setSize(486,509);//Set of the size
        this.setLocationRelativeTo(null);//Spawn the frame at the center of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Now the bouton exit , end the program.
        this.setResizable(false);//The frame is not Resizable
        this.setContentPane(panel);//ADD the panel at the frame
        panel.setLayout(null);//Set the layout at null for use a personaly layout panel.   
        this.setVisible(true);//The frame is now visible for the user
        for (int i=0;i<15;i++){
        	int j = 0;
        	for (j = 0;j<15;j++)
        	{block[i][j] = new JLabel();//Creation of the item of the screen.
        	panel.add(block[i][j]);}}//Add the item in the panel
    }
        
    public void creationLevel(int[][] map,int pX, int pY)//Take the map and assign the texture
    {
    	block = printer.creation(map, pX, pY,block);
        this.repaint();
        
        //Keylistener
        this.addKeyListener(this);//ADD the Keylistener at the Frame
        this.requestFocus();//Set the focus on the frame
    }
    
    public void updateScore(int score) //Update the score
    {
    	this.setTitle("Score : " + score);
    }
    
    public void printScreen(int[][] map,String pos,int pX,int pY)
    {
    	printer.print(map, pX, pY, block,pos);
        this.repaint();
    }
    
    public int getKey()//Get the Keykode of the last Key pressed when the controller not have an action in traitment
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

    public void keyPressed(KeyEvent e) {//Give the KeyCode of the KeyPressed
    	this.Press = true;
      	this.keyType = e.getKeyCode();

       
    }

    public void keyReleased(KeyEvent e) {

    }

    public void update(Observable obs, Object obj) {
    	
    }
    
    public void updateStatus(String status)
    {
    	if (status == "die"){
    		JOptionPane pan = new JOptionPane();
    		pan.showMessageDialog(null, "Vous etes morts", "Fin de la partie", JOptionPane.ERROR_MESSAGE);
    		System.exit(0);
    	}
    	if (status == "end"){
    		JOptionPane pan = new JOptionPane();
    		pan.showMessageDialog(null, "Vous avez collecter 10 diamants, Félicitation !", "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
    		System.exit(0);
    	}
    }

}
