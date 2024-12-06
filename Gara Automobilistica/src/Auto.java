public class Auto {
    private String scuderia;
    private int cilindrata;
    private int distanzaPercorsa;
    private Pilota pilota;

    public Auto(String Scuderia, int Cilindrata, Pilota pilota) {
        this.scuderia = Scuderia;
        this.cilindrata = Cilindrata;
        this.pilota = pilota;
    }

    public String getScuderia() {
        return scuderia;
    }

    public void setScuderia(String scuderia) {
        this.scuderia = scuderia;
    }

    public int getCilindrata() {
        return cilindrata;
    }


    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getDistanzaPercorsa() {
        return distanzaPercorsa;
    }

    public void setDistanzaPercorsa(int distanzaPercorsa) {
        this.distanzaPercorsa = distanzaPercorsa;
    }

    public Pilota getPilota() {
        return pilota;
    }

    public void setPilota(Pilota pilota) {
        this.pilota = pilota;
    }
}
