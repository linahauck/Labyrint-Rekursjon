public class HvitRute extends Rute {

    //- super klasse til aapning
    public HvitRute(int rad, int kolonne, Labyrint lab){
        super(rad, kolonne, lab);
    }

    @Override 
    public String toString(){
        return "Hvit Rute: ("+rad+","+kol+")";
    }

    @Override
    public void finn(Rute fra){
        if (fra == null){
            nord.finn(this);
            syd.finn(this);
            oest.finn(this);
            vest.finn(this);
        }
        else {
            if (fra != nord){
                nord.finn(this);
            }
            if (fra != syd){
                syd.finn(this);
            }
            if (fra != oest){
                oest.finn(this);
            }
            if (fra != vest){
                vest.finn(this);
            }
        }
    }
}
