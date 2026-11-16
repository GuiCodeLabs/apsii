public class PagamentoService {
    public void cobrar(String pedidoId, long valorEmCentavos) {
        if (valorEmCentavos <= 0) {
            throw new IllegalArgumentException("O valor da cobrança deve ser positivo.");
        }

        System.out.printf("Pagamento: cobrança aprovada para %s (R$ %.2f)%n",
                pedidoId, valorEmCentavos / 100.0);
    }
}
