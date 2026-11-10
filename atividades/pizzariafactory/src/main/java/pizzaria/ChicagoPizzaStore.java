package pizzaria;

import java.util.Locale;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        String normalized = type.trim().toLowerCase(Locale.ROOT);
        PizzaIngredientFactory factory = new ChicagoPizzaIngredientFactory();
        Pizza pizza;
        switch (normalized) {
            case "queijo": case "cheese":
                pizza = new CheesePizza(factory); pizza.name = "Pizza de Queijo no Estilo de Chicago"; break;
            case "vegetariana": case "veggie":
                pizza = new VeggiePizza(factory); pizza.name = "Pizza Vegetariana no Estilo de Chicago"; break;
            case "calabresa": case "pepperoni":
                pizza = new PepperoniPizza(factory); pizza.name = "Pizza de Calabresa no Estilo de Chicago"; break;
            case "mariscos": case "clam":
                pizza = new ClamPizza(factory); pizza.name = "Pizza de Mariscos no Estilo de Chicago"; break;
            default: throw new IllegalArgumentException("Tipo de pizza desconhecido: " + type);
        }
        return pizza;
    }
}
