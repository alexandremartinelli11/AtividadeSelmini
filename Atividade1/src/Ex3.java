import java.util.ArrayList;
import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        int tamanho;
        int l;
        int k;
        int armazena;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        System.out.println("Insira o tamanho da lista");

        tamanho = sc.nextInt();

        System.out.println("Insira o k da lista");

        k = sc.nextInt();
        
        for (int i = 0; i < tamanho; i++){
            System.out.println("Insira os valores desejados");
            l = sc.nextInt();
            lista.add(l);
        }

        for(int i = 0; i < tamanho; i++){
            if(lista.get(i) <= k){
                armazena = lista.get(i);
                lista.remove(i);
                lista.addFirst(armazena);
            }
            else{
                armazena = lista.get(i);
                lista.remove(i);
                lista.addLast(armazena);
            }
        }
        System.out.println(lista);
        sc.close();
    }

}
