import java.util.Scanner;

public class Oblig6 {
    public static void main(String[] args) {
        Labyrint lab = new Labyrint(args[0]);
        
        Scanner in = new Scanner(System.in);
        String input = "";
        while (! input.equals("-1")){
            System.out.println("\nSkriv inn koordinater <rad> <kolonne> "+
            "('-1' for aa avslutte)");
            input = in.nextLine();
            if (input.equals("-1")){
                return;
            }
            int rad = Integer.parseInt(input.split(" ")[0]);
            int kol = Integer.parseInt(input.split(" ")[1]);
            System.out.println("Aapninger: ");
            lab.finnUtveiFra(rad, kol);
        }
        in.close(); 

    }
    
}
