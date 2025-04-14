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
}
