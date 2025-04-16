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
            "3. Listar todas as cidades com suas ligações diretas.\n4. Dado o nome de uma cidade de origem e uma cidade de destino, verificar se existe uma ligação direta e, se sim, exibir o tempo estimado da entrega.\n" +
            "5. Dado um tempo limite (em minutos), exibir todas as ligações diretas em toda a malha que possam ser realizadas dentro desse tempo.\n" + "6. Sair do programa.";
    String op = "";

        while (!op.equals("exit")) {
            op = showInputDialog(decricao);
            switch (op) {

                case "1":

                    String nome = showInputDialog("Digite o nome do cidade: ").toUpperCase().trim();
                    cidades.add(new NoDuplo<Cidade>(new Cidade(nome)));
                    break;

                case "2":

                    nome = showInputDialog("Digite o nome da nova cidade: ").toUpperCase().trim();
                    String cidadeP = showInputDialog("Qual a cidade que ela tem ligação direta: ").toUpperCase().trim();
                    createCidade(nome, cidadeP);
                    break;

                case "3":
                    showMessageDialog(null, cidades.imprimir());
                    break;

                case "4":
                    String cidadeOri  = showInputDialog("Digite a cidade de origem: ").toUpperCase().trim();
                    String destino  = showInputDialog("Digite a cidade de destino: ").toUpperCase().trim();
                    detinoP(cidadeOri, destino);
                    break;

                case "5":
                    double tempo = parseDouble(showInputDialog("Qual o tempo limite "));
                    showMessageDialog(null,tempoF(tempo));
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

    public static void createCidade(String nome, String cidadeP) {
        Cidade vai = pesquisar(cidadeP);
        if (vai == null) {

            int r = showConfirmDialog(null, "A cidade " + cidadeP + " não foi encontrada deseja cria-la?");
            if (r == YES_OPTION) {

                cidades.add(new NoDuplo<>(new Cidade(cidadeP)));
                showMessageDialog(null, "Cidade" + cidadeP + " criada com sucesso");
                double distancia = parseDouble(showInputDialog("Digite a distancia entre as cidades: "));
                double trafego = parseDouble(showInputDialog("Digite o fator tráfego entre as cidades: "));
                int pedagios = parseInt(showInputDialog("Digite os pedagios entre as cidades: "));
                if (distancia >= 0.0 && trafego != 0.0 && pedagios != 0) {
                    NoDuplo<Cidade> c = cidades.buscar(new Cidade(cidadeP));
                    c.getDado().getDireta().add(new NoDuplo<>(new Ligacao(nome, distancia, trafego, pedagios)));
                    showMessageDialog(null, "Cidade" + nome + " criada com sucesso");

                }
                else {
                    showMessageDialog(null, "Não foi possível criar a cidade " +  nome + " devido a valores ínvalidos");
                }


            }

            if (r == NO_OPTION) {

                return;

            }
            return;

        }
        double distancia = parseDouble(showInputDialog("Digite a distancia entre as cidades: "));
        double trafego = parseDouble(showInputDialog("Digite o fator tráfego entre as cidades (0-2): "));
        int pedagios = parseInt(showInputDialog("Digite os pedagios entre as cidades: "));

        if (distancia >= 0.0 && trafego != 0 && pedagios != 0) {
            NoDuplo<Cidade> c = cidades.buscar(new Cidade(cidadeP));
            c.getDado().getDireta().add(new NoDuplo<>(new Ligacao(nome, distancia, trafego, pedagios)));
            showMessageDialog(null, "Cidade " + nome + " criada com sucesso");
        }
        else {
            showMessageDialog(null, "Não foi possível criar a cidade " +  nome + " devido a valores ínvalidos");
        }

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

    public static void detinoP(String cidadeOri, String destino) {
        Cidade ori = pesquisar(cidadeOri);
        if (ori != null ) {
            NoDuplo<Ligacao> dst = ori.getDireta().buscar(new Ligacao(destino));

            if (dst != null) {

                showMessageDialog(null, "A viagem de " + ori.getNome() + " até " +dst.getDado().getNome() + " tem tempo estimado de " + dst.getDado().getTempo() + " minutos");
                return;
            }

        }
        showMessageDialog(null , "Não existe trajeto de " + cidadeOri + " até " + destino);


    }

     /* public static String tempoF(double tempo) {

        NoDuplo<Cidade> aux = cidades.getFirst();
        String msg = "";

        while(aux.getDado() != null){

            if (aux.getDado() == null)
                return msg;

            NoDuplo<Ligacao> tenta = aux.getDado().buscarTempo(aux.getDado().getDireta().getFirst().getDado(), tempo);
            msg += tenta.getDado().getNome() + " " + tenta.getDado().getTempo() + " minutos";


            aux = aux.getProx();
        }
        return msg;

    }

      */

    public static String tempoF(double tempo) {

        String msg = "";
        NoDuplo<Cidade> aux = cidades.getFirst();

        while (aux != null) {
            Cidade atual = aux.getDado();
            ListaDupla<Ligacao> ligAtual = atual.getDireta();

            if (ligAtual != null) {
                NoDuplo<Ligacao> ligacao = ligAtual.getFirst();

                while (ligacao != null) {

                    Ligacao x = ligacao.getDado();
                    if (x.getTempo() <= tempo)
                        msg += atual.getNome() + " -> " + x.getNome() + "(" + x.getTempo() + ")";
                ligacao = ligacao.getProx();
                }

            }
            aux = aux.getProx();
        }
        if (msg.equals(""))
            msg = "Nao existem caminhos com menso qw o tempo limite";
        return msg;
    }
}
