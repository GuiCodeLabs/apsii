public class Livro extends Produto implements InfoGerais {

    private String autor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void exibeInformacoes() {
        System.out.println("\n--- Informações do Livro ---");
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Autor: " + autor);
    }
}
