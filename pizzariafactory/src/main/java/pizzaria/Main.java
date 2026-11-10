package pizzaria;

public class Main {
    public static void main(String[] args) {
        PizzaStore chicago = new ChicagoPizzaStore();
        PizzaStore newYork = new NYPizzaStore();

        chicago.orderPizza("queijo");
        chicago.orderPizza("vegetariana");
        newYork.orderPizza("queijo");
        newYork.orderPizza("mariscos");
    }
}
