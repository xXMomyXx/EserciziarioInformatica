import java.util.ArrayList;

public class Rettangolo {
    private Punto angolo;
    private double base, altezza;
    private ArrayList<Segmento> segmenti;

    public Rettangolo(Punto angolo, double base, double altezza) {
        this.angolo = angolo;
        this.base = base;
        this.altezza = altezza;
    }

    public Punto getAngolo() {
        return angolo;
    }

    public void setAngolo(Punto angolo) {
        this.angolo = angolo;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public ArrayList<Segmento> getSegmenti() {
        return segmenti;
    }

    public void setSegmenti(ArrayList<Segmento> segmenti) {
        this.segmenti = segmenti;
    }

    private Punto[] trovaPunti() throws Exception {
        if (angolo.getY() < altezza) {
            throw new Exception("L'altezza è di lunghezza superiore rispetto alla coordinata Y del punto specificato. Il rettangolo andrebbe dunque fuori dal primo quadrante.");
        }
        Punto[] punti = new Punto[3];
        punti[0] = new Punto(angolo.getX() + base, angolo.getY()); //Punto in alto a destra
        punti[1] = new Punto(angolo.getX() + base, angolo.getY() - altezza); //Punto in basso a destra
        punti[2] = new Punto(angolo.getX(), angolo.getY() - altezza); //Punto in basso a sinistra
        return punti;
    }

    public ArrayList<Segmento> trovaSegmenti() throws Exception {
        ArrayList<Segmento> segmenti = new ArrayList<>();
        Punto[] puntiRettangolo = trovaPunti();
        //I segmenti sono indicati in senso orario partendo dall'angolo del rettangolo (Il punto in alto a sinistra)
        segmenti.add(new Segmento(angolo, puntiRettangolo[0])); //Il segmento indicante la base superiore
        segmenti.add(new Segmento(puntiRettangolo[0], puntiRettangolo[1])); //Il segmento indicante l'altezza a destra
        segmenti.add(new Segmento(puntiRettangolo[1], puntiRettangolo[2])); //Il segmento indicante la base inferiore
        segmenti.add(new Segmento(puntiRettangolo[2], angolo)); //Il segmento indicante l'altezza a sinistra
        return segmenti;
    }

    public void disegnaRettangolo(ArrayList<Segmento> segmenti) throws Exception {
        int righe = (int) (angolo.getY() + altezza + 10), colonne = (int) (angolo.getX() + base + 10); //Variabili indicanti la grandezza del piano cartesiano
        final Segmento sopra = segmenti.get(0), destra = segmenti.get(1), sotto = segmenti.get(2), sinistra = segmenti.get(3);
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (j >= sopra.getEstremo1().getX() - 1 && j <= sopra.getEstremo2().getX() - 1 && i == sopra.getEstremo1().getY() - 1) { //Se ci troviamo sulla base superiore del rettangolo, stampiamo trattini
                    System.out.print("-");
                } else if (j >= sotto.getEstremo2().getX() - 1 && j <= sotto.getEstremo1().getX() - 1 && i == sotto.getEstremo1().getY()) { //Se ci troviamo sulla base inferiore del rettangolo, stampiamo trattini
                    System.out.print("-");
                } else if (i <= sopra.getEstremo2().getY() - 2 && i >= sotto.getEstremo1().getY() + 1 && j == sopra.getEstremo2().getX() - 1) { //Se ci troviamo sull'altezza destra del rettangolo, stampiamo barre verticali
                    System.out.print("|");
                } else if (i <= sopra.getEstremo2().getY() - 2 && i >= sotto.getEstremo1().getY() + 1 && j == sopra.getEstremo1().getX() - 1) { //Se ci troviamo sull'altezza sinistra del rettangolo, stampiamo barre verticali
                    System.out.print("|");
                } else {
                    System.out.print("*"); //Se nessuna delle condizioni è soddisfatta stampiamo asterischi rappresentanti il piano cartesiano
                }
            }
            System.out.println();
        }
    }
}
