public class Segmento {
    private Punto estremo1, estremo2;

    public Segmento(Punto estremo1, Punto estremo2) {
        this.estremo1 = estremo1;
        this.estremo2 = estremo2;
    }

    public Punto getEstremo1() {
        return estremo1;
    }

    public void setEstremo1(Punto estremo1) {
        this.estremo1 = estremo1;
    }

    public Punto getEstremo2() {
        return estremo2;
    }

    public void setEstremo2(Punto estremo2) {
        this.estremo2 = estremo2;
    }

    @Override
    public String toString() {
        return String.format("Primo estremo: %s, Secondo estremo: %s", estremo1, estremo2);
    }
}
