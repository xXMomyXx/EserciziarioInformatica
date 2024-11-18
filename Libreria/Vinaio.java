import java.util.Scanner;

public class Vinaio {
    public static void main(String[] args) {

        Scanner lettore = new Scanner(System.in);

        int bottiglioni, nClienti = 0, nBottiglioni = 0;
        double cap = 1.5, merlot = 1, lugana = 2, barbera = 1.5, iva, prezzoTotale = 0, vinoScelto;
        String scelta, tipoVino;

        do {
            nClienti = nClienti + 1;
            System.out.println("Quanti bottiglioni vuoi comprare?");
            bottiglioni = lettore.nextInt();
            nBottiglioni = nBottiglioni + bottiglioni;
            lettore.nextLine();
            System.out.println("Che tipo di vino vuoi acquistare? Inserire M per Merlot, L per lugana o B per barbera");
            tipoVino = lettore.nextLine();
            while (!tipoVino.equalsIgnoreCase("m") && !tipoVino.equalsIgnoreCase("b") && !tipoVino.equalsIgnoreCase("l")) {
                System.out.println("Non hai inserito nessuna delle tre opzioni!\nInserisci di nuovo");
                tipoVino = lettore.nextLine();
            }
            if (tipoVino.equalsIgnoreCase("m")) {
                vinoScelto = merlot;
            } else if (tipoVino.equalsIgnoreCase("l")) {
                vinoScelto = lugana;
            } else {
                vinoScelto = barbera;
            }
            prezzoTotale = prezzoTotale + (cap * vinoScelto * bottiglioni);
            System.out.println("Inserire S per un altro cliente o N per chiudere");
            scelta = lettore.nextLine();
            while (!scelta.equalsIgnoreCase("S") && !scelta.equalsIgnoreCase("N")) {
                System.out.println("Non hai inserito ne' S ne' N!\nInserire S per continuare con un altro cliente o N per chiudere");
                scelta = lettore.nextLine();
            }
        } while (scelta.equalsIgnoreCase("S"));
        iva = prezzoTotale * 0.21;
        double prezzoConIva = prezzoTotale + iva;
        System.out.println("BARBERA VINI" + "\nSCONTRINO\n" + "N.clienti: " + nClienti + "\nIl numero di bottiglioni acquistati e': " + nBottiglioni +
                "\nIl prezzo totale del vino e': " + prezzoTotale + " €" + "\nL'IVA applicata è di: " + Math.ceil(iva * 100) / 100 + " €" + "\nIl totale è: "
                + Math.ceil(prezzoConIva * 100) / 100 + " €\nCASSA CHIUSA");
    }
}
