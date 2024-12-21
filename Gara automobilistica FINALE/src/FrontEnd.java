import java.util.ArrayList;
import java.util.Scanner;

public class FrontEnd {
    private static final Scanner sc = new Scanner(System.in);

    public static Gara aggiungiGara(ArrayList<Gara> raccoltaGare) throws Exception {
        System.out.println("Inserisci il nome della gara");
        String nomeGara = sc.nextLine();
        for (Gara g : raccoltaGare) {
            if (g.getNome().equals(nomeGara)) {
                return null;
            }
        }
        System.out.println("Inserisci la nazione della gara");
        String nazioneGara = sc.nextLine();
        return new Gara(nomeGara, nazioneGara);
    }

    public static boolean rimuoviGara(ArrayList<Gara> raccoltaGare) throws Exception {
        System.out.println("Inserisci il nome della gara che vuoi rimuovere");
        String nomeGaraDaRimuovere = sc.nextLine();
        if (!Pilota.isValue(nomeGaraDaRimuovere)) {
            throw new Exception("Il nome della gara da rimuovere inserito non è valido");
        }
        return raccoltaGare.removeIf(g -> g.getNome().equals(nomeGaraDaRimuovere));
    }

    public static Scuderia aggiungiScuderia(ArrayList<Gara> raccoltaGare, int index) throws Exception {
        System.out.println("Inserisci il nome della scuderia");
        String nomeScuderia = sc.nextLine();
        for (Scuderia s : raccoltaGare.get(index).getGriglia()) {
            if (s.getNome().equals(nomeScuderia)) {
                throw new Exception("La scuderia che vuoi inserire è già presente");
            }
        }
        System.out.println("Inserisci il numero dell'auto della scuderia");
        int nAutoScuderia = Integer.parseInt(sc.nextLine());
        System.out.println("Inserisci il nome del pilota della scuderia");
        String nomePilotaScuderia = sc.nextLine();
        System.out.println("Inserisci il cognome del pilota della scuderia");
        String cognomePilotaScuderia = sc.nextLine();
        System.out.println("Inserisci la nazionalità del pilota della scuderia");
        String nazionalitaPilotaScuderia = sc.nextLine();
        Pilota pilotaScuderia = new Pilota(nomePilotaScuderia, cognomePilotaScuderia, nazionalitaPilotaScuderia);
        return new Scuderia(nomeScuderia, pilotaScuderia, nAutoScuderia);
    }

    public static boolean rimuoviScuderia(ArrayList<Gara> raccoltaGare, int index) {
        System.out.println("Inserisci il nome della scuderia");
        String nomeScuderia = sc.nextLine();
        return raccoltaGare.get(index).getGriglia().removeIf(g -> g.getNome().equals(nomeScuderia));
    }

    public static int trovaIndiceGara(ArrayList<Gara> raccoltaGare, String nomeGara) {
        int index = -1;
        for (int i = 0; i < raccoltaGare.size(); i++) {
            if (raccoltaGare.get(i).getNome().equals(nomeGara)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
