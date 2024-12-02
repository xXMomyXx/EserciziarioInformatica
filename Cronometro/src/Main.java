import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci S e premi invio per far iniziare il cronometro, e quando vuoi fermarlo inserisci S di nuovo");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("S")) {
                if (!cronometro.isOn()) {
                    cronometro.iniziaCronometro();
                    System.out.println("Cronometro avviato.");
                } else {
                    System.out.println("Cronometro fermato.");
                    cronometro.fermaCronometro();
                    break;
                }
            }
        }
    }
}