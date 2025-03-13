import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {
    
    /*A ordem de complexidade é Math.pow(n, 2) ou (O(n²)) :)  */
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int f;
        int x;
        System.out.println("Qual o tamanho desejado na lista");
        f = sc.nextInt();
        for (int i = 0; i < f; i++){
            System.out.println("Insira o número desejado");
            x = sc.nextInt();
            lista.add(x);
        }

        sc.close();

        for(int i = 0; i<lista.size()-1;i++){
            for (int j=1;j< lista.size()-1;j++){
                if (lista.get(i) == lista.get(j) && lista.indexOf(i) != lista.indexOf(j)){
                    System.out.println("primeiro numero repetido eh: " + lista.get(i));
                    return;
                }
            }
        }
        System.out.println("Nao existem numeros repetidos");
    }
}