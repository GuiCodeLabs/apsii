public class Principal {
    public static void main(String[] args) {
        Banco b1 = new Banco ("Raul", "0000", 15);
        Banco b2 = new Banco ();
        Banco b3 = new Banco ("José", "0000", 0.1);

        System.out.println(b3.getNome());
        b3.setNome("Cristiano Ronaldo");
        System.out.println(b3.getNome());

    }
}
