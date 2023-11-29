import java.util.Scanner;

public class Risposta {
    public static void main(String[] args) {

        Scanner lettore = new Scanner(System.in);

        int bottiglioni, nClienti = 0, nBottiglioni = 0;
        double cap = 1.5, prezzoBott = 1, iva, prezzo, prezzoTotale;
        String scelta = "S";

        do {
            nClienti = nClienti + 1;
            System.out.println("Quanti bottiglioni vuoi comprare?");
            bottiglioni = lettore.nextInt();
            nBottiglioni = nBottiglioni + bottiglioni;
            System.out.println("Inserire S per un altro cliente o N per chiudere");
            lettore.nextLine();
            scelta = lettore.nextLine();
            while (!scelta.equalsIgnoreCase("S") && !scelta.equalsIgnoreCase("N")) {
                System.out.println("Non hai inserito ne' S ne' N!\nInserire S per continuare con un altro cliente o N per chiudere");
                scelta = lettore.nextLine();
            }
        } while (scelta.equalsIgnoreCase("S"));
        prezzo = cap * prezzoBott * nBottiglioni;
        iva = prezzo * 0.21;
        prezzoTotale = prezzo + iva;
        System.out.println("BARBERA VINI" + "\nSCONTRINO\n" + "N.clienti: " + nClienti + "\nIl numero di bottiglioni acquistati e': " + nBottiglioni +
                "\nIl prezzo totale del vino e': " + prezzo + " €" + "\nL'IVA applicata è di: " + Math.ceil(iva * 100) / 100 + " €" + "\nIl totale è: "
                + Math.ceil(prezzoTotale * 100) / 100 + " €");
    }
}