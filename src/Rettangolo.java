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

    public Punto[] trovaPunti(Punto angolo, double base, double altezza) throws Exception {
        if (angolo.getY() < altezza) {
            throw new Exception("L'altezza è di lunghezza superiore rispetto alla coordinata Y del punto specificato. Il rettangolo andrebbe dunque fuori dal primo quadrante.");
        }
        Punto[] punti = new Punto[3];
        punti[0] = new Punto(angolo.getX() + base, angolo.getY()); //Punto in alto a destra
        punti[1] = new Punto(angolo.getX() + base, angolo.getY() - altezza); //Punto in basso a destra
        punti[2] = new Punto(angolo.getX(), angolo.getY() - altezza); //Punto in basso a sinistra
        return punti;
    }

    public ArrayList<Segmento> trovaSegmenti(Punto angolo, double base, double altezza) throws Exception {
        ArrayList<Segmento> segmenti = new ArrayList<>();
        Punto[] puntiRettangolo = this.trovaPunti(angolo, base, altezza);
        //I segmenti sono indicati in senso orario partendo dall'angolo del rettangolo (Il punto in alto a sinistra)
        segmenti.add(new Segmento(angolo, puntiRettangolo[0])); //Il segmento indicante la base superiore
        segmenti.add(new Segmento(puntiRettangolo[0], puntiRettangolo[1])); //Il segmento indicante l'altezza a destra
        segmenti.add(new Segmento(puntiRettangolo[1], puntiRettangolo[2])); //Il segmento indicante la base inferiore
        segmenti.add(new Segmento(puntiRettangolo[2], angolo)); //Il segmento indicante l'altezza a sinistra
        return segmenti;
    }
    public void disegnaRettangolo(){
        //Da sviluppare
    }
}
