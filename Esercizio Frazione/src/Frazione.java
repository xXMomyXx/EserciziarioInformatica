public class Frazione {
    private int numeratore, denominatore;

    public Frazione(int numeratore, int denominatore) throws Exception {
        this.numeratore = numeratore;
        setDenominatore(denominatore);
    }

    public Frazione(String numeratore, String denominatore) throws Exception {
        this(Integer.parseInt(numeratore), Integer.parseInt(denominatore));
    }

    public int getNumeratore() {
        return numeratore;
    }

    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    public void setDenominatore(int denominatore) throws Exception {
        if (denominatore == 0)
            throw new Exception("Lo zero non è un valore valido come denominatore.");
        this.denominatore = denominatore;
    }

    private Frazione sommaFrazioni(Frazione f1) throws Exception {
        int denominatore1 = getDenominatore(), denominatore2 = f1.getDenominatore();
        int numeratore1 = getNumeratore() * denominatore2, numeratore2 = f1.getNumeratore() * denominatore1;
        int numeratore = numeratore1 + numeratore2, denominatore = denominatore1 * denominatore2;
        int oggettoRicerca = Math.min(numeratore, denominatore);
        for (int i = oggettoRicerca; i >= 2; i--) { //Riduzione ai minimi termini
            if (numeratore % i == 0 && denominatore % i == 0) {
                numeratore /= i;
                denominatore /= i;
                break;
            }
        }
        return new Frazione(numeratore, denominatore);
    }

    private double sommaFrazioniValore(Frazione f1) throws Exception {
        Frazione sommaFrazioni = sommaFrazioni(f1);
        return (double) sommaFrazioni.getNumeratore() / sommaFrazioni.getDenominatore();
    }

    public void visualizzaRisultatoSomma(Frazione f1) throws Exception { //L'unico modo per cui il consumatore può accedere al risultato della somma (sia frazionaria che per valore) è questo metodo
        Frazione sommaFrazioni = sommaFrazioni(f1);
        double sommaFrazioniValore = sommaFrazioniValore(f1);
        System.out.println("La somma rappresentata come frazione è " + sommaFrazioni);
        System.out.println("La somma rappresentata come valore decimale è " + sommaFrazioniValore);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numeratore, denominatore);
    }
}