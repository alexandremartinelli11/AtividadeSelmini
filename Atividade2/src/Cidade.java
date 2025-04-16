public class Cidade {

    private String nome;
    private ListaDupla<Ligacao> direta = new ListaDupla<>();

    public Cidade(String nome) {

        this.nome = nome;

    }

    public ListaDupla<Ligacao> getDireta() {
        return direta;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {

        return (obj != null) &&
                (obj instanceof Cidade) &&
                ((Cidade) obj).getNome().equals(this.nome);

    }

    @Override
    public String toString() {
        String retorno = imprimir();
        return "Cidade principal " + nome + " -> " + retorno + "\n";
    }

    public String imprimir() {

        NoDuplo<Ligacao> aux = direta.first;
        String msg = aux.getDado().toString();

        while (aux.getProx() != null) {

            aux = aux.getProx();
            msg += ", " + aux.getDado().toString();

        }

        return msg;

    }

    public NoDuplo<Ligacao> buscarTempo(Ligacao dado, double tempo) {
        NoDuplo<Ligacao> aux = this.direta.getFirst();
        while(aux != null){
            if(aux.getDado().getTempo() <= tempo)
                return aux;
            else{
                aux = aux.getProx();
            }
        }
        return null;
    }
}
