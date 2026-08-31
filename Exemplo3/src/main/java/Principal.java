public class Principal {
	public static void main (String[]args) {
		Veiculo veiculo = new Veiculo();
		Carro carro = new Carro();
		Bicicleta bicicleta = new Bicicleta();
		System.out.println(veiculo.acelerar());
		System.out.println(carro.acelerar());
		System.out.println(bicicleta.acelerar());
	}
}
