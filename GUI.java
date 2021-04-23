// unsere GUI wird mit Java Swing gemacht
// Tutorial: https://examples.javacodegeeks.com/desktop-java/swing/java-swing-tutorial-beginners/
import javax.swing.*;
// GUI: Graphical User Interface
public class GUI
{
    // Bilder: alle Bilder sind im assets Ordner
    // die Bilder sind folgerndermaßen benannt: [FARBE]_[NUMMER] für die Kreuz 2 also 0_2
   
    public GUI()
    {
       main(); 
    }
    
    public static void main() {
        JFrame frame = new JFrame("Hello Swing");
        ImagePanel panel = new ImagePanel("assets/0_2.png");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setVisible(true);
        frame.add(panel);
    }
}
