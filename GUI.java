// unsere GUI wird mit Java Swing gemacht
// Tutorial: https://examples.javacodegeeks.com/desktop-java/swing/java-swing-tutorial-beginners/
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Insets;
import java.awt.*;
import javax.swing.border.EmptyBorder;
// GUI: Graphical User Interface
public class GUI
{
    // Bilder: alle Bilder sind im assets Ordner
    // die Bilder sind folgerndermaßen benannt: [FARBE]_[NUMMER] für die Kreuz 2 also 0_2
   
    private Spiel spiel;
    private JFrame frame;
    private JPanel panel;
    private JFrame spielFrame;
    
    public GUI(Spiel spielInConstructor)
    {
       spiel = spielInConstructor;
       main(); 
    }
    
    public void main() {
        frame = new JFrame("Hauptmenü");
        // ImagePanel panel = new ImagePanel("assets/0_2.png");
        panel = new JPanel();
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
        
        // den Buttons Funktionen zuweisen
        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                spielFrame = new JFrame("Spiel");
                spielFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                spielFrame.setSize(350, 250);
                Container pane = spielFrame.getContentPane();
                pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                pane.setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                c.fill = GridBagConstraints.HORIZONTAL;
                spielFrame.setVisible(true);
                zeigeKartenVomErstenSpieler(pane, c);
            }
        });
        jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        
    }
    private void zeigeKartenVomErstenSpieler(Container pane, GridBagConstraints c) {
        Spieler ersterSpieler = spiel.spieler[0];
        for (int i = 0; i < ersterSpieler.karten.length; i++) {
            Karte karte = ersterSpieler.karten[i];
            String pfad = "assets/" + Integer.toString(karte.farbe) + "_" + Integer.toString(karte.nummer) + ".png";
            ImagePanel panel = new ImagePanel(pfad);
            BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
            //panel.setLayout(boxlayout);
            panel.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = i * 10;
            c.gridy = i * 10;
           spielFrame.add(panel, c);
            
        }
    }
}
