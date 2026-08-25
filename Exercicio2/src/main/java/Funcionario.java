public class Funcionario {

    private String nome;
    private String matricula;
    private double salarioBase;
    private String dataAdmissao;


    public Funcionario(String novoNome, String novaMatricula, double novoSalarioBase, String novoDataAdmissao){

        this.nome = novoNome;
        this.matricula = novaMatricula;
        this.salarioBase = novoSalarioBase;
        this.dataAdmissao = novoDataAdmissao;

    }

    public String getNome() {
        return nome;
    }

    public String getMatricula(){
        return matricula;
    }

    public double getSalarioBase(){
        return salarioBase;
    }

    public String getDataAdmissao(){
        return dataAdmissao;
    }

    public double calcularSalario(){
        return salarioBase;
    }

    public double calcularDesconto() {
        return salarioBase * 0.08;
    }

    @Override
    public String toString() {
        double liquido = calcularSalario() - calcularDesconto();
        return String.format( "%s [%s] - Salário: R$ %.2f | Desconto: R$ %.2f | Líquido: R$ %.2f", nome, matricula,
        calcularSalario(), calcularDesconto(), liquido );
    }

}
