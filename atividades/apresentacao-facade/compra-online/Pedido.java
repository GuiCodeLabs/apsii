public class Pedido {
    private final String id;
    private final String sku;
    private final int quantidade;
    private final long valorEmCentavos;

    public Pedido(String id, String sku, int quantidade, long valorEmCentavos) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("O id do pedido é obrigatório.");
        }
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("O SKU é obrigatório.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser positiva.");
        }
        if (valorEmCentavos <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo.");
        }

        this.id = id;
        this.sku = sku;
        this.quantidade = quantidade;
        this.valorEmCentavos = valorEmCentavos;
    }

    public String getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public long getValorEmCentavos() {
        return valorEmCentavos;
    }
}
