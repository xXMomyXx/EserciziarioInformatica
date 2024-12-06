import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Auto> veicoli = new ArrayList<>();
        try {
            System.out.println("Inserisci nome e cognome del pilota");
            Pilota pilota1 = new Pilota(sc.nextLine(), sc.nextLine());
            System.out.println("Inserisci nome e cognome del pilota");
            Pilota pilota2 = new Pilota(sc.nextLine(), sc.nextLine());
            //La 'cilindrata' delle auto rappresenta la loro velocità, generiamo
            //dunque una 'cilindrata' casuale per ogni auto in modo da non avere auto con 'cilindrata'
            //fissa (poiché l'auto con la cilindrata superiore vincerebbe sempre).
            Auto auto = new Auto("Mercedes", generaCasuale(), pilota1);
            Auto auto2 = new Auto("Ferrari", generaCasuale(), pilota2);
            veicoli.add(auto);
            veicoli.add(auto2);
            Gara f1 = new Gara("Monza", veicoli, 10000);
            //Chiamiamo il metodo 'corriGara' che pone il valore indicante il vincitore e
            //il numero di secondi passati prima che questo raggiungesse il
            //traguardo in 'risultato' dell'oggetto chiamante il metodo (Sotto forma di stringa).
            //Usiamo poi l'apposito getter per vedere il risultato stampato.
            f1.corriGara();
            System.out.println(f1.getRisultato());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo utilizzato al fine di generare un valore casuale di 'cilindrata' per i veicoli che gareggiano
    public static int generaCasuale() {
        Random rm = new Random();
        return rm.nextInt(1500, 5001);
    }
}