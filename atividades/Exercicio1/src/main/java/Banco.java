public class Banco {
    private String nome;
    private String cpf;
    private double saldo;

    public Banco (String novoNome, String novoCPF, double novoSaldo) {
        this.nome = novoNome;
        this.cpf = novoCPF;
        this.saldo = novoSaldo;
    }

    public Banco () {
        this.setNome("Sem Nome");
        this.cpf = "Sem CPF";
        this.saldo = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
}
