//Il metodo visualizzaContattiNascosti non è più stato implementato in quanto per sapere quale contatto sia nascosto o meno usiamo l'attributo "nascosto" della classe Contatto

import java.util.Scanner;

import static Tools.Utility.*;

public class Main {
    public static final String pwrd = "duemila24";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int contatti = 10;
        int contattiInseriti = 0;
        int chiamateFatte = 0;
        int saldo = 0;
        int valoreRicarica;
        Contatto[] rubrica = new Contatto[contatti];
        Contatto[] cronologia = new Contatto[100];
        String[] opzioni = {"RUBRICA", "1 - Aggiungi contatto", "2 - Visualizza contatti", "3 - Visualiza contatti nascosti", "4 - Rendi contatto nascosto", "5 - Rendi contatto visibile", "6 - Chiama contatto", "7 - Visualizza ultime chiamate", "8 - Ricarica", "9 - Esci"};
        int scelta;
        String contattoDaChiamare;
        String pwrdInserita;
        do {
            scelta = menu(opzioni, sc);
            switch (scelta) {
                case 1 -> {
                    if (contattiInseriti < contatti) {
                        rubrica[contattiInseriti] = inserisciContatto(sc);
                        contattiInseriti++;
                        System.out.println("Contatto inserito con successo");
                    } else {
                        System.out.println("La rubrica è piena");
                    }
                }
                case 2 -> {
                    if (!visualizzaContatti(rubrica, contattiInseriti)) {
                        System.out.println("Non vi è alcun contatto da visualizzare");
                    }
                }
                case 3 -> {
                    System.out.println("Inserisci la password");
                    pwrdInserita = sc.nextLine();
                    if (controllaPassword(pwrdInserita)) {
                        if (!visualizzaContattiNascosti(rubrica, contattiInseriti)) {
                            System.out.println("Non vi è alcun contatto nascosto da visualizzare");
                        }
                    } else {
                        System.out.println("Password errata inserita!");
                    }
                }
                case 4 -> {
                    System.out.println("Inserisci la password");
                    pwrdInserita = sc.nextLine();
                    if (controllaPassword(pwrdInserita)) {
                        if (rendiContattoNascosto(rubrica, contattiInseriti, sc)) {
                            System.out.println("Contatto nascosto con successo");
                        } else {
                            System.out.println("Il contatto inserito non è presente");
                        }
                    } else {
                        System.out.println("Password errata inserita!");
                    }
                }
                case 5 -> {
                    System.out.println("Inserisci la password");
                    pwrdInserita = sc.nextLine();
                    if (controllaPassword(pwrdInserita)) {
                        if (rendiContattoVisibile(rubrica, contattiInseriti, sc)) {
                            System.out.println("Il contatto è stato reso visibile con successo");
                        } else {
                            System.out.println("Il contatto non è presente nella rubrica o è già visibile");
                        }
                    } else {
                        System.out.println("Password errata inserita!");
                    }
                }
                case 6 -> {
                    if (saldo >= 2) {
                        System.out.println("Inserisci il numero del contatto che vuoi chiamare");
                        contattoDaChiamare = sc.nextLine();
                        if (chiamaContatto(rubrica, cronologia, contattiInseriti, chiamateFatte, contattoDaChiamare)) {
                            System.out.println("Chiamata fatta");
                            saldo -= 2;
                            chiamateFatte++;
                        } else {
                            System.out.println("Il contatto che cerchi non è presente");
                        }
                    } else {
                        System.out.println("Il tuo saldo è insufficiente per chiamare (Saldo richiesto: 2 euro). Seleziona l'opzione ricarica per tornare a chiamare.");
                    }
                }
                case 7 ->
                    visualizzaUltimeChiamate(cronologia, chiamateFatte);
                case 8 -> {
                    System.out.println("Quanto vuoi ricaricare?\n 1. 5 euro\n 2. 10 euro\n 3. 20 euro");
                    String input = sc.nextLine();
                    valoreRicarica = -1;

                    while (true) {
                        try {
                            valoreRicarica = Integer.parseInt(input);
                            if (valoreRicarica == 1 || valoreRicarica == 2 || valoreRicarica == 3) {
                                break;
                            } else {
                                System.out.println("Il valore inserito non è valido. Reinserire.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Il valore inserito non è valido. Reinserire.");
                        }
                        input = sc.nextLine();
                    }

                    saldo = ricaricaSaldo(saldo, valoreRicarica);
                    System.out.println("Ricarica effettuata con successo");
                }
                case 9 -> System.out.println("Uscita in corso...");
            }
        } while (scelta != 9);
    }

    public static boolean visualizzaContatti(Contatto[] rubrica, int contattiInseriti) {
        boolean presente = false;
        for (int i = 0; i < contattiInseriti; i++) {
            if (!rubrica[i].nascosto) {
                presente = true;
                System.out.println(rubrica[i]);
            }
        }
        return presente;
    }

    public static boolean visualizzaContattiNascosti(Contatto[] rubrica, int contattiInseriti) {
        boolean presente = false;
        for (int i = 0; i < contattiInseriti; i++) {
            if (rubrica[i].nascosto) {
                presente = true;
                System.out.println(rubrica[i]);
            }
        }
        return presente;
    }

    public static Contatto inserisciContatto(Scanner sc) {
        Contatto contatto = new Contatto();
        System.out.println("Inserisci il nome del contatto");
        contatto.nome = sc.nextLine();
        System.out.println("Inserisci il cognome del contatto");
        contatto.cognome = sc.nextLine();
        System.out.println("Inserisci il numero del contatto");
        contatto.numero = sc.nextLine();
        while (!isNumber(contatto.numero)) {
            System.out.println("Il numero non può contenere lettere. Inserisci un nuovo numero");
            contatto.numero = sc.nextLine();
        }
        System.out.println("Inserisci l'email del contatto");
        contatto.email = sc.nextLine();
        return contatto;
    }

    public static boolean rendiContattoNascosto(Contatto[] rubrica, int contattiInseriti, Scanner sc) {
        System.out.println("Inserisci il nome del contatto che vuoi rendere nascosto");
        boolean presente = false;
        String nome = sc.nextLine();
        for (int i = 0; i < contattiInseriti; i++) {
            if (rubrica[i].nome.equals(nome)) {
                presente = true;
                if (!rubrica[i].nascosto) {
                    rubrica[i].nascosto = true;
                } else {
                    System.out.println("Questo contatto è già nascosto");
                    break;
                }
            }
        }
        return presente;
    }

    public static boolean rendiContattoVisibile(Contatto[] rubrica, int contattiInseriti, Scanner sc) {
        System.out.println("Inserisci il nome del contatto che vuoi rendere visibile");
        boolean presente = false;
        String nome = sc.nextLine();
        for (int i = 0; i < contattiInseriti; i++) {
            if (rubrica[i].nome.equals(nome)) {
                presente = true;
                if (rubrica[i].nascosto) {
                    rubrica[i].nascosto = false;
                } else {
                    return false;
                }
            }
        }
        return presente;
    }

    public static boolean chiamaContatto(Contatto[] rubrica, Contatto[] cronologia, int contattiInseriti, int chiamateFatte, String contattoDaChiamare) {
        for (int i = 0; i < contattiInseriti; i++) {
            if (rubrica[i].numero.equals(contattoDaChiamare)) {
                cronologia[chiamateFatte] = rubrica[i];
                return true;
            }
        }
        return false;
    }

    public static void visualizzaUltimeChiamate(Contatto[] cronologia, int chiamateFatte) {
        for (int i = chiamateFatte - 1; i >= 0; i--) {
            System.out.println(cronologia[i]);
        }
        if (chiamateFatte == 0) {
            System.out.println("Non si ha ancora chiamato alcun contatto");
        }
    }

    private static int ricaricaSaldo(int saldo, int valoreRicarica) {
        switch (valoreRicarica) {
            case 1 -> saldo += 5;
            case 2 -> saldo += 10;
            case 3 -> saldo += 20;
        }
        return saldo;
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean controllaPassword(String password) {
        return password.equals(pwrd);
    }
}