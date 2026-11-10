public class Estagiario extends Funcionario {

    private double valorBolsaAuxilio;
    private int cargaHorariaSemanal;

    public Estagiario(String novoNome, String novaMatricula, double novoSalarioBase,
                      String novaDataAdmissao, double novoValorBolsaAuxilio,
                      int novaCargaHorariaSemanal) {

        super(novoNome, novaMatricula, novoSalarioBase, novaDataAdmissao);

        this.valorBolsaAuxilio = novoValorBolsaAuxilio;
        this.cargaHorariaSemanal = novaCargaHorariaSemanal;
    }

    @Override
    public double calcularSalario() {
        return valorBolsaAuxilio;
    }

    @Override
    public double calcularDesconto() {
        return 0;
    }
}