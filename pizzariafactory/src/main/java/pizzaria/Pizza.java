package pizzaria;

import java.util.Arrays;

public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected Veggies[] veggies;
    protected Pepperoni pepperoni;
    protected Clams clams;

    public abstract void prepare();

    public void bake() { System.out.println("Assando por 25 minutos a 180 °C."); }
    public void cut() { System.out.println("Cortando a pizza em fatias diagonais."); }
    public void box() { System.out.println("Colocando a pizza na caixa oficial da pizzaria."); }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + "\n  Massa: " + dough + "\n  Molho: " + sauce + "\n  Queijo: " + cheese
                + (veggies == null ? "" : "\n  Vegetais: " + Arrays.toString(veggies))
                + (pepperoni == null ? "" : "\n  Calabresa: " + pepperoni)
                + (clams == null ? "" : "\n  Mariscos: " + clams);
    }
}
