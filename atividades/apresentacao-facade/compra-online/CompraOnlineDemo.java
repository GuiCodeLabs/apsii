public class CompraOnlineDemo {

    public static void main(String[] args) {
        Pedido pedido = new Pedido("PED-1001", "LIVRO-JAVA", 2, 12990);

        System.out.println("=== ANTES DA FACADE ===");
        System.out.println("O cliente conhece e coordena os quatro serviços:\n");

        EstoqueService estoqueAntes = new EstoqueService(10);
        PagamentoService pagamentoAntes = new PagamentoService();
        EntregaService entregaAntes = new EntregaService();
        NotificacaoService notificacaoAntes = new NotificacaoService();

        estoqueAntes.reservar(pedido.getSku(), pedido.getQuantidade());
        pagamentoAntes.cobrar(pedido.getId(), pedido.getValorEmCentavos());
        entregaAntes.agendar(pedido.getId());
        notificacaoAntes.confirmar(pedido.getId());

        System.out.println("\n=== DEPOIS DA FACADE ===");
        System.out.println("O cliente pede a tarefa à fachada em uma chamada:\n");

        FinalizacaoPedidoFacade finalizacao = new FinalizacaoPedidoFacade(
                new EstoqueService(10),
                new PagamentoService(),
                new EntregaService(),
                new NotificacaoService());

        finalizacao.finalizar(pedido);
    }
}

class FinalizacaoPedidoFacade {
    private final EstoqueService estoque;
    private final PagamentoService pagamento;
    private final EntregaService entrega;
    private final NotificacaoService notificacao;

    FinalizacaoPedidoFacade(EstoqueService estoque,
                            PagamentoService pagamento,
                            EntregaService entrega,
                            NotificacaoService notificacao) {
        this.estoque = estoque;
        this.pagamento = pagamento;
        this.entrega = entrega;
        this.notificacao = notificacao;
    }

    void finalizar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }

        estoque.reservar(pedido.getSku(), pedido.getQuantidade());
        pagamento.cobrar(pedido.getId(), pedido.getValorEmCentavos());
        entrega.agendar(pedido.getId());
        notificacao.confirmar(pedido.getId());
    }
}

class Pedido {
    private final String id;
    private final String sku;
    private final int quantidade;
    private final long valorEmCentavos;

    Pedido(String id, String sku, int quantidade, long valorEmCentavos) {
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

    String getId() {
        return id;
    }

    String getSku() {
        return sku;
    }

    int getQuantidade() {
        return quantidade;
    }

    long getValorEmCentavos() {
        return valorEmCentavos;
    }
}

class EstoqueService {
    private int unidadesDisponiveis;

    EstoqueService(int unidadesIniciais) {
        if (unidadesIniciais < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.unidadesDisponiveis = unidadesIniciais;
    }

    void reservar(String sku, int quantidade) {
        if (quantidade > unidadesDisponiveis) {
            throw new IllegalStateException("Estoque insuficiente para " + sku);
        }

        unidadesDisponiveis -= quantidade;
        System.out.println("Estoque: reservado " + quantidade + " unidade(s) de " + sku
                + ". Saldo: " + unidadesDisponiveis);
    }
}

class PagamentoService {
    void cobrar(String pedidoId, long valorEmCentavos) {
        if (valorEmCentavos <= 0) {
            throw new IllegalArgumentException("O valor da cobrança deve ser positivo.");
        }

        System.out.printf("Pagamento: cobrança aprovada para %s (R$ %.2f)%n",
                pedidoId, valorEmCentavos / 100.0);
    }
}

class EntregaService {
    void agendar(String pedidoId) {
        System.out.println("Entrega: agendada para o pedido " + pedidoId);
    }
}

class NotificacaoService {
    void confirmar(String pedidoId) {
        System.out.println("Notificação: pedido " + pedidoId + " confirmado");
    }
}
