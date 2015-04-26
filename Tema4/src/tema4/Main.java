/*
 * clasa Main unde se activeaza primul frame si se apeleaza metoda de populare a hashtable-ului cu date din fisier
 */
package tema4;

/**
 *
 * @author Ariana
 */
public class Main {
    static ReadFile obj=new ReadFile();
    static FirstFrame frame=new FirstFrame();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        obj.hashPopulate();
        frame.setVisible(true);
        
    }
    
}
