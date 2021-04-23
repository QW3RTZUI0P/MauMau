public class Spieler
{
    public int nummer;
    // aktuelles Spiel
    public Spiel spiel;
    public int anzahlKarten;
    public Karte[] karten = {};
    
    public Spieler(int nummerInConstructor, Spiel spielInConstructor, int anzahlKartenInConstructor, Karte[] kartenInConstructor)
    {
        nummer = nummerInConstructor;
        spiel = spielInConstructor;
        anzahlKarten = anzahlKartenInConstructor;
        karten = kartenInConstructor;
    }
    
    public void karteAusspielen() {
    
        Karte gewählteKarte = karteWählen();
        if (spiel.kartePrüfen(gewählteKarte)) {
        
            spiel.karteLegen(nummer, gewählteKarte);
        
        } else {
        
            // neue Karte wählen
        
        }
        
    
    }
    
    public Karte karteWählen() {
    
        //TODO: hier ein grafisches Auswahlmenü für die Karten machen
        return karten[0];
    
    }

}
