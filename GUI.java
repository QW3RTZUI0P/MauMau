// unsere GUI wird mit Java Swing gemacht
// Tutorial: https://examples.javacodegeeks.com/desktop-java/swing/java-swing-tutorial-beginners/
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;
// GUI: Graphical User Interface
public class GUI
{
    // Bilder: alle Bilder sind im assets Ordner
    // die Bilder sind folgerndermaßen benannt: [FARBE]_[NUMMER] für die Kreuz 2 also 0_2
   
    private Spiel spiel;
    
    public GUI(Spiel spielInConstructor)
    {
       spiel = spielInConstructor;
       main(); 
    }
    
    public static void main() {
        JFrame frame = new JFrame("Hauptmenü");
        // ImagePanel panel = new ImagePanel("assets/0_2.png");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Herzlich willkommen! Bitte wählen Sie keine Option!", JLabel.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setVisible(true);
        // frame.add(panel);
        frame.add(label);
        // Setting for the panel
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));
        
        // Define new buttons
        JButton jb1 = new JButton("Spiel starten");
        JButton jb2 = new JButton("Einstellungen");      
        JButton jb3 = new JButton(";(");
        
        // Add buttons to the frame (and spaces between buttons)
        panel.add(jb1); 
        panel.add(jb2);
        panel.add(jb3);
        
        // Add the label and panel to the frame
        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);
        
        // Settings for the frame
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
