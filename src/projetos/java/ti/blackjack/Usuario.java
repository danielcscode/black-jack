package projetos.java.ti.blackjack;

public class Usuario {
    private String nome;
    private double dinheiro;
    private double aposta;

    public Usuario() {
        this.dinheiro = 1000;
    }

    public double getAposta() {
        return aposta;
    }
    public void setAposta(double aposta) {
        this.aposta = aposta;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getDinheiro() {
        return dinheiro;
    }
}
