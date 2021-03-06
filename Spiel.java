import java.util.*;

public class Spiel
{
    private GUI gui;
    // am besten höchstens 6 Spieler
    private int anzahlSpieler;
    private int anzahlKartenInsgesamt = 52;
    private int anzahlStartkarten;
    public Spieler[] spieler;
    private Karte[] nachziehstapel;
    // Variable Werte, die sich während des Spiels ändern
    // Nummer des aktuellen Startspielers
    private int startspieler;
    private Karte obersteKarte;
    

   
    public Spiel(int anzahlSpielerInConstructor, int anzahlStartkartenInConstructor)
    {
        
        anzahlSpieler = anzahlSpielerInConstructor;
        anzahlStartkarten = anzahlStartkartenInConstructor;
        startspieler = 0;
        spieler = new Spieler[anzahlSpielerInConstructor];
        kartenAufteilenUndSpielerErstellen();
        gui = new GUI(this);
    }
    
    public void kartenAufteilenUndSpielerErstellen() {
        Karte[] alleKarten = new Karte(0, 0).kartensetGeben();
        // kartensetMischen(alleKarten);
        int zähler = alleKarten.length - 1;
        for (int i = 0; i < anzahlSpieler; i ++) {
            Karte[] kartenDesSpielers;
            kartenDesSpielers = new Karte[anzahlStartkarten];
            for (int j = 0; j < anzahlStartkarten; j++) {
                kartenDesSpielers[j] = new Karte(alleKarten[zähler].farbe, alleKarten[zähler].nummer);
                alleKarten[zähler] = new Karte(0,0);
                zähler = zähler - 1;
            }
            spieler[i] = new Spieler(i, this, anzahlStartkarten, kartenDesSpielers);
        
        }
        obersteKarte = alleKarten[zähler];
        alleKarten[zähler] = null;
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
    
    public boolean kartePrüfen(Karte prüfungskarte) {
    
        if (prüfungskarte.nummer == obersteKarte.nummer) {
        
            return true;
        
        }
        if (prüfungskarte.farbe == obersteKarte.farbe) {
        
            return true;
        
        }
        
        return false;
    
    }
    
    public void spielStarten() {
        runde();
    }
    
    public void runde() {
        for (int i = 0; i < anzahlSpieler; i++) {
        spieler[i].karteAusspielenOderZiehen();
    }
    
    }
    
    public void karteLegen(int spielernummer, Karte gelegteKarte) {
    
        
    
    }
}
