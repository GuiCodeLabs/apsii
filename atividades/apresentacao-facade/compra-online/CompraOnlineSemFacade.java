public class CompraOnlineSemFacade {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("PED-1001", "LIVRO-JAVA", 2, 12990);

        System.out.println("=== COMPRA ONLINE SEM FACADE ===");
        System.out.println("O cliente coordena cada serviço diretamente:\n");

        EstoqueService estoque = new EstoqueService(10);
        PagamentoService pagamento = new PagamentoService();
        EntregaService entrega = new EntregaService();
        NotificacaoService notificacao = new NotificacaoService();

        estoque.reservar(pedido.getSku(), pedido.getQuantidade());
        pagamento.cobrar(pedido.getId(), pedido.getValorEmCentavos());
        entrega.agendar(pedido.getId());
        notificacao.confirmar(pedido.getId());
    }
}
