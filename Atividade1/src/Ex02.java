import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

    /*A ordem de complexidade é n ou (O(n))*/
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

        for(int i = 0; i<lista.size()-2;i++){
            if (lista.get(i+2) == (lista.get(i+1) + lista.get(i))){
                System.out.println("Existe um elemento que é a soma dos dois anteriores: " + lista.get(i+2));
                return;
            }
        }
        System.out.println("Nenhum elemento é a soma dos dois anteriores");

    }

}