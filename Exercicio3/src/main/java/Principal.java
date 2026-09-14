import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Livro livro = new Livro();
        CD cd = new CD();

        System.out.println("=== Cadastro do Livro ===");
        System.out.print("Nome: ");
        livro.setNome(entrada.nextLine());

        System.out.print("Preço: ");
        livro.setPreco(entrada.nextDouble());
        entrada.nextLine();

        System.out.print("Autor: ");
        livro.setAutor(entrada.nextLine());

        System.out.println("\n=== Cadastro do CD ===");
        System.out.print("Nome: ");
        cd.setNome(entrada.nextLine());

        System.out.print("Preço: ");
        cd.setPreco(entrada.nextDouble());

        System.out.print("Número de faixas: ");
        cd.setNumFaixas(entrada.nextInt());

        livro.exibeInformacoes();
        cd.exibeInformacoes();

        entrada.close();
    }
}
