public class Scuderia implements Comparable<Scuderia> {
    private final String nome;
    private final Pilota nPilota;
    private final int nAuto;
    private final Cronometro tempoGiro;

    public Scuderia(String nome, Pilota nPilota, int nAuto) throws Exception {
        tempoGiro = new Cronometro();
        if (!Pilota.isValue(nome)) {
            throw new Exception("Il nome inserito nella scuderia non è valido");
        } else if (!Pilota.isValue(String.valueOf(nAuto))) {
            throw new Exception("Il numero d'auto inserito nella scuderia non è valido");
        }
        this.nome = nome;
        this.nPilota = nPilota;
        this.nAuto = nAuto;
    }

    public String getNome() {
        return nome;
    }

    public Pilota getnPilota() {
        return nPilota;
    }

    public Cronometro getTempoGiro() {
        return tempoGiro;
    }

    @Override
    public String toString() {
        return String.format("Nome scuderia: %s, %s, Numero auto scuderia: %d", nome, nPilota.toString(), nAuto);
    }

    @Override
    public int compareTo(Scuderia o) {
        return tempoGiro.compareTo(o.tempoGiro);
    }
}
