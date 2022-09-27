public class SortRute extends Rute {
    
    public SortRute(int rad, int kolonne, Labyrint lab){
        super(rad, kolonne, lab);
    }

    @Override 
    public String toString(){
        return "Sort Rute: ("+rad+","+kol+")";
    }

    @Override
    public void finn(Rute fra){
        if (fra == null){
            System.out.println("Kan ikke starte i sort rute!");
        }
    }
}
