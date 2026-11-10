public class Gerente extends FuncionarioCLT {

    private int tamanhoEquipe;
    private double percentualBonus;

    public Gerente(String novoNome, String novaMatricula, double novoSalarioBase,
                   String novaDataAdmissao, double novoValeTransporte,
                   double novoValeAlimentacao, int novoTamanhoEquipe,
                   double novoPercentualBonus) {

        super(novoNome, novaMatricula, novoSalarioBase, novaDataAdmissao,
                novoValeTransporte, novoValeAlimentacao);

        this.tamanhoEquipe = novoTamanhoEquipe;
        this.percentualBonus = novoPercentualBonus;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (getSalarioBase() * percentualBonus);
    }

    @Override
    public double calcularDesconto() {

        double desconto = super.calcularDesconto();

        if (tamanhoEquipe > 10) {
            desconto = desconto + 100;
        }

        return desconto;
    }
}