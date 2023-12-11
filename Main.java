import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String bin;
        int decimale = 0;
        final int due = 2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un byte per ottenere il corrispondente valore decimale");
        bin = sc.nextLine();

        for (int i = 0; i < bin.length(); i++) {
            while (bin.charAt(i) != '0' && bin.charAt(i) != '1' || bin.length() != 8) {
                System.out.println("Il valore inserito non e' un byte\nReinserire");
                bin = sc.nextLine();
            }
        }
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                decimale = decimale + (int) Math.pow(due, bin.length() - i - 1);
            }
        }
        System.out.println("Il valore in decimale e': " + decimale);
    }
}