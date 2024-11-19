import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

import static Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAXLIBRI = 3;
        int posizione = -1;
        boolean uscita = false;
        ArrayList<Libro> gestore = new ArrayList<>(MAXLIBRI);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String[] opzioni = {"Gestore libri", "1 Inserimento", "2 Visualizza", "3 Ricerca per titolo ed autore", "4 Elimina libro", "5 Ricerca per titolo", "6 Cambia data", "7 Successivo", "8 Precedente", "9 Fine"};

        do {
            try {
                if (!gestore.isEmpty()) {
                    System.out.println("Inserisci la posizione iniziale per lo scorrimento. Es. 1 = Primo libro");
                    posizione = Integer.parseInt(sc.nextLine());
                    while (posizione <= 0 || posizione > gestore.size()) {
                        System.out.println("Posizione non valida. Reinserire.");
                        posizione = Integer.parseInt(sc.nextLine());
                    }
                    String nomeLibro = gestore.get(posizione - 1).getTitolo();
                    String autoreLibro = gestore.get(posizione - 1).getAutore();
                    System.out.println("Libro attuale: " + nomeLibro + " di " + autoreLibro);
                }
                switch (Menu(opzioni, sc)) {
                    case 1 -> {
                        Libro nuovoLibro = inserimentoLibro(gestore, sc);
                        if (gestore.size() < MAXLIBRI) {
                            if (nuovoLibro != null) {
                                gestore.add(nuovoLibro);
                            } else {
                                throw new Exception("Libro già presente");
                            }
                        } else {
                            throw new Exception("La mensola è piena. Rimuovere un libro per poter inserire.");
                        }
                    }
                    case 2 -> {
                        if (gestore.isEmpty()) {
                            throw new Exception("La mensola è vuota.");
                        }
                        visualizza(gestore);
                    }
                    case 3 -> {
                        if (gestore.isEmpty()) {
                            throw new Exception("La mensola è vuota.");
                        }
                        System.out.println("Inserisci il nome del libro che vuoi trovare");
                        String titleToFind = sc.nextLine();
                        System.out.println("Inserisci l'autore del libro che vuoi trovare");
                        String authorToFind = sc.nextLine();
                        int index = ricercaLibro(gestore, titleToFind, authorToFind);
                        if (index != -1) {
                            System.out.println("Il libro si trova all'indice " + index);
                            System.out.println(gestore.get(index).formattaDati());
                        } else {
                            throw new Exception("Libro non presente");
                        }
                    }
                    case 4 -> {
                        if (gestore.isEmpty()) {
                            throw new Exception("La mensola è vuota.");
                        }
                        System.out.println("Inserisci il nome del libro che vuoi eliminare");
                        String titleToRemove = sc.nextLine();
                        System.out.println("Inserisci l'autore del libro che vuoi eliminare");
                        String authorToRemove = sc.nextLine();
                        if (eliminaLibro(gestore, titleToRemove, authorToRemove)) {
                            System.out.println("Il libro " + titleToRemove + " è stato eliminato con successo");
                        } else {
                            throw new Exception("Libro non presente");
                        }
                    }
                    case 5 -> {
                        if (gestore.isEmpty()) {
                            throw new Exception("La mensola è vuota.");
                        }
                        System.out.println("Inserisci il nome del libro che vuoi trovare");
                        String titleToFind = sc.nextLine();
                        int index = findIndex(gestore, titleToFind);
                        if (index != -1) {
                            System.out.println("Il libro si trova all'indice " + index);
                            System.out.println(gestore.get(index).formattaDati());
                        } else {
                            throw new Exception("Libro non presente");
                        }
                    }
                    case 6 -> {
                        if (gestore.isEmpty()) {
                            throw new Exception("La mensola è vuota.");
                        }
                        System.out.println("Inserisci il nome del libro a cui vuoi cambiare la data");
                        String titleToChange = sc.nextLine();
                        System.out.println("Inserisci l'autore del libro a cui vuoi cambiare la data");
                        String authorToChange = sc.nextLine();
                        int index = ricercaLibro(gestore, titleToChange, authorToChange);
                        if (index != -1) {
                            try {
                                gestore.get(index).setDataLibro(formatter.parse(sc.nextLine()));
                            } catch (ParseException e) {
                                throw new Exception("Inserimento invalido");
                            }
                        } else {
                            throw new Exception("Libro non presente");
                        }
                    }
                    case 7 -> {
                        if (posizione != -1) {
                            if (gestore.isEmpty()) {
                                throw new Exception("La mensola è vuota");
                            }
                            if (posizione != gestore.size() - 1) {
                                posizione++;
                            } else {
                                throw new Exception("Sei già all'ultimo libro");
                            }
                        } else {
                            throw new Exception("Non è stato ancora impostato un libro come riferimento per lo scorrimento");
                        }
                    }
                    case 8 -> {
                        if (posizione != -1) {
                            if (gestore.isEmpty()) {
                                throw new Exception("La mensola è vuota");
                            }
                            posizione--;
                        } else {
                            throw new Exception("Non è stato ancora impostato un libro come riferimento per lo scorrimento");
                        }
                    }
                    case 9 -> uscita = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!uscita);
    }

    public static Libro inserimentoLibro(ArrayList<Libro> gestore, Scanner sc) {
        Libro libro = new Libro();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Inserisci il titolo del libro:");
        libro.setTitolo(sc.nextLine());
        System.out.println("Inserisci l'autore del libro:");
        libro.setAutore(sc.nextLine());
        System.out.println("Inserisci la data");
        try {
            libro.setDataLibro(formatter.parse(sc.nextLine()));
        } catch (ParseException e) {
            System.out.println("Inserimento invalido");
        }
        if (ricercaLibro(gestore, libro.getTitolo(), libro.getAutore()) != -1) {
            return null;
        }
        System.out.println("Inserisci il numero di pagine:");
        libro.setPagine(Integer.parseInt(sc.nextLine()));

        try {
            String[] opzioni = {"Inserisci il genere", "1- Romanzo", "2- Manuale", "3- Thriller"};
            int scelta;
            do {
                scelta = Menu(opzioni, sc);
                switch (scelta) {
                    case 1:
                        libro.setGenereLibro(genere.romanzo);
                        break;
                    case 2:
                        libro.setGenereLibro(genere.manuale);
                        break;
                    case 3:
                        libro.setGenereLibro(genere.thriller);
                        break;
                    default:
                        System.out.println("Scelta non valida, riprova.");
                }
            } while (scelta < 1 || scelta > 3);
        } catch (NumberFormatException e) {
            return null;
        }
        return libro;
    }

    public static void visualizza(ArrayList<Libro> gestore) {
        gestore.forEach(libro -> System.out.println(libro.formattaDati()));
    }

    public static int ricercaLibro(ArrayList<Libro> gestore, String titolo, String autore) {
        for (int i = 0; i < gestore.size(); i++) {
            if (gestore.get(i).getTitolo().equalsIgnoreCase(titolo) && gestore.get(i).getAutore().equalsIgnoreCase(autore)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean eliminaLibro(ArrayList<Libro> gestore, String titolo, String autore) {
        //return gestore.removeIf(libro -> libro.titolo.equals(titolo) && libro.autore.equals(autore));
        return gestore.removeIf(libro -> libro.getTitolo().compareTo(titolo) == 0 && libro.getAutore().compareTo(autore) == 0);
    }

    public static int findIndex(ArrayList<Libro> gestore, String titolo) {
        for (int i = 0; i < gestore.size(); i++) {
            if (gestore.get(i).getTitolo().equalsIgnoreCase(titolo)) {
                return i;
            }
        }
        return -1;
    }
}
