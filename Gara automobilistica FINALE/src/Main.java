import java.util.ArrayList;
import java.util.Scanner;

import static Utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Gara> raccoltaGare = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String[] opzioni = {"GARA", "Aggiungi gara", "Rimuovi gara", "Aggiungi scuderia", "Rimuovi scuderia", "Corri gara", "Visualizza gare", "Visualizza scuderie gara", "Uscita"};
        boolean uscita = false;
        int index;
        do {
            try {
                switch (Menu(opzioni, sc)) {
                    case 1 -> {
                        Gara nuovaGara = FrontEnd.aggiungiGara(raccoltaGare);
                        if (nuovaGara != null) {
                            raccoltaGare.add(nuovaGara);
                            System.out.println("Gara aggiunta con successo");
                        } else {
                            throw new Exception("E' già presente una gara con questo nome");
                        }
                    }
                    case 2 -> {
                        if (!raccoltaGare.isEmpty()) {
                            if (FrontEnd.rimuoviGara(raccoltaGare)) {
                                System.out.println("Gara rimossa con successo");
                            } else {
                                throw new Exception("Non è presente alcuna gara con questo nome");
                            }
                        } else {
                            throw new Exception("Non è presente nessuna gara");
                        }
                    }
                    case 3 -> {
                        System.out.println("Inserisci il nome della gara a cui vuoi aggiungere la scuderia");
                        index = FrontEnd.trovaIndiceGara(raccoltaGare, sc.nextLine());
                        if (index == -1) {
                            throw new Exception("Non è presente alcuna gara con questo nome");
                        }
                        raccoltaGare.get(index).getGriglia().add(FrontEnd.aggiungiScuderia(raccoltaGare, index));
                        raccoltaGare.get(index).setnSquadre(raccoltaGare.get(index).getnSquadre() + 1);
                        System.out.println("Scuderia aggiunta alla gara " + raccoltaGare.get(index).getNome() + " con successo");
                    }
                    case 4 -> {
                        if (!raccoltaGare.isEmpty()) {
                            System.out.println("Inserisci il nome della gara da cui vuoi rimuovere la scuderia");
                            index = FrontEnd.trovaIndiceGara(raccoltaGare, sc.nextLine());
                            if (index == -1) {
                                throw new Exception("Non è presente alcuna gara con questo nome");
                            }
                            if (FrontEnd.rimuoviScuderia(raccoltaGare, index)) {
                                raccoltaGare.get(index).setnSquadre(raccoltaGare.get(index).getnSquadre() - 1);
                                System.out.println("Scuderia rimossa con successo");
                            } else {
                                throw new Exception("Non è presente alcuna scuderia con questo nome nella gara selezionata");
                            }
                        } else {
                            throw new Exception("Non è presente nessuna gara");
                        }
                    }
                    case 5 -> {
                        if (!raccoltaGare.isEmpty()) {
                            System.out.println("Inserisci il nome della gara che vuoi correre (Si possono correre di nuovo anche le gare già fatte)");
                            index = FrontEnd.trovaIndiceGara(raccoltaGare, sc.nextLine());
                            if (index == -1) {
                                throw new Exception("Non è presente alcuna gara con questo nome");
                            }
                            raccoltaGare.get(index).corriGara();
                            System.out.println("La gara " + raccoltaGare.get(index).getNome() + " fatta in " + raccoltaGare.get(index).getNazione() + " è terminata. Il vincitore è " + raccoltaGare.get(index).getVincitore() + " con un tempo di " + raccoltaGare.get(index).getGriglia().getFirst().getTempoGiro().getTempoGiroCronometro() + " secondi");
                            for (int i = 1; i < raccoltaGare.get(index).getGriglia().size(); i++) {
                                System.out.println((i + 1) + "° posto: " + raccoltaGare.get(index).getGriglia().get(i).getnPilota().getNome() + " " + raccoltaGare.get(index).getGriglia().get(i).getnPilota().getCognome() + raccoltaGare.get(index).getGriglia().get(i).getTempoGiro().getTempoGiroCronometro() + " secondi");
                            }
                        } else {
                            throw new Exception("Non è presente nessuna gara");
                        }
                    }
                    case 6 -> {
                        if (!raccoltaGare.isEmpty()) {
                            raccoltaGare.forEach(System.out::println);
                        } else {
                            throw new Exception("Non è presente nessuna gara");
                        }
                    }
                    case 7 -> {
                        if (!raccoltaGare.isEmpty()) {
                            System.out.println("Inserisci il nome della gara di cui vuoi vedere le scuderie");
                            index = FrontEnd.trovaIndiceGara(raccoltaGare, sc.nextLine());
                            if (index == -1) {
                                throw new Exception("Non è presente alcuna gara con questo nome");
                            }
                            if (!raccoltaGare.get(index).getGriglia().isEmpty()) {
                                raccoltaGare.get(index).getGriglia().forEach(System.out::println);
                            } else {
                                throw new Exception("Non è presente alcuna scuderia nella gara selezionata");
                            }
                        } else {
                            throw new Exception("Non è presente nessuna gara");
                        }
                    }
                    case 8 -> uscita = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!uscita);
    }
}
