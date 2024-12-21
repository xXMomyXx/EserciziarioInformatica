public class Pilota {
    private final String nome;
    private final String cognome;
    private final String nazionalita;

    public Pilota(String nome, String cognome, String nazionalita) throws Exception {
        if (!isValue(nome)) {
            throw new Exception("Il nome inserito nel pilota non è valido");
        } else if (!isValue(cognome)) {
            throw new Exception("Il cognome inserito nel pilota non è valido");
        } else if (!isValue(nazionalita)) {
            throw new Exception("La nazionalità inserita nel pilota non è valida");
        }
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return String.format("Nome pilota: %s, Cognome pilota: %s, Nazionalità pilota: %s", nome, cognome, nazionalita);
    }

    public static boolean isValue(String s) {
        return s != null && !s.isEmpty();
    }
}
