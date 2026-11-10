package pizzaria;

public class PepperoniPizza extends Pizza {
    private final PizzaIngredientFactory ingredientFactory;
    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) { this.ingredientFactory = ingredientFactory; }
    @Override public void prepare() {
        System.out.println("Preparando " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
    }
}
