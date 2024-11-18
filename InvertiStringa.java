import java.util.Scanner;

public class InvertiStringa {
    public static void main(String[] args) {
        String frase, invertita = "";
        char lettera;
        Scanner lettore = new Scanner(System.in);

        System.out.println("Inserisci una frase per ottenerla al contrario");
        frase = lettore.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            lettera = frase.charAt(i);
            invertita = lettera + invertita;
        }
        System.out.println("La frase invertita e': " + invertita);
    }
}
