package view;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    
    void creationLevel(int[][] map);
    
    void printScreen(int[][] map,String pos);
    
    void updateScore(int score);
    
    int getKey();
    

    
}
