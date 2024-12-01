public class Main {
    public static void main(String[] args) throws Exception {
      //Frazione f = new Frazione(14, 10); Dovesse essere utilizzato 0 nel costruttore il programma sarà interrotto, non essendo questo un valore valido come denominatore per una frazione
        Frazione f1 = new Frazione(14, 10); //
        Frazione f2 = new Frazione(20, 30);
        f1.visualizzaRisultatoSomma(f2); //Si chiama il metodo passando ad esso la frazione da sommare e questo stamperà sia il risultato in frazione che in valore decimale
    }
}
