public class Spieler
{
    public int anzahlKarten;
    public Karte[] karten = {};
    
    public Spieler(int anzahlKartenInConstructor, Karte[] kartenInConstructor)
    {
        anzahlKarten = anzahlKartenInConstructor;
        karten = kartenInConstructor;
    }

}
