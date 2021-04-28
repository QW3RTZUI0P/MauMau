public class Karte
{
    // 1: Ass
    // 2-10: Zahlenkarten
    // 11: Junge
    // 12: Dame
    // 13: König
    public int nummer;
    // 0: Kreuz
    // 1: Pik
    // 2: Herz
    // 3: Karo
    public int farbe;

    public Karte(int farbeInConstructor, int nummerInConstructor)
    {
        farbe = farbeInConstructor;
        nummer = nummerInConstructor; 
       
    }
    
    public Karte[] kartensetGeben() {
    Karte[] set;
    set = new Karte[52];
    int zähler = 0;
    for (int i = 0; i < 4; i++) {
    
        for (int j = 1; j < 14; j++) {
            set[zähler] = new Karte(i, j);
            zähler = zähler + 1;
        
        }
    
    }
    
    return set;
    }
    
}



