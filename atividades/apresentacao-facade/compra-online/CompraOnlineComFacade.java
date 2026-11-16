public class CompraOnlineComFacade {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("PED-1001", "LIVRO-JAVA", 2, 12990);

        System.out.println("=== COMPRA ONLINE COM FACADE ===");
        System.out.println("O cliente solicita a finalização em uma chamada:\n");

        FinalizacaoPedidoFacade finalizacao = new FinalizacaoPedidoFacade(
                new EstoqueService(10),
                new PagamentoService(),
                new EntregaService(),
                new NotificacaoService());

        finalizacao.finalizar(pedido);
    }
}
