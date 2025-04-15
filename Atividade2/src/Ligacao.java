public class Ligacao {

    private String nome;
    private double distancia;
    private double trafego;
    private int pedagios;
    private double tempo;

    public Ligacao(String nome, double trafego, double distancia, int pedagios) {

        this.nome = nome;
        this.distancia = distancia;
        this.trafego = trafego;
        this.pedagios = pedagios;
        this.tempo = (distancia * trafego) + (pedagios * 2);

    }

    public Ligacao(String nome) {
        this.nome = nome;
    }

    public Ligacao getDado() {
        Ligacao aux = new Ligacao(this.nome, trafego, distancia, pedagios);
        return aux;

    }

    public double getTempo() {
        return tempo;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " | Distancia " + distancia + " |Tráfego " + trafego + " | Pedágio " + pedagios + " | Tempo " + tempo;
    }

    @Override
    public boolean equals(Object obj) {

        return (obj != null) &&
                (obj instanceof Ligacao) &&
                ((Ligacao) obj).getNome().equals(this.nome);

    }
}
