public class FinalizacaoPedidoFacade {
    private final EstoqueService estoque;
    private final PagamentoService pagamento;
    private final EntregaService entrega;
    private final NotificacaoService notificacao;

    public FinalizacaoPedidoFacade(EstoqueService estoque,
                                   PagamentoService pagamento,
                                   EntregaService entrega,
                                   NotificacaoService notificacao) {
        this.estoque = estoque;
        this.pagamento = pagamento;
        this.entrega = entrega;
        this.notificacao = notificacao;
    }

    public void finalizar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }

        estoque.reservar(pedido.getSku(), pedido.getQuantidade());
        pagamento.cobrar(pedido.getId(), pedido.getValorEmCentavos());
        entrega.agendar(pedido.getId());
        notificacao.confirmar(pedido.getId());
    }
}
