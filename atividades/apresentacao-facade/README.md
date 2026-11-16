# Facade em Java — exemplos para apresentação

Este Eclipse project contém dois exemplos independentes. O código ativo está separado em arquivos: cada classe tem seu próprio `.java`.

## Arquivos recomendados

### Home theater

- `home-theater/HomeTheaterDemo.java` executa a comparação antes/depois.
- `home-theater/HomeTheaterFacade.java` coordena `watchMovie` e `endMovie`.
- `PopcornPopper.java`, `TheaterLights.java`, `Screen.java`, `Projector.java`, `Amplifier.java` e `DvdPlayer.java` representam os aparelhos.

### Compra online

- `compra-online/CompraOnlineSemFacade.java` executa o fluxo com chamadas diretas.
- `compra-online/CompraOnlineComFacade.java` executa o fluxo usando a fachada.
- `compra-online/FinalizacaoPedidoFacade.java` coordena as etapas.
- `Pedido.java` guarda os dados do pedido.
- `EstoqueService.java`, `PagamentoService.java`, `EntregaService.java` e `NotificacaoService.java` executam as etapas simuladas.

## Executar no Eclipse

Importe esta pasta como projeto existente do Eclipse. Para cada demonstração, clique com o botão direito na classe abaixo e selecione **Run As → Java Application**:

- `HomeTheaterDemo`
- `CompraOnlineSemFacade`
- `CompraOnlineComFacade`

O `.classpath` configura `bin` como destino dos arquivos compilados.

## Executar pelo terminal

Abra o terminal na raiz `atividades/apresentacao-facade`.

### Home theater

```text
cd home-theater
javac -encoding UTF-8 -d ../bin HomeTheaterDemo.java HomeTheaterFacade.java PopcornPopper.java TheaterLights.java Screen.java Projector.java Amplifier.java DvdPlayer.java
java -cp ../bin HomeTheaterDemo
cd ..
```

### Compra online

```text
cd compra-online
javac -encoding UTF-8 -d ../bin CompraOnlineSemFacade.java CompraOnlineComFacade.java Pedido.java FinalizacaoPedidoFacade.java EstoqueService.java PagamentoService.java EntregaService.java NotificacaoService.java
java -cp ../bin CompraOnlineSemFacade
java -cp ../bin CompraOnlineComFacade
```

## Versões comentadas

As cópias com comentários foram preservadas em `referencia-comentada/`. São material de estudo; os exemplos principais para executar e apresentar são os arquivos listados acima.

## Limite didático

Os aparelhos e os serviços de compra são simulados no console. A compra altera um estoque em memória, mas não realiza pagamento, entrega, persistência ou transação reais. Facade organiza as chamadas; não fornece rollback automaticamente.
