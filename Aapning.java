public class Aapning extends HvitRute {
    
    public Aapning(int rad, int kolonne, Labyrint lab){
        super(rad, kolonne, lab);
    }

    public String toString(){
        return "Aapning: ("+rad+","+kol+")";
    }

    @Override
    public void finn(Rute fra){
        System.out.println("("+rad+","+kol+")");
        
        if (fra == null){
            if (fra != nord && nord!=null){
                nord.finn(this);
            }
            if (fra != syd && syd!=null){
                syd.finn(this);
            }
            if (fra != oest && oest!=null){
                oest.finn(this);
            }
            if (fra != vest && vest!=null){
                vest.finn(this);
            }
        }
        
    }
}
