import java.util.*;

public class Spiel
{
    private int anzahlSpieler;
    private int anzahlKartenInsgesamt = 52;
    private int anzahlStartkarten;
    private Spieler[] spieler;
    private Karte[] nachziehstapel;
    

   
    public Spiel(int anzahlSpielerInConstructor, int anzahlStartkartenInConstructor)
    {
        anzahlSpieler = anzahlSpielerInConstructor;
        anzahlStartkarten = anzahlStartkartenInConstructor;
        kartenAufteilen();
    }
    
    public void kartenAufteilen() {
        Karte[] alleKarten = new Karte(0, 0).kartensetGeben();
        kartensetMischen(alleKarten);
        int zähler = alleKarten.length - 1;
        for (int i = 0; i < anzahlSpieler; i ++) {
            Karte[] kartenDesSpielers = {};
            for (int j = 0; j < anzahlStartkarten; j++) {
                kartenDesSpielers[j] = new Karte(alleKarten[zähler].farbe, alleKarten[zähler].nummer);
                alleKarten[zähler] = null;
                zähler = zähler - 1;
            }
            spieler[i] = new Spieler(anzahlStartkarten, kartenDesSpielers);
        
        }
        nachziehstapel = alleKarten;
        
        
    
    }
    
    public void kartensetMischen(Karte[] set) {
        Random rand = new Random();
        
        for (int i = 0; i < set.length; i++) {
            int randomIndexToSwap = rand.nextInt(set.length);
            Karte temp = set[randomIndexToSwap];
            set[randomIndexToSwap] = set[i];
            set[i] = temp;
        }
        
    }
}
