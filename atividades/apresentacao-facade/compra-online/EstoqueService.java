public class EstoqueService {
    private int unidadesDisponiveis;

    public EstoqueService(int unidadesIniciais) {
        if (unidadesIniciais < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.unidadesDisponiveis = unidadesIniciais;
    }

    public void reservar(String sku, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser positiva.");
        }
        if (quantidade > unidadesDisponiveis) {
            throw new IllegalStateException("Estoque insuficiente para " + sku);
        }

        unidadesDisponiveis -= quantidade;
        System.out.println("Estoque: reservado " + quantidade + " unidade(s) de " + sku
                + ". Saldo: " + unidadesDisponiveis);
    }
}
