import javax.swing.*;
import java.util.List;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import static javax.swing.JOptionPane.*;
public class Menu {


    static ListaDupla<Cidade> cidades;

    public static void main(String[] args) {
        tudo();
    }

    public static void tudo() {
        cidades = new ListaDupla<>();
    String decricao = "1. Cadastrar cidades na lista principal.\n2. Cadastrar ligações diretas entre cidades.\n" +
            "3. Listar todas as cidades com suas ligações diretas.\n 4. Dado o nome de uma cidade de origem e uma cidade de destino, verificar se existe uma igação direta e, se sim, exibir o tempo estimado da entrega.\n" +
            "5. Dado um tempo limite (em minutos), exibir todas as ligações diretas em toda a malha que possam ser realizadas dentro desse tempo." +
            "6. Sair do programa.";
    String op = "";

        while (!op.equals("exit")) {
            op = showInputDialog(decricao);
            switch (op) {

                case "1":

                    String nome = showInputDialog("Digite o nome do cidade: ");
                    cidades.add(new NoDuplo<Cidade>(new Cidade(nome)));
                    break;

                case "2":

                    nome = showInputDialog("Digite o nome da nova cidade: ");
                    String cidadeP = showInputDialog("Qual a cidade que ela tem ligação direta: ");
                    double distancia = parseDouble(showInputDialog("Digite a distancia entre as cidades: "));
                    double trafego = parseDouble(showInputDialog("Digite o fator tráfego entre as cidades: "));
                    int pedagios = parseInt(showInputDialog("Digite os pedagios entre as cidades: "));
                    createCidade(nome, cidadeP, distancia, trafego, pedagios);
                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "5":

                    break;
                case "6":
                    int r = showConfirmDialog(null, "Realmente deseja sair?");
                    if (r == YES_OPTION) {

                        op = "exit";

                    }
                    break;

            }
        }

    };

    public static void createCidade(String nome, String cidadeP, double distancia, double trafego, int pedagios) {
        Cidade vai = pesquisar(cidadeP);
        if (vai == null) {

            int r = showConfirmDialog(null, "A cidade " + cidadeP + " não foi encontrada deseja cria-la?");
            if (r == YES_OPTION) {

                cidades.add(new NoDuplo<>(new Cidade(cidadeP)));
                showMessageDialog(null, "Cidade criada com sucesso");

            }

            if (r == NO_OPTION) {

                return;

            }

            NoDuplo<Cidade> c = cidades.buscar(new Cidade(cidadeP));
            c.getDado().getDireta().add(new NoDuplo<>(new Ligacao(nome, distancia, trafego, pedagios)));
            showMessageDialog(null, "Cidade criada com sucesso");
            return;

        }
        NoDuplo<Cidade> c = cidades.buscar(new Cidade(cidadeP));
        c.getDado().getDireta().add(new NoDuplo<Ligacao>(new Ligacao(nome, distancia, trafego, pedagios)));
        showMessageDialog(null, "Cidade criada com sucesso");

    }

    public static Cidade pesquisar(String cidadeP){
        Cidade cidade = null;
        while(true){
            try{
                NoDuplo<Cidade> c = cidades.buscar(new Cidade(cidadeP));
                if(c != null)
                    cidade = c.getDado();
                break;
            }catch(RuntimeException e){
                showMessageDialog(null, "Valor inválido");
            }
        }
        return cidade;
    }





}
