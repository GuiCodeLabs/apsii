package pizzaria;

public class ClamPizza extends Pizza {
    private final PizzaIngredientFactory ingredientFactory;
    public ClamPizza(PizzaIngredientFactory ingredientFactory) { this.ingredientFactory = ingredientFactory; }
    @Override public void prepare() {
        System.out.println("Preparando " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClam();
    }
}
