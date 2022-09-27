public abstract class Rute {
    /*
OK    - super klasse til hvit og sort rute
OK    - ikke mulig å oprette objekt av klassen: abstrakt
    - Ta vare på / ha:
                * koordinater: rad, kolonne
                * referanse til labyrinten den er den del av
                * referanse til naboruter:
                            - nord
                            - syd
                            - vest
                            - oest


    */
    protected int rad = 0;
    protected int kol = 0;
    protected Labyrint lab = null;
    protected int antallNaboer = 0;
    //naboer:
    protected Rute nord = null;
    protected Rute syd = null;
    protected Rute vest = null;
    protected Rute oest = null;

    public Rute(int rad, int kolonne, Labyrint lab){
        this.rad = rad;
        kol = kolonne;
        this.lab = lab;
    }

    public void leggTilNaboNord(Rute nabo){
        nord = nabo;
        antallNaboer++;
    }

    public void leggTilNaboSyd(Rute nabo){
        syd = nabo;
        antallNaboer++;
    }

    public void leggTilNaboVest(Rute nabo){
        vest = nabo;
        antallNaboer++;
    }

    public void leggTilNaboOest(Rute nabo){
        oest = nabo;
        antallNaboer++;
    }

    public int hentAntNaboer(){
        return antallNaboer;
    }

    public void finn(Rute fra){ 
        
    }

    
}
