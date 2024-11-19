public class Main {
    public static void main(String[] args) throws Exception {
        double base = 30, altezza = 10;
        Punto angolo = new Punto(10,20);
        Rettangolo rt = new Rettangolo(angolo, base, altezza);
        rt.setSegmenti(rt.trovaSegmenti(angolo,base,altezza));
    }
}
