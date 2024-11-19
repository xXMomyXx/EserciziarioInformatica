import java.util.Date;

public class Libro {
    private String autore;
    private String titolo;
    private int pagine;
    private genere genereLibro;
    private final double COSTOPAGINE = 0.05;
    private Date dataLibro;


    public String formattaDati() {
        return String.format("Autore: %s, Titolo: %s, Prezzo Libro: %.2f, Genere: %s", autore, titolo, COSTOPAGINE * pagine, genereLibro);
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public genere getGenereLibro() {
        return genereLibro;
    }

    public void setGenereLibro(genere genereLibro) {
        this.genereLibro = genereLibro;
    }

    public double getCOSTOPAGINE() {
        return COSTOPAGINE;
    }

    public Date getDataLibro() {
        return dataLibro;
    }

    public void setDataLibro(Date dataLibro) {
        this.dataLibro = dataLibro;
    }

    @Override
    public boolean equals(Object o) {
        Libro l = (Libro) o;
        return autore.equals(l.autore) && titolo.equals(l.titolo);
    }
}