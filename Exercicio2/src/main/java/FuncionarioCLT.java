public class FuncionarioCLT extends Funcionario {

    private double valeTransporte;
    private double valeAlimentacao;

    public FuncionarioCLT(String novoNome, String novaMatricula, double novoSalarioBase,
                          String novaDataAdmissao, double novoValeTransporte,
                          double novoValeAlimentacao) {

        super(novoNome, novaMatricula, novoSalarioBase, novaDataAdmissao);

        this.valeTransporte = novoValeTransporte;
        this.valeAlimentacao = novoValeAlimentacao;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + valeTransporte + valeAlimentacao;
    }

    @Override
    public double calcularDesconto() {
        return super.calcularDesconto() + 50;
    }
}