public class Diretor extends Gerente {

    private double participacaoLucros;

    public Diretor(String novoNome, String novaMatricula, double novoSalarioBase,
                   String novaDataAdmissao, double novoValeTransporte,
                   double novoValeAlimentacao, int novoTamanhoEquipe,
                   double novoPercentualBonus, double novaParticipacaoLucros) {

        super(novoNome, novaMatricula, novoSalarioBase, novaDataAdmissao,
                novoValeTransporte, novoValeAlimentacao,
                novoTamanhoEquipe, novoPercentualBonus);

        this.participacaoLucros = novaParticipacaoLucros;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + participacaoLucros;
    }
}