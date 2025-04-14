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

    public double getTempo() {
        return tempo;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getNome() {
        return nome;
    }


}
