package controller;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
    	
    	
    	//this.getView().displayMessage(this.getModel().getExampleById(1).toString());
    	//this.getModel().newMapLoading();
    	//this.getView().creationLevel(this.getModel().creationLevel());
    	this.getView().creationLevel(this.getModel().newMapLoading());
    	checkKeyType();
    	
    	  	
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    
    
    /**
     * MY CODE
     */
    public void checkKeyType()
    {
    	int keyType;
    	while( 1 == 1)
    	{
    		
    		keyType = this.getView().getKey();
    		
    		//Up
    		if (keyType == 90)
    		{
    			System.out.println("Up");
    			this.getView().printScreen(this.getModel().up(),"UP");
    			
    		}
    		//Down
    		else if (keyType == 83)
    		{
    			System.out.println("Down");
    			this.getView().printScreen(this.getModel().down(),"UP");
    			
    		}
    		//Left
    		else if (keyType == 81)
    		{
    			System.out.println("Left");
    			this.getView().printScreen(this.getModel().left(),"LEFT");
    			
    		}
    		//Right
    		else if (keyType == 68)
    		{
    			System.out.println("Right");
    			this.getView().printScreen(this.getModel().right(),"RIGHT");
    			
    		}
    		
    		this.getView().updateScore(this.getModel().getScore());
    		
    		try {
				Thread.sleep(20);//A little delay 
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
    	}
    }

    
    
    
}
