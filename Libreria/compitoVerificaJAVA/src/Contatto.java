public class Contatto {
    String nome;
    String cognome;
    String numero;
    String email;
    boolean nascosto = false;

    public String toString() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Numero: " + numero + ", Email: " + email + ", Nascosto: " + (nascosto ? "sì" : "no");
    }
}
