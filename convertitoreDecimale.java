import java.util.Scanner;

public class convertitoreDecimale {
    public static void main(String[] args) {
        String[] numeri = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String numHex = "";
        int numDec, numDec1, numDec2, resto, numOct = 0, numBin = 0, i = 0, scelta = 1;

        Scanner lettore = new Scanner(System.in);
        while (scelta == 1) {
            System.out.println("Inserisci un numero in base decimale per convertirlo in esadecimale, ottale e binario");
            numDec = lettore.nextInt();
            while (numDec < 0 || numDec == 0) {
                System.out.println("Il numero non puo' equivalere a 0 o essere un numero negativo!\nInserisci di nuovo il numero");
                numDec = lettore.nextInt();
            }
            numDec1 = numDec;
            numDec2 = numDec;

            while (numDec > 0) {
                resto = numDec % 16;
                numHex = numeri[resto] + numHex;
                numDec = numDec / 16;
            }

            while (numDec1 > 0) {
                resto = numDec1 % 8;
                numOct = numOct + resto * (int) Math.pow(10, i);
                numDec1 = numDec1 / 8;
                i++;
            }
            i = 0;

            while (numDec2 > 0) {
                resto = numDec2 % 2;
                numBin = numBin + resto * (int) Math.pow(10, i);
                numDec2 = numDec2 / 2;
                i++;
            }

            System.out.println("Il tuo numero in esadecimale e': " + numHex);
            System.out.println("Il tuo numero in ottale e': " + numOct);
            System.out.println("Il tuo numero in binario e': " + numBin);

            numHex = "";
            numOct = 0;
            numBin = 0;
            i = 0;

            System.out.println("Vuoi rifare con un altro numero? Inserisci 1 per si' e 0 per chiudere");
            scelta = lettore.nextInt();
            while (scelta != 0 && scelta != 1) {
                System.out.println("Non hai inserito ne' 1 ne' 0!\nInserisci 1 per sì e 0 per chiudere");
                scelta = lettore.nextInt();
            }
        }
    }
}