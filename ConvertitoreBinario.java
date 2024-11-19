import java.util.Scanner; 

public class ConvertitoreBinario {
    public static void main(String[] args) {
        int n;
        int nBin;
        int resto;
        int i=0;
        
        Scanner lettura = new Scanner(System.in);
        System.out.println("Inserisci un numero in decimale per convertirlo in binario");
        n = lettura.nextInt();
        nBin=0;
        while(n>0){
            resto = n%2;
            nBin=nBin+resto*(int)Math.pow(10,i);
            i=i+1;
            n=n/2;
        }
        System.out.println("Il numero in binario e': "+nBin);
        
    }
}
