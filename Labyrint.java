import java.io.*;
import java.util.Scanner;

public class Labyrint{
    /*
    Innhold:
    OK   - to dimensjonalt array: int[][] eller String[][]
                        * referanser til alle Rute-objekter
                        * tar vare på antall rader, tar vare på antall kolonner
                        
        - toString(): skriv ut lab
                        * lab: en referanse til Labyrint-objektet
    */
    private int antRad = 0;
    private int antKol = 0;
    private Rute[][] ruter = null;

    public Labyrint(String filnavn){
        Scanner sc = null;
        try{
            sc = new Scanner(new File(filnavn));
            String[] line1 = sc.nextLine().split(" ");
            antRad = Integer.parseInt(line1[0]);
            antKol = Integer.parseInt(line1[1]);
            ruter = new Rute[antRad][antKol];
            for(int r = 0; r < antRad; r++){
                String[] rute = sc.nextLine().trim().split("");
                for (int k = 0; k <= antKol-1; k++){
                    if (rute[k].equals(".") 
                        && (r==0 || r==antRad-1 
                        || k==0 || k==antKol-1)){
                        Rute ruten = new Aapning(r, k, this);
                        ruter[r][k] = ruten;
                    }
                    else if (rute[k].equals(".")){
                        Rute ruten = new HvitRute(r, k, this);
                        ruter[r][k] = ruten;
                    }
                    else if (rute[k].equals("#")){
                        Rute ruten = new SortRute(r, k, this);
                        ruter[r][k] = ruten;
                    }
                    else 
                        System.out.println("Noe er feil med innlesing av fila!"+
                        "\n Ingen rute ble lagt til i plassering: ("+r+","+k+")");
                }
            }
            //legger til naboer
            for (int r=0; r<antRad-1; r++){
                for (int k=0; k<antKol; k++){
                    ruter[r][k].leggTilNaboSyd(ruter[r+1][k]);
                    ruter[r+1][k].leggTilNaboNord(ruter[r][k]);
                }
            }
            for (int r=0; r<antRad; r++){
                for (int k=0; k<antKol-1; k++){
                    ruter[r][k].leggTilNaboOest(ruter[r][k+1]);
                    ruter[r][k+1].leggTilNaboVest(ruter[r][k]);
                }
            }

        } catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet!");
        }
        System.out.println(this);
    }

    public Rute[][] hentRuter(){
        return ruter;
    }

    public void finnUtveiFra(int rad, int kol){
        ruter[rad][kol].finn(null);
    }

    
    @Override
    public String toString(){
        String l = "\nLabyrint:\n\n";
        for (int r=0; r<=antRad-1;r++){
            for (int k=0; k<=antKol-1;k++){
                if (ruter[r][k] instanceof SortRute){
                    l += "  #";
                }
                else{
                    l += "  .";
                }
            }
            l += "\n";
        }
        return l;
    }
}