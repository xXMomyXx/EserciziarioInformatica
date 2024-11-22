public class Main {
    public static void main(String[] args) {
        try {
            double base = 10, altezza = 3;
            Punto angolo = new Punto(10, 22);
            Rettangolo rt = new Rettangolo(angolo, base, altezza);
            rt.setSegmenti(rt.trovaSegmenti());
            rt.disegnaRettangolo(rt.getSegmenti());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
